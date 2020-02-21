## 多线程理解&进阶

### 线程的简介

进程与线程。。。

参见《操作系统第四版》

### ==线程的实现==	

#### 继承Thread类

1. 编写自己的类然后需要继承`Thread`类

   ```java
   public class MyThread extends Thread{
       
       @Override
       public void run(){
           // 自定义run方法
       }
   }
   ```

   

2. 创建线程对象， 调用start()方法执行

   ```java
   public class MyThread extends Thread{
       
       @Override
       public void run(){
           // 自定义run方法
       }
       
       public static void main(String[] args){
           MyThread thread = new MyThread();
           thread.start();
       }
   }
   ```

   

#### 实现Runnable接口

#### 实现Callable接口

### 线程的状态

### ==线程同步==

### 线程通信

### 线程池等高阶用法