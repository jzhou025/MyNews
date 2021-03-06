package com.jingyu.mynews.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jingyu.mynews.R;
import com.jingyu.mynews.mvp.MvpFragment;
import com.jingyu.mynews.retrofit.response.News;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsGalleryFragment extends MvpFragment<NewsContract.Presenter> implements MyNewsCard.OnSwipeListener, NewsContract.View {

    private SwipePlaceHolderView mSwipeView;

    public static NewsGalleryFragment newInstance() {
        Bundle args = new Bundle();
        NewsGalleryFragment fragment = new NewsGalleryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_gallery, container, false);

        mSwipeView = view.findViewById(R.id.swipeView);

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.my_news_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.my_news_swipe_out_msg_view));

        view.findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(false);
            }
        });

        view.findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(true);
            }
        });

        return view;
    }

    @Override
    public void showNewsCard(List<News> newsList) {
        // clear all previous news card
        mSwipeView.removeAllViews();

        for (News news : newsList) {
            MyNewsCard tinNewsCard = new MyNewsCard(news, mSwipeView, this);
            mSwipeView.addView(tinNewsCard);
        }
    }
    @Override
    public void onError() {
        Toast.makeText(getContext(), "News has been inserted before", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLike(News news) {
        presenter.saveFavoriteNews(news);
    }

    @Override
    public NewsContract.Presenter getPresenter() {
        return new NewsPresenter();
    }
}
