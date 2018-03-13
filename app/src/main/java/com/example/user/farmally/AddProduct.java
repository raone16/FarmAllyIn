package com.example.user.farmally;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddProduct extends AppCompatActivity {
    String[] Ctype = {"Cereals","Pulses","Vegetables","Spices","Fruits"};
    String[] Cereals = {"Rice","Ragi","Paddy","Wheat"};
    String[] Pulses = {"Bengal Gram","Black Gram"};
    String[] Veg = {"Bottle Gourd","Brinjal","Cabbage","Onion","Tomato"};
    String[] Spices = {"Garlic","Ginger","Clove","Pepper","Bay Leaf"};
    String[] Fruits = {"Banana","Mango","Papaya","PineApple","Water Melon"};
    Spinner S1,S2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        S1=(Spinner) findViewById(R.id.spinner1);
        S2=(Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> typeAd= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,Ctype);
        final ArrayAdapter<String> cAd = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,Cereals);
        final ArrayAdapter<String> pAd = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,Pulses);
        final ArrayAdapter<String> vAd = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,Veg);
        final ArrayAdapter<String> sAd = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,Spices);
        final ArrayAdapter<String> fAd = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,Fruits);
        S1.setAdapter(typeAd);
        S1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        S2.setAdapter(cAd);
                        break;
                    case 1:
                        S2.setAdapter(pAd);
                        break;
                    case 2:
                        S2.setAdapter(vAd);
                        break;
                    case 3:
                        S2.setAdapter(sAd);
                        break;
                    case 4:
                        S2.setAdapter(fAd);
                        break;
                }
            }
        });



    }
}
