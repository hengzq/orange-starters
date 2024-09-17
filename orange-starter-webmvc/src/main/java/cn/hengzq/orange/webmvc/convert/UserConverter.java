package cn.hengzq.orange.webmvc.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
  * 
 */
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

}
