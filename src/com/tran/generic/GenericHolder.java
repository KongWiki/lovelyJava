package com.tran.generic;

/**
 * @Time: 19-12-12下午9:34
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class GenericHolder<T> {
    private T a;

    public GenericHolder() {
    }
    public void set(T a){ this.a = a;}
    public T get(){ return a;}

    public static void main(String[] args) {
        GenericHolder<Automobile> h3 = new GenericHolder<>();
        Automobile automobile = new Automobile();
        h3.set(new Automobile());

        Automobile a = h3.get();
        System.out.println(a);
    }
}
