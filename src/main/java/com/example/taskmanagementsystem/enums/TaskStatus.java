package com.example.taskmanagementsystem.enums;

public enum TaskStatus {
    NEWTASK(1, "newTask"),
    BUG(2, "bug"),
    INPROCESS(3, "inProcess"),
    REOPEN(4, "reopen"),
    RESOLVED(5, "resolved"),
    DONE(6, "done");

    private int id;
    private String value;

    TaskStatus(int id, String value) {

        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }


    public static TaskStatus getById(int id){
        for(TaskStatus taskStatus : TaskStatus.values()){
            if(taskStatus.id == id){
                return taskStatus;
            }
        }
        return null;
    }
}
