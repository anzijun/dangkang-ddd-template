package com.dangkang.shclearinghouse.infrastructure.converter;

import com.dangkang.shclearinghouse.client.dto.response.ExampleQueryResultDTO;
import com.dangkang.report.domain.facade.CallRequest;
import com.dangkang.report.domain.model.DomainObject;
import com.dangkang.shclearinghouse.infrastructure.repository.dataobject.DomainObjectDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 *  对象转换，应用Mapstruct（https://github.com/mapstruct/mapstruct）
 * @date 2022/12/23 18:01
 */
@Mapper
public interface ExampleContextConverter {
    ExampleContextConverter INSTANCE = Mappers.getMapper(ExampleContextConverter.class);

    DomainObjectDO toDomainObjectDO(DomainObject domainObject);

    DomainObject toDomainObject(DomainObjectDO domainObjectDO);

    CallRequest toCallRequestDto(DomainObject domainObject);

    List<DomainObject> toDomainObjectList(List<DomainObjectDO> domainObjects);

    List<ExampleQueryResultDTO> toQueryResultDataDtoList(List<DomainObject> domainObjects);

}
