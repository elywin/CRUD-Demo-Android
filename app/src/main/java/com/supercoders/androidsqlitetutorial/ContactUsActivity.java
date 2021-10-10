package com.supercoders.androidsqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

//        Button backbtn = (Button) findViewById(R.id.backbtn);
        TextView logout = (TextView) findViewById(R.id.logout);
        TextView copyright = (TextView) findViewById(R.id.copyright);
        copyright.setTextColor(Color.BLUE);
        Button callbtn = (Button) findViewById(R.id.callbtn);

//                backbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), LoginActivity2.class);
//                startActivity(intent);
//            }
//        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(logout);
            }
        });

        callbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                   Intent launch = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456798"));
                   startActivity(launch);
    }
});
    }

}