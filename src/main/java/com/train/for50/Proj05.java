package com.train.for50;

/**
 * @Time: 19-10-16下午7:34
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Proj05 {
    /**
     * 分数
     * @param args
     */
    public static void main(String[] args) {
        int n = -1;
        try {
            n = Integer.parseInt(args[0]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("请输入成绩");
            return;
        }
        judegeScore(n);
    }

    public static String judegeScore(int score){
        if(score < 60){
            return "C";
        }else if(score>60&&score<90){
            return "B";
        }else if(score>=90){
            return "A";
        }
        return "错误";
    }
}
