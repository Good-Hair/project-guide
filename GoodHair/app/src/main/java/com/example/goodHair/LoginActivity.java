package com.example.goodHair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private TextView btn_userSignup;
    private TextView btn_stylistSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //added

        etUsername = findViewById(R.id.login_username);
        etPassword = findViewById(R.id.login_password);
        btnLogin = findViewById(R.id.login_btn);
        btn_userSignup = findViewById(R.id.btn_userSignup);
        btn_stylistSignup = findViewById(R.id.btn_stylistSignup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etUsername.getText().toString();
                String email = etPassword.getText().toString();
                login(name, email);
            }
        });

        btn_userSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goUserRegistration();
            }
        });

        btn_stylistSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goStylistRegistration();
            }
        });

    }

    private void goUserRegistration() {
        Intent i = new Intent(this, UserRegistration.class);
        startActivity(i);
        Log.d("WORKING", "It's working");
        finish();
    }

    private void goStylistRegistration() {
        Intent i = new Intent(this, StylistRegistration.class);
        startActivity(i);
        Log.d("WORKING", "It's working");
        finish();
    }

    private void login( String user, String password) {
        ParseUser.logInInBackground(user, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Log.e("ERROR", "Issue w Login");
                    e.printStackTrace();
                    return;
                }
                //TODO:navigate to new activity if the sign in succeeds
                goMainActivity();
            }
        });
    }

    private void  goMainActivity(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        Log.d("WORKING", "It's working");
        finish();
    }

}
