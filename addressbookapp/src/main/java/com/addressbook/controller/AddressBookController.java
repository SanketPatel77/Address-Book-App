package com.addressbook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {
    // testing application is working or not
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Connected Successfully");
    }
}
