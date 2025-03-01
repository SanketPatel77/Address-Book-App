package com.addressbook.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
public class AddressBook {
    private int id;
    private String name;
    private String email;
}
