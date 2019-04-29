package com.jingyu.mynews.profile;

import com.jingyu.mynews.MyApplication;
import com.jingyu.mynews.database.AppDatabase;

public class ProfileModel implements ProfileContract.Model {

    private ProfileContract.Presenter presenter;
    private AppDatabase db = MyApplication.getDataBase();

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void deleteAllNewsCache() {

    }

    @Override
    public void setDefaultCountry(String country) {

    }
}

