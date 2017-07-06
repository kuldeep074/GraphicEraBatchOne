package com.example.pradeep.countmax;

import java.util.ArrayList;



/**
 * Created by pradeep on 28/6/17.
 */

public class Check implements Icheck{
    public String verify(ArrayList<String> list)
    {
        int max=0,i=0;
        int a[]=new int[list.size()];
        for (String s : list) {
            int c=s.charAt(0);
            max=0;
            for (String sc : list)
            {
                int cl=sc.charAt(0);

                if(cl==c)
                {
                    max++;
                }

            }
            a[i]=max;
            i++;

        }
         max=a[0];
        for(i=1;i<a.length;i++)
        {
            if(a[i]>max) {
                max = a[i];
            }
        }
        String s= Integer.toString(max);
        return (s);
    }


}
