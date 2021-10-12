package com.adonaiitsolutions.kcl.SignupandSignin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.adonaiitsolutions.kcl.R;
import com.google.android.material.tabs.TabLayout;

public class SigninandSignup extends AppCompatActivity {
    TabLayout tabLayout;
    Context context;
    ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinand_signup);




    tabLayout=(TabLayout)findViewById(R.id.signuptab);
    viewPager=findViewById(R.id.viewpager);

        tabLayout.addTab(tabLayout.newTab().setText("Signup"));
        tabLayout.addTab(tabLayout.newTab().setText("Signin"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        viewpager viewpager=new viewpager(getSupportFragmentManager(),getLifecycle());

        viewPager.setAdapter(viewpager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

}
}