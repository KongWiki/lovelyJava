package com.train.jvm.methods;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;


/**
 * @Time: 20-2-19下午4:49
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class HelloWorld {
    private static Logger logger = Logger.getLogger(HelloWorld.class.getName());
    public void sayHello(String message){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY");
        String today = format.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(HelloWorld.class.getName());
    }
}
