package com.dangkang.app.ability.factory;

import com.dangkang.client.example.dto.request.ExampleServiceRequestDTO;
import com.dangkang.domain.example.model.DomainObject;
import org.springframework.stereotype.Component;

@Component
public class DomainObjectFactory {

    public DomainObject initDomainObject(String email, String phoneNumber) {

        DomainObject domainObject = new DomainObject(email,phoneNumber);
        return domainObject;
    }

    public DomainObject initDomainObject(ExampleServiceRequestDTO exampleServiceRequestDTO) {
        DomainObject domainObject = new DomainObject();
        domainObject.setEmail(exampleServiceRequestDTO.getEmail()).
                                 setPhoneNumber(exampleServiceRequestDTO.getPhoneNumber());
        return domainObject;
    }
}
