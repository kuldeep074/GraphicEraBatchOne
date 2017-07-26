package com.example.pradeep.recycleview;

/**
 * Created by pradeep on 23/7/17.
 */

public class ListItem {
    private String head;
    private String des;

    public ListItem(String head,String des)
    {
        this.head=head;
        this.des=des;
    }

    public String getHead()
    {
        return head;
    }

    public String getDes(){
        return des;
    }
}
