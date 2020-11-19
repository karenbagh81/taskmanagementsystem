package com.example.taskmanagementsystem.enums;

public enum TaskStatus {
    NEWTASK("newTask"),
    BUG("bug"),
    INPROCESS("inProcess"),
    REOPEN("reopen"),
    RESOLVED("resolved"),
    DONE("done");

    private String value;

    TaskStatus(String value){
        this.value = value;
    }
}
