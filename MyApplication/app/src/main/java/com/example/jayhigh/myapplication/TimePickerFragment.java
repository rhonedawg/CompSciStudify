package com.example.jayhigh.myapplication;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;


/**
 * Created by Zellie on 3/3/17.
 */

import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.app.Dialog;
import java.util.Calendar;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.EditText;
import android.widget.TimePicker;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.app.FragmentManager;
import android.app.FragmentManagerNonConfig;

public class TimePickerFragment extends DialogFragment //maybe use static
        implements TimePickerDialog.OnTimeSetListener {

    EditText timeText;

    public TimePickerFragment(EditText timeText){
        super();
        this.timeText = timeText;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        //int am_pm = c.get(Calendar.AM_PM);


        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        timeText.setText(timeToString(hourOfDay, minute));
    }

    public String timeToString(int hour, int minute) {
        String time = "";
        String AM_PM = "";
        String min = "";

        if (hour < 12) {
            AM_PM = "AM";
        }
        else {
            AM_PM = "PM";
        }

        if (minute < 10) {
            min = "0" + Integer.toString(minute);
        }
        else {
            min = Integer.toString(minute);
        }

        String hr = Integer.toString(hour);
        time = hr + ":" + min + AM_PM;
        return time;
    }
}





