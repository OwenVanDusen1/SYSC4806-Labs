package com.example.sysc4806lab3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AddressBookTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    AddressBook addressBook1;
    BuddyInfo buddyInfo1;
    BuddyInfo buddyInfo2;
    BuddyInfo buddyInfo3;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        addressBook1 = new AddressBook();
        addressBook1.setAddressBookId(1L);
        buddyInfo1 = new BuddyInfo("Charles III", "613-411-2365", "77 University Drive");
        buddyInfo2 = new BuddyInfo("James", "613-299-7742", "Edinburgh");
        buddyInfo3 = new BuddyInfo("William II", "613-219-5941", "Torbay harbour");
    }

    @Test
    public void addressBookSavesBuddyInfoToList() {
        assertEquals(0, addressBook1.getAddressBookSize());
        addressBook1.addBuddyToAddressBook(buddyInfo2);
        assertEquals(1, addressBook1.getAddressBookSize());
        addressBook1.addBuddyToAddressBook(buddyInfo1);
        addressBook1.addBuddyToAddressBook(buddyInfo3);
        assertEquals(3, addressBook1.getAddressBookSize());
    }

    @After
    public void teardown() throws Exception {
        System.setOut(originalOut);
    }

}