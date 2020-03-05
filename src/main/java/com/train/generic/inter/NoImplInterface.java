package com.train.generic.inter;

/**
 * @Time: 20-3-5上午8:54
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class NoImplInterface<T> implements MyInterface<T> {
    private T text;

    public NoImplInterface(T text) {
        this.text = text;
    }

    @Override
    public T getT() {
        return text;
    }
}
