package com.cst2335.androidfinalproject;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.cst2335.androidfinalproject.ListDao;
import com.cst2335.androidfinalproject.ListEntry;

@Database(entities = {ListEntry.class},version = 1)
public abstract class ListDatabase extends RoomDatabase {
    static String DB_NAME="ListDB";
    public abstract ListDao listDao();
    private static ListDatabase mInstance;
    public static synchronized ListDatabase getInstance(Context ctx) {
        if(mInstance == null) {
            mInstance = Room.databaseBuilder(ctx.getApplicationContext(),
                            ListDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return mInstance;
    }

}