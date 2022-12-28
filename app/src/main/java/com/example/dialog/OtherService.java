package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OtherService extends AppCompatActivity {
    Button btnJsonGet,btnGMap,btnFragment,btnTablayout,btnButtomNagivation, OpenDrawer,DataPassing,btnSQLdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_service);

        //Initialization
        btnJsonGet=findViewById(R.id.btnJson);
//        btnJsonGet=findViewById(R.id.btnGMap);
        btnFragment= findViewById(R.id.btnFragment);
        btnTablayout=findViewById(R.id.btnTablayout);
        btnButtomNagivation=findViewById(R.id.btnNagivation);
       OpenDrawer=findViewById(R.id.btnOpenDrawer);
       DataPassing= findViewById(R.id.btnDataPassing);
       btnSQLdata =findViewById(R.id.btnSQL);

        //go JSON GET API testing Activity
        btnJsonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iJson= new Intent(OtherService.this,JsonGetApi.class);
                startActivity(iJson);

            }
        });
//
//        //go to Google map Activity
//        btnGMap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent iMap= new Intent(OtherService.this,GoogleMapActivity.class);
//                startActivity(iMap);
//
//            }
//        });

        //go to Fragment Activity
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iFrag= new Intent(OtherService.this,FragmentActivity.class);
                startActivity(iFrag);

            }
        });

        btnTablayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iTab= new Intent(OtherService.this,TablayoutActivity.class);
                startActivity(iTab);

            }
        });

        btnButtomNagivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iTab= new Intent(OtherService.this,ButtomNagivationActivity.class);
                startActivity(iTab);

            }
        });

        OpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDrawer= new Intent(OtherService.this,DrawerActivity.class);
                startActivity(iDrawer);

            }
        });

        DataPassing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDrawer= new Intent(OtherService.this, FragmentDataPassing.class);
                startActivity(iDrawer);

            }
        });

        btnSQLdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iSQL= new Intent(OtherService.this, SQLDataImplementation.class);
                startActivity(iSQL);

            }
        });



    }
}