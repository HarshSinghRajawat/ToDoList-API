package com.one.mytest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface github {
    @GET("/todos")
    Call<List<Data>> listRepos();
}
