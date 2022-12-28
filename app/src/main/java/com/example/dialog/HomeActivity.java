package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button btnLogout,btnImplicit,btnWebSearch,btnOtherService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Initialization
        btnLogout= findViewById(R.id.btnLogout);
        btnImplicit=findViewById(R.id.btnHomeToImlicit);
        btnWebSearch=findViewById(R.id.btnWebSearch);
        btnOtherService= findViewById(R.id.btnOtherService);


        //Logout --on Click
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change SharePreferences
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor= pref.edit();
                editor.putBoolean("flag",false);
                editor.apply();

                //Open new Activity
                Intent iLogin= new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(iLogin);
                finishAffinity();
            }
        });

        //Goto Implicit Activity
        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMain= new Intent(HomeActivity.this,MainActivity.class);
                startActivity(iMain);

            }
        });

        //open Web Search
        btnWebSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iWeb= new Intent(HomeActivity.this,WebActivity.class);
                startActivity(iWeb);

            }
        });

        //open OtherServices Activity
        btnOtherService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iOther= new Intent(HomeActivity.this,OtherService.class);
                startActivity(iOther);

            }
        });




    }
}