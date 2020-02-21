package com.train.jvm;

import com.train.jvm.IBM.Sample;

import java.util.Random;

/**
 * @Time: 20-2-17下午10:26
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
//-Xms8m -Xmx8m -XX:+PrintGCDetails
public class TEST {
    public static void main(String[] args) {
        String str = "wkkkkkkkkkkkwkkkkkkkkkk";
        while (true){
            str += new Random().nextInt(999999999)+ new Random().nextInt(999999999);
        }
    }
}
