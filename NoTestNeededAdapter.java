package com.example.android19;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android19.R;

import java.util.ArrayList;

public class NoTestNeededAdapter extends ArrayAdapter<Person> {
    private ArrayList<Person> persons;
    private Context context;
    private int resource;

    public NoTestNeededAdapter(Context context, int resource, ArrayList<Person> objects) {
        super(context, resource, objects);
        this.persons=objects;
        this.context=context;
        this.resource=resource;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String firstn2=this.persons.get(position).getFirstName();
        String lastn2=this.persons.get(position).getLastName();
        int userage2=this.persons.get(position).getAge();

        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView=inflater.inflate(this.resource,parent,false);

        TextView tv22=(TextView)convertView.findViewById(R.id.name2);
        TextView tv23=(TextView)convertView.findViewById(R.id.age2);


        tv22.setText(firstn2+" "+lastn2);
        tv23.setText(Integer.toString(userage2));

        return convertView;
    }
}
