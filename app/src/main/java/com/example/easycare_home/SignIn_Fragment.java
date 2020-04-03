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
import androidx.fragment.app.Fragment;

public class SignIn_Fragment extends Fragment {
    View view;
    public SignIn_Fragment() {
    }

    Button btn_lregister, btn_llogin;
    EditText et_lusername, et_lpassword;


    DatabaseHelper databaseHelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sign_in, container,false);
        databaseHelper = new DatabaseHelper(getContext());

        et_lusername = view.findViewById(R.id.username);
        et_lpassword = view.findViewById(R.id.password);

        btn_llogin = view.findViewById(R.id.login);
        btn_lregister = view.findViewById(R.id.register);


        btn_llogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_lusername.getText().toString();
                String password = et_lpassword.getText().toString();

                boolean checklogin = databaseHelper.checkUser(username, password);
                if(checklogin){
                    Toast.makeText(getContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getContext(), Tab_viewer2.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
