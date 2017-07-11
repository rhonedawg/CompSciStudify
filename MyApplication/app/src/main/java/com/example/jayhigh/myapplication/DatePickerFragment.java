package com.example.jayhigh.myapplication;
import android.app.DialogFragment;
import android.app.DatePickerDialog;
import android.app.Dialog;
import java.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;



public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{
        Bundle bundle;
        String checkString = "data not set";
        EditText dateText;
        Calendar calendar;


        public DatePickerFragment(){
            super();
            //this.dateText = dateText;
        }

        public DatePickerFragment(EditText text){
            super();
            this.dateText = text;
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
            dateText.setText(calendarToString(year, month, day));
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

