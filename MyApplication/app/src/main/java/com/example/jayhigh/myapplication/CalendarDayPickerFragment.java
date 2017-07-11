package com.example.jayhigh.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class CalendarDayPickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{
        Bundle bundle;
        String checkString = "data not set";
        EditText dateText;
        Calendar calendar;
        CalendarPage calendarPage;


        public CalendarDayPickerFragment(CalendarPage calendarPage){
            super();
            this.calendarPage = calendarPage;
            //this.dateText = dateText;
        }


    public CalendarDayPickerFragment(){
        super();
        //this.dateText = dateText;
    }



        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            bundle = savedInstanceState;
            calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);


            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }


        public void onDateSet(DatePicker view, int year, int month, int day) {
            CalendarPage.date = calendarToString(year, month, day);
            calendarPage.refreshDate();
        }

        public String calendarToString(int year, int month, int day) {
            String date = "";
            String yr = Integer.toString(year);
            String monthOfYr = Integer.toString(month+1);
            String dayOfMonth = Integer.toString(day);

            date = monthOfYr + "/" + dayOfMonth + "/" + yr;
            return date;
        }


    }

