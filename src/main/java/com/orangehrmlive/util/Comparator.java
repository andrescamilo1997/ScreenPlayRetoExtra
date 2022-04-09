package com.orangehrmlive.util;

public enum Comparator {
    MSG_ALL_OK_TEXT ("United States Dollar"),
    MSG_DELETE("No Records Found");

    private final String value;

    public String getValue() {
        return value;
    }

    Comparator(String value) {
        this.value = value;
    }

}
