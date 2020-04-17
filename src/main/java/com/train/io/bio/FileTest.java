package com.train.io.bio;

import java.io.File;
import java.util.Date;

/**
 * @Time: 20-4-8下午1:23
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FileTest {
    public static void main(String[] args) {
//        File f1 = new File("/src/main/resources/");
//        System.out.println(f1.getAbsolutePath());
//        File f2 = new File("out.txt");
//        System.out.println(f2.getAbsolutePath());
//        File f3 = new File(f1, "out.txt");
//        System.out.println(f3.getAbsolutePath());
//        // 判断文件是否存在
//        System.out.println("是否存在 " + f2.exists());
//        // 判断是否是文件
//        System.out.println("是否是文件 " + f2.isFile());
//        // 判断是否是文件夹
//        System.out.println("是否是文件夹 " + f2.isDirectory());
//        // 文件长度
//        System.out.println("文件长度 " + f2.length());
//        // 文件最后修改时间
//        long time = f2.lastModified();
//        Date d = new Date(time);
//        System.out.println("文件最后修改时间 " + d);
//        //设置文件修改时间为1970.1.1 08:00:00
//        f2.setLastModified(0);
        System.out.println("======================================");
        File file = new File("../../Downloads");
        System.out.println(file.exists());
        int i  = 0;
        File[] f = file.listFiles();

        for (File file1 : f) {
            i++;
            System.out.print(file1.getName()+ "、 ");
            if(i % 5 == 0){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("===========Download下容量最值文件=========");
        long max = 0;
        long min = Integer.MAX_VALUE;
        String maxName = null;
        String minName = null;
        for (File f2 : f) {
            if(f2.isDirectory()){
                continue;
            }
            if(f2.length() > max){
                max=f2.length();
                maxName = f2.getName();
            }
            if(f2.length() < min){
                min = f2.length();
                minName = f2.getName();
            }

        }
        System.out.println("最大文件为: "+maxName + " 大小为 " + max/1024);
        System.out.println("最小文件为: "+minName + " 大小为 " + min/1024);
        System.out.println("===========Download下文件遍历=========");
        for (File f1 : f) {
            System.out.println(f1.getName());
            if(f1.isDirectory()){
                for(File ff : f1.listFiles()) {
                    System.out.println("  +" + ff.getName());
                }
            }
        }



    }
}
