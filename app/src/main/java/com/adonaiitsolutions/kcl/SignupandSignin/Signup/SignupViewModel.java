package com.adonaiitsolutions.kcl.SignupandSignin.Signup;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupViewModel extends AndroidViewModel {
String Response;
Context context;

    public SignupViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public String postData(String name, String father_name, String dob, String blood, String phone,
                           String email, String adhar, String networkname, String doorno,
                           String streetname, String pin, String village, String taluk,
                           String nomineename, String nomineeaddar, String nomineerelation,
                           String nomineedob, String state, String district, String photo) {



            String url="http://aiccollege.com/PHP/signup.php";

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("TAG", "onResponse: "+ response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", "onErrorResponse: "+error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String>parms=new HashMap<String, String>();
                parms.put("name",name);
                parms.put("email",email);
                parms.put("fname",father_name);
                parms.put("dob",dob);
                parms.put("blood_group",blood);
                parms.put("telephone",phone);
                parms.put("adhar_card",adhar);
                parms.put("network_name",networkname);
                parms.put("address",doorno);
                parms.put("address2",streetname);
                parms.put("country","IN");
                parms.put("state",state);
                parms.put("city",district);
                parms.put("postcode",pin);
                parms.put("profile_img",photo);
               // parms.put("landmark",father_name);
                parms.put("taluk",taluk);
                parms.put("village",village);
                parms.put("nominename",nomineename);
                parms.put("nominename_adhar",nomineeaddar);
                parms.put("nominename_relation",nomineerelation);
                parms.put("n_dob",nomineedob);
                return parms;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);




        return Response;
    }



}
