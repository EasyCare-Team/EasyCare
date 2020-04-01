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

public class Sign_In extends AppCompatActivity  {
    Button btn_lregister, btn_llogin;
    EditText et_lusername, et_lpassword;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        databaseHelper = new DatabaseHelper(this);

        et_lusername = findViewById(R.id.username);
        et_lpassword = findViewById(R.id.password);

        btn_llogin = findViewById(R.id.login);
        btn_lregister = findViewById(R.id.register);

        btn_lregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_In.this, Sign_Up.class);
                startActivity(intent);
            }
        });

        btn_llogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_lusername.getText().toString();
                String password = et_lpassword.getText().toString();

                Boolean checklogin = databaseHelper.CheckLogin(username, password);
                if(checklogin == true){
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


//    EditText e1, e2;
//    Button b1,b2;
//    DatabaseHelper db;
//
//    private AppBarConfiguration mAppBarConfiguration;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.sign_in);
//
//        db = new DatabaseHelper(this);
//        e1 = (EditText) findViewById(R.id.username);
//        e2 = (EditText) findViewById(R.id.password);
//        b2 = (Button) findViewById(R.id.register);
//        b1 = (Button) findViewById(R.id.login);
//
//        b1.setOnClickListener(this);
//
//    }
//    public void signUp(){
//        Intent intent = new Intent(this, Sign_Up.class);
//        startActivity(intent);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.login:
//                String user = e1.getText().toString().trim();
//                String pw = e2.getText().toString().trim();
//                Boolean res = db.checkUser(user, pw);
//                if (res == true) {
//                    Toast.makeText(Sign_In.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(Sign_In.this, "Login Error", Toast.LENGTH_SHORT).show();
//                }
//                break;
//            case R.id.register:
//                signUp();
//                break;
//        }
//
//    }
}
