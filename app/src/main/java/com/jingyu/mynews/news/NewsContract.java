package com.jingyu.mynews.news;

import com.jingyu.mynews.mvp.MvpContract;

public interface NewsContract {
    interface View extends MvpContract.View<Presenter> {

    }

    interface Presenter extends MvpContract.Presenter<View, Model> {

    }

    interface Model extends MvpContract.Model<Presenter> {

    }

}
