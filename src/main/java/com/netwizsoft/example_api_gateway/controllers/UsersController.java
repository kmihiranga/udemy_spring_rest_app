package com.netwizsoft.example_api_gateway.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.netwizsoft.example_api_gateway.model.User;

import java.util.Date;
import java.util.Map;

@RestController
public class UsersController {

    @GetMapping("/test")
    public void test(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            System.out.println(key + " - " + value);
        });
    }
    
    @GetMapping("/test/{id}")
    public ResponseEntity<String> findUserName(@RequestHeader(value = "number1", defaultValue = "100") int num) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("own-property", "This uis the value");
    	return new ResponseEntity<>("This is a string " + num, HttpStatus.OK);
    }
    
    @GetMapping("/test2")
    public User userDetails() {
    	User user = User.builder()
    			.firstName("kalana")
    			.lastName("last")
    			.email("test123@test.com")
    			.regDate(new Date())
    			.build();
    	return user;
    }
}
