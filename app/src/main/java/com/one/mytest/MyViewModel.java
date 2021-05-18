package com.one.mytest;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel {
    static ArrayList<Data> Received_data=new ArrayList<>();
    static MyAdapter adapter;
    protected MyAdapter makeRequest(Activity context){
            adapter = new MyAdapter(context, Received_data);
            ListView list = context.findViewById(R.id.list);
            list.setAdapter(adapter);
            ProgressBar bar = context.findViewById(R.id.progressBar);
            networking._getData().enqueue(new Callback<List<Data>>() {
                @Override
                public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                    if (response.code() == 200) {

                        Received_data.addAll(response.body());
                        bar.setVisibility(View.GONE);
                        adapter.notifyDataSetChanged();

                    } else {
                        Log.i("test", "status error");
                    }

                }

                @Override
                public void onFailure(Call<List<Data>> call, Throwable t) {
                    Log.i("test", "status error");
                }

            });

        return adapter;
    }

}
