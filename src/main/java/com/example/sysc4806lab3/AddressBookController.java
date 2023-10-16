package com.example.sysc4806lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@Controller
public class AddressBookController {

    @Autowired
    AddressBookRepository addressBookRepository;
    @Autowired
    BuddyInfoRepository buddyInfoRepository;

    @PostMapping("/AddressBook")
    public String createAddressBook(Model model) {
        AddressBook addressBook = new AddressBook();
        addressBookRepository.save(addressBook);
        model.addAttribute("addressBook", addressBook);

        return "view";
    }

    @GetMapping("/AddressBook/{id}")
    public String showAddressBook(@PathVariable Long id, Model model) {
        AddressBook addressBook = addressBookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find addressBook"));

        model.addAttribute("addressBook", addressBook);

        return "view";
    }

    @PostMapping("/AddressBook/{id}/buddy")
    public String addBuddy(@PathVariable Long id, @RequestBody BuddyInfo buddy, Model model) {
        AddressBook ab = addressBookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find addressBook"));
        ab.addBuddyToAddressBook(buddy);
        addressBookRepository.save(ab);

        model.addAttribute("addressBook", ab);

        return "view";
    }

    @PostMapping("/AddressBook/{aId}/removeBuddy/{bId}")
    public String removeBuddy(@PathVariable Long aId, @PathVariable Long bId, Model model) {
        AddressBook ab = addressBookRepository.findById(aId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find addressBook"));
        BuddyInfo b = buddyInfoRepository.findById(bId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find addressBook"));

        ab.removeBuddyFromAddressBook(b);
        addressBookRepository.save(ab);

        model.addAttribute("addressBook", ab);

        return "view";

    }

}
