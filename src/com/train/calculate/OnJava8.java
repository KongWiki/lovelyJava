package com.train.calculate;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @Time: 19-12-4下午8:23
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class OnJava8 {

    public static void printQ(Queue queue){
        while (queue.peek() != null){
            System.out.println(queue.remove() + " ");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random();
        for(int i = 0; i< 10; i++){
            queue.offer(random.nextInt(i+10));

        }
        System.out.println(queue);
        Queue<Character> qc = new LinkedList<>();
        for (char c : "Brontosaurus".toCharArray()) {
            qc.offer(c);

        }
        System.out.println(qc);

    }
}
