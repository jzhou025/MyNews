package com.jingyu.mynews.news;

import com.jingyu.mynews.mvp.MvpContract;
import com.jingyu.mynews.retrofit.response.News;

import java.util.List;

public interface NewsContract {
    interface View extends MvpContract.View<Presenter> {
        void showNewsCard(List<News> newsList);
        void onError();
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
        void showNewsCard(List<News> newsList);
        void saveFavoriteNews(News news);
        void onError();
    }

    interface Model extends MvpContract.Model<Presenter> {
        void fetchData();
        void saveFavoriteNews(News news);
    }

}
