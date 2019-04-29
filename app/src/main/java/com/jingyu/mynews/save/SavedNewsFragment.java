package com.jingyu.mynews.save;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jingyu.mynews.R;
import com.jingyu.mynews.common.MyBasicFragment;
import com.jingyu.mynews.common.MyFragmentManager;
import com.jingyu.mynews.save.detail.SavedNewsDetailedFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedNewsFragment extends MyBasicFragment {

    public static SavedNewsFragment newInstance() {
        SavedNewsFragment fragment = new SavedNewsFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved_news, container, false);
        TextView textView = view.findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MyFragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance());
                //Log.d("state", "onclick");
            }
        });
        return view;
    }

}
