package com.jingyu.mynews.profile;

import android.annotation.SuppressLint;

import com.jingyu.mynews.MyApplication;
import com.jingyu.mynews.database.AppDatabase;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ProfileModel implements ProfileContract.Model {

    private ProfileContract.Presenter presenter;
    private AppDatabase db = MyApplication.getDataBase();

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @SuppressLint("CheckResult")
    @Override
    public void deleteAllNewsCache() {
        Completable.fromAction(() -> db.newsDao().deleteAllNews()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
            presenter.onCacheCleared();
        }, error -> {

        });
    }

    @Override
    public void setDefaultCountry(String country) {
        EventBus.getDefault().post(new CountryEvent(country));
    }
}

