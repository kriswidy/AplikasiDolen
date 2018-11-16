package com.example.android.ayodolen.Rest;

import com.example.android.ayodolen.Model.UserResponse;
import com.example.android.ayodolen.Model.Wisata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by user on 15/11/2018.
 */

public interface ApiInterface {
    @GET("wisata/{id_kategori}")
    Call<Wisata> getWisata(@Path("id_kategori") int id_kategori);

    //-------------------------//
    @GET("user/{username}&{password}")
    Call<UserResponse> getUser(@Path("username") String username,@Path("password") String password);
}
