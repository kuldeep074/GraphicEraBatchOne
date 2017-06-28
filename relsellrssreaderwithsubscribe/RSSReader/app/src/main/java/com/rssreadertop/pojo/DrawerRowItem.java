/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.rssreadertop.pojo;

/**
 * Created by anil on 12/7/15.
 */
public class DrawerRowItem {
    private String mTitle;
    private int mIcon;
    private boolean showIcon = true;
    private boolean mActive;
    private boolean mSectionHeader;
    private int mView;


    public boolean isShowIcon() {
        return showIcon;
    }

    public void setShowIcon(boolean showIcon) {
        this.showIcon = showIcon;
    }

    public boolean ismSectionHeader() {
        return mSectionHeader;
    }

    public void setmSectionHeader(boolean mSectionHeader) {
        this.mSectionHeader = mSectionHeader;
    }

    public boolean ismActive() {
        return mActive;
    }

    public void setmActive(boolean mActive) {
        this.mActive = mActive;
    }


    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
    public int getmIcon() {
        return mIcon;
    }

    public void setmIcon(int mIcon) {
        this.mIcon = mIcon;
    }

    public int getmView() {
        return mView;
    }

    public void setmView(int mView) {
        this.mView = mView;
    }
}
