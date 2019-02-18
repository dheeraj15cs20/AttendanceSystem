package com.example.neha.attendancesystem;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Register extends AppCompatActivity {
    ImageView Iv1,Iv2,Iv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Iv1=(ImageView)findViewById(R.id.Iv1);
        Iv2=(ImageView)findViewById(R.id.Iv2);
        Iv3=(ImageView)findViewById(R.id.Iv3);
        Iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1= new Intent(Register.this,Student.class);
                startActivity(I1);
            }
        });
        Iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I2= new Intent(Register.this,Faculty.class);
                startActivity(I2);
            }
        });
        Iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I3= new Intent(Register.this,Admin.class);
                startActivity(I3);
            }
        });


    }
}
