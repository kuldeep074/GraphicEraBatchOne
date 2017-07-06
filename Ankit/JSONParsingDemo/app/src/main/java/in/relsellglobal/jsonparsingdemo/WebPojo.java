/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.jsonparsingdemo;

/**
 * Created by anilkukreti on 27/06/17.
 */

public class WebPojo {
    private String id;
    private String username;
    private String fcmId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFcmId() {
        return fcmId;
    }

    public void setFcmId(String fcmId) {
        this.fcmId = fcmId;
    }

    @Override
    public String toString() {
        return "WebPojo{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", fcmId='" + fcmId + '\'' +
                '}';
    }
}
