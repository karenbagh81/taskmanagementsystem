package com.example.taskmanagementsystem.enums;

public enum Role {
    MANAGER("manager"), EMPLOYEE("employee");

    private String value;

    Role(String value) {
        this.value = value;
    }
}
