package com.example.android19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android19.R;

import java.util.Calendar;

public class Patient_Entry_Activity extends AppCompatActivity {
    public static PersonDatabase personDatabase;

    TextView bdate;
    DatePickerDialog datePickerDialog;
    int currentyear;
    int currentmonth;
    int currentdayofMonth;
    Calendar calendar;
    int age;
    int prioritylevel;
    boolean travelhistory;
    String namefirst;
    String namelast;
    String result;
    int chday;
    int chmonth;
    int chyear;
    int maxwaitingnumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__entry_);


        getSupportActionBar().setTitle("Patient Entry Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        personDatabase = Room.databaseBuilder(getApplicationContext(), PersonDatabase.class, "personlist").allowMainThreadQueries().build();

        maxwaitingnumber = personDatabase.personDao().getmaxwaitinglist();

    }


    public void datebuttonpressed(View view) {
        bdate = (TextView) findViewById(R.id.getdate);
        calendar = Calendar.getInstance();
        currentyear = calendar.get(Calendar.YEAR);
        currentmonth = calendar.get(Calendar.MONTH);
        currentdayofMonth = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(Patient_Entry_Activity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                bdate.setText(day + "/" + (month + 1) + "/" + year);
                age = currentyear - year;
                chday = day;
                chmonth = month;
                chyear = year;

            }
        }, currentyear, currentmonth, currentdayofMonth);

        datePickerDialog.show();

    }

    public void submitonclick(View view) {

        EditText firstname = (EditText) findViewById(R.id.fname);
        namefirst = firstname.getText().toString();
        EditText lastname = (EditText) findViewById(R.id.lname);
        namelast = lastname.getText().toString();
        Switch travel = (Switch) findViewById(R.id.switch1);
        bdate = (TextView) findViewById(R.id.getdate);

        if (age > 65 && travel.isChecked()) {
            prioritylevel = 3;
            travelhistory = true;
            result = "You need a test";

        } else if (age > 65) {
            prioritylevel = 2;
            travelhistory = false;
            result = "You need a test";

        } else if (travel.isChecked()) {
            prioritylevel = 1;
            travelhistory = true;
            result = "You need a test";

        } else if (!travel.isChecked() && age < 65) {
            prioritylevel = 0;
            travelhistory = false;
            result = "No test required";
        }

        boolean checkDetails = true;

        if (namefirst.equals("")) {
            checkDetails = false;
            Toast toast = Toast.makeText(getApplicationContext(), "First name can't be Empty!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if (chyear<1900) {
            checkDetails = false;
            Toast toast = Toast.makeText(getApplicationContext(), "Invalid Date!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if (bdate.getText().equals("")) {
            checkDetails = false;
            Toast toast = Toast.makeText(getApplicationContext(), "Invalid Date!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if (chyear > currentyear)
        {
            checkDetails = false;
            Toast toast = Toast.makeText(getApplicationContext(), "Invalid Date!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if(chyear == currentyear){
            if(chmonth > currentmonth)
            {
                checkDetails = false;
                Toast toast = Toast.makeText(getApplicationContext(), "Invalid Date!", Toast.LENGTH_SHORT);
                toast.show();
            }
            else if (chmonth == currentmonth)
            {
                if(chday > currentdayofMonth)
                {
                    checkDetails = false;
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid Date!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        }
        else {
        }

        if(checkDetails == true)
        {
            if(prioritylevel == 0)
            {
                Person person = new Person(namefirst, namelast, age, prioritylevel, travelhistory,0);
                personDatabase.personDao().insert(person);
                Intent intent = new Intent(this, Result_Activity.class);
                intent.putExtra("level", Integer.toString(prioritylevel));
                intent.putExtra("resulttext", result);
                intent.putExtra("wait","N/A");
                startActivity(intent);
            }
            else
            {
                Person person = new Person(namefirst, namelast, age, prioritylevel, travelhistory,(maxwaitingnumber+1));
                personDatabase.personDao().insert(person);
                Intent intent = new Intent(this, Result_Activity.class);
                intent.putExtra("level", Integer.toString(prioritylevel));
                intent.putExtra("resulttext", result);
                intent.putExtra("wait",Integer.toString(maxwaitingnumber+1));
                startActivity(intent);
            }
        }


        }
        public boolean onOptionsItemSelected (MenuItem item)
        {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            return true;
        }
    }

