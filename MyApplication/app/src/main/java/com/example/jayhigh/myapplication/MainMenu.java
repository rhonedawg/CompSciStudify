package com.example.jayhigh.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MainMenu extends AppCompatActivity {

    Button viewCalenderButton;
    Button addCoursesButton;
    Button addEventButton;
    Button addTaskButton;
    static DateMap Priorities = new DateMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        viewCalenderButton = (Button) findViewById(R.id.calenderButton);
        if(Priorities == null){
            Priorities = new DateMap();
        }

        viewCalenderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCalendar();
            }
        });

        addCoursesButton = (Button) findViewById(R.id.coursesButton);
        addCoursesButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                goToAddCourses();
            }
        });

        addEventButton = (Button) findViewById(R.id.addEventButton);
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                Fragment frag = manager.findFragmentByTag("edit_name");
                if (frag != null) {
                    manager.beginTransaction().remove(frag).commit();
                }
                NewEventFragment eventFrag = new NewEventFragment();
                eventFrag.show(manager, "edit_name");
            }
        });

        addTaskButton = (Button) findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                Fragment frag = manager.findFragmentByTag("edit_taskname");
                if (frag != null) {
                    manager.beginTransaction().remove(frag).commit();
                }
                NewTaskFragment eventFrag = new NewTaskFragment();
                eventFrag.show(manager, "edit_taskname");
            }
        });


    }




    public void goToAddCourses(){
        Intent myIntent = new Intent(this, AddCourses.class);
        startActivity(myIntent);
    }

    public void goToCalendar(){
        Intent myIntent = new Intent(this, CalendarPage.class);
        startActivity(myIntent);
    }
}







