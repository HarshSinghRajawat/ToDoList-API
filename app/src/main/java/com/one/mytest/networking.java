package com.one.mytest;

import android.util.Log;

import com.squareup.moshi.Moshi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class networking {
    public static Call<List<Data>> _getData(){
        Moshi moshi = new Moshi.Builder().build();
        Retrofit retro=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build();
        github make=retro.create(github.class);
        Call<List<Data>> _call=make.listRepos();
        Log.i("test","status ok");
        return  _call;
    }
}
