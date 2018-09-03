package com.zakharchenko.oksana.getplaces.ui;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.zakharchenko.oksana.getplaces.db.AppDatabase;

public class ExtApplication extends Application {

    AppDatabase appDb;
    int chatUserId = 0;
    final String TAG = "ExtApplication";
    private static ExtApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        createDb();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }


    void createDb() {
        appDb = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    public AppDatabase getAppDb() {
        if (!appDb.isOpen())
            createDb();
        return appDb;
    }

    public static ExtApplication getInstance() {
        return application;
    }


}


