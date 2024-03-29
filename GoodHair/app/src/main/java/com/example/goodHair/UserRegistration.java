package com.example.goodHair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class UserRegistration extends AppCompatActivity {

    private final String SIGNUP = "SIGNUP";
    private final String ERROR = "ERROR";
    private EditText etfname;
    private EditText etlname;
    private EditText etemail;
    private EditText etpassword;
    private EditText etusername;
    private EditText etphonenum;
    private EditText etaddress;
    private Button btn_back;
    private Button btn_SignUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        etfname = findViewById(R.id.userReg_fname);
        etlname = findViewById(R.id.userReg_lname);
        etemail = findViewById(R.id.userReg_email);
        etpassword = findViewById(R.id.userReg_password);
        etusername = findViewById(R.id.userReg_username);
        etphonenum = findViewById(R.id.userReg_phone);
        etaddress = findViewById(R.id.userReg_address);
        btn_back = findViewById(R.id.btn_Back);
        btn_SignUp = findViewById(R.id.btn_SignUp);

        btn_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get the text from form
                String fname = etfname.getText().toString();
                String lname = etlname.getText().toString();

                String name = fname + " " + lname;
                String email = etemail.getText().toString();
                String password = etpassword.getText().toString();
                String username = etusername.getText().toString();
                String phonenum = PhoneNumberUtils.formatNumber(etphonenum.getText().toString());
                String address = etaddress.getText().toString();

                // Verify
                //verify(fname, lname, email, username, password);

                register(name, email, username, password, phonenum);//, address);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLoginPage();
            }
        });

    }

    /*private void verify(String fname, String lname, String email, String username, String password) {

        if (fname == "") { Toast.makeText(UserRegistration.this, "There is no photo!", Toast.LENGTH_SHORT).show(); }

        }*/

    private void register(String name, String email, String username, String password, String phonenum) {//, String address) {

        User user = new User();
        ParseUser parseUser = new ParseUser();
        parseUser.setUsername(username);
        parseUser.setPassword(password);
        parseUser.put(user.KEY_NAME, name);
        parseUser.put(user.KEY_USERNAME, username);
        parseUser.put(user.KEY_EMAIL, email);
        parseUser.put(user.KEY_PHONENUM, phonenum);
        parseUser.put(user.KEY_ISSTYLIST, false);


        parseUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null){
                    Log.e(ERROR, "Error in signing up user");
                    e.printStackTrace();
                    return;
                }
                Log.d(SIGNUP, "Sign Up Successful");
                etfname.setText("");
                etlname.setText("");
                etusername.setText("");
                etpassword.setText("");
                etaddress.setText("");
                etphonenum.setText("");

            }
        });

    }


    private void goLoginPage() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        Log.d("WORKING", "It's working");
        finish();
    }




}
