package com.train.io.nio.buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Time: 2020/4/24上午9:59
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BasicBufferExample {
    public static void writeData(){

    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("../../Downloads/aaa.txt", "rw");
        FileChannel inChannel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = inChannel.read(buffer);
        while (read != -1){
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.print((char)buffer.get());
            }
            buffer.clear();
            read = inChannel.read(buffer);
        }
        file.close();
    }
}
