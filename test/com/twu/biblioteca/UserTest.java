package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;

    @Before
    public void initialize() {
        user = new User("000-0001", "abc123", "Tom", "tom@email.com", "91234567");
    }

    @Test
    public void getLibraryNumberShouldReturnLibraryNumber() {
        assertEquals("000-0001", user.getLibraryNumber());
    }

    @Test
    public void getNameShouldReturnName() {
        assertEquals("Tom", user.getName());
    }

    @Test
    public void getEmailShouldReturnEmail() {
        assertEquals("tom@email.com", user.getEmail());
    }

    @Test
    public void getPhoneNumberShouldReturnPhoneNumber() {
        assertEquals("91234567", user.getPhoneNumber());
    }

    @Test
    public void toStringShouldPrintUserDetails() {
        assertEquals("Library number: 000-0001\nName: Tom\nEmail: tom@email.com\nPhone Number: 91234567", user.toString());
    }

    @Test
    public void usersWithSameLibraryNumberShouldBeEqual() {
        User user2 = new User("000-0001", "abc123", "Alan", "alan@email.com", "98765432");
        assertEquals(user, user2);
    }
}
