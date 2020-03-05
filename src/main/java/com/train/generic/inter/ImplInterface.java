package com.train.generic.inter;

import com.train.jvm.classloader.MyClassLoader;

/**
 * @Time: 20-3-5上午8:53
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ImplInterface implements MyInterface<Integer> {
    private int a = 100;

    public ImplInterface(int a) {
        this.a = a;
    }

    @Override
    public Integer getT() {
        return a;
    }
}
