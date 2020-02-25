package com.train.lambda;

/**
 * @Time: 20-2-21下午4:17
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */

// 推到lambda表达式
public class Test {
    //2 静态内部类
    static class Like2 implements Ilike {

        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        Ilike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();
        //3 局部内部类
        class Like3 implements Ilike {

            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }

        like = new Like3();
        like.lambda();

        //4 匿名内部类
        like = new Ilike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();

        // 5 lambda
        like = () -> {
            System.out.println("i like lambda5");
        };
        like.lambda();



    }
}

//定义一个函数式接口
interface Ilike {
    void lambda();
}

//1 实现类
class Like implements Ilike {

    @Override
    public void lambda() {
        System.out.println("i like lambda1");
    }
}
