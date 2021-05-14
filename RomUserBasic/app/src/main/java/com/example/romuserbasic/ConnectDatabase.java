package com.example.romuserbasic;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class ConnectDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "user.db";
    private static ConnectDatabase instance;
    public static synchronized ConnectDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ConnectDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract UserDao userDao();
}
