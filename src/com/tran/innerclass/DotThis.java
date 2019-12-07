package com.tran.innerclass;

/**
 * @Time: 19-12-7上午11:17
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner{
        public DotThis outer(){
            return DotThis.this;
        }
    }

    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
