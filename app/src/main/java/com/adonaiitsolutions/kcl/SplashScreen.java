package com.adonaiitsolutions.kcl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.adonaiitsolutions.kcl.SignupandSignin.FirstPage;
import com.adonaiitsolutions.kcl.SignupandSignin.Signin.Signin;
import com.adonaiitsolutions.kcl.SignupandSignin.Signup.Signup;

public class SplashScreen extends AppCompatActivity {
ImageView imageView;
    Animation animationUptoDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageView = findViewById(R.id.image_view);
        animationUptoDown = AnimationUtils.loadAnimation(this,R.anim.uptodownanim);


        imageView.setAnimation(animationUptoDown);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashScreen.this, FirstPage.class));
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            finish();
        },4000);

    }
}