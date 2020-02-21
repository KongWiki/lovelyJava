package com.train.collection.train;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * @Time: 19-11-18下午7:43
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CollectionTrain {
    // 产生10个1-100的随机数 并放到一个数组中吧数组中大于等于10的数字放到一个list集合中
    public static void topic1(){
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[10];
        Random random = new Random();
        for(int i=0; i<arr.length; i++){
            arr[i] = random.nextInt(100) +1;
            if(arr[i] >= 10){
                list.add(arr[i]);
            }
        }
        System.out.println(list);
    }

    public  static  void topic2(){
        /**
         * 定义一个方法listTest(ArrayList<Integer> al, Integer s)，
         * 要求返回s在al里面第一次出现的索引，如果s没出现过返回-1。
         */
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(10);
        arrayList.add(12);
        arrayList.add(13);
        System.out.println("索引值为: "+listTest(arrayList, 5));
    }

    private static int listTest(ArrayList<Integer> arrayList, int i) {
        for(int j=0; j<arrayList.size(); j++){
            if(arrayList.get(j) == i){
                return i;
            }
        }
        return -1;
    }


    public static  void topic3(){
        /**
         * 已知数组存放一批QQ号码，QQ号码最长为11位，
         * 最短为5位String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"}。
         *
         * 将该数组里面的所有qq号都存放在LinkedList中，将list中重复元素删除，
         * 将list中所有元素分别用迭代器和增强for循环打印出来。
         */
        String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"};
        LinkedList<Long> linkedList = new LinkedList<>();
        for (String str : strs) {
            linkedList.add(Long.parseLong(str));
        }
        // 迭代器输出
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        // for-each循环
        for(long i : linkedList){
            System.out.print(i + " ");
        }
    }

    //###########################################//
    //HashSet的使用
    // 双色球规则：双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
    // 红色球号码从1—33中选择；
    // 蓝色球号码从1—16中选择；
    // 请随机生成一注双色球号码。（要求同色号码不重复）
    //###########################################//
    public static  void top5(){
        String[] stringArr = new String[7];
        int flag = 0;
        Random ra = new Random();
        int blueBaallIndex = ra.nextInt(7);
        stringArr[blueBaallIndex] = top5Method2();
        for(int i=0; i< stringArr.length; i++){
            if(i==blueBaallIndex){
                continue;
            }
            stringArr[i] = top5Method1();
        }
        for(int i=0; i< stringArr.length; i++){
            System.out.print(stringArr[i]+" ");
        }
    }

    public static  String top5Method1(){
        /**
         * 用于生成红球字符串
         */
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i< 33; i++){
            Integer temp = (i+1);
            arrayList.add(temp.toString());
        }
        Random ra = new Random();
        int randomValue = ra.nextInt(33);
        return "红球"+arrayList.get(randomValue);
    }

    public static String top5Method2(){
        /**
         * 用于生成篮球字符串
         */
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0; i< 16; i++){
            Integer temp = (i+1);
            arrayList.add(temp.toString());
        }
        Random ra = new Random();
        int randomValue = ra.nextInt(16);
        return "篮球"+arrayList.get(randomValue);
    }

    public static void main(String[] args) {
//        topic1();
//        topic2();
//        topic3();
        top5();
//        String a = "124";
//        int b = Integer.parseInt(a);
//        System.out.println(b);
    }

}
