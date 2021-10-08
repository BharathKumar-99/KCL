package com.adonaiitsolutions.kcl;

import com.adonaiitsolutions.kcl.SignupandSignin.SignupModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {
    @FormUrlEncoded
    @POST("upload.php")
    Call<SignupModel> createPost(@Body SignupModel dataModal);
}
