package com.example.roomwithjavarx.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey(autoGenerate = true)
    private  int userID ;
    private String userName;
    private String phone;

    public User(String userName, String phone) {
        this.userName = userName;
        this.phone = phone;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhone() {
        return phone;
    }
}
