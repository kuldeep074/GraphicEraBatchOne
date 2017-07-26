package com.example.pradeep.audioplayer;

/**
 * Created by pradeep on 23/7/17.
 */

public class ListItem {
    private int sno;
    private int songid;



    public int getSongid() {
        return songid;
    }



    public ListItem(int sno,int songid) {
        this.sno = sno;
        this.songid = songid;
    }

    public int getSno() {
        return sno;
    }

}
