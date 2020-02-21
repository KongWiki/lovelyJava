package com.train.jvm.classloader;

import java.io.*;

/**
 * @Time: 20-2-19上午9:57
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MyClassLoader extends ClassLoader {
    // 文件路径
    private String root;

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            // 参数
            // name: 需要加载的文件
            // classData: 数据二进制
            // off: 偏移量
            // len:
            return defineClass(name, classData, 0, classData.length);
        }

    }

    private byte[] getClassData(String className) {
        String path = root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        MyClassLoader loader = new MyClassLoader();
        loader.setRoot("");
        Class<?> testClass = null;

        try{
            testClass = loader.loadClass("com.train.jvm.classloader.LoaderTest");
            Object instance = testClass.newInstance();
            System.out.println(instance.getClass().getClassLoader());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
