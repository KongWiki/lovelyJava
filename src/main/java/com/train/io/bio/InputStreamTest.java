package com.train.io.bio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @Time: 20-4-8下午2:05
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class InputStreamTest {
    public static void main(String[] args) {
        try {
            // 创建基于文件的输入流
            File f = new File("out.txt");
            // 通过下面的输入流 就可以把数据从磁盘中读到JVM中（读到内存中）
            System.out.println(f.exists());
            FileInputStream stream = new FileInputStream(f);
            byte[] all = new byte[(int) f.length()];
            stream.read(all);
            for (byte b : all) {
                System.out.println(b);
            }
            stream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
