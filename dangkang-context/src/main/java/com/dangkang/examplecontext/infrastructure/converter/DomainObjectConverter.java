package com.dangkang.examplecontext.infrastructure.converter;

import com.dangkang.examplecontext.client.dto.response.ExampleQueryResultDTO;
import com.dangkang.examplecontext.domain.facade.CallRequestDto;
import com.dangkang.examplecontext.domain.model.DomainObject;
import com.dangkang.examplecontext.infrastructure.repository.dataobject.DomainObjectDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @date 2022/12/23 18:01
 */
@Mapper
public interface DomainObjectConverter {
    DomainObjectConverter INSTANCE = Mappers.getMapper(DomainObjectConverter.class);

    DomainObjectDO toDomainObjectDO(DomainObject domainObject);

    DomainObject toDomainObject(DomainObjectDO domainObjectDO);

    CallRequestDto toCallRequestDto(DomainObject domainObject);

    List<DomainObject> toDomainObjectList(List<DomainObjectDO> domainObjects);

    List<ExampleQueryResultDTO> toQueryResultDataDtoList(List<DomainObject> domainObjects);

}
