package com.example.knowyourbmi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.DecimalFormat;

//Copyright by RAJKUMAR


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    double bmi=0.0;
    String result1;
    public void calcbmi(View v){
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        EditText height=(EditText) findViewById(R.id.heightinput);

        if(height.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Height is empty! Please enter!", Toast.LENGTH_SHORT).show();
        }
        else{
            String h=height.getText().toString();
            double he=Float.parseFloat(h);
        he=0.01*he;
        EditText weight=(EditText) findViewById(R.id.weightinput);
            if(weight.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Weight is empty! Please enter!", Toast.LENGTH_SHORT).show();
            }
        else{String w=weight.getText().toString();
        double we=Float.parseFloat(w);
        bmi=(we/(he*he));
        DecimalFormat twoDForm = new DecimalFormat("#.#");
        bmi=Double.valueOf(twoDForm.format(bmi));
        result1="Your BMI is "+String.valueOf(bmi);
        if(bmi<18.5) {
            result1 += "\nHey! You're in the UnderWeight category. \nDo develop your body and stay fit.";
            ImageView outp = (ImageView) findViewById(R.id.pic);
            outp.setImageDrawable(getResources().getDrawable(R.drawable.down));
        }
        else if(bmi<24.9 && bmi>=18.5){
            result1+="\nHey! You're in the Normal category. Congrats. Maintain it. ";
            ImageView outp=(ImageView) findViewById(R.id.pic);
            outp.setImageDrawable(getResources().getDrawable(R.drawable.up));
        }

        else if(bmi>=24.9 && bmi<=30)
        {
            result1+="\nHey! You're in the Overweight category. \nDo exercise your body and stay fit.";
            ImageView outp=(ImageView) findViewById(R.id.pic);
            outp.setImageDrawable(getResources().getDrawable(R.drawable.down));
        }
        else if(bmi>30) {
            result1 += "\nHey! You're in the Obese category. \nDo exercise your body and stay fit.";
            ImageView outp = (ImageView) findViewById(R.id.pic);
            outp.setImageDrawable(getResources().getDrawable(R.drawable.down2));
        }

        TextView result=(TextView) findViewById(R.id.output);
        result.setText(result1);
    }}}
    public void share(View v)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Hey! Do you know how important it is to stay fit and healthy? I've found out my BMI to be "+bmi+".\nCheck out yours too.");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
