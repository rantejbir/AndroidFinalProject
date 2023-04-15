package com.cst2335.androidfinalproject;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * The @Database annotation specifies the name of the database and the entities (tables) that are present in it. In this instance, a list item is represented by a single entity, called ListEntry.
 *
 * The class has a ListDao object for accessing the database and a static variable for the database name. If an instance of the database already exists, the getInstance() method returns that instance instead of creating a new one. The function sets some settings, including the context, the database class, and the database name, before using the databaseBuilder() method to construct a database instance. When the version number changes, the fallbackToDestructiveMigration()
 * function is used to reconstruct the database. When schema changes are frequent throughout development, this is helpful.
 */

@Database(entities = {ListEntry.class},version = 1)
public abstract class ListDatabase extends RoomDatabase {
    static String DB_NAME="List";
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