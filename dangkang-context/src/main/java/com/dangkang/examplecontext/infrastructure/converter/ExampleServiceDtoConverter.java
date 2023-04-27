package com.dangkang.examplecontext.infrastructure.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @date 2022/12/23 10:26
 */
@Mapper
public interface ExampleServiceDtoConverter {
    ExampleServiceDtoConverter INSTANCE = Mappers.getMapper(ExampleServiceDtoConverter.class);
}
