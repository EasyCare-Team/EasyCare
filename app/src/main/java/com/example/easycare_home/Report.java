package com.example.easycare_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

public class Report extends AppCompatActivity {

    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);
        b1 = (Button) findViewById(R.id.tabLayout_id);
        b2 = (Button) findViewById(R.id.weekly);
        b3 = (Button) findViewById(R.id.monthly);


        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.tabLayout_id:
                        measure();
                        predict();
                        report();
                        break;
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                weekly();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                monthly();
            }
        });


    }
    public void report(){
        Intent intent = new Intent(this, Report.class);
        startActivity(intent);
    }
    public void predict(){
        Intent intent = new Intent(this, Prediction.class);
        startActivity(intent);
    }
    public void measure(){
        Intent intent = new Intent(this, Measure.class);
        startActivity(intent);
    }
    public void weekly(){
        Intent intent = new Intent(this, WeeklyReport.class);
        startActivity(intent);
    }
    public void monthly(){
        Intent intent = new Intent(this, MonthlyReport.class);
        startActivity(intent);
    }

}
