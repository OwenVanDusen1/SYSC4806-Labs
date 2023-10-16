package com.example.sysc4806lab3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BuddyInfoTest {
    BuddyInfo buddyInfo;

    @Before
    public void setUp() {
        buddyInfo = new BuddyInfo("Charles III", "613-411-2365", "77 University Drive");
    }
    @Test
    public void buddyInfoNameSaves() {
        assertEquals("Charles III", buddyInfo.getName());
    }

    @Test
    public void buddyInfoPhoneNumSaves() {
        assertEquals("613-411-2365", buddyInfo.getPhoneNum());
    }

    @Test
    public void buddyInfoAddressSaves() {
        assertEquals("77 University Drive", buddyInfo.getAddress());
    }

    @Test
    public void buddyInfoToStringOutputs() {
        assertEquals("BuddyInfo{name='Charles III', phoneNum='613-411-2365', address='77 University Drive'}", buddyInfo.toString());
    }

}