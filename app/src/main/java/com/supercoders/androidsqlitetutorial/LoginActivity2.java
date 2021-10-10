package com.supercoders.androidsqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity2 extends AppCompatActivity {
    DatabaseHelper dBhelper;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Username = "username";
    public static final String Password = "password";
    SharedPreferences sharedpreferences;

    private EditText email, pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        dBhelper = new DatabaseHelper(this);

        Button loginbtn = (Button) findViewById(R.id.loginbtn);
        TextView regbtn = (TextView) findViewById(R.id.regbtn);
        regbtn.setTextColor(Color.BLUE);
        TextView copyright = (TextView) findViewById(R.id.copyright);
        copyright.setTextColor(Color.BLUE);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 email = (EditText) findViewById(R.id.email);
                 pwd = (EditText) findViewById(R.id.pwd);

                String em = email.getText().toString();
                String ps = pwd.getText().toString();


                SharedPreferences.Editor editor = sharedpreferences.edit();


                if (em.equals("") || ps.equals("")) {
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    editor.putString(Username, em);
                    editor.putString(Password, ps);
                    editor.commit();
                    Boolean checkLogin = dBhelper.CheckLogin(em,ps);
                    if (checkLogin) {

                        Intent login = new Intent(getApplicationContext(), MainActivity.class);

                        startActivity(login);
                    }
                }
            }
        });

        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://elywin.github.io/"));
                startActivity(intent);
            }
        });

    }

}