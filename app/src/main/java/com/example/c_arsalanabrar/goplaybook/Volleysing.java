package com.example.c_arsalanabrar.goplaybook;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class Volleysing extends Application{
    private static Volleysing sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }
}
