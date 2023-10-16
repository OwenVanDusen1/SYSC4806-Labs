package com.example.sysc4806lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
class AddressBookPersistenceTest {

    @Autowired
    private AddressBookRepository repository;

    private AddressBook addressBook;
    private BuddyInfo b1, b2;


    @BeforeEach
    void setUp() {
        addressBook = new AddressBook();
        b1 = new BuddyInfo("Charles III", "613-411-2365", "77 University Drive");
        b2 = new BuddyInfo("James", "613-299-7742", "Edinburgh");
    }

    @Test
    public void testPersist() {
        addressBook.addBuddyToAddressBook(b1);
        addressBook.addBuddyToAddressBook(b2);

        repository.save(addressBook);

        // Querying all the address books.
        List<AddressBook> results = (List<AddressBook>) repository.findAll();

        System.out.println("List of AddressBooks");
        results.get(0).printAddressBook();

        // Asserts that only one buddy was returned.
        System.out.println("List of Buddies in AddressBook");
        assertEquals(1, results.size());
        assertEquals(2, results.get(0).getAddressBookSize());

        for (BuddyInfo b : results.get(0).getAddressBook()) {
            System.out.println(b + " (id=" + b.getBuddyId() + ")");
        }
    }
}
