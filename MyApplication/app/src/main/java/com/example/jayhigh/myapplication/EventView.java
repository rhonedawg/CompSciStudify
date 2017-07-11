package com.example.jayhigh.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by apps on 3/4/17.
 */

public class EventView extends LinearLayout {
    TextView nameView;
    TextView endTimeView;
    TextView startTimeView;
    TextView descriptionView;
    Button deleteButton;
    int deleteState = 0;
    View view;
    Event event;


    public EventView(Event event, Context context) {
        super(context);
        this.event = event;

        //here we need to inflate the layout on construction
        inflate(context, R.layout.event_view, this);
        //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflater.inflate(R.layout.event_view, this, true);

        nameView = (TextView) this.findViewById(R.id.event_name);
        startTimeView = (TextView) findViewById(R.id.event_time);
        descriptionView = (TextView) findViewById(R.id.event_description);

        nameView.setText(event.name);

        String gotime = event.startTime + "-" + event.endTime;

        startTimeView.setText(event.getFormattedTime());
        descriptionView.setText(event.description);
        deleteButton = (Button) this.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new deleteClickListener());

    }


    private class deleteClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            List<Priority> events = MainMenu.Priorities.get(event.date);
                            events.remove(event);
                            CalendarPage.page.refreshDate();
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("Are you sure you want to delete this?").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();


        }

    }

}


