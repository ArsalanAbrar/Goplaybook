package com.example.c_arsalanabrar.goplaybook;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Credentials {
    private static final String APP_KEY = "app_name";
    public static Credentials instance = null;
    private static Context mContext = null;

    public static Credentials getInstance(Context context) {
        mContext = context;
        if (instance == null) {
            instance = new Credentials();
        }
        return instance;
    }
    public void SaveprofileUrl(String profileurl) {
        SharedPreferences preferences;
        SharedPreferences.Editor editor;
        preferences = mContext.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("profileurl", profileurl);
        editor.apply();
    }

    public static String getprofileUrl() {
        SharedPreferences preferences;
        preferences = mContext.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);
        return preferences.getString("profileurl", "");
    }

    public void email(String email) {
        SharedPreferences preferences;
        SharedPreferences.Editor editor;
        preferences = mContext.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("email", email);
        editor.apply();
    }

    public static String email() {
        SharedPreferences preferences;
        preferences = mContext.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);
        return preferences.getString("email", "");

    }

    public void firstname(String fname) {
        SharedPreferences preferences;
        SharedPreferences.Editor editor;
        preferences = mContext.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("first", fname);
        editor.apply();
    }

    public void lastname(String lname) {
        SharedPreferences preferences;
        SharedPreferences.Editor editor;
        preferences = mContext.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("last", lname);
        editor.apply();
    }


    public static String getlname() {
        SharedPreferences preferences;
        preferences = mContext.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);
        return preferences.getString("last", "");
    }

    public static String getfname() {
        SharedPreferences preferences;
        preferences = mContext.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);
        return preferences.getString("first", "");
    }
    public void Userid(String userid) {
        SharedPreferences preferences;
        SharedPreferences.Editor editor;
        preferences = mContext.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("id", userid);
        editor.apply();
    }


    public static String getuserid() {
        SharedPreferences preferences;
        preferences = mContext.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);
        return preferences.getString("id", "");
    }




}

