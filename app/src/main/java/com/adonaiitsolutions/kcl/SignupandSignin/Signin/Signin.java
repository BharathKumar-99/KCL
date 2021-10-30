package com.adonaiitsolutions.kcl.SignupandSignin.Signin;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.adonaiitsolutions.kcl.R;
import com.adonaiitsolutions.kcl.SignupandSignin.Signup.Signup;
import com.adonaiitsolutions.kcl.ui.Profile.ProfileActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Signin extends AppCompatActivity {
TextView phone,password,signupnav;
Button login;
    String email1;
    boolean result;
String Phone,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        phone=findViewById(R.id.loginnumber);
        password=findViewById(R.id.loginpassword);
       login=findViewById(R.id.login);
        signupnav=findViewById(R.id.signupnav);


       login.setOnClickListener(v->{

               Phone = phone.getText().toString();
               Password = password.getText().toString();
                login(Phone,Password);

           signupnav.setOnClickListener(e-> startActivity(new Intent(this, Signup.class)));


       });
    }
    public void login(String phone,String password){

        String url="http://aiccollege.com/PHP/login.php";

        Log.d("TAG", "login: ");

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                response ->{

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Log.d("TAG", "onResponse: "+ response);
                    assert jsonObject != null;
                    if (jsonObject.optString("login").equals("1")){
                            result=true;
                            try {

                                 email1 = jsonObject.getString("message");

                                Log.d("TAG", "login: "+email1);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(this, ProfileActivity.class);
                            i.putExtra("key",email1);
                            startActivity(i);
                            finishAffinity();
                        }else {
                            Toast.makeText(this, "Login Failed Check phone and Password", Toast.LENGTH_SHORT).show();
                        }
                },
                error -> {
                    Log.d("TAG", "onErrorResponse: "+error.toString());
                    Toast.makeText(this, "Something went wrong try again after sometime", Toast.LENGTH_SHORT).show();
                })
        {
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String>parms= new HashMap<>();
                parms.put("email",phone);
                parms.put("psw",password);
                return parms;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}