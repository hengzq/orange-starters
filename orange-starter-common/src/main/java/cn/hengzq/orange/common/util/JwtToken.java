package cn.hengzq.orange.common.util;

import cn.hengzq.orange.common.constant.SecurityConstant;
import cn.hengzq.orange.common.dto.LoginUserInfo;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @author hengzq
 */
@Slf4j
public class JwtToken {

    /**
     * 创建Token
     * @param userInfo 获取Token的用户信息
     * @return 返回生成的Token
     */
    public static String createToken(LoginUserInfo userInfo) {
        return createToken(SecurityConstant.TOKEN_EXPIRE_TIME, Convert.toMap(String.class, Object.class, userInfo));
    }

    /**
     * 创建Token
     * @param expireTime token过期时间
     * @param userInfo 获取token的用户信息
     * @return 返回Token
     */
    public static String createToken(Long expireTime, Map<String, Object> userInfo) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + expireTime);
        return JWT.create()
                .withIssuer(SecurityConstant.ISSUER)
                .withIssuedAt(now)
                .withExpiresAt(expireDate)
                .withClaim(SecurityConstant.PAYLOAD_KEY_USER_INFO, userInfo)
                .sign(Algorithm.HMAC256(SecurityConstant.DEFAULT_SECRET_KEY));
    }


    /**
     * 验证Token并返回解析后的Token
     */
    public static DecodedJWT verify(String token) {
        try {
            if (StrUtil.isBlank(token)) {
                return null;
            }
            Algorithm algorithm = Algorithm.HMAC256(SecurityConstant.DEFAULT_SECRET_KEY);
            JWTVerifier jwtVerifier = JWT.require(algorithm).withIssuer(SecurityConstant.ISSUER).build();
            return jwtVerifier.verify(token);
        } catch (Exception ex) {
            log.error("Illegal token.", ex);
            return null;
        }
    }

    /**
     * 获取token中的用户信息
     */
    public static LoginUserInfo getUserInfo(String token) {
        DecodedJWT decodedJWT = verify(token);
        if (Objects.isNull(decodedJWT)) {
            return null;
        }
        Map<String, Object> userInfoMap = decodedJWT.getClaim(SecurityConstant.PAYLOAD_KEY_USER_INFO).asMap();
        if (Objects.isNull(userInfoMap)) {
            return null;
        }
        return BeanUtil.toBean(userInfoMap, LoginUserInfo.class);
    }

}