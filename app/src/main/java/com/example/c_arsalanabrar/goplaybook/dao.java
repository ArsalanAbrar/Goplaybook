package com.example.c_arsalanabrar.goplaybook;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface dao {

    @Insert
    void insertdata(List<PlayerData> data);

    @Query("SELECT age from playerdata WHERE userid=:id")
    String age(String id);

    @Query("SELECT field from playerdata WHERE userid=:id")
    String field(String id);

    @Query("SELECT gender from playerdata WHERE userid=:id")
    String genter(String id);

    @Query("SELECT number from playerdata WHERE userid=:id")
    String number(String id);

    @Query("SELECT blood from playerdata WHERE userid=:id")
    String blood(String id);
    @Query("SELECT state from playerdata WHERE userid=:id")
    String state(String id);

    @Query("SELECT email from playerdata WHERE userid=:id")
    String email(String id);

    @Query("SELECT goplaybookid from playerdata WHERE userid=:id")
    int adhar(String id);
}
