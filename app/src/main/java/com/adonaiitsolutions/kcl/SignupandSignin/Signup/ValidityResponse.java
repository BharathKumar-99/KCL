package com.adonaiitsolutions.kcl.SignupandSignin.Signup;

import com.google.gson.annotations.SerializedName;

public class ValidityResponse {

    @SerializedName("success")
    boolean successString;
    @SerializedName("message")
    String messageString;

    public boolean isSuccess(){
        return successString;
    }

    public String getMessage() {
        return messageString;
    }
}
