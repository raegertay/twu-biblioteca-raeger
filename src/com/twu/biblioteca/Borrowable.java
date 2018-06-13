package com.twu.biblioteca;

abstract public class Borrowable {
    private boolean availability = true;

    public boolean isAvailable() {
        return availability;
    }

    public void checkout() {
        availability = false;
    }

    public void checkin() {
        availability = true;
    }
}
