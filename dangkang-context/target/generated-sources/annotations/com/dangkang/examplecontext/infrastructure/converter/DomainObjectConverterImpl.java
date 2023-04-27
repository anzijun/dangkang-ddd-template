package com.dangkang.examplecontext.infrastructure.converter;

import com.dangkang.examplecontext.client.dto.response.ExampleQueryResultDTO;
import com.dangkang.examplecontext.domain.facade.CallRequestDto;
import com.dangkang.examplecontext.domain.model.DomainObject;
import com.dangkang.examplecontext.infrastructure.repository.dataobject.DomainObjectDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-27T18:58:10+0800",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 1.8.0_352 (Amazon.com Inc.)"
)
public class DomainObjectConverterImpl implements DomainObjectConverter {

    @Override
    public DomainObjectDO toDomainObjectDO(DomainObject domainObject) {
        if ( domainObject == null ) {
            return null;
        }

        String email = null;
        String phoneNumber = null;

        email = domainObject.getEmail();
        phoneNumber = domainObject.getPhoneNumber();

        DomainObjectDO domainObjectDO = new DomainObjectDO( email, phoneNumber );

        return domainObjectDO;
    }

    @Override
    public DomainObject toDomainObject(DomainObjectDO domainObjectDO) {
        if ( domainObjectDO == null ) {
            return null;
        }

        DomainObject domainObject = new DomainObject();

        domainObject.setEmail( domainObjectDO.getEmail() );
        domainObject.setPhoneNumber( domainObjectDO.getPhoneNumber() );

        return domainObject;
    }

    @Override
    public CallRequestDto toCallRequestDto(DomainObject domainObject) {
        if ( domainObject == null ) {
            return null;
        }

        CallRequestDto callRequestDto = new CallRequestDto();

        callRequestDto.setEmail( domainObject.getEmail() );
        callRequestDto.setPhoneNumber( domainObject.getPhoneNumber() );

        return callRequestDto;
    }

    @Override
    public List<DomainObject> toDomainObjectList(List<DomainObjectDO> domainObjects) {
        if ( domainObjects == null ) {
            return null;
        }

        List<DomainObject> list = new ArrayList<DomainObject>( domainObjects.size() );
        for ( DomainObjectDO domainObjectDO : domainObjects ) {
            list.add( toDomainObject( domainObjectDO ) );
        }

        return list;
    }

    @Override
    public List<ExampleQueryResultDTO> toQueryResultDataDtoList(List<DomainObject> domainObjects) {
        if ( domainObjects == null ) {
            return null;
        }

        List<ExampleQueryResultDTO> list = new ArrayList<ExampleQueryResultDTO>( domainObjects.size() );
        for ( DomainObject domainObject : domainObjects ) {
            list.add( domainObjectToExampleQueryResultDTO( domainObject ) );
        }

        return list;
    }

    protected ExampleQueryResultDTO domainObjectToExampleQueryResultDTO(DomainObject domainObject) {
        if ( domainObject == null ) {
            return null;
        }

        ExampleQueryResultDTO exampleQueryResultDTO = new ExampleQueryResultDTO();

        exampleQueryResultDTO.setEmail( domainObject.getEmail() );
        exampleQueryResultDTO.setPhoneNumber( domainObject.getPhoneNumber() );

        return exampleQueryResultDTO;
    }
}
