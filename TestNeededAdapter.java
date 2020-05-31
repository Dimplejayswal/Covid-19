package com.example.android19;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android19.R;

import java.util.ArrayList;

public class TestNeededAdapter extends ArrayAdapter<Person>{
    private ArrayList<Person> persons;
    private Context context;
    private int resource;

    public TestNeededAdapter(Context context, int resource, ArrayList<Person> objects) {
        super(context, resource, objects);
        this.persons=objects;
        this.context=context;
        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String firstn=this.persons.get(position).getFirstName();
        String lastn=this.persons.get(position).getLastName();
        int userage=this.persons.get(position).getAge();
        int pri=this.persons.get(position).getPriority();

        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView=inflater.inflate(this.resource,parent,false);

        TextView tv1=(TextView)convertView.findViewById(R.id.name1);
        TextView tv2=(TextView)convertView.findViewById(R.id.age1);
        TextView tv3=(TextView)convertView.findViewById(R.id.priority1);


        tv1.setText(firstn+" "+lastn);
        tv2.setText(Integer.toString(userage));
        tv3.setText(Integer.toString(pri));


        if (pri==1){
            tv1.setTextColor(Color.rgb(4,184,73));
            tv2.setTextColor(Color.rgb(4,184,73));
            tv3.setTextColor(Color.rgb(4,184,73));
        }
        else if(pri==2){
            tv1.setTextColor(Color.rgb(255,165,0));
            tv2.setTextColor(Color.rgb(255,165,0));
            tv3.setTextColor(Color.rgb(255,165,0));

        }
        else if(pri==3){
            tv1.setTextColor(Color.RED);
            tv2.setTextColor(Color.RED);
            tv3.setTextColor(Color.RED);
        }

        return convertView;
    }
}
