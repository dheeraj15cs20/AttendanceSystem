package com.example.neha.attendancesystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Admin extends AppCompatActivity {
    EditText adminName,adminPassword,adminCpassword;
    Button adminSignup;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        firebaseAuth= FirebaseAuth.getInstance();
        adminName=(EditText)findViewById(R.id.adminName);
        adminPassword=(EditText)findViewById(R.id.adminPassword);
        adminCpassword=(EditText)findViewById(R.id.adminCpassword);
        adminSignup=(Button)findViewById(R.id.adminSignup);
        progressDialog=new ProgressDialog(this);

        adminSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminRegister();
                Intent I = new Intent(getApplication(), MainActivity.class);
                startActivity(I);
            }
        });
    }
    private  void AdminRegister(){
        String aName=adminName.getText().toString().trim();
        String aPassword=adminPassword.getText().toString().trim();
        String aCpassword=adminCpassword.getText().toString().trim();
        if(TextUtils.isEmpty(aName)|| TextUtils.isEmpty(aPassword)|| TextUtils.isEmpty(aCpassword)){
            Toast.makeText(getApplication(),"don't left the field empty",Toast.LENGTH_SHORT).show();
            return;
        }
        if(aPassword.length()<8)
        {
            Toast.makeText(getApplicationContext(),"password length should be eight character",Toast.LENGTH_SHORT).show();
        }
        if(aPassword.equals(aCpassword))
        {
            Toast.makeText(this,"password matched",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"password does not match",Toast.LENGTH_SHORT).show();
        }

        progressDialog.setMessage("Registering User.... ");
        progressDialog.show();
       /* firebaseAuth.createUserWithEmailAndPassword(aPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Admin.this, "Registration Successfull", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(Admin.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                });*/
    }
}
