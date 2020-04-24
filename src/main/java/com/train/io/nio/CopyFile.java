package com.train.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Time: 20-4-8下午9:05
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        if(args.length < 2){
            System.err.println("Usage:java " +
                    "CopyFIle infile outfile");
            System.exit(1);
        }
        String infile = args[0];
        String outfile = args[1];

        FileInputStream fin = new FileInputStream(infile);
        FileOutputStream fout = new FileOutputStream(outfile);

        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true){
            buffer.clear();
            int r = fcin.read(buffer);
            if(r==-1){
                break;
            }
        }
        buffer.flip();
        fcout.write(buffer);

    }
}
