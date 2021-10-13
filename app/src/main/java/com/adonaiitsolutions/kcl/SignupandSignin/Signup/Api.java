package com.adonaiitsolutions.kcl.SignupandSignin.Signup;

import com.adonaiitsolutions.kcl.SignupandSignin.Signup.SignupModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("signup.php")
    Call<SignupModel> createPost(@Field("name") String name,
                                 @Field("fname") String Fathername,
                                 @Field("dob") String dob, @Field("blood_group") String Blood,
                                 @Field("telephone") String Mobile, @Field("email") String Email,
                                 @Field("adhar_card") String Adhar, @Field("network_name") String network,
                                 @Field("address") String doorno, @Field("address2") String street,
                                 @Field("postcode") String pincode, @Field("village") String Village,
                                 @Field("state") String State, @Field("city") String City, @Field("taluk") String taluk,
                                 @Field("nominename") String nominemane, @Field("nominename_adhar")
                                         String nominename_adhar, @Field("nominename_relation") String nominename_relation,
                                 @Field("n_dob") String n_dob);




}
