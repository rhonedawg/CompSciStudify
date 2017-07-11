package com.example.jayhigh.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by apps on 2/25/17.
 */

public class CourseAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> values;

    CourseAdapter(Context context, List<String> values){
        super(context, R.layout.course_table_row, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        //check to make sure view has been inflated
        final int pos = position;
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
        });

        return view;
    }

    public void swapItems(List<String> items) {
        this.values = items;
        notifyDataSetChanged();
    }







}
