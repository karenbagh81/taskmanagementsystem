package com.example.taskmanagementsystem.enums;

public enum TaskStatus {
    NEWTASK(1),
    BUG(2),
    INPROCESS(3),
    REOPEN(4),
    RESOLVED(5),
    DONE(6);

    private int id;

    TaskStatus(int id) {

        this.id = id;
    }

    public int getId() {
        return id;
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
