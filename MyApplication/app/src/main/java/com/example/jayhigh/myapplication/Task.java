package com.example.jayhigh.myapplication;

import java.util.Date;

/**
 * Created by apps on 2/26/17.
 */

public class Task extends Priority {
    static final int HIGH = 2;
    static final int LOW = 1;
    public int priority;

    public Task(String name, String date, String description, int priority){
        super( name, date, description);
        this.priority = priority;
    }


}
