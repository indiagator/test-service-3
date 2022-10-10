package com.code22.testservice3;

import com.code22.testservice3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/0.1/test-service-3")
@CrossOrigin
public class TestService3Application {

    @Autowired
    private TestService3Config config;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserinfoRepository userinfoRepository;

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

    @PostMapping(value = "/saveProduct")
    public void saveProduct(@RequestParam("username") String username,@RequestParam("hscode") String hscode, @RequestParam("productname")String productname, @RequestParam("unit")String unit)
    {
        Product product = new Product();
        product.setHscode(hscode);
        product.setId(username);
        product.setName(productname);
        product.setUnit(unit);

        productRepository.save(product);
    }

    @PostMapping("/userinfo")
    public Userinfo fetchSpecificUserInfo(@RequestParam("username") String username)
    {
         Optional<Userinfo> userinfo =  userinfoRepository.findById(username);

        return userinfo.get();
    }





}
