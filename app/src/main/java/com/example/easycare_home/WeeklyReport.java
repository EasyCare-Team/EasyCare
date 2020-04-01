package com.example.easycare_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class WeeklyReport extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weekly_report);

        b1 = (Button) findViewById(R.id.monthly);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                monthly();
            }
        });
    }

    public void monthly(){
        Intent intent = new Intent(this, MonthlyReport.class);
        startActivity(intent);
    }



}
