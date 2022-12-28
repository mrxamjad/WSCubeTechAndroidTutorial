package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dialog.Fragment.Frag1;
import com.example.dialog.Fragment.Frag2;
import com.example.dialog.Fragment.Frag3;

public class FragmentDataPassing extends AppCompatActivity {
    Button Frag1, Frag2,Frag3,set;

    EditText name,prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_data_passing);
        Frag1= findViewById(R.id.btnFrag1);
        Frag2= findViewById(R.id.btnFrag2);
        Frag3=findViewById(R.id.btnFrag3);
        name=findViewById(R.id.edtName);
        prof=findViewById(R.id.edtProfession);
        set=findViewById(R.id.btnSetData);


        //data passing Bundel
//        set.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String n=name.getText().toString();
//                String p=prof.getText().toString();
//
//                Bundle bundle=new Bundle();
//                bundle.putString("agr1",n);
//                bundle.putString("arg2",p);
//
//                new Frag1().setArguments(bundle);
//            }
//        });







        //btn click to chane the fragment
        Frag1.setOnClickListener(new View.OnClickListener() {
            Frag1 frag1=new Frag1();
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



    }
    //Function for loading the fragment
    public void loadFragment(Fragment fragment, int flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

        Bundle bundle=new Bundle();
        bundle.putString("arg1","This is the First parameter");
        bundle.putString("arg2","This is the second parameter");

        fragment.setArguments(bundle);


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