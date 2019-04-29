package com.jingyu.mynews.news;

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
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }
}
