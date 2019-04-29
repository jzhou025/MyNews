package com.jingyu.mynews.news;

import com.jingyu.mynews.retrofit.response.News;

import java.util.List;

public class NewsPresenter implements NewsContract.Presenter{

    private NewsContract.View view;
    private NewsContract.Model model;  // link model with presenter

    @Override
    public void onCreate() {
        this.model = new NewsModel();
        this.model.setPresenter(this);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(NewsContract.View view) {
        this.view = view;
        this.model.fetchData();
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    @Override
    public void showNewsCard(List<News> newsList) {
        if (this.view != null) {
            view.showNewsCard(newsList);
        }
    }

}
