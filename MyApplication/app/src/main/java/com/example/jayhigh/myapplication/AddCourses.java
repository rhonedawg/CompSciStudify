package com.example.jayhigh.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class AddCourses extends AppCompatActivity {

    String[] departments = {"Computer Science", "Mathematics", "Chemistry"};
    String[] csciCourses = {"CS141", "CS145", "CS241", "CS247", "CS301"};
    String[] mathCourses ={"MATH 124", "MATH 125", "MATH 204", "MATH 341"};
    String[] chemCourses = {"CHEM 121", "CHEM 122", "CHEM 123"};

    ArrayList<String> courses = new ArrayList<String>();
    Spinner departmentSpinner;
    Spinner courseSpinner;
    Button addCourseButton;

    ArrayAdapter<CharSequence> mathAdapter;
    ArrayAdapter<CharSequence> csAdapter;
    ArrayAdapter<CharSequence> chemAdapter;
    ArrayAdapter<CharSequence> courseAdapter;

    CourseAdapter listAdapter;


    ListView courseList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_courses);
        courseSpinner = (Spinner) findViewById(R.id.courseSpinner);
        departmentSpinner = (Spinner) findViewById(R.id.departmentSpinner);

        //the first argument is the context, the second is a layout file for what the views should look like in dropdown, the third is string array
        ArrayAdapter<CharSequence> departmentAdapter = new ArrayAdapter<CharSequence>(this, R.layout.support_simple_spinner_dropdown_item, departments);
        departmentSpinner.setAdapter(departmentAdapter);
        departmentSpinner.setOnItemSelectedListener(new DepartmentListener());

        courseAdapter  =new ArrayAdapter<CharSequence>(this, R.layout.support_simple_spinner_dropdown_item);
        mathAdapter = new ArrayAdapter<CharSequence>(this, R.layout.support_simple_spinner_dropdown_item, mathCourses);
        csAdapter = new ArrayAdapter<CharSequence>(this, R.layout.support_simple_spinner_dropdown_item, csciCourses);
        chemAdapter = new ArrayAdapter<CharSequence>(this, R.layout.support_simple_spinner_dropdown_item, chemCourses);
        courseSpinner.setAdapter(csAdapter);

        addCourseButton = (Button) findViewById(R.id.addCoursesButton);
        addCourseButton.setOnClickListener(new AddButtonListener());


        courses.add("hello");
        courseList = (ListView) findViewById(R.id.courseList);
        listAdapter = new CourseAdapter(getApplicationContext(), courses);
        courseList.setAdapter(listAdapter);



        //set on item click listener


    }


    public class DepartmentListener implements AdapterView.OnItemSelectedListener{
        //empty constructor
        DepartmentListener(){

        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(view == null){
                return;
            }
            TextView textView = (TextView) view;
            String text = textView.getText().toString();
            Log.d("DEBUG", "Listener activated");
            if(text.equals("Computer Science")){
                Log.d("DEBUG", "computer science selected");
                courseSpinner.setAdapter(csAdapter);
            } else if(text.equals("Mathematics")){
                courseSpinner.setAdapter(mathAdapter);
            } else if(text.equals("Chemistry")){
                courseSpinner.setAdapter(chemAdapter);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            courseAdapter.clear();
        }
    }


    public class AddButtonListener implements Button.OnClickListener{

        @Override
        public void onClick(View view){
            String textSelected = (String) courseSpinner.getSelectedItem();
            Log.d("TAG", textSelected);
            for(int i = 0; i < courses.size(); i++){
                if(courses.get(i).equals(textSelected)){
                    return;
                }
            }
            courses.add(textSelected);
            listAdapter.notifyDataSetChanged();
        }
    }


}
