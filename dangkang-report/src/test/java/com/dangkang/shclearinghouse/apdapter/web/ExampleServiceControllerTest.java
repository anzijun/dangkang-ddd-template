package com.dangkang.shclearinghouse.apdapter.web;


import com.dangkang.shclearinghouse.adapter.web.ReportServiceController;
import com.dangkang.shclearinghouse.client.dto.request.ExampleServiceRequestDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleServiceControllerTest {

    @Autowired
    private ReportServiceController exampleServiceController;

    @Test
    public void executeShouldSuccessTest(){
        ExampleServiceRequestDTO exampleServiceRequestDTO = new ExampleServiceRequestDTO();
        exampleServiceRequestDTO.setEmail("dangkang@email.com");
        exampleServiceRequestDTO.setPhoneNumber("17600405800");
        exampleServiceController.execute(exampleServiceRequestDTO);
    }

    @Test()
    public void executeShouldFailTest(){
        ExampleServiceRequestDTO exampleServiceRequestDTO = new ExampleServiceRequestDTO();
        exampleServiceRequestDTO.setEmail("");
        exampleServiceRequestDTO.setPhoneNumber("1760040580");
        exampleServiceController.execute(exampleServiceRequestDTO);
    }
}
