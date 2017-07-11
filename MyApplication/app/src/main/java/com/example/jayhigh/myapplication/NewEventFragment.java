package com.example.jayhigh.myapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

import static com.example.jayhigh.myapplication.R.id.startTimeButton;
import static com.example.jayhigh.myapplication.R.id.time;


public class NewEventFragment extends DialogFragment {
    Bundle bundle;
    String checkString = "data not set";
    EditText editDate;
    EditText nameText;
    EditText descText;
    EditText startTimeText;
    EditText endTimeText;

    Calendar calendar;
    public Button calendarButton;
    public Button coursesButton;

    public Button eventButton;
    public Button selectDateButton;
    public Button selectStartTimeButton;
    public Button selectEndTimeButton;

    public Button submitButton;




    public NewEventFragment() {
        super();
        //this.dateText = dateText;
    }


    //@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_event_dialog, container, false);

        selectDateButton = (Button) v.findViewById(R.id.datePicker);


        nameText= (EditText) v.findViewById(R.id.event_name_edit);
        descText = (EditText) v.findViewById(R.id.event_desc_edit);
        editDate = (EditText) v.findViewById(R.id.date_text);
        startTimeText = (EditText) v.findViewById(R.id.startTimeEdit);
        endTimeText = (EditText) v.findViewById(R.id.endTimeEdit);


        Button submit = (Button) v.findViewById(R.id.submitButton);
        submit.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (checkValidFields()) {
                    createEvent();
                    getDialog().dismiss();
                } else {
                    //toast something

                }
            }
        });


// CANCEL BUTTON
       Button cancel = (Button) v.findViewById(R.id.cancel_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // NEED TO CANCEL EVENT
                getDialog().dismiss();
            }
        });




        editDate.setEnabled(false);
        editDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DatePickerFragment newFragment = new DatePickerFragment(editDate);
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });

        selectDateButton = (Button) v.findViewById(R.id.datePicker);
        selectDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment newFragment = new DatePickerFragment(editDate);
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });




        selectStartTimeButton = (Button) v.findViewById(R.id.startTimeButton);
        selectStartTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerFragment newFragment = new TimePickerFragment(startTimeText);
                newFragment.show(getFragmentManager(), "startTimePicker");

            }

        });


        selectEndTimeButton = (Button) v.findViewById(R.id.endTimeButton);
        selectEndTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerFragment newFragment = new TimePickerFragment(endTimeText);
                newFragment.show(getFragmentManager(), "startTimePicker");

            }

        });





        return v;
    }




    //we need a way of telling user he needs to fill in all information
    //we need to verify all information is inserted
    //boom


    public void createEvent(){
        if(checkValidFields()) {
            String date = editDate.getText().toString();
            String eventName = nameText.getText().toString();
            String desc = descText.getText().toString();
            String time = startTimeText.getText().toString();
            String endTime = endTimeText.getText().toString();
            Event event = new Event(eventName, date, desc, time, endTime);
            MainMenu.Priorities.addPriority(date, event);
        } else{
            Log.d("TAG", "Event fields not filled in");
        }
    }


    public boolean checkValidFields(){
        if(editDate.getText().toString().isEmpty() || nameText.getText().toString().isEmpty() ||
                descText.getText().toString().isEmpty() || startTimeText.getText().toString().isEmpty()){
            return false;
        } else{
            return true;
        }
    }


}
