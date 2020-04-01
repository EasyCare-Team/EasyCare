package com.example.easycare_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MonthlyReport extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monthly_report);

        b1 = (Button) findViewById(R.id.weekly);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                weekly();
            }
        });
    }

    public void weekly(){
        Intent intent = new Intent(this, WeeklyReport.class);
        startActivity(intent);
    }



}
