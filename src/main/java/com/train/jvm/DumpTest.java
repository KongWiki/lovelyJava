package com.train.jvm;

import com.train.array.Arra;

import java.util.ArrayList;

/**
 * @Time: 20-2-18上午9:53
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// -Xms4m -Xmx4m -XX:+HeapDumpOnOutOfMemoryError
public class DumpTest {
    byte[] array = new byte[1024*1024];

    public static void main(String[] args) {
        ArrayList<DumpTest> objects = new ArrayList<>();
        int count = 0;
        try{
            while (true){
                objects.add(new DumpTest());
                count += 1;
            }
        }catch (Exception e){
            System.out.println("count: " +count);
            e.printStackTrace();
        }
    }
}
