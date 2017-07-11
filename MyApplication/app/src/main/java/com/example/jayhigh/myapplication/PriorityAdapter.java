package com.example.jayhigh.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by apps on 2/26/17.
 */

public class PriorityAdapter extends ArrayAdapter<Priority>{
    private Context context;
    private List<Priority> values;

    public PriorityAdapter(Context context, List<Priority> values){
        super(context, R.layout.event_view, values);
        this.values = values;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        if(values.get(position) instanceof Event){
            if(view == null){
                view = new EventView((Event)values.get(position), getContext());
            } else{
                Event event = (Event) values.get(position);
                EventView eventV = (EventView) view;
                eventV.nameView.setText(event.name);
                eventV.descriptionView.setText(event.description);
                eventV.startTimeView.setText(event.startTime);
            }
        } else if(values.get(position) instanceof Task){ //instance of Task
            if(view == null){
                view = new TaskView((Task)values.get(position), getContext());
            } else{
                view = new TaskView((Task)values.get(position), getContext());

            /*    Task task = (Task) values.get(position);
                TaskView taskV = (TaskView) view;
                taskV.nameView.setText(task.name);
                taskV.descriptionView.setText(task.description);*/
            }
        }


        //check to make sure view has been inflated




      /*  final int pos = position;
        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.course_table_row, parent, false);
        }
        TextView courseTextView = (TextView) view.findViewById(R.id.addCourseRowText);
        courseTextView.setText(values.get(position));

        ImageView deleteButton = (ImageView) view.findViewById(R.id.addCourseRowDelBut);
        deleteButton.setOnClickListener(new ImageView.OnClickListener(){
            public void onClick(View v){
                values.remove(pos);
                notifyDataSetChanged();
            }
        });*/

        return view;
    }

}
