package com.example.android19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android19.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestRequiredList extends AppCompatActivity {
    public  static PersonDatabase personDatabase1;
    ListView lv;
    TestNeededAdapter adapter;
    List<Person> people;
    ArrayList<Person>persons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_required_list);

        getSupportActionBar().setTitle("Test Required List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        personDatabase1 = Room.databaseBuilder(getApplicationContext(),PersonDatabase.class,"personlist").allowMainThreadQueries().build();
        people= personDatabase1.personDao().getallpersons();


        lv=(ListView)findViewById(R.id.testneededlist);
        persons=(ArrayList<Person>) people;

        Collections.sort(people);

        adapter=new TestNeededAdapter(this,R.layout.testneeded,persons);



        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder builder=new AlertDialog.Builder(TestRequiredList.this);
                builder.setTitle("Test check");
                builder.setMessage("Are you done with the test?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        persons.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("No",null);
                builder.show();
            }

        });






    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        return true;
    }
}
