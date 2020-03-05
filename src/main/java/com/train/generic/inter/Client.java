package com.train.generic.inter;

/**
 * @Time: 20-3-5上午8:56
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Client {
    public static void main(String[] args) {
        NoImplInterface<String> noImplInterface = new NoImplInterface<>("wkk");
        ImplInterface implInterface = new ImplInterface(123);
        System.out.println(noImplInterface.getT());
        System.out.println(implInterface.getT());
    }
}
