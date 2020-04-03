package com.example.easycare_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class Tab_viewer2 extends AppCompatActivity {

    TabLayout tablayout;
    ViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        tablayout = (TabLayout) findViewById(R.id.tabLayout_id);
        viewpager = (ViewPager) findViewById(R.id.viewpager_id);

        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.AddFragment(new Measure_Fragment(), "Measure");
        adapter.AddFragment(new Report_Fragment(), "Report");

        adapter.AddFragment(new Prediction_Fragment(), "Prediction");
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);

    }

}
