/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.reversedemo;

/**
 * Created by anilkukreti on 20/06/17.
 */

public class Reverse implements IReverse {


    public String doReverse(String input) {
        StringBuffer stringBuffer = new StringBuffer(input);

        stringBuffer.reverse();

        return stringBuffer.toString();
    }


}
