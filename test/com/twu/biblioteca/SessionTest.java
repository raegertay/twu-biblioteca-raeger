package com.twu.biblioteca;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class SessionTest {
    @Test
    public void authenticateUserShouldReturnTrueIfUserCredentialIsCorrect() {
        Session session = new Session();
        User user = new User("000-0001", "abc123", "Tom", "tom@email.com", "91234567");
        HashSet<User> users = new HashSet<>(Arrays.asList(user));
        assertEquals(true, session.authenticateUser(users, "000-0001", "abc123"));
    }

    @Test
    public void getCurrentUserShouldReturnCurrentAuthenticatedUser() {
        Session session = new Session();
        User user = new User("000-0001", "abc123", "Tom", "tom@email.com", "91234567");
        HashSet<User> users = new HashSet<>(Arrays.asList(user));
        session.authenticateUser(users, "000-0001", "abc123");
        assertEquals(user, session.getCurrentUser());
    }
}
