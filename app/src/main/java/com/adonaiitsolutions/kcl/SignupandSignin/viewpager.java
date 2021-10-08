package com.adonaiitsolutions.kcl.SignupandSignin;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.adonaiitsolutions.kcl.SignupandSignin.Signin.Signin;
import com.adonaiitsolutions.kcl.SignupandSignin.Signup.Signup;

public class viewpager extends FragmentStateAdapter {
    int count;

    public viewpager(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1){
            return new Signin();
        }else
            return new Signup();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
