package com.tran.conclusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Time: 19-11-26下午8:19
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SortUtils {

    public static void main(String[] args) {
        // 测试3次，每次10w个100以内的随机数
        for (int i = 0; i < 10; i++) {
            testSort(100000);
        }
    }

    /**
     * 测试所有排序的正确性，已经耗时
     *
     * @param len
     */
    public static void testSort(int len) {
        Random r = new Random();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            list.add(r.nextInt(100));
        }
        Integer[] srcArrs = list.toArray(new Integer[] {});

        // 系统排序
        long start = System.currentTimeMillis();
        Collections.sort(list);
        long time = System.currentTimeMillis() - start;
        System.out.println("系统排序 耗时：" + time);

        // 快速排序
        Integer[] arrs = Arrays.copyOf(srcArrs, srcArrs.length);
        start = System.currentTimeMillis();
        quickSort(arrs, 0, arrs.length - 1);
        time = System.currentTimeMillis() - start;
        assertEquals(list, arrs, "快速排序", time);

        // 合并排序
        arrs = Arrays.copyOf(srcArrs, srcArrs.length);
        start = System.currentTimeMillis();
        mergeSort(arrs, 0, arrs.length - 1);
        time = System.currentTimeMillis() - start;
        assertEquals(list, arrs, "合并排序", time);

        // 希尔排序
        arrs = Arrays.copyOf(srcArrs, srcArrs.length);
        start = System.currentTimeMillis();
        shellSort(arrs, 0, arrs.length - 1);
        time = System.currentTimeMillis() - start;
        assertEquals(list, arrs, "希尔排序", time);

        // 插入排序
        arrs = Arrays.copyOf(srcArrs, srcArrs.length);
        start = System.currentTimeMillis();
        insertionSort(arrs, 0, arrs.length - 1);
        time = System.currentTimeMillis() - start;
        assertEquals(list, arrs, "插入排序", time);

        // 选择排序
        arrs = Arrays.copyOf(srcArrs, srcArrs.length);
        start = System.currentTimeMillis();
        selectionSort(arrs, 0, arrs.length - 1);
        time = System.currentTimeMillis() - start;
        assertEquals(list, arrs, "选择排序", time);

        // 冒泡排序
        arrs = Arrays.copyOf(srcArrs, srcArrs.length);
        start = System.currentTimeMillis();
        bubbleSort(arrs, 0, arrs.length - 1);
        time = System.currentTimeMillis() - start;
        assertEquals(list, arrs, "冒泡排序", time);

        // 堆 排序
        arrs = Arrays.copyOf(srcArrs, srcArrs.length);
        start = System.currentTimeMillis();
        heapSort(arrs, 0, arrs.length - 1);
        time = System.currentTimeMillis() - start;
        assertEquals(list, arrs, "堆 排序", time);

        System.out.println();
    }

    public static void assertEquals(List<Integer> list, Integer[] arrs, String msg, Long time) {
        for (int i = 0; i < list.size(); i++) {
            if (!arrs[i].equals(list.get(i))) {
                System.out.println(msg + " ERR Index：" + i);
                System.exit(1);
            }
        }
        System.out.println(msg + " 正确, 耗时 " + time);
    }




    /**
     * 堆排序
     *
     * @author daihui.gu
     * @param arrs
     * @param s
     * @param e
     */
    public static void heapSort(Integer[] arrs, int s, int e) {
        // 创建最大堆
        int n = (e + s) / 2;
        for (int i = n; i >= s; i--) {
            heapAdjust(arrs, i, e);
        }

        for (int i = e; i >= s; i--) {
            int tmp = arrs[s];
            arrs[s] = arrs[i];
            arrs[i] = tmp;
            heapAdjust(arrs, s, i - 1);
        }
    }

    /**
     * 堆排序调整方法
     *
     * @author daihui.gu
     * @param arrs
     * @param s
     * @param e
     */
    public static void heapAdjust(Integer[] arrs, int s, int e) {
        // s 到 e 之间，仅有 s 位置需要调整，其余均是最大堆
        int tmp = arrs[s];
        int i = s;
        while (i * 2 + 1 <= e) {
            int index = i;
            int left = 2 * i + 1, right = left + 1;
            if (arrs[i] < arrs[left]) {
                index = left;
            }
            if (right <= e && arrs[i] < arrs[right] && arrs[left] < arrs[right]) {
                index = right;
            }
            if (index > i) {
                arrs[i] = arrs[index];
                arrs[index] = tmp;
                i = index;
            } else {
                break;
            }
        }
    }

    /**
     * 合并排序
     *
     * @author daihui.gu
     * @param arrs
     * @param s
     * @param e
     */
    public static void mergeSort(Integer[] arrs, int s, int e) {
        if (s >= e) {
            return;
        }
        int n = (s + e) / 2;
        mergeSort(arrs, s, n);
        mergeSort(arrs, n + 1, e);

        Integer[] sort = new Integer[e - s + 1];
        int index = 0;
        int i = s, j = n + 1;
        while (i <= n && j <= e) {
            if (arrs[i] <= arrs[j]) {
                sort[index++] = arrs[i++];
            } else {
                sort[index++] = arrs[j++];
            }
        }
        while (i <= n) {
            sort[index++] = arrs[i++];
        }
        while (j <= e) {
            sort[index++] = arrs[j++];
        }

        for (int x = 0; x < sort.length; x++) {
            arrs[s + x] = sort[x];
        }
    }

    /**
     * 希尔排序
     *
     * @author daihui.gu
     * @param arrs
     * @param s
     * @param e
     */
    public static void shellSort(Integer[] arrs, int s, int e) {
        int n = e - s;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = s + gap; i < e + 1; i++) {
                if (arrs[i] < arrs[i - gap]) {
                    int tmp = arrs[i];
                    int j;
                    for (j = i - gap; j >= s && arrs[j] > tmp; j -= gap) {
                        arrs[j + gap] = arrs[j];
                    }
                    arrs[j + gap] = tmp;
                }
            }
        }
    }



    /**
     * 插入排序
     *
     * @author daihui.gu
     * @param arrs
     * @param s
     * @param e
     */
    public static void insertionSort(Integer[] arrs, int s, int e) {
        for (int i = s; i < e + 1; i++) {
            int val = arrs[i];
            int loc = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arrs[j] > val) {
                    arrs[j + 1] = arrs[j];
                    loc = j;
                }
            }
            if (loc < i) {
                arrs[loc] = val;
            }
        }
    }

    /**
     * 选择排序
     *
     * @author daihui.gu
     * @param arrs
     * @param s
     * @param e
     */
    public static void selectionSort(Integer[] arrs, int s, int e) {
        for (int i = s; i < e; i++) {
            int min = arrs[i];
            int loc = s;
            for (int j = i + 1; j < e + 1; j++) {
                if (min > arrs[j]) {
                    min = arrs[j];
                    loc = j;
                }
            }
            if (loc > i) {
                arrs[loc] = arrs[i];
                arrs[i] = min;
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @author daihui.gu
     * @param arrs
     * @param s
     * @param e
     */
    public static void bubbleSort(Integer[] arrs, int s, int e) {
        for (int i = s; i < e; i++) {
            for (int j = i + 1; j < e + 1; j++) {
                if (arrs[i] > arrs[j]) {
                    int tmp = arrs[i];
                    arrs[i] = arrs[j];
                    arrs[j] = tmp;
                }
            }
        }
    }

    /**
     * 快速排序
     *
     * @author daihui.gu
     * @param arrs
     * @param s
     * @param e
     */
    public static void quickSort(Integer[] arrs, int s, int e) {
        int i = s, j = e;
        int val = arrs[i];

        while (i < j) {
            while (val <= arrs[j] && i < j) {
                j--;
            }
            if (i < j) {
                arrs[i] = arrs[j];
                arrs[j] = val;
                i++;
            }
            while (val >= arrs[i] && i < j) {
                i++;
            }
            if (i < j) {
                arrs[j] = arrs[i];
                arrs[i] = val;
                j--;
            }
        }
        // 递归
        if (s < i - 1) {
            quickSort(arrs, s, i - 1);
        }
        if (i + 1 < e) {
            quickSort(arrs, i + 1, e);
        }
    }

}