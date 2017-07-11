package com.example.jayhigh.myapplication;

import java.util.Date;

/**
 * Created by apps on 2/25/17.
 */

public abstract class Priority {

    public String name;
    public String date;
    public String description;

    public Priority(String name, String date, String description){
        this.name = name;
        this.date = date;
        this.description = description;
    }



}
