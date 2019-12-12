package com.app.myapplication.network;


import retrofit2.Callback;

public abstract class ApiCallBack<T> implements Callback<T> {
    public abstract void onRefresh();
}
