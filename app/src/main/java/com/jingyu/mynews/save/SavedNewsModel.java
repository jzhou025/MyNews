package com.jingyu.mynews.save;

public class SavedNewsModel implements SavedNewsContract.Model {

    private SavedNewsContract.Presenter presenter;

    @Override
    public void setPresenter(SavedNewsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}

