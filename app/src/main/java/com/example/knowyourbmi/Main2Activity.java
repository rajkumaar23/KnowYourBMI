package com.example.knowyourbmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    //Copyright by RAJKUMAR
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void start(View view)
    {
       Intent intent = new Intent(Main2Activity.this, MainActivity.class);


        startActivity(intent);
    }
}
