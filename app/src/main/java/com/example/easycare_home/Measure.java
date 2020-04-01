package com.example.easycare_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class Measure extends AppCompatActivity implements View.OnClickListener {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.measure);


        b1 = findViewById(R.id.tabLayout_id);

        b1.setOnClickListener(this);


    }

    public void report(){
        Intent intent = new Intent(this, Report.class);
        startActivity(intent);
    }
    public void predict(){
        Intent intent = new Intent(this, Prediction.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.tabLayout_id:
                report();
                predict();
                break;
        }

    }
}
