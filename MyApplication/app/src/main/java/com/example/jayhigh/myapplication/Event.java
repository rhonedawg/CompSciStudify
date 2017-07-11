package com.example.jayhigh.myapplication;

import java.sql.Time;
import java.util.Date;

/**
 * Created by apps on 2/26/17.
 */

public class Event extends Priority {
    String startTime;
    String endTime;


    public Event(String name, String date, String description, String startTime, String endTime){
        super( name, date, description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getFormattedTime(){
        return startTime + "-" + endTime;
    }


}
