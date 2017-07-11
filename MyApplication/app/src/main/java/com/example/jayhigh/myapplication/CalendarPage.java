package com.example.jayhigh.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;


public class CalendarPage extends AppCompatActivity {

    ListView listView;
    TextView dateText;
    Button datePickerButton;
    PriorityAdapter calendarAdapter;
    static String date = "3/2/2017";
    static CalendarPage page;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        page = this;
        listView = (ListView) findViewById(R.id.calenderList);
        dateText = (TextView) findViewById(R.id.calendarDateText);
        datePickerButton = (Button) findViewById(R.id.chooseDateButton);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarDayPickerFragment newFragment = new CalendarDayPickerFragment(page);
                newFragment.show(getFragmentManager(), "dayPicker");
            }
        });

        calendarAdapter = new PriorityAdapter(this, MainMenu.Priorities.get(date));
        listView.setAdapter(calendarAdapter);

        //date text will have some date
    }
        @Override
        protected void onResume() {
            super.onResume();
            calendarAdapter = new PriorityAdapter(this, MainMenu.Priorities.get(date));
            listView.setAdapter(calendarAdapter);
    }

        public void refreshDate(){
            if(!MainMenu.Priorities.containsKey(date)){
                ArrayList<Priority> priorities = new ArrayList<Priority>();
                MainMenu.Priorities.put(date, priorities);
            }
            calendarAdapter = new PriorityAdapter(this, MainMenu.Priorities.get(date));
            listView.setAdapter(calendarAdapter);
            dateText.setText(date);

        }
}
