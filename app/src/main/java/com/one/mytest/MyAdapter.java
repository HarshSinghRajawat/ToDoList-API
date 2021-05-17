package com.one.mytest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Data> {
    public MyAdapter(Activity context, ArrayList<Data> data){
        super(context,0,data);
        Log.i("adapter","Adapter Created");
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem= convertView;
        if(listItem==null){
            listItem= LayoutInflater.from(getContext()).inflate(R.layout.adapter_layout,parent,false);
        }
        Data curWord=getItem(position);

        TextView userId=listItem.findViewById(R.id.userID);
        TextView ID=listItem.findViewById(R.id.ID);
        TextView title=listItem.findViewById(R.id.des);
        ConstraintLayout background=listItem.findViewById(R.id.background);
        setColor(curWord,background);
        background.setOnClickListener(view -> {
            curWord.is_done=!curWord.is_done;
            setColor(curWord,background);
        });

        userId.setText(curWord.getUid()+"");
        ID.setText(curWord.getId()+"");
        title.setText(curWord.getTitle());

        return listItem;
    }
    private void setColor(Data cur,ConstraintLayout background){
        if(cur.is_done){
            background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.if_true));
        }else{
            background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.if_false));
        }
    }
}
