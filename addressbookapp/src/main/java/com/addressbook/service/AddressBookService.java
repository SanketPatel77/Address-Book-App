package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;

import java.util.List;

public interface AddressBookService {
    void addAddressBook(AddressBookDTO addressBookDTO);
    List<AddressBookDTO> getAllAddressBook();
    AddressBookDTO getAddressBookById(int id);
    AddressBookDTO updateAddressBookById(int id, AddressBookDTO addressBookDTO);
    void deleteAddressBookById(int id);
}
