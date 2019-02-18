package com.example.neha.attendancesystem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;



public class CustomAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList arrayRegNo;
    private ArrayList arrayName;
    private TextView RegNo;
    private TextView Name;

    public CustomAdapter(@NonNull Context context, ArrayList regNo,ArrayList name) {
        super(context, R.layout.student_list,regNo);
        this.context = context;
        this.arrayRegNo = regNo;
        this.arrayName = name;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.student_list,null);

        RegNo = view.findViewById(R.id.RegNo);
        Name = view.findViewById(R.id.Name);

        RegNo.setText((String)arrayRegNo.get(position));
        Name.setText((String)arrayName.get(position));

        return view;

    }

}
