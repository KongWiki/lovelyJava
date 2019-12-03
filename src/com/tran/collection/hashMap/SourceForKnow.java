package com.tran.collection.hashMap;

/**
 * @Time: 19-12-2下午3:39
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SourceForKnow {
    public static void main(String[] args) {
        int h;
        Object m = "fdsafa";
        // ^ ：按位异或
        // >>>:无符号右移，忽略符号位，空位都以0补齐
        h = m.hashCode();
        System.out.println(h);
        System.out.println(h >>> 16);
   
    }
}
