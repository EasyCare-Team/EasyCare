package com.example.easycare_home;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    GridView gridView;
    String [] measureName = {"Measure Heart Rate", "Measure Blood Pressure", "Measure Temperature", "Measure BMI"};
    int [] measureImg = {R.drawable.heartrate, R.drawable.bp, R.drawable.temp, R.drawable.bmi};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridview);
        CustomAdapter customAdapter= new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("name", measureName[i]);
                intent.putExtra("image", measureImg[i]);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return measureImg.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data, null);
            TextView name = view1.findViewById(R.id.text2);
            ImageView img = view1.findViewById(R.id.img2);
            name.setText(measureName[i]);
            img.setImageResource(measureImg[i]);
            return view1;
        }
    }

}
