package cn.hengzq.orange.webmvc.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * @author hengzq
 */
@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

}
