package com.example.neha.attendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt2=(Button)findViewById(R.id.bt2);
        editText1=(EditText)findViewById(R.id.et1);
        editText2=(EditText)findViewById(R.id.et2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=  new Intent(MainActivity.this,Register.class);
                startActivity(I);
            }
        });
        Button bt1=(Button)findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName=editText1.getText().toString().trim();
                String Password=(editText2.getText().toString().trim());
                if(UserName.equals("Admin") || Password.equals("123")) {
                    Intent I1 = new Intent(MainActivity.this, Classes.class);
                    startActivity(I1);

                }
            }
        });
    }
}
