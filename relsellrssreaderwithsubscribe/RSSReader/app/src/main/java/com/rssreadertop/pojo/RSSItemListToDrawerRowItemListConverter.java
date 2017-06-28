/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.rssreadertop.pojo;

import java.util.ArrayList;

/**
 * Created by anilkukreti on 05/02/16.
 */
public class RSSItemListToDrawerRowItemListConverter {

    private ArrayList<DrawerRowItem> drawerRowItemArrayList;
    private ArrayList<IRSSItem> rssItemArrayList;

    public void setDrawerRowItemArrayList(ArrayList<DrawerRowItem> drawerRowItemArrayList) {
        this.drawerRowItemArrayList = drawerRowItemArrayList;
    }

    public void setRssItemArrayList(ArrayList<IRSSItem> rssItemArrayList) {
        this.rssItemArrayList = rssItemArrayList;
    }

    public ArrayList<DrawerRowItem> getDrawerRowItemArrayList() {
        for(IRSSItem rssItem : rssItemArrayList) {
            DrawerRowItem obj = new DrawerRowItem();
            if(rssItem instanceof RSSItem) {
                obj.setmTitle(rssItem.getTitle());
                obj.setmView(1);
            }else if (rssItem instanceof RSSItem2) {
                obj.setmTitle(rssItem.getTitle());
                obj.setmView(2);
            }
            drawerRowItemArrayList.add(obj);
        }
        return drawerRowItemArrayList;
    }
}
