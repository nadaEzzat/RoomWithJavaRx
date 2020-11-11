package com.example.roomwithjavarx.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomwithjavarx.room.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface userDao {

    @Insert
    Completable insertUser(User user);

    @Query("select * from user_table")
    Observable<List<User>> getUsers();


}
