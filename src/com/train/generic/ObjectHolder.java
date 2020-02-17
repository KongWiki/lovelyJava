package com.train.generic;

/**
 * @Time: 19-12-12下午9:25
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ObjectHolder {
    private Object a ;
    private ObjectHolder(Object a){
        this.a = a;
    }

    public Object getA() {
        return a;
    }

    public void setA(Object a) {
        this.a = a;
    }

    public static void main(String[] args) {
        ObjectHolder h2 = new ObjectHolder(new Automobile());
        h2.setA("Not an Automobile");
        String s = (String) h2.getA();
        System.out.println("当前getA为: " + s);
        h2.setA(1);
        Integer x = (Integer) h2.getA();
        System.out.println("当前getA为: " + x);


    }
}
