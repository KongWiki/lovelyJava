package com.train.io.bio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @Time: 20-4-8下午2:44
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CloseSream {
    public static void main(String[] args) {
        FileOutputStream stream = null;
        try {
            File file = new File("out.txt");
            stream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(null != stream){
                try{
                    stream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
