package com.example.pradeep.picslider;

import com.example.pradeep.picslider.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pradeep on 17/7/17.
 */

//singelton class

public class Utility {

    public List<DummyContent.DummyItem> ITEMS = new ArrayList<DummyContent.DummyItem>();
    private static Utility obj;

    private Utility()
    {

    }

    public static Utility getInstance()
    {
        if(Utility.obj==null)
        {
            obj=new Utility();
        }
        return obj;
    }
}
