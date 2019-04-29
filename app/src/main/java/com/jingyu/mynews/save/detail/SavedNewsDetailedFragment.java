package com.jingyu.mynews.save.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jingyu.mynews.R;
import com.jingyu.mynews.common.MyBasicFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedNewsDetailedFragment extends MyBasicFragment {


    public static SavedNewsDetailedFragment newInstance() {

        Bundle args = new Bundle();

        SavedNewsDetailedFragment fragment = new SavedNewsDetailedFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

}
