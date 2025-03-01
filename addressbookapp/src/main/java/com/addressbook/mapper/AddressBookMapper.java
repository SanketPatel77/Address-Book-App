package com.addressbook.mapper;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface AddressBookMapper {
    AddressBookMapper INSTANCE = Mappers.getMapper(AddressBookMapper.class);

    AddressBook toEntity(AddressBookDTO addressBookDTO);
    AddressBookDTO toDto (AddressBook addressBook);
}
