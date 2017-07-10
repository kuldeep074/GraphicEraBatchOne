/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.rssreadertop.pojo;

/**
 * Created by anilkukreti on 05/02/16.
 */
public interface IRSSItem {
    public String getLink();
    public String getTitle();
    public String getPubDate();
    public void setTitle(String title);
    public void setLink(String link);
    public void setPubDate(String pubDate);
}
