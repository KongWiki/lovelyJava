package com.train.concurrent.book.program;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;

/**
 * @Time: 20-2-22上午9:47
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class StopThreadUnsafe {
    public static User u = new User();

    public static class User{
        private int id = 0;
        private String name = "0";

        public User() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class ChangeObjectThread implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (u){
                    int l = (int) (System.currentTimeMillis() / 1000);
                    u.setId(l);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    u.setName(String.valueOf(l));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (u){
                    if(u.getId()!=Integer.parseInt(u.getName())){
                        System.out.println(u.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ReadObjectThread()).start();
        while (true){
            ChangeObjectThread changeObjectThread = new ChangeObjectThread();
            Thread thread = new Thread(changeObjectThread);
            thread.start();
            Thread.sleep(1000);
            thread.stop();
        }

    }

}
