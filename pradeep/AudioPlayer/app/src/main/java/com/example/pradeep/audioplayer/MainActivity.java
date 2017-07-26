package com.example.pradeep.audioplayer;

import android.os.Bundle;

import android.media.MediaPlayer;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems=new ArrayList<>();


        ListItem listItem = new ListItem(1,R.raw.a);
        listItems.add(listItem);
        listItem = new ListItem(2,R.raw.b);
        listItems.add(listItem);
        listItem = new ListItem(3,R.raw.c);
        listItems.add(listItem);
        listItem = new ListItem(4,R.raw.d);
        listItems.add(listItem);
        listItem = new ListItem(5,R.raw.e);
        listItems.add(listItem);
        listItem = new ListItem(6,R.raw.f);
        listItems.add(listItem);
        listItem = new ListItem(7,R.raw.g);
        listItems.add(listItem);


        adapter=new MyAdapter(listItems,this);

        recyclerView.setAdapter(adapter);

    }



}