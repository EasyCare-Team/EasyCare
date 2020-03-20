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
    Button b1, b2;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        db = new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.email);
        e2 = (EditText) findViewById(R.id.username);
        e3 = (EditText) findViewById(R.id.password);
        e4 = (EditText) findViewById(R.id.cpassword);
        b1 = (Button) findViewById(R.id.register);
        b2 = (Button) findViewById(R.id.login);

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
                    }
                    else {
                        Toast.makeText(Sign_Up.this, "Registration error", Toast.LENGTH_SHORT).show();
                    }
              }
                else {
                    Toast.makeText(getApplicationContext(), "Password does nots match", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
    public void signIn(){
        Intent intent = new Intent(this, Sign_In.class);
        startActivity(intent);
    }
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.register:
//                String email = e1.getText().toString().trim();
//                String user = e2.getText().toString().trim();
//                String pwd = e3.getText().toString().trim();
//                String cnf_pwd = e4.getText().toString().trim();
//
//                if (pwd.equals(cnf_pwd)) {
//                    long val = db.addUser(email, user, pwd);
//                    if (val > 0){
//                        Toast.makeText(Sign_Up.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
//                    }
//                    else {
//                        Toast.makeText(Sign_Up.this, "Registration error", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), "Password does nots match", Toast.LENGTH_SHORT).show();
//                }
//                break;
//            case R.id.login:
//                signIn();
//                break;
//        }

//    }
}
