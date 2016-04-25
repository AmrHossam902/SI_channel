package com.example.antou.trial_7;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Home extends AppCompatActivity {

    TabLayout TL;
    ViewPager VP;
   static Context X;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        X = getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (MainActivity.getType() == 0) {
            TL = (TabLayout) findViewById(R.id.tabLayout);
            VP = (ViewPager) findViewById(R.id.viewPager);
            ViewPagerAdapter VPA = new ViewPagerAdapter(getSupportFragmentManager());
            VPA.add_fragements(new Info_Frags(), "Information");
            VPA.add_fragements(new Survey_frag(), "Survey");
            VPA.add_fragements(new Disc_frag(), "Discussion");
            VP.setAdapter(VPA);
            TL.setupWithViewPager(VP);
        }
        else
        {
            TL = (TabLayout) findViewById(R.id.tabLayout);
            VP = (ViewPager) findViewById(R.id.viewPager);
            ViewPagerAdapter VPA = new ViewPagerAdapter(getSupportFragmentManager());
            VPA.add_fragements(new Admin_info() , "My Information");
            VPA.add_fragements(new Survey_frag(), "Survey");
            VPA.add_fragements(new Add_Delete_user(), "Control Users");
            VP.setAdapter(VPA);
            TL.setupWithViewPager(VP);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}
