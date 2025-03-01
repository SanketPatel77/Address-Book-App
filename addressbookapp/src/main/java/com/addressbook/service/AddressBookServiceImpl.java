package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.mapper.AddressBookMapper;
import com.addressbook.model.AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService{
    // list to add data
    private final List<AddressBook> addressBookList = new ArrayList<>();


    // method to add
    @Override
    public void addAddressBook(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = AddressBookMapper.INSTANCE.toEntity(addressBookDTO);
        addressBook.setId(addressBookList.size()+1);
        addressBookList.add(addressBook);
    }

    public List<AddressBookDTO> getAllAddressBook(){
        return addressBookList.stream().map(AddressBookMapper.INSTANCE::toDto).toList();
    }

    @Override
    public AddressBookDTO getAddressBookById(int id) {
        for(AddressBook addressBook : addressBookList){
            if(addressBook.getId() == id){
                return AddressBookMapper.INSTANCE.toDto(addressBook);
            }
        }
        return null;
    }

    @Override
    public AddressBookDTO updateAddressBookById(int id, AddressBookDTO addressBookDTO) {
        for (AddressBook addressBook : addressBookList) {
            if (addressBook.getId() == id) {
                // Update the fields
                addressBook.setName(addressBookDTO.getName());
                addressBook.setEmail(addressBookDTO.getEmail());
                // Return the updated DTO
                return AddressBookMapper.INSTANCE.toDto(addressBook);
            }
        }
        return null; // Return null if no matching ID is found
    }

    @Override
    public void deleteAddressBookById(int id) {
        addressBookList.removeIf(addressBook -> addressBook.getId() == id);
    }


}
