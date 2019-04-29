package com.jingyu.mynews;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;

import com.jingyu.mynews.common.MyBasicActivity;
import com.jingyu.mynews.common.MyFragmentPagerAdapter;

public class MainActivity extends MyBasicActivity {

    private ViewPager viewPager;
    private BottomNavigationView bottomBar;
    private MyFragmentPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link view pager with view
        viewPager = findViewById(R.id.viewpager);
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(MyFragmentPagerAdapter.FRAGMENT_NUMBER);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showSnackBar(String message) {

    }

}
