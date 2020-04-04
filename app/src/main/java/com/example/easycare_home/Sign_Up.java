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
        e1 =  findViewById(R.id.email);
        e2 =  findViewById(R.id.username);
        e3 =  findViewById(R.id.password);
        e4 =  findViewById(R.id.cpassword);
        b1 =  findViewById(R.id.register);
        b2 =  findViewById(R.id.login);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_Up.this, Sign_In.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String username = e2.getText().toString();
                String password = e3.getText().toString();
                String cnf_pwd = e4.getText().toString();

                if(email.equals("") || username.equals("") || password.equals("") || cnf_pwd.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields Required", Toast.LENGTH_SHORT).show();
                }else{
                    if (password.equals(cnf_pwd)){
                        Boolean checkusername = db.CheckUsername(username);
                        if (checkusername == true){
                            Boolean insert = db.Insert(username,password);
                            if (insert == true){
                                Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                                email.setText("");
                                username.setText("");
                                password.setText("");
                                cnf_pwd.setText("");
                            }
                        }else {
                            Toast.makeText(getApplicationContext(), "Username Already Taken", Toast.LENGTH_SHORT).show();

                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Password Does Not Match", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }
}
