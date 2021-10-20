package com.adonaiitsolutions.kcl.SignupandSignin.Signin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.adonaiitsolutions.kcl.R;

public class Signin extends AppCompatActivity {
TextView phone,password;
Button login;
    boolean result;
String Phone,Password;
SigninViewmodel signinViewmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        phone=findViewById(R.id.loginnumber);
        password=findViewById(R.id.loginpassword);
       login=findViewById(R.id.login);

       signinViewmodel=new ViewModelProvider(this).get(SigninViewmodel.class);
       login.setOnClickListener(v->{
           SharedPreferences sh = getSharedPreferences("login_cred", MODE_PRIVATE);

           String saved_phone = sh.getString("phone", "");
           String saved_password =sh.getString("password","");
            if(saved_phone == null)
               {
               Phone = phone.getText().toString();
               Password = password.getText().toString();
               result=signinViewmodel.login(Phone,Password);
               }else
               result=signinViewmodel.login(saved_phone,saved_password);
           if(result){
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();

               SharedPreferences sharedPreferences = getSharedPreferences("login_cred",MODE_PRIVATE);
               SharedPreferences.Editor myEdit = sharedPreferences.edit();
               myEdit.putString("phone", phone.getText().toString());
               myEdit.putInt("password", Integer.parseInt(password.getText().toString()));
               myEdit.apply();

            }else
                Toast.makeText(this, "Login Failed Check phone and Password", Toast.LENGTH_SHORT).show();

       });
    }
}