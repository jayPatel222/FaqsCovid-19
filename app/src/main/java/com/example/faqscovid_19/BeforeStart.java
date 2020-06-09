package com.example.faqscovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BeforeStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_start);
    }

    public void RunningEmulator(View myView){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void RunningCellphone(View myView){
        Intent myIntent = new Intent(this, login.class);
        startActivity(myIntent);
    }
}