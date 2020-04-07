package com.train.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Time: 20-4-6上午10:03
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FileIo {
    public static void main(String[] args) {
        InputStream input = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
    }
}
