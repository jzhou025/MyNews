package com.jingyu.mynews.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.jingyu.mynews.retrofit.response.News;

@Dao
public interface NewsDao {

    @Insert
    void insertNews(News news);
}

