package com.tran.collection.onjava8;

import java.util.ArrayList;

/**
 * @Time: 19-12-12下午6:58
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
class Apple{
    private static long counter;
    private final long id = counter ++;
    public long id(){return  id;}
}

class Orange{
}


public class AppleOrangeWithoutGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());

        }
        apples.add(new Orange());
        for (Object apple : apples) {
            ((Apple) apple).id();
        }
    }
}
