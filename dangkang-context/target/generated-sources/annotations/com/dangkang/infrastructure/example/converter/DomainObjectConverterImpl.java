package com.dangkang.infrastructure.example.converter;

import com.dangkang.client.example.dto.response.ExampleQueryResultDTO;
import com.dangkang.domain.example.ability.facade.CallRequestDto;
import com.dangkang.domain.example.model.DomainObject;
import com.dangkang.infrastructure.example.repository.dataobject.DomainObjectDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-27T15:42:51+0800",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 1.8.0_20 (Oracle Corporation)"
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
