package com.example.neha.attendancesystem;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentNames extends AppCompatActivity {

    private ArrayList arrayRegNo;
    private ArrayList arrayName;
    private ArrayAdapter<String> arrayAdapter;
    private ListView listView;
    private FloatingActionButton floatingActionButton;
    private String regNo;
    private String name;
    private EditText reg_No;
    private EditText name_stu;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_names);

        listView = findViewById(R.id.list_student);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        submit = findViewById(R.id.submit);

        arrayRegNo = new ArrayList();
        arrayName = new ArrayList();

        arrayAdapter = new CustomAdapter(getApplicationContext(),arrayRegNo,arrayName);

        listView.setAdapter(arrayAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(StudentNames.this);
                View view1 = getLayoutInflater().inflate(R.layout.alert_box_for_reg_no,null);

                reg_No = view1.findViewById(R.id.Name);
                Button next = view1.findViewById(R.id.Nextbtn);
                Button cancel = view1.findViewById(R.id.Cancelbtn);

                alert.setView(view1);

                final AlertDialog alertDialog = alert.create();
                alertDialog.show();

                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        regNo = reg_No.getText().toString();
                        alertDialog.cancel();

                        AlertDialog.Builder al = new AlertDialog.Builder(StudentNames.this);

                        View view2 = getLayoutInflater().inflate(R.layout.alert_box_for_name,null);
                        name_stu =  view2.findViewById(R.id.Name);

                        Button save = view2.findViewById(R.id.Savebtn);
                        Button can = view2.findViewById(R.id.Cancelbtn);

                        al.setView(view2);

                        final AlertDialog alertDialog1 = al.create();
                        alertDialog1.show();


                        save.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                name = name_stu.getText().toString();
                                arrayRegNo.add(regNo);
                                arrayName.add(name);

                                alertDialog1.cancel();
                                arrayAdapter.notifyDataSetChanged();

                            }
                        });

                        can.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                alertDialog1.cancel();
                            }
                        });



                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        alertDialog.cancel();

                    }
                });


            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String string = "";

                for (int i = 0 ; i < arrayRegNo.size() ; i++){

                    //View view1 = getViewByPosition(i,listView);

                    View view1 = listView.getChildAt(i);

                    RadioButton present = view1.findViewById(R.id.Present);
                    RadioButton absent = view1.findViewById(R.id.Absent);

                    if (present.isChecked())
                        string+=" present";
                    else if (absent.isChecked())
                        string+=" Absent";

                }

                Toast.makeText(StudentNames.this, string, Toast.LENGTH_SHORT).show();

            }
        });

    }

   /* public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }*/
}
