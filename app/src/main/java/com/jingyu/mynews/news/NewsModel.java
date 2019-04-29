package com.jingyu.mynews.news;

public class NewsModel implements NewsContract.Model {

    private NewsContract.Presenter presenter;

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
