package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.dialog.Fragment.Frag1;
import com.example.dialog.Fragment.Frag2;
import com.example.dialog.Fragment.Frag3;

public class FragmentActivity extends AppCompatActivity {
    Button Frag1, Frag2,Frag3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        //Initialization
        Frag1= findViewById(R.id.btnFrag1);
        Frag2= findViewById(R.id.btnFrag2);
        Frag3=findViewById(R.id.btnFrag3);

        //set a auto fragment
        loadFragment(new Frag1(),0);

        //btn click to chane the fragment
        Frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new Frag1(),1);
            }
        });
        Frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new Frag2(),1);
            }
        });
        Frag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new Frag3(),1);
            }
        });




        //
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