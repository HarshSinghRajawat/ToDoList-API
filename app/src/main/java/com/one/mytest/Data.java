package com.one.mytest;

import com.squareup.moshi.Json;

import org.json.JSONArray;

public class Data {
    @Json(name="userId")
    int Uid;
    @Json(name="id")
    int id;
    @Json(name="title")
    String title;
    @Json(name="completed")
    boolean is_done;

    public Data(int uid, int id, String title, boolean is_done) {
        Uid = uid;
        this.id = id;
        this.title = title;
        this.is_done = is_done;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isIs_done() {
        return is_done;
    }

    public void setIs_done(boolean is_done) {
        this.is_done = is_done;
    }

}
