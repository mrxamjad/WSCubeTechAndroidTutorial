package com.example.dialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.dialog.Fragment.Frag1;
import com.example.dialog.Fragment.Frag2;
import com.example.dialog.Fragment.Frag3;
import com.example.dialog.Fragment.Frag4;
import com.example.dialog.Fragment.Frag5;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ButtomNagivationActivity extends AppCompatActivity {
    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttom_nagivation);
        //initialization

        bnView=findViewById(R.id.buttomNagivation);
        loadFragment(new Frag1(),0);

        //on Click on Nagivation Buttom
        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                 if(id==R.id.nav_home)
                 {
                     loadFragment(new Frag1(),1);
                 }else if(id==R.id.nav_play)
                 {
                     loadFragment(new Frag2(),1);
                 }else if(id==R.id.nav_upload)
                 {
                     loadFragment(new Frag3(),1);
                 }else if(id==R.id.nav_profile)
                 {
                     loadFragment(new Frag4(),1);
                 }else {
                     loadFragment(new Frag5(),1);
                 }
                return true;
            }
        });



    }
    //Function for loading the fragment
    public void loadFragment(Fragment fragment, int flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if (flag==0)
        {
            ft.add(R.id.container,fragment);
        }else
        {
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }
}