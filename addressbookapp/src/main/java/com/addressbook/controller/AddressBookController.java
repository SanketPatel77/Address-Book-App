package com.addressbook.controller;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.dto.ResponseDTO;
import com.addressbook.model.AddressBook;
import com.addressbook.service.AddressBookService;
import com.addressbook.service.AddressBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookServiceImpl addressBookService;

    @Autowired
    public AddressBookController(AddressBookServiceImpl addressBookService) {
        this.addressBookService = addressBookService;
    }

    // testing application is working or not
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Connected Successfully");
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addAddressBook(@RequestBody AddressBookDTO addressBookDTO){
        addressBookService.addAddressBook(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("AddressBook added Successfully",addressBookDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAll(){
       List<AddressBookDTO> addressBookDTOList = addressBookService.getAllAddressBook();
       ResponseDTO responseDTO = new ResponseDTO("All AddressBook",addressBookDTOList);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable("id") int id){
        AddressBookDTO addressBookDTO = addressBookService.getAddressBookById(id);
        ResponseDTO responseDTO = new ResponseDTO("AddressBook",addressBookDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBook(@PathVariable("id") int id,@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookDTO updatedAddressBook = addressBookService.updateAddressBookById(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated AddressBook", updatedAddressBook);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        addressBookService.deleteAddressBookById(id);
        return ResponseEntity.ok("AddressBook entry deleted successfully.");
    }

}
