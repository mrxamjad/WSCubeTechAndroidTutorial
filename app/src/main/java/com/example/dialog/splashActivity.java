package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ipsec.ike.exceptions.IkeNetworkLostException;
import android.os.Bundle;
import android.os.Handler;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Handler Class for preferences
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref=getSharedPreferences("login",MODE_PRIVATE);
                Boolean check=pref.getBoolean("flag",false);

                Intent iNext;
                if(check)
                {
                    iNext=new Intent(splashActivity.this,HomeActivity.class);

                }else{
                    iNext= new Intent(splashActivity.this, LoginActivity.class);
                }
                startActivity(iNext);
                finishAffinity();
            }
        },2000);
    }
}