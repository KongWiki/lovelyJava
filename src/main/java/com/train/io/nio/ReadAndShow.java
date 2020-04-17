package com.train.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Time: 20-4-8下午3:15
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ReadAndShow {
    public static void main(String[] args) {
        try {
            // 获取通道
            FileInputStream fin = new FileInputStream("out.txt");
            FileChannel fc = fin.getChannel();
            // 创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 将数据从通道中读到缓冲区
            fc.read(buffer);
            buffer.flip();
            int i = 0;
            while (buffer.remaining() > 0){
                byte b = buffer.get();
                System.out.println( "Character "+i+": "+((char)b) );
                i++;
            }
            fin.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
