package com.tran.innerclass;

/**
 * @Time: 19-12-6下午9:59
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Parcell {
    class Contents{
        private int i =11;
        public int value() {
            return  i;
        }
    }

    class Destination{
        private String label;

        Destination(String whereTo){
            label = whereTo;
        }

        String readLabel() {
            return label;
        }

    }


    public void ship(String dest){
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());

    }


    public static void main(String[] args) {
        Parcell p = new Parcell();
        p.ship("Tasmania");
    }

}
