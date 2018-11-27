package com.example.android.ayodolen;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DataHelper dbHelper;
    Button register;
    TextView login;
    EditText email, username, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//        getActionBar().hide();

        email = findViewById(R.id.inputEmail);
        username = findViewById(R.id.inputUsername);
        pwd = findViewById(R.id.inputPasswd);

        register = findViewById(R.id.btnRegister);
        login = findViewById(R.id.tvLogin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO user ( email, username, password) VALUES ('" +
                        email.getText().toString() + "','" +
                        username.getText().toString() + "','" +
                        pwd.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "Register Successful", Toast.LENGTH_SHORT).show();
                emptyEditText();
//                Intent mIntent = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(mIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void emptyEditText(){
        email.setText(null);
        username.setText(null);
        pwd.setText(null);
    }
}
