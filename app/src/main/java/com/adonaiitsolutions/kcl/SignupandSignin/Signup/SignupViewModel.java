package com.adonaiitsolutions.kcl.SignupandSignin.Signup;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;


import com.adonaiitsolutions.kcl.SignupandSignin.SendMail;
import com.adonaiitsolutions.kcl.SignupandSignin.Signin.Signin;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.Api;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;



public class SignupViewModel {
    String Response;
    @SuppressLint("StaticFieldLeak")
    Context context;



    public String postData(String name, String father_name, String dob, String blood, String phone,
                           String email, String adhar, String networkname, String doorno,
                           String streetname, String pin, String village, String taluk,
                           String nomineename, String nomineeaddar, String nomineerelation,
                           String nomineedob, String state, String district, String photo,
                           String Password,String pid,Context context) {

this.context=context;
        String url = "http://aiccollege.com/PHP/signup.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response ->{ Log.d("TAG", "onResponse: " + response);
                    Toast.makeText(context, "login done", Toast.LENGTH_SHORT).show();
Signin signup=new Signin();
signup.login(email,Password);
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
                parms.put("pid",pid);
                return parms;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return Response;
    }


}
