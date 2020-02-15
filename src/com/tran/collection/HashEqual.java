package com.tran.collection;

import com.tran.collection.hashMap.HashTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * @Time: 20-2-14下午4:48
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class HashEqual {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return i % 10;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof HashEqual)) {
            return false;
        }
        HashEqual other = (HashEqual) object;
        if (other.getI() == this.getI()) {
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        HashEqual a = new HashEqual();
        HashEqual b = new HashEqual();
        a.setI(1);
        b.setI(1);
        HashSet set = new HashSet();
        set.add(a);
        set.add(b);
        System.out.println("a hashCode " + a.hashCode());
        System.out.println("b hashCode " + b.hashCode());
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(set);


    }
}
