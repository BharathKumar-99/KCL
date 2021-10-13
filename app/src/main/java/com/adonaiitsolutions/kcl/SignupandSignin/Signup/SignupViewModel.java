package com.adonaiitsolutions.kcl.SignupandSignin.Signup;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupViewModel extends ViewModel {
String Response;

    public String postData(String name, String father_name, String dob, String blood, String phone,
                           String email, String adhar, String networkname, String doorno,
                           String streetname, String pin, String village, String taluk,
                           String nomineename, String nomineeaddar, String nomineerelation,
                           String nomineedob, String state, String district, String photo) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://aiccollege.com/PHP/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api retrofitAPI = retrofit.create(Api.class);

        Call<SignupModel> call = retrofitAPI.createPost(name, father_name, dob, blood, phone, email, adhar, networkname, doorno, streetname, pin,
                village, state, district, taluk, nomineename, nomineeaddar, nomineerelation, nomineedob);


        call.enqueue(new Callback<SignupModel>() {
            @Override
            public void onResponse(Call<SignupModel> call, Response<SignupModel> response) {
                Log.d("TAG", "onResponse: " + response.toString()+ "ss");
             Response="Signup Successful";
            }

            @Override
            public void onFailure(Call<SignupModel> call, Throwable t) {
                Response=t.toString();
            }
        });
        return Response;
    }



}
