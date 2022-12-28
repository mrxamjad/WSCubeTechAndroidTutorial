package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.dialog.Adaptor.viewPagerMessegerAdaptor;
import com.google.android.material.tabs.TabLayout;

public class TablayoutActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);

        viewPagerMessegerAdaptor adaptor=new viewPagerMessegerAdaptor(getSupportFragmentManager());

        viewPager.setAdapter(adaptor);

        tabLayout.setupWithViewPager(viewPager);
    }
}