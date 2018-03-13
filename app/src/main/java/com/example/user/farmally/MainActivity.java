package com.example.user.farmally;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText e1,e2;
Button b1;
TextView l1;
SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);

        b1=(Button)findViewById(R.id.b1);

        l1=(TextView)findViewById(R.id.t1);

        db=openOrCreateDatabase("ACCDB", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS LOGIN(NAME VARCHAR,AGE VARCHAR,UNAME VARCHAR,PWORD VARCHAR,ADDR VARCHAR,TYPE VARCHAR,PHONE VARCHAR);");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.rawQuery("SELECT * FROM LOGIN WHERE UNAME='" + e1.getText().toString() + "' AND PWORD='" + e2.getText().toString() + "'", null);
                if (c.moveToFirst())
                {
                    Intent intent=new Intent(MainActivity.this,HOME.class);
                    intent.putExtra("UNAME",e1.getText().toString());
                    startActivity(intent);
                }
                else
                    showMessage("Error", "Invalid Data!...");
            }
        });

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Register.class));
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


