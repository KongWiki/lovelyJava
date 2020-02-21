package com.train.jvm.IBM;

import java.lang.reflect.Method;

/**
 * @Time: 20-2-17下午2:14
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Sample {
    private Sample instance;

    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.testClassIdentity();
    }

    public void setSimple(Object instance){
        this.instance = (Sample) instance;
    }
    public void testClassIdentity(){
        String classDataPath = "/home/kongweikun/IdeaProjects/JavaTrain/out/production/JavaTrain";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataPath);
        String name= "com.train.jvm.IMB.Sample";
        try{
            Class<?> aClass = fscl1.loadClass(name);
            Object obj1 = aClass.newInstance();
            Class<?> aClass1 = fscl2.loadClass(name);
            Object obj2 = aClass1.newInstance();
            Method setSimple = aClass.getDeclaredMethod("setSimple", Object.class);
            setSimple.invoke(obj1, obj2);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
