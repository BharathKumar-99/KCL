package com.adonaiitsolutions.kcl.SignupandSignin.Signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.adonaiitsolutions.kcl.R;


public class Signup extends Fragment {
TextView name,father_name,dob,blood,phone,email,adhar,networkname,doorno,streetname,pin,village,
        taluk,nomineename,nomineeaddar,nomineerelation,nomineedob;
Spinner state,district;
Button pic,submit;
    public Signup() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_signup, container, false);
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name=view.findViewById(R.id.name);
        father_name=view.findViewById(R.id.fathername);
        dob=view.findViewById(R.id.dob);
        blood=view.findViewById(R.id.bloodgroup);
        phone=view.findViewById(R.id.phonenumber);
        email=view.findViewById(R.id.email);
        adhar=view.findViewById(R.id.adharnum);
        networkname=view.findViewById(R.id.networkname);
        doorno=view.findViewById(R.id.doorno);
        streetname=view.findViewById(R.id.streetname);
        pin=view.findViewById(R.id.pin);
        village=view.findViewById(R.id.village);
        state=view.findViewById(R.id.state);
        district=view.findViewById(R.id.District);
        taluk=view.findViewById(R.id.taluk);
        nomineename=view.findViewById(R.id.nname);
        nomineeaddar=view.findViewById(R.id.naddar);
        nomineerelation=view.findViewById(R.id.nrelation);
        nomineedob=view.findViewById(R.id.ndob);
        pic=view.findViewById(R.id.photo);
        submit=view.findViewById(R.id.submit);





    }
}