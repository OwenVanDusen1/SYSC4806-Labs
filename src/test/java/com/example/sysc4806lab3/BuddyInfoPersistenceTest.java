package com.example.sysc4806lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class BuddyInfoPersistenceTest {

    @Autowired
    private BuddyInfoRepository repository;
    private BuddyInfo b1, b2;

    @BeforeEach
    void setUp() {
        b1 = new BuddyInfo("Charles III", "613-411-2365", "77 University Drive");
        b2 = new BuddyInfo("James", "613-299-7742", "Edinburgh");
    }

    @Test
    void testPersistBuddyInfoClass() {
        repository.save(b1);
        repository.save(b2);

        List<BuddyInfo> results = (List<BuddyInfo>) repository.findAll();

        assertEquals(4, results.size());

        for (BuddyInfo b : results) {
            System.out.println(b + " (id=" + b.getBuddyId() + ")");
        }
    }

}
