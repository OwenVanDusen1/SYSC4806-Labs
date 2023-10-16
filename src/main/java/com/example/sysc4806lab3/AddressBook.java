package com.example.sysc4806lab3;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long addressBookId;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BuddyInfo> addressBook;

    public AddressBook() {
        addressBook = new ArrayList<>();
    }

    public Long getAddressBookId() {
        return this.addressBookId;
    }

    public void setAddressBookId(Long id) {
        this.addressBookId = id;
    }

    public List<BuddyInfo> getAddressBook() {
        return addressBook;
    }

    public void addBuddyToAddressBook(BuddyInfo buddyInfo) {
        if (buddyInfo != null) {
            addressBook.add(buddyInfo);
        }
    }

    public boolean removeBuddyFromAddressBook(BuddyInfo buddy){
        if (addressBook.contains(buddy)){
            addressBook.remove(buddy);
            return true;
        }
        return false;
    }

    public List<BuddyInfo> getBuddies() {
        return addressBook;
    }

    public int getAddressBookSize() {
        return addressBook.size();
    }

    public void printAddressBook() {
        System.out.println("----------- " + "AddressBook " + addressBookId + " -----------");
        for (BuddyInfo buddyInfo : addressBook) {
            System.out.println(buddyInfo.toString());
        }
        System.out.println();
    }
}

