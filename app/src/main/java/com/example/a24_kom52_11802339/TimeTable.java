package com.example.a24_kom52_11802339;



import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class TimeTable extends AppCompatActivity {
    TabLayout tl;
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        tl=findViewById(R.id.tb1);
        vp=findViewById(R.id.vp1);
        tl.addTab(tl.newTab().setText("Monday"));
        tl.addTab(tl.newTab().setText("Tuesday"));
        tl.addTab(tl.newTab().setText("Wednesday"));
        tl.addTab(tl.newTab().setText("Thursday"));
        tl.addTab(tl.newTab().setText("Friday"));
        tl.addTab(tl.newTab().setText("Saturday"));

        AdapterForTabs a=new AdapterForTabs(getApplicationContext(),
                getSupportFragmentManager(),tl.getTabCount());
        vp.setAdapter(a);
        vp.addOnPageChangeListener
                (new TabLayout.TabLayoutOnPageChangeListener(tl));
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }
}