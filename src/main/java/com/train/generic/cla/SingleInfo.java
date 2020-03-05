package com.train.generic.cla;

/**
 * @Time: 20-3-5上午8:36
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SingleInfo<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SingleInfo{" +
                "value=" + value +
                '}';
    }
}
