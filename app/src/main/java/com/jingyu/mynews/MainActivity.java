package com.jingyu.mynews;

import android.os.Bundle;

import com.jingyu.mynews.common.MyBasicActivity;

public class MainActivity extends MyBasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showSnackBar(String message) {

    }

}
