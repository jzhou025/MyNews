package com.jingyu.mynews.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.jingyu.mynews.retrofit.response.News;

/* Database: Contains the database holder
   and serves as the main access point
   for the underlying connection to app's persisted, relational data.

   Entity: Represents a table within the database.

   Dao: Contains the methods used for accessing the database.
*/

@Database(entities = {News.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();
}

