package com.tran.collection.linkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-1-5下午4:17
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LinkedLIstForKnow {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("我");
        ll.add("是");
        ll.add("孔维坤");
        System.out.println("当前的LinkedList为：" + ll);
//        LinkedList<String> newList = new LinkedList<>(ll);
//        System.out.println("新的list为： " + newList);
        LinkedList<String> aa = new LinkedList<>();
        aa.add("我");
        aa.add("是");
        aa.add("韩欢欢");
        System.out.println("当前的LinkedList为：" + aa);
        System.out.println("addAll()? " + aa.addAll(ll));
        System.out.println("使用addAll()之后的链表W为: "+ aa);
        System.out.println();
        System.out.println();
        List list = new LinkedList();
        list.add(11);
        list.add(0);
        System.out.println(list.size());
        if(list.size()<0){
            throw  new IndexOutOfBoundsException("size<0");
        }else {
            throw new IndexOutOfBoundsException("size() > 0");
        }


    }
}
