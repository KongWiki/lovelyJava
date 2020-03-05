package com.train.generic.cla;

/**
 * @Time: 20-3-5上午8:35
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Info {
    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Info{ " +
                "value='" + value + '\'' +
                '}';
    }
}
