package com.tran.generic;

/**
 * @Time: 19-12-12下午9:54
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class TupleTest {
    static Tuple2<String, Integer> f(){
        return new Tuple2<>("h1", 99);
    }

    static Tuple3<Amphibian, String, Integer> g(){
        return new Tuple3<>(new Amphibian(), "h1", 100);
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> ttsi = f();
        System.out.println(ttsi);

        System.out.println(g());
        System.out.println();
    }
}
