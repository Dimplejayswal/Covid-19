package com.example.android19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.android19.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoTestRequiredList extends AppCompatActivity {
    public  static PersonDatabase personDatabase2;
    ListView lv;
    NoTestNeededAdapter adapter;
    List<Person> people;
    ArrayList<Person>persons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_test_required_list);

        getSupportActionBar().setTitle("No Test Required List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        personDatabase2 = Room.databaseBuilder(getApplicationContext(),PersonDatabase.class,"personlist").allowMainThreadQueries().build();
        people= personDatabase2.personDao().getallpersonsnotest();

        lv=(ListView)findViewById(R.id.notestneededlist);
        persons=(ArrayList<Person>) people;

        Collections.sort(persons, new PersonNameComparator());
        adapter=new NoTestNeededAdapter(this,R.layout.testnotneeded,persons);

        lv.setAdapter(adapter);
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        return true;
    }
}
