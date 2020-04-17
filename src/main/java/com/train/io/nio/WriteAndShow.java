package com.train.io.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @Time: 20-4-8下午3:29
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class WriteAndShow {
    static private final byte message[] = {83, 111, 109, 101, 32,
            98, 121, 116, 101, 115, 46};
    private static Character[] mesage = {'维', '坤', '坤'};

    static public void main(String args[]) throws Exception {
        FileOutputStream fout = new FileOutputStream("input.txt");

        FileChannel fc = fout.getChannel();

        CharBuffer buffer = CharBuffer.allocate(1024);
        for (Character character : mesage) {
            buffer.put(character);
        }
        //重设缓冲区
        buffer.flip();
        //通道将缓冲区的内容写入文件，通道只能操作byteBuffer,
        // 所以需要使用Charset将CharBuffer转为ByteBuffer
        Charset charset=Charset.defaultCharset();
        ByteBuffer byteBuffer=charset.encode(buffer);
        while (byteBuffer.hasRemaining()){
            fc.write(byteBuffer);
        }

        fc.close();
        fout.close();
    }
}
