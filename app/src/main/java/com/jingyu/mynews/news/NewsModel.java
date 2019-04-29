package com.jingyu.mynews.news;

import com.jingyu.mynews.retrofit.NewsRequestApi;
import com.jingyu.mynews.retrofit.RetrofitClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewsModel implements NewsContract.Model {

    private final NewsRequestApi newsRequestApi;
    private NewsContract.Presenter presenter;

    public NewsModel() {
        newsRequestApi = RetrofitClient.getInstance().create(NewsRequestApi.class);
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
}
