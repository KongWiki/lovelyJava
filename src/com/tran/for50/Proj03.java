package com.tran.For50;

import javax.sound.midi.Track;
import java.util.ArrayList;

/**
 * @Time: 19-10-16下午7:23
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Proj03 {
    /**
     * 水仙花
     */
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=100; i<1000; i++){
            if(isFlower(i)){
                a.add(i);
            }
        }
        System.out.println(a);
    }

    public static boolean isFlower(int n){
        int hundred = n/100;
        int ten = (n-hundred*100)/10;
        int single = (n-hundred*100)%10;
        int result = hundred*hundred*hundred + ten*ten*ten + single*single*single;
        boolean flag = false;
        if(result == n){
            flag = true;
        }
        return flag;
    }
}
