package com.example.c_arsalanabrar.goplaybook;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {PlayerData.class},version = 1)
public abstract class MyAppDatabse extends RoomDatabase {
    private static final String DB_NAME = "player.db";
    private static MyAppDatabse instance;

    public abstract dao dao();
    static synchronized MyAppDatabse getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static MyAppDatabse create(final Context context) {
        return Room.databaseBuilder(
                context,
                MyAppDatabse.class,
                DB_NAME).allowMainThreadQueries().build();
    }

}
