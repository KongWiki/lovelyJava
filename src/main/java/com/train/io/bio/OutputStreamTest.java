package com.train.io.bio;

import java.io.*;

/**
 * @Time: 20-4-8下午2:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class OutputStreamTest {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            FileOutputStream stream = new FileOutputStream(file);
            byte[] data = {97, 98};
            stream.write(data);
            stream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
