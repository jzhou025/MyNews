package com.jingyu.mynews.save;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jingyu.mynews.R;
import com.jingyu.mynews.common.MyBasicFragment;
import com.jingyu.mynews.common.MyFragmentManager;
import com.jingyu.mynews.mvp.MvpFragment;
import com.jingyu.mynews.retrofit.response.News;
import com.jingyu.mynews.save.detail.SavedNewsDetailedFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedNewsFragment extends MvpFragment<SavedNewsContract.Presenter> implements SavedNewsContract.View {

    private TextView author;
    private TextView description;

    public static SavedNewsFragment newInstance() {
        SavedNewsFragment fragment = new SavedNewsFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved_news, container, false);
        author = view.findViewById(R.id.author);
        description = view.findViewById(R.id.description);
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MyFragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance());
                //Log.d("state", "onclick");
            }
        });
        return view;
    }
    @Override
    public SavedNewsContract.Presenter getPresenter() {
        return new SavedNewsPresenter();
    }
    @Override
    public void loadSavedNews(List<News> newsList) {
        if (newsList.size() > 0) {
            News news = newsList.get(newsList.size() - 1);
            author.setText(news.getAuthor());
            description.setText(news.getDescription());
        }
    }
}
