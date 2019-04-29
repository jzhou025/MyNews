package com.jingyu.mynews.news;

import android.annotation.SuppressLint;

import com.jingyu.mynews.MyApplication;
import com.jingyu.mynews.database.AppDatabase;
import com.jingyu.mynews.retrofit.NewsRequestApi;
import com.jingyu.mynews.retrofit.RetrofitClient;
import com.jingyu.mynews.retrofit.response.News;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewsModel implements NewsContract.Model {

    private final NewsRequestApi newsRequestApi;
    private NewsContract.Presenter presenter;
    private final AppDatabase db;

    public NewsModel() {
        newsRequestApi = RetrofitClient.getInstance().create(NewsRequestApi.class);
        db = MyApplication.getDataBase();
    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void fetchData() {
        newsRequestApi.getNewsByCountry("us")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(baseResponse -> baseResponse != null && baseResponse.articles != null)
                .subscribe(baseResponse -> {
                    presenter.showNewsCard(baseResponse.articles);
                });

    }

    @SuppressLint("CheckResult")
    @Override
    public void saveFavoriteNews(News news) {
        Completable.fromAction(() -> db.newsDao().insertNews(news)).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() ->{

        }, error -> {
        });
    }

}
