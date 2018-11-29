package com.example.android.ayodolen.Rest;

import com.example.android.ayodolen.Model.User;
import com.example.android.ayodolen.Model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by user on 15/11/2018.
 */

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login")
    Call<UserResponse> loginRequest(@Field("username") String username);
//    @FormUrlEncoded
//    @POST("login")
//    Call<UserResponse> loginRequest(@Field("username") String username,
//                                    @Field("password") String password);

}
