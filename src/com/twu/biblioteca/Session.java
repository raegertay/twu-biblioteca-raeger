package com.twu.biblioteca;

import java.util.HashSet;

public class Session {
    private User currentUser;

    public boolean authenticateUser(HashSet<User> users, String libraryNumber, String password) {
        for (User user : users) {
            if (user.getLibraryNumber().equals(libraryNumber) && user.verifyPassword(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
