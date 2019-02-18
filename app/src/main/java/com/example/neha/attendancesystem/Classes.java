package com.example.neha.attendancesystem;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Classes extends AppCompatActivity {

    private Button button;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList arrayList;
    private MyDBHelper myDBHelper;
    private int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classes);

        myDBHelper = new MyDBHelper(Classes.this);
        arrayList = new ArrayList();

        Cursor cursor = myDBHelper.GET_CLASS_NAME();
        while (cursor.moveToNext()){

            String className = cursor.getString(0);
            arrayList.add(className);

        }

        arrayAdapter = new ArrayAdapter<String>(
                Classes.this,
                R.layout.list_view,
                arrayList
        );

        listView = findViewById(R.id.list);

        listView.setAdapter(arrayAdapter);

        button = findViewById(R.id.addClass);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean result = myDBHelper.ADD_CLASS("GEC16");

                if (result){
                    arrayList.add("GCS16");
                    arrayAdapter.notifyDataSetChanged();
                }

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                x = i;

                AlertDialog.Builder alert = new AlertDialog.Builder(Classes.this);

                alert.setMessage("Do you want to delete this class ");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Integer deletedRows = myDBHelper.DELETE_CLASS((String) arrayList.get(x));

                        if (deletedRows > 0){

                            arrayList.remove(x);
                            arrayAdapter.notifyDataSetChanged();

                        }

                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                alert.show();

                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
}
