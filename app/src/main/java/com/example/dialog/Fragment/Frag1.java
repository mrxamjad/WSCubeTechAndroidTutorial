package com.example.dialog.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dialog.R;

import java.security.KeyPairGenerator;


public class Frag1 extends Fragment {

    TextView txtProf;
    private static final String arg1="argument1";
    private static final String arg2="argument2";

    public static Frag1 getInstance(String Value1,String Value2){
        Frag1 frag1=new Frag1();
        Bundle bundle=new Bundle();
        bundle.putString(arg1,Value1);
        bundle.putString(arg2,Value2);

        frag1.setArguments(bundle);



        return frag1;
    }




    // Cunstructor
    public Frag1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if (getArguments()!=null)
        {
            String name=getArguments().getString("argument1");
            Log.d("frag", "onCreateView: Fragment Data "+name);

        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag1, container, false);









    }
}