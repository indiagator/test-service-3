package com.code22.testservice3;

import com.code22.testservice3.model.Menu;
import com.code22.testservice3.model.MenuRepository;
import com.code22.testservice3.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/0.1/test-service-3")
public class TestService3Application {

    @Autowired
    private TestService3Config config;

    @Autowired
    private MenuRepository menuRepository;

    public static void main(String[] args) {
        SpringApplication.run(TestService3Application.class, args);
    }

    @GetMapping(value = "/health", produces = "application/json")
    public Message getResponse() {
        Message testMsg = new Message();
        testMsg.setMsgString("Everything A.OK! with Service 3");
        return  testMsg;
    }

    @PostMapping(value = "/save")
    public Message saveMenu(@RequestBody Menu menu)
    {
        menuRepository.save(menu);
        Message saveCustomerMsg = new Message();
        saveCustomerMsg.setMsgString("New Menu Info Saved ");
        return saveCustomerMsg;
    }

    @GetMapping(value = "/getAll")
    public List<Menu> getAllCustomers ()
    {
        return (List<Menu>) menuRepository.findAll();
    }

}
