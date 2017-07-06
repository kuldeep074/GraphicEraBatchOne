package com.example.kuldeep.loginpage;

/**
 * Created by kuldeep on 25/6/17.
 */

public class Check implements Icheck {
    public Boolean verify(String n,String p)
    {
        Boolean o=n.equals(p);
        return o;
    }
}
