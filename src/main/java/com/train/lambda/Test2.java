package com.train.lambda;

/**
 * @Time: 20-2-21下午4:38
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Test2 {
    static class Love2 implements ILove{

        @Override
        public void love(int a) {
            System.out.println("hello hello hei 2" + a);
        }
    }

    public static void main(String[] args) {
        // 实现类
        ILove love = new Love1();
        love.love(1);

        // 静态内部类
        love = new Love2();
        love.love(2);

        // 局部内部类
        class Love3 implements ILove{

            @Override
            public void love(int a) {
                System.out.println("hello hello hei 3" + a);
            }
        }
        love = new Love3();
        love.love(3);

        // 匿名内部类
        love = new ILove() {
            @Override
            public void love(int a) {
                System.out.println("hello hello hei 4" + a);
            }
        };
        love.love(4);

        // lambda
        love = (int a) -> {
            System.out.println("hello hello hei 5" + a);
        };
        love.love(5);

        // 简化一: 去掉参数
        love = (a) -> {
            System.out.println("hello hello hei 6" + a);
        };
        love.love(6);

        // 简化二： 去括号
        love = a -> {
            System.out.println("hello hello hei 7" + a);
        };
        love.love(7);

        // 简化三： 去花括号
        love = a -> System.out.println("hello hello hei 8" + a);
        // 若是只有一行可以去掉花括号
        // 若是有多行





    }

}

interface ILove{
    void love(int a);
}

class Love1 implements ILove{

    @Override
    public void love(int a) {
        System.out.println("hello hello hei 1" + a);
    }
}
