package com.example.jayhigh.myapplication;

import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Zellie on 3/6/17.
 */

public class NewTaskFragment extends DialogFragment {
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
    public Button selectTimeButton;

    public Button submitButton;

    public String urgency;




    public NewTaskFragment() {
        super();
        //this.dateText = dateText;
    }


    //@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_task_dialog, container, false);

        selectDateButton = (Button) v.findViewById(R.id.datePicker);


        nameText = (EditText) v.findViewById(R.id.task_nameID);
        descText = (EditText) v.findViewById(R.id.desc_nameID);
        editDate = (EditText) v.findViewById(R.id.date_text);



        Button submit = (Button) v.findViewById(R.id.submitButton);
        submit.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
            if(checkValidFields()) {
                createTask();
                getDialog().dismiss();
            }else{
                //toast it
                Toast.makeText(v.getContext(), "Please fill in all required fields", Toast.LENGTH_LONG).show();
            }
            }
        });


        // CANCEL BUTTON
        Button cancel = (Button) v.findViewById(R.id.cancel_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

        final Spinner spinner = (Spinner) v.findViewById(R.id.priority_option);

        final ArrayList<String> prioritySpinner = new ArrayList<String>();
        prioritySpinner.add("Low");
        prioritySpinner.add("Medium");
        prioritySpinner.add("High");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, prioritySpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(NewTaskFragment.this, "You selected : " + prioritySpinner.get(position),
                        Toast.LENGTH_SHORT).show();*/
                urgency = prioritySpinner.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        return v;
    }



    //we need a way of telling user he needs to fill in all information
    //we need to verify all information is inserted
    //boom


    /*public void createEvent(){
        if(checkValidFields()) {
            String date = editDate.getText().toString();
            String eventName = nameText.getText().toString();
            String desc = descText.getText().toString();
            String time = startTimeText.getText().toString();
            String endTime = "23:30";
            Event event = new Event(eventName, date, desc, time, endTime);
            MainMenu.Priorities.addPriority(date, event);
        } else{
            Log.d("TAG", "Event fields not filled in");
        }
    }*/


    public boolean checkValidFields(){
        if(editDate.getText().toString().isEmpty() || nameText.getText().toString().isEmpty() ||
                descText.getText().toString().isEmpty()){
            return false;
        } else{
            return true;
        }
    }

    public void createTask(){
        if(checkValidFields()) {
            String date = editDate.getText().toString();
            String eventName = nameText.getText().toString();
            String desc = descText.getText().toString();
            int priority = 0;
            if(urgency.equals("Low")){
                priority = 1;
            } else if(urgency.equals("Medium")){
                priority = 2;
            } else if(urgency.equals("High")){
                priority = 3;
            }
            Task task = new Task(eventName, date, desc, priority);
            MainMenu.Priorities.addPriority(date, task);
        } else{
            Log.d("TAG", "Event fields not filled in");
        }
    }


}


