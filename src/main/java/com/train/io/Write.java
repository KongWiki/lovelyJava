package com.train.io;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Time: 19-12-28下午12:02
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Write {
    public static void main(String[] args) throws IOException {
        try(PrintWriter out= new PrintWriter("fine.txt", "utf-8")) {

            out.println("i'm fine thank you");

        }catch ( Exception e){
            System.out.println(e);
        }

    }
}
