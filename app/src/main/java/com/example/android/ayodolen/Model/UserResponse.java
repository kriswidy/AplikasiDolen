package com.example.android.ayodolen.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 15/11/2018.
 */

public class UserResponse {
    @SerializedName("id_user") private Integer id_user;
    @SerializedName("username") private String username;
    @SerializedName("password") private String password;
    @SerializedName("nama") private String nama;
    @SerializedName("tanggal_lahir") private String tanggal_lahir;

    public UserResponse(Integer id_user, String username, String password, String nama, String tanggal_lahir) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }
}
