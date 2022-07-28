package com.code22.testservice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("api/0.1/test-service-3")
public class TestService2Application {

    public static void main(String[] args) {
        SpringApplication.run(TestService2Application.class, args);
    }

    @GetMapping(value = "/health", produces = "application/json")
    public Message getResponse() {
        Message testMsg = new Message();
        testMsg.setMsgString("Everything A.OK! with Service 3");
        return  testMsg;
    }

}
