## 多线程理解&进阶

### lambda表达式

#### 函数式接口

任何接口， 如果包含唯一一个抽象方法， 那么他就是一个函数式接口

```java
public interface Runnable{
    public abstract void run();
}
```

对于函数式接口， 就可以使用lambda表达式创建该接口的对象

避免匿名内部类过多

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

1. 编写类之后需要实现Runnable接口

   ```java
   public class MyThread implements Runnable{
       @Override
   	public void run(){
           // 自定义run方法
       }
       
       public static void main(String[] args){
           MyThread thread = new MyThread();
           new Thread(thread).start();
       }
   }
   ```

   

   

2. 根据静态代理， 使用Thread代理自己编写的类

#### 实现Callable接口

### 线程的状态

线程的五大状态：

其状态的转换和进程的状态转换等同

创建状态

就绪状态

阻塞状态

运行状态

死亡状态

### ==线程同步== 

### 线程通信

### 线程池等高阶用法