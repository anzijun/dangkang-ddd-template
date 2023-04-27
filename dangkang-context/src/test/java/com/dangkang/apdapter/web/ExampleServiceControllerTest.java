package com.dangkang.apdapter.web;


import com.dangkang.adapter.web.ExampleServiceController;
import com.dangkang.client.example.dto.request.ExampleServiceRequestDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.soap.Addressing;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleServiceControllerTest {

    @Autowired
    private ExampleServiceController exampleServiceController;

    @Test
    public void executeShouldSuccessTest(){
        ExampleServiceRequestDTO exampleServiceRequestDTO = new ExampleServiceRequestDTO();
        exampleServiceRequestDTO.setEmail("dangkang@email.com");
        exampleServiceRequestDTO.setPhoneNumber("17600405800");
        exampleServiceController.execute(exampleServiceRequestDTO);
    }

    @Test
    public void executeShouldFailTest(){
        ExampleServiceRequestDTO exampleServiceRequestDTO = new ExampleServiceRequestDTO();
        exampleServiceRequestDTO.setEmail("");
        exampleServiceRequestDTO.setPhoneNumber("1760040580");
        exampleServiceController.execute(exampleServiceRequestDTO);
    }
}
