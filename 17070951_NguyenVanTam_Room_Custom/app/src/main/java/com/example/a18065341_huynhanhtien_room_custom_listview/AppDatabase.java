package com.example.a18065341_huynhanhtien_room_custom_listview;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Place.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Room-database-custom";



    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public abstract PlaceDao placeDao();
}
