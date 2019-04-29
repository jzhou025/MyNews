package com.jingyu.mynews.news;

import com.jingyu.mynews.profile.CountryEvent;
import com.jingyu.mynews.retrofit.response.News;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class NewsPresenter implements NewsContract.Presenter{

    private NewsContract.View view;
    private NewsContract.Model model;

    public NewsPresenter() {
        this.model = new NewsModel();
        this.model.setPresenter(this);   // link model with presenter
    }

    @Override
    public void onCreate() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(CountryEvent countryEvent) {
        if (this.view != null) {
            this.model.fetchData(countryEvent.country);
        }
    }

    @Override
    public void onViewAttached(NewsContract.View view) {
        this.view = view;
        this.model.fetchData("us");
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

    @Override
    public void saveFavoriteNews(News news) {
        this.model.saveFavoriteNews(news);
    }

    @Override
    public void onError() {
        view.onError();
    }

}
