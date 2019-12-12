package com.tran.collection.queue;

import java.util.*;

/**
 * @Time: 19-12-4下午9:50
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PriorityQueueDemo {

    public static void printQ(Queue queue) {
        while (queue.peek() != null) {
            System.out.println(queue.remove() + " ");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            priorityQueue.offer(random.nextInt(i + 10));
        }
        printQ(priorityQueue);

        List<Integer> ints = Arrays.asList(25, 22, 20,
                18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<>(ints);
        printQ(priorityQueue);

    }
}
