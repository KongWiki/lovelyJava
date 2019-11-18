package com.tran.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Time: 19-11-18下午12:27
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SeekSource {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", Integer.valueOf(1));
        map.put("2", Integer.valueOf(1));
        map.put("3", Integer.valueOf(1));
        System.out.println(map.get("1"));
    }
}
