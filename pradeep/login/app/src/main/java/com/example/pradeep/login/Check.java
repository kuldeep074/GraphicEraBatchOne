package com.example.pradeep.login;

/**
 * Created by pradeep on 21/6/17.
 */

public class Check implements Icheck{
    public Boolean verify(String n,String p)
        {
            Boolean o=n.equals(p);
            return o;
        }
}
