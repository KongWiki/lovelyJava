package com.train.generic.cla;

/**
 * @Time: 20-3-5上午8:37
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Client {
    public static void main(String[] args) {
        Info info = new Info();
        info.setValue("维坤坤");
        System.out.println(info.getValue());

        SingleInfo<Integer> integerSingleInfo = new SingleInfo<>();
        integerSingleInfo.setValue(124);
        System.out.println(integerSingleInfo.getValue());

        SingleInfo<Double> singleInfo = new SingleInfo<>();
        singleInfo.setValue(123.34);
        System.out.println(singleInfo.getValue());
    }
}
