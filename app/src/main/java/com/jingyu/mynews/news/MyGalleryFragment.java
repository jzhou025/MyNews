package com.jingyu.mynews.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jingyu.mynews.R;
import com.jingyu.mynews.common.MyBasicFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyGalleryFragment extends MyBasicFragment {


    public static MyGalleryFragment newInstance() {

        Bundle args = new Bundle();

        MyGalleryFragment fragment = new MyGalleryFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_gallery, container, false);
    }

}
