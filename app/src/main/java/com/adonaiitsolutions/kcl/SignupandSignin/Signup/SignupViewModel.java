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


public class SignupViewModel extends AndroidViewModel{
    @SuppressLint("StaticFieldLeak")
    Context context;

    public SignupViewModel(@NonNull Application application) {
        super(application);
        context=getApplication().getApplicationContext();
    }


    public void postData(String name, String father_name, String dob, String blood, String phone,
                           String email, String adhar, String networkname, String doorno,
                           String streetname, String pin, String village, String taluk,
                           String nomineename, String nomineeaddar, String nomineerelation,
                           String nomineedob, String state, String district, String photo,
                           String Password) {


        String url = "https://kscoa.in/Php/signup.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response ->{ Log.d("TAG", "onResponse: " + response);
                    Toast.makeText(context, "login done", Toast.LENGTH_SHORT).show();
context.startActivity(new Intent(context, FirstPage.class));

                },
                error -> Log.d("TAG", "onErrorResponse: " + error.toString())) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parms = new HashMap<>();
                parms.put("name", name);
                parms.put("email", email);
                parms.put("fname", father_name);
                parms.put("dob", dob);
                parms.put("blood_group", blood);
                parms.put("telephone", phone);
                parms.put("adhar_card", adhar);
                parms.put("network_name", networkname);
                parms.put("address", doorno);
                parms.put("address2", streetname);
                parms.put("country", "IN");
                parms.put("state", state);
                parms.put("city", district);
                parms.put("postcode", pin);
                Log.d("TAG", "getParams: " + photo);
                parms.put("taluk", taluk);
                parms.put("village", village);
                parms.put("nominename", nomineename);
                parms.put("nominename_adhar", nomineeaddar);
                parms.put("nominename_relation", nomineerelation);
                parms.put("n_dob", nomineedob);
                parms.put("password", Password);
                parms.put("upload", photo);

                return parms;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


    }


}
