package com.tran.innerclass;

/**
 * @Time: 19-12-6下午10:13
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Parcell2 {
    class Contents{
        private int i = 1;
        public int value() {return i;}

    }

    class Destination{
        private String label;

        Destination(String whereTo){
            label = whereTo;
        }

        String readLable(){
            return label;
        }
    }

    public Destination to(String s){
        return new Destination(s);
    }

    public Contents contents(){
        return new Contents();
    }


    public void ship(String dest){
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLable());
    }

    public static void main(String[] args) {
        Parcell2 p = new Parcell2();
        p.ship("Tasmania");
        Parcell2 q = new Parcell2();
        // 外部类调用内部类, 需要明确指定(OuterClassName.InnerClassName)
        Parcell2.Contents c = q.contents();
        Parcell2.Destination d = q.to("Borneo");
        System.out.println(d.readLable());


    }
}
