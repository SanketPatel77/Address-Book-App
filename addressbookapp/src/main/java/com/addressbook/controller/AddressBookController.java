package com.addressbook.controller;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.dto.ResponseDTO;
import com.addressbook.service.AddressBookService;
import com.addressbook.service.AddressBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private AddressBookServiceImpl addressBookService;

    @Autowired
    public AddressBookController(AddressBookServiceImpl addressBookService) {
        this.addressBookService = addressBookService;
    }

    // testing application is working or not
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Connected Successfully");
    }
}
