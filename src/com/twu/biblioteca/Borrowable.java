package com.twu.biblioteca;

abstract public class Borrowable {
    private boolean availability = true;
    private User borrower;

    public boolean isAvailable() {
        return availability;
    }

    public void checkout(User borrower) {
        availability = false;
        this.borrower = borrower;
    }

    public void checkin() {
        availability = true;
        borrower = null;
    }

    public User getBorrower() {
        return borrower;
    }
}
