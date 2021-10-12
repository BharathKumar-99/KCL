package com.adonaiitsolutions.kcl.SignupandSignin.Signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.adonaiitsolutions.kcl.SignupandSignin.Api;
import com.adonaiitsolutions.kcl.R;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Signup extends Fragment {
    String Name,Fathername,Dob,Blood,Phone,Email,Addar,NetworkName,Doorno,StreetName,Pin,Village,Taluk,
    NomineeName,NomineeAddar,NomineeRelation,NomineeDob,State,District,Pic;
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
        name = view.findViewById(R.id.name);
        father_name = view.findViewById(R.id.fathername);
        dob = view.findViewById(R.id.dob);
        blood = view.findViewById(R.id.bloodgroup);
        phone = view.findViewById(R.id.phonenumber);
        email = view.findViewById(R.id.email);
        adhar = view.findViewById(R.id.adharnum);
        networkname = view.findViewById(R.id.networkname);
        doorno = view.findViewById(R.id.doorno);
        streetname = view.findViewById(R.id.streetname);
        pin = view.findViewById(R.id.pin);
        village = view.findViewById(R.id.village);
        state = view.findViewById(R.id.state);
        district = view.findViewById(R.id.District);
        taluk = view.findViewById(R.id.taluk);
        nomineename = view.findViewById(R.id.nname);
        nomineeaddar = view.findViewById(R.id.naddar);
        nomineerelation = view.findViewById(R.id.nrelation);
        nomineedob = view.findViewById(R.id.ndob);
        pic = view.findViewById(R.id.photo);
        submit = view.findViewById(R.id.submit);

        submit.setOnClickListener(v -> {
            Name = name.getText().toString();
            Fathername = father_name.getText().toString();
            Dob = dob.getText().toString();
            Blood = blood.getText().toString();
            Phone = phone.getText().toString();
            Email = email.getText().toString();
            Addar = adhar.getText().toString();
            NetworkName = networkname.getText().toString();
            Doorno = doorno.getText().toString();
            StreetName = streetname.getText().toString();
            Pin = pin.getText().toString();
            Village = village.getText().toString();
            State = "Karnataka";
            District = "Bangalore";
            Taluk = taluk.getText().toString();
            NomineeName = nomineename.getText().toString();
            NomineeAddar = nomineeaddar.getText().toString();
            NomineeRelation = nomineerelation.getText().toString();
            NomineeDob = nomineedob.getText().toString();
            Pic = "Path";

            postData(Name,Fathername,Dob,Blood,Phone,Email,Addar,NetworkName,Doorno,StreetName,Pin,
            Village,Taluk,NomineeName,NomineeAddar,NomineeRelation,NomineeDob,State,District,Pic);


        });
    }
        private void postData(String name, String father_name, String dob, String blood, String phone,
                              String email, String adhar, String networkname, String doorno,
                              String streetname, String pin, String village, String taluk,
                              String nomineename, String nomineeaddar, String nomineerelation,
                              String nomineedob, String state, String district, String photo) {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://aiccollege.com/PHP/")
                    .addConverterFactory(GsonConverterFactory.create())
                    // at last we are building our retrofit builder.
                    .build();
            // below line is to create an instance for our retrofit api class.
            Api retrofitAPI = retrofit.create(Api.class);


            SignupModel modal = new SignupModel(name,father_name,dob,blood,phone,email,adhar,
                    networkname,doorno,streetname,pin,village, taluk,nomineename,nomineeaddar,
                    nomineerelation,nomineedob,state,district,photo);

            // calling a method to create a post and passing our modal class.
            Call<SignupModel> call = retrofitAPI.createPost(name,father_name,dob,blood,phone,email,adhar,networkname,doorno,streetname,pin,
                    village,state,District,taluk,nomineename,nomineeaddar,nomineerelation,nomineedob);

            // on below line we are executing our method.
            call.enqueue(new Callback<SignupModel>() {
                @Override
                public void onResponse(Call<SignupModel> call, Response<SignupModel> response) {
                    Log.d("TAG", "onResponse: "+response.toString());
                }

                @Override
                public void onFailure(Call<SignupModel> call, Throwable t) {

                }
            });
    }


    }
