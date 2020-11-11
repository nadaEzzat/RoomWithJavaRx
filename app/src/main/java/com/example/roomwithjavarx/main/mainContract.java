package com.example.roomwithjavarx.main;

import com.example.roomwithjavarx.room.User;

import java.util.List;

public interface mainContract {

    interface viewInterface{

        void setUsers(List<User> users);


    }
    interface presnterInterface{

        void getUsers();
        void saveUser(User user);

    }

}
