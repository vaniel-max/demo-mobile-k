package com.example.demomobilv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLog = (Button) findViewById(R.id.buttonLogLO);
        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNav();
            }
        });
    }

    public void  openNav(){
        Intent intent = new Intent(this, NavMain2Activity.class);
        startActivity(intent);
    }
}