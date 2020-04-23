package com.train.io.comp;

import com.train.concurrent.syn.SyncTest;

import javax.xml.ws.BindingType;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.Time;

/**
 * @Time: 2020/4/23下午1:34
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SimpleFileTransferTest {
    private long transferFile(File source, File des) throws IOException{
        long startTime = System.currentTimeMillis();
        if(!des.exists()){
            des.createNewFile();
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes))!= -1){
            bos.write(bytes, 0, len);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long transferFileWithNIO(File source, File des) throws IOException{
        long startTime = System.currentTimeMillis();
        if(!des.exists()){
            des.createNewFile();
        }

        RandomAccessFile read = new RandomAccessFile(source, "rw");
        RandomAccessFile write = new RandomAccessFile(des, "rw");
        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024);
        while (readChannel.read(byteBuffer) > 0){
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        writeChannel.close();
        readChannel.close();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;

    }

    public static void main(String[] args) throws IOException {
        SimpleFileTransferTest test = new SimpleFileTransferTest();
        File source = new File("../../Downloads/极客时间/spring核心编程思想/04-特性总览：核心特性、数据存储、Web技术、框架整合与测试.mp4");
        File des = new File("../../Downloads/io.avi");
        File nio = new File("../../Downloads/nio.avi");
        long time = test.transferFile(source, des);
        System.out.println(time + ": 普通字节流时间");
        long timeII = test.transferFileWithNIO(source, nio);
        System.out.println(timeII + ": NIO时间");

    }
}
