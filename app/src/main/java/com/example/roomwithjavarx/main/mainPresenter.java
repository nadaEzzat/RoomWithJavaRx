package com.example.roomwithjavarx.main;

import android.content.Context;
import android.util.Log;

import com.example.roomwithjavarx.room.User;
import com.example.roomwithjavarx.room.userDataBase;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class mainPresenter implements mainContract.presnterInterface {

    private mainContract.viewInterface viewInterface;
    private userDataBase userDatabase;
    private Context context;

    public mainPresenter(mainContract.viewInterface viewInterface, Context context) {
        this.viewInterface = viewInterface;
        userDatabase = userDataBase.getInstance(context);

    }

    @Override
    public void getUsers() {
        userDatabase.userDao().getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("tag", "get onSubscribe");
                    }

                    @Override
                    public void onNext(List<User> users) {
                        Log.i("tag", "get onNext");
                        viewInterface.setUsers(users);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("tag", "get onError : " + e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        Log.i("tag", "get onComplete");

                    }
                });
    }

    @Override
    public void saveUser(User user) {
        userDatabase.userDao().insertUser(user)
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("tag", "onSubscribe");
                    }

                    @Override
                    public void onComplete() {
                         Log.i("tag", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("tag", "onError : " + e.getMessage());
                    }
                });
    }
}
