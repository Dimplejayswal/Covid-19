package com.example.android19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android19.R;

public class Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_);

        getSupportActionBar().setTitle("ResultActivity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String current;

        String intent=getIntent().getStringExtra("level");
        String getresult=getIntent().getStringExtra("resulttext");
        String getwait=getIntent().getStringExtra("wait");

        TextView waitlevel=(TextView)findViewById(R.id.waitingnum);
        TextView result=(TextView)findViewById(R.id.resultshare);





            current=intent;
            result.setText(getresult);
            waitlevel.setText(getwait);

            TextView plvel=(TextView)findViewById(R.id.priotitynum);
            plvel.setText(current);
//            Toast toast = Toast.makeText(getApplicationContext(), ""+getwait, Toast.LENGTH_SHORT);
//            toast.show();






    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent i = new Intent(getApplicationContext(), Patient_Entry_Activity.class);
        startActivity(i);
        return true;
    }



}
