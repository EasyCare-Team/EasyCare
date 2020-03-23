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

public class Sign_In extends AppCompatActivity {

    EditText e1, e2;
    Button b1,b2;
    DatabaseHelper db;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        db = new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.username);
        e2 = (EditText) findViewById(R.id.password);
        b2 = (Button) findViewById(R.id.tabLayout_id);
        b1 = (Button) findViewById(R.id.login);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.login:
                        String user = e1.getText().toString().trim();
                        String pw = e2.getText().toString().trim();
                        Boolean res = db.checkUser(user, pw);
                        if (res == true) {
                            Toast.makeText(Sign_In.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                            measure();
                        } else {
                            Toast.makeText(Sign_In.this, "Login Error", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.register:
                        signUp();
                        break;
                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.tabLayout_id:
                        signUp();
                        signIn();
                        break;
                }

            }

        });

    }

    public void signUp(){
        Intent intent = new Intent(this, Sign_Up.class);
        startActivity(intent);
    }
    public void signIn(){
        Intent intent = new Intent(this, Sign_In.class);
        startActivity(intent);
    }
    public void measure(){
        Intent intent = new Intent(this, Measure.class);
        startActivity(intent);
    }
}
