package com.example.jayhigh.myapplication;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by apps on 3/4/17.
 */

public class DateMap extends HashMap<String, List<Priority>>{

    public DateMap(){
        super();
        Event event = new Event("class", "3/2/2017", "lecture for this class", "9:30am", "10:30am");
        Event event2 = new Event("class", "3/2/2017", "WTFFFF", "12:30am", "10:30am");
        Event event3 = new Event("have to go to that thing", "3/2/2017", "lecture for this class", "9:30am", "10:30am");
        addPriority("3/2/2017", event);
        addPriority("3/2/2017", event2);
        addPriority("3/2/2017", event3);



    }

    public void addPriority(String date, Priority priority){
        if(this.containsKey(date)){
            List priorityList = this.get(date);
            priorityList.add(priority);
            Log.d("TAG", "placing priority in list");
        } else{
            List priorityList = new ArrayList<Priority>();
            priorityList.add(priority);
            this.put(date, priorityList);
        }
    }





    //to sort the list, we will use some comparison based sort and override our comparison operation to sort
    //first by priority type, and then by time/urgency


}
