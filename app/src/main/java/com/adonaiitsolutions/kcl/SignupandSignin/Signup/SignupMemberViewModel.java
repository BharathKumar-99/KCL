package com.adonaiitsolutions.kcl.SignupandSignin.Signup;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.adonaiitsolutions.kcl.SignupandSignin.FirstPage;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SignupMemberViewModel extends AndroidViewModel {

    @SuppressLint("StaticFieldLeak")
    Context context;
    public SignupMemberViewModel(@NonNull Application application) {
        super(application);
        this.context=getApplication().getApplicationContext();
    }

    public void postData(String name, String fathername, String dob, String blood, String phone,
                         String email, String addar, String networkName, String doorno,
                         String streetName, String pin, String village, String taluk,
                         String nomineeName, String nomineeAddar, String nomineeRelation,
                         String nomineeDob, String state, String district, String pic, String password,String memberid) {

        String url = "https://kscoa.in/Php/signupemp.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    Log.d("TAG", "onResponse: " + response);
                    Toast.makeText(context, "login done", Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context, FirstPage.class));

                },
                error -> Log.d("TAG", "onErrorResponse: " + error.toString())) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parms = new HashMap<>();
                parms.put("name", name);
                parms.put("email", email);
                parms.put("fname", fathername);
                parms.put("dob", dob);
                parms.put("blood_group", blood);
                parms.put("telephone", phone);
                parms.put("adhar_card", addar);
                parms.put("network_name", networkName);
                parms.put("address", doorno);
                parms.put("address2", streetName);
                parms.put("country", "IN");
                parms.put("state", state);
                parms.put("city", district);
                parms.put("postcode", pin);
                Log.d("TAG", "getParams: " + pic);
                parms.put("taluk", taluk);
                parms.put("village", village);
                parms.put("nominename", nomineeName);
                parms.put("nominename_adhar", nomineeAddar);
                parms.put("nominename_relation", nomineeRelation);
                parms.put("n_dob", nomineeDob);
                parms.put("password", password);
                parms.put("upload", pic);
                parms.put("memberid", memberid);

                return parms;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }
}


