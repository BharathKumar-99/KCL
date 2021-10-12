package com.adonaiitsolutions.kcl.SignupandSignin.Signin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.adonaiitsolutions.kcl.R;


public class Signin extends Fragment {

    TextView phone,password;
    Button submit;
    String Phone,Password;

    public Signin() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_signin, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        phone=view.findViewById(R.id.phone);
        password=view.findViewById(R.id.password);
        submit=view.findViewById(R.id.login);



        submit.setOnClickListener(v->{

            Phone=phone.getText().toString();
            Password=password.getText().toString();


        });
    }
}