package com.adonaiitsolutions.kcl.SignupandSignin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.adonaiitsolutions.kcl.R;
import com.adonaiitsolutions.kcl.SignupandSignin.Signin.Signin;
import com.adonaiitsolutions.kcl.SignupandSignin.Signup.Signup;

public class FirstPage extends AppCompatActivity {
TextView login,sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        login=findViewById(R.id.loginf);
        sign=findViewById(R.id.signupf);


        login.setOnClickListener(v->{

            startActivity(new Intent(this, Signin.class));
            finishAffinity();
        });
        sign.setOnClickListener(v->{

            startActivity(new Intent(this, Signup.class));
            finishAffinity();
        });

    }
}