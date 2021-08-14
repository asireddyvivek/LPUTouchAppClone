package com.example.a24_kom52_11802339;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AdapterForTabs extends FragmentPagerAdapter {
    Context ct;
    int totaltabs;
    public AdapterForTabs(@NonNull Context ct,FragmentManager fm,int totaltabs) {
        super(fm);
        this.ct=ct;
        this.totaltabs=totaltabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                Monday d1=new Monday();
                return d1;
            case 1:
                Tuesday d2=new Tuesday();
                return d2;
            case 2:
                Wednesday d3=new Wednesday();
                return d3;
            case 3:
                Thursday d4 = new Thursday();
                return  d4;
            case 4:
                Friday d5 = new Friday();
                return  d5;
            case 5:
                Saturday d6 = new Saturday();
                return  d6;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totaltabs;
    }
}
