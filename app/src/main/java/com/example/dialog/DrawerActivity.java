package com.example.dialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dialog.Fragment.Frag1;
import com.example.dialog.Fragment.Frag2;
import com.example.dialog.Fragment.Frag3;
import com.example.dialog.Fragment.Frag4;
import com.example.dialog.Fragment.Frag5;
import com.google.android.material.navigation.NavigationView;

public class DrawerActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        toolbar=findViewById(R.id.toolbarDrawer);
        drawer=findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationViewDrawer);



        setSupportActionBar(toolbar); // add actionbar in activity

        loadFragment(new Frag1(),0);





        //add toggel button to open drawer

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.openDrawer,R.string.closeDrawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        //set click listner on each item of the drawer
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
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


        //close the drawer if it is open







    }
    //Function for loading the fragment
    public void loadFragment(Fragment fragment, int flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if (flag==0)
        {
            ft.add(R.id.containerDrawer,fragment);

        }else
        {
            ft.replace(R.id.containerDrawer,fragment);

        }
        ft.commit();
        drawer.closeDrawer(GravityCompat.START);



    }
    //onback press close the drawer first
    @Override
    public void onBackPressed(){
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }
}