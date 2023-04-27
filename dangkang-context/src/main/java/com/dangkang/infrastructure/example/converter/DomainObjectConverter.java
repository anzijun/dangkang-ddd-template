package com.dangkang.infrastructure.example.converter;

import com.dangkang.client.example.dto.response.ExampleQueryResultDTO;
import com.dangkang.domain.example.ability.facade.CallRequestDto;
import com.dangkang.domain.example.model.DomainObject;
import com.dangkang.infrastructure.example.repository.dataobject.DomainObjectDO;
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
