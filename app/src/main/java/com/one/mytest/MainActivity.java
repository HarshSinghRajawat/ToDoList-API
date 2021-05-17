package com.one.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    ArrayList<Data> Received_data= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        MyAdapter adapter=new MyAdapter(this,Received_data);
        ListView list=findViewById(R.id.list);
        ProgressBar bar=findViewById(R.id.progressBar);
        networking._getData().enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                if(response.code()==200) {

                    Received_data.addAll(response.body());
                    bar.setVisibility(View.GONE);
                    list.setAdapter(adapter);

                }else{
                    Log.i("test","status error");
                }

            }
            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
                Log.i("test","status error");
            }

        });

    }

}