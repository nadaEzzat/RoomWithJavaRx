package com.example.roomwithjavarx.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = User.class , version = 1)
public abstract class userDataBase extends RoomDatabase {

    private static userDataBase instance;
    public abstract userDao userDao();

    public static synchronized userDataBase getInstance(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context , userDataBase.class , "user_database").fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
