package com.train.generic;


import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 19-10-22下午1:38
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class GenericForKnow {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
//        List arrayList = new ArrayList();
        arrayList.add("aaaa");
//        arrayList.add(100);
        for(int i =0; i< arrayList.size(); i++){
            String item = (String) arrayList.get(i);
            System.out.println("泛型测试： item="+item);
        }
    }
}
