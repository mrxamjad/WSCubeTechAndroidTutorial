package com.example.dialog.Adaptor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.dialog.Fragment.Frag1;
import com.example.dialog.Fragment.Frag2;
import com.example.dialog.Fragment.Frag3;
import com.example.dialog.Fragment.Frag4;

public class viewPagerMessegerAdaptor extends FragmentPagerAdapter {
    public viewPagerMessegerAdaptor(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new Frag1();
        }else if (position==1)
        {
            return new Frag2();
        }else if(position==3)
            return new Frag4();

        else {
            return new Frag3();
        }


    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
        {
            return "CHAT";
        }
        else if (position==1)
        {
            return "STATUS";


        }
        else if(position==2)
        {
            return "GROUPS";
        }else
        {
            return "CALLS";
        }

    }
}
