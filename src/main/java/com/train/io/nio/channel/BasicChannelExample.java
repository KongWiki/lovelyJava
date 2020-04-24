package com.train.io.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Time: 2020/4/24上午9:39
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BasicChannelExample {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("../../Downloads/aaa.txt", "rw");
        FileChannel inChannel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int byteRead = inChannel.read(buffer);
        while (byteRead != -1){
            System.out.println("文件内容长度 " + byteRead);
            // 切换为读模式
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            byteRead = inChannel.read(buffer);
        }
        file.close();

    }
}
