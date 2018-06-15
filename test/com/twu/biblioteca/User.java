package com.twu.biblioteca;

import java.util.Objects;

public class User {
    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("Library number: %s\nName: %s\nEmail: %s\nPhone Number: %s", libraryNumber, name, email, phoneNumber);
    }

    @Override
    public int hashCode() {
        return libraryNumber.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o ==  this) return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(libraryNumber, user.getLibraryNumber());
    }
}
