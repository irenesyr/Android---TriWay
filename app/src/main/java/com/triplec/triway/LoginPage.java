package com.triplec.triway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.triplec.triway.R;

public class LoginPage extends AppCompatActivity {
    private Button signUp, login;
    private EditText mail, password;
    private final int PASSWORD_LENGTH = 8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mail = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        login = findViewById(R.id.loginButton);
        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String validEmail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";

                String email = mail.getText().toString();
                String passW = password.getText().toString();
                boolean isValidPassword = validPassword(passW);


                Matcher matcher= Pattern.compile(validEmail).matcher(email);
                if (matcher.matches()){
                    if (!isValidPassword){
                        Toast.makeText(getApplicationContext(), "Password length should at least be" +
                                "8", Toast.LENGTH_LONG).show();
                    }
                    else{
                        //
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(),"Enter Valid Email",
                            Toast.LENGTH_LONG).show();
                }
            }



        });

        signUp = findViewById(R.id.signUpButton);
        signUp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpPage();
            }
        });


    }

    public void openSignUpPage(){
        Intent intent = new Intent(this, SignUpPage.class);
        startActivity(intent);
    }

    public boolean validPassword(String password){
        return password.length() >= PASSWORD_LENGTH;
    }
}
