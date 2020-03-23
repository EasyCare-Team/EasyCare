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

public class Sign_Up extends AppCompatActivity {

    EditText e1, e2, e3, e4;
    Button b1;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        db = new DatabaseHelper(this);
        e1 =  findViewById(R.id.email);
        e2 =  findViewById(R.id.username);
        e3 =  findViewById(R.id.password);
        e4 =  findViewById(R.id.cpassword);
        b1 =  findViewById(R.id.register);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString().trim();
                String user = e2.getText().toString().trim();
                String pwd = e3.getText().toString().trim();
                String cnf_pwd = e4.getText().toString().trim();

                if (pwd.equals(cnf_pwd)) {
                    long val = db.addUser(email, user, pwd);
                    if (val > 0){
                        Toast.makeText(Sign_Up.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                        measure();
                    }
                    else {
                        Toast.makeText(Sign_Up.this, "Registration error", Toast.LENGTH_SHORT).show();
                    }
              }
                else {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void measure(){
        Intent intent = new Intent(this, Measure.class);
        startActivity(intent);
    }
}
