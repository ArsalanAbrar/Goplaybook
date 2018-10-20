package com.example.c_arsalanabrar.goplaybook;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "playerdata")
public class PlayerData {
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "userid")
        String id;
        @ColumnInfo(name = "name")
        String fname;
        @ColumnInfo(name = "surname")
        String surname;
        @ColumnInfo(name = "age")
        String age;
        @ColumnInfo(name = "gender")
        String gender;
        @ColumnInfo(name = "blood")
        String bld;
        @ColumnInfo(name = "number")
        String num;
        @ColumnInfo(name = "field")
        String field;
        @ColumnInfo(name = "email")
        String email;
        @ColumnInfo(name = "state")
        String state;
        @ColumnInfo(name = "goplaybookid")
        int adharid;

    public int getAdharid() {
        return adharid;
    }

    public void setAdharid(int adharid) {
        this.adharid = adharid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getBld() {
            return bld;
        }

        public void setBld(String bld) {
            this.bld = bld;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getGender() {
            return gender;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getSurname() {
            return surname;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }




