package com.adonaiitsolutions.kcl.SignupandSignin.Signin;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class SigninViewmodel extends AndroidViewModel {

Context context;
Boolean result;
    public SigninViewmodel(@NonNull Application application) {
        super(application);
        context=getApplication().getApplicationContext();
    }


}
