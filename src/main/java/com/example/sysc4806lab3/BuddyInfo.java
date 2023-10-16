package com.example.sysc4806lab3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue
    private Long buddyId;

    @ManyToOne
    private AddressBook addressBook;
    private String name;
    private String phoneNum;
    private String address;

    public BuddyInfo (String name, String phoneNum, String address) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    protected BuddyInfo() {
        this("","","");
    }

    public Long getBuddyId() {
        return this.buddyId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setBuddyId(Long id) {
        this.buddyId = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    @Override
    public String toString() {
        return "BuddyInfo{" +
                "name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
