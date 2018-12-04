package com.example.android.ayodolen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.ayodolen.Model.User;
import com.example.android.ayodolen.Model.UserResponse;
import com.example.android.ayodolen.Rest.ApiClient;
import com.example.android.ayodolen.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    EditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getActionBar().hide();
        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
//        getActionBar().hide();

        btnLogin = findViewById(R.id.buttonYuk);
//        getActionBar().hide();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface mApiInterface =
                        ApiClient.getClient().create(ApiInterface.class);
                Call<UserResponse> mLogin = mApiInterface.loginRequest(username.getText().toString());
                mLogin.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        String status = response.body().getStatus();
                        if (status.equals("success")){
                            User user = response.body().getUser();
//                            create sesion
//                            mSesion.createLoginSession(krywn.getId(),krywn.getNama(),krywn.getLevel());
                            Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                            startActivity(i);
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(),"fail login",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "tidak connect",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}
