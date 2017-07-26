package com.example.pradeep.audioplayer;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pradeep on 23/7/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>implements View.OnClickListener {

    private List<ListItem> listitems;
    private Context context;



    public MyAdapter(List<ListItem> listitems, Context context) {
        this.listitems = listitems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final ListItem listItem=listitems.get(position);
        holder.sno.setText(String.valueOf(listItem.getSno()));
        holder.songid.setText(String.valueOf(listItem.getSongid()));

        holder.relativeLayout.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,MainActivity2.class);
                intent.putExtra("songId",listItem.getSongid());

            context.startActivity(intent);



            }

        });


    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    @Override
    public void onClick(View v) {

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public  TextView sno;
        public TextView songid;
        public RelativeLayout relativeLayout;


        public ViewHolder(View itemView) {
            super(itemView);

            sno=(TextView) itemView.findViewById(R.id.sno);
            songid=(TextView) itemView.findViewById(R.id.songid);
            relativeLayout=(RelativeLayout) itemView.findViewById(R.id.relativelayout);
              }
    }
}
