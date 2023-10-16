package com.example.sysc4806lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AddressBookRestController {

    @Autowired
    AddressBookRepository addressBookRepository;
    @Autowired
    BuddyInfoRepository buddyInfoRepository;

    @PostMapping("/AddressBook")
    public AddressBook createAddressBook() {
        AddressBook addressBook = new AddressBook();
        addressBookRepository.save(addressBook);

        return addressBook;
    }

    @GetMapping("/AddressBook/{id}")
    public AddressBook showAddressBook(@PathVariable Long id) {
        AddressBook addressBook = addressBookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find addressBook"));

        return addressBook;
    }
}
