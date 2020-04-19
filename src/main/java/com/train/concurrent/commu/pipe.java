package com.train.concurrent.commu;


import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Time: 2020/4/19下午6:09
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class pipe {
    static class ReaderThread implements Runnable {
        private PipedReader reader;

        public ReaderThread(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            System.out.println("This is Reader");
            int receive = 0;
            try {
                while ((receive = reader.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }


    static class WriterThread implements Runnable {
        private PipedWriter writer;

        public WriterThread(PipedWriter writer) {
            this.writer = writer;
        }


        @Override
        public void run() {
            System.out.println("This is Writer");
            int receive = 0;
            try {
                writer.write("hello");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader);

        new Thread(new ReaderThread(reader)).start();
        Thread.sleep(200);
        new Thread(new WriterThread(writer)).start();

    }
}
