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

import com.google.android.material.tabs.TabLayout;

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
        e3 =  findViewById(R.id.pass);
        e4 =  findViewById(R.id.cpassword);
        b1 =  findViewById(R.id.register);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString().trim();
                String user = e2.getText().toString().trim();
                String pwd =  e3.getText().toString().trim();
                String cnf_pwd = e4.getText().toString().trim();

                if (pwd.equals(cnf_pwd)) {
                    long val = db.addUser(email, user, pwd);
                    if (val > 0){
                        Toast.makeText(Sign_Up.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
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
//        signin.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//
//
//                public void onTabSelected(TabLayout.Tab tab) {
//                    Intent fp = new Intent(Sign_Up.this, Sign_In.class);
//                    startActivity(fp);
//
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//        signup.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//
//
//            public void onTabSelected(TabLayout.Tab tab) {
//                Intent fp = new Intent(Sign_Up.this, Sign_Up.class);
//                startActivity(fp);
//
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//    View view;
//    public Sign_In() {
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.sign_in, container,false);
//        return view;
//    }

    }
}
