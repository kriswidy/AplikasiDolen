package com.example.android.ayodolen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    EditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getActionBar().hide();
        username = findViewById(R.id.editTextPassword);
        password = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.buttonYuk);
//        getActionBar().hide();

    }
}
