package com.example.user.farmally;

import android.app.AlertDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddProduct extends AppCompatActivity {
   EditText type,comm,qua,price;
    SQLiteDatabase db;
    Button Add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        type = (EditText) findViewById(R.id.type);
        comm = (EditText) findViewById(R.id.comm);
        qua = (EditText) findViewById(R.id.qua);
        price = (EditText) findViewById(R.id.price);
        Add = (Button) findViewById(R.id.Add);
        db=openOrCreateDatabase("ACCDB", Context.MODE_PRIVATE,null);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Type = type.getText().toString();
                String Comm = comm.getText().toString();
                String Quant = qua.getText().toString();
                String Price = price.getText().toString();
                db.execSQL("INSERT INTO PRODUCT VALUES('" + Type + "','" + Comm + "','" + Quant + "','" + Price + "');");
                showMessage("Success","Product added successfully");



            }
        });



    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
