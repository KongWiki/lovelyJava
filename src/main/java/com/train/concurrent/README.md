## 并发

并发实现与处理都与线程脱不开关系， 所以一下为线程的使用 

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



### 并发的核心机制

#### synchronized关键字

> Java语言的关键字，当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码。

**锁定一个对象**

**疑问：**

1. 如何保证同一时刻至多只有一个线程执行该段代码
2. **保证在同一时刻最多只有一个线程执行该段代码**的意义

synchronized关键字保证了操作的**原子性**



**使用一**

```java
// 锁定一个对象 执行完之后自动释放
public class T {
    private int count = 10;
    private Object o = new Object();

    public void m(){
        // 任何线程要执行下述代码 都需要先获得o的锁
        synchronized(o){
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " +count);
        }
    }
}
```



**使用二**

若是使用synchronized关键字每次都创建一个对象，显然不科学，也不推荐，因为其是锁定一个对象，所以可以锁定自身

```java
public class T2 implements Runnable {
    private int count = 10;

    public void m() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count= " + count);
        }
    }

    @Override
    public void run() {
        m();
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        for (int i = 0; i < 8; i++) {
            new Thread(t2).start();
        }

    }
}
```



**使用三**

直接用在方法上

```java
// synchronized(this)的简写
public class T3 {
    private int count = 10;

    // 等同于在方法的代码执行时要synchronized(this)
    public synchronized void m(){
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " +count);
    }
}

```



synchronized方法在运行时， 其他非synchronized方法是可以运行的，但是其他synchronized方法需要等待当前运行的synchronized释放锁（可能会出现脏读现象)





#### Volatile

#### CAS

#### ThreadLocal



### 并发锁

#### ReentrantLock

相比与synchronized关键字， ReentranLock灵活度更高，需要手动加锁解锁 `lock.lock()`  `lock.unlock()`

**使用synchronized锁定的话如果遇到异常，JVM会自动释放锁，但是lock必须手动释放锁， 因此经常在finally中进行锁的释放**

```java
public class ReentrantLock2 {
    Lock lock = new ReentrantLock();

    void m1() {
        lock.lock();  // synchronized(this)
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    void m2() {
        lock.lock();
        try {
            System.out.println("m2...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public static void main(String[] args) {
        ReentrantLock2 r1 = new ReentrantLock2();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r1::m2).start();
    }
}
```

**尝试加锁**

```java
    Lock lock = new ReentrantLock();
    void m1() {
        lock.lock();  // synchronized(this)
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 使用tryLock进行尝试锁定，不过锁定与否，方法都将继续执行
     * 可根据tryLock的返回值来确定是否锁定
     * 也可以指定tryLock的时间，有tryLock(time)抛出异常，
     * 所以要注意unlock的处理必须放到finally中
     */
    synchronized void m2() {
        // 如果锁定了怎么办， 没锁定怎么办， 逻辑根据返回值来判断
		/*boolean locked = lock.tryLock();
		System.out.println("m2......" + locked);
		if (locked) lock.unlock();*/

        boolean locked = lock.tryLock();
        try {
            locked = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("m2......" + locked);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }
```

**可以对线程interrupt方法做出响应**

暂时不理解

**指定是否为公平锁**

```java
public class ReentrantLock5 extends Thread {

	private ReentrantLock lock = new ReentrantLock(true); // 参数为true为公平锁

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName() + "获得锁");
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		ReentrantLock5 r1 = new ReentrantLock5();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
	}
}

```

#### 生产者消费者

1. 使用synchronized关键字

   ```java
   public class ProducerConsumer<T> {
       // 共享资源 list
       private LinkedList<T> list = new LinkedList<>();
       private int MAX = 10;
       private int count = 0;
       public synchronized void product(T t){
           while (list.size() == MAX){
               try {
                   this.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           list.add(t);
           count++;
           this.notifyAll();
       }
   
       public synchronized T consumer(){
           while (list.size() == 0){
               try {
                   this.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           count--;
           T t = list.removeFirst();
           this.notifyAll();
           return t;
       }
   
       public static void main(String[] args) {
           ProducerConsumer<String> resource = new ProducerConsumer<>();
           // 2个生产者 10个消费者
           for (int i = 0; i < 10; i++) {
               new Thread(()->{
                   for (int i1 = 0; i1 < 5; i1++) {
                       System.out.println(resource.consumer());
                   }
               }, "c" + i).start();
           }
   
           try {
               TimeUnit.SECONDS.sleep(2);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
   
           for (int i = 0; i < 2; i++) {
               new Thread(()->{
                   for (int i1 = 0; i1 < 25; i1++) {
                       resource.product(Thread.currentThread().getName() + " " + i1);
                   }
               }, "p" + i).start();
           }
       }
   }
   ```

   

2. 使用ReentranLock

   ```java
   public class ProducerConsumerII<T> {
       private LinkedList<T> list = new LinkedList<>();
       private int count = 0;
       private int max = 20;
       private Lock lock = new ReentrantLock();
   
       private Condition producer = lock.newCondition();
       private Condition consumer = lock.newCondition();
   
   
   
   
       public void product(T t){
           try{
               lock.lock();
               while (list.size() == max){
                   producer.await();
               }
               list.add(t);
               count ++;
               consumer.signalAll();
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally{
               lock.unlock();
           }
   
       }
   
       public T consumer(){
           T t = null;
           try{
               lock.lock();
               while (list.size() == 0){
                   consumer.await();
               }
               t = list.removeFirst();
               count--;
               producer.signalAll();
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally{
               lock.unlock();
           }
           return t;
   
       }
   
       public static void main(String[] args) {
           ProducerConsumer<String> resource = new ProducerConsumer<>();
           // 2个生产者 10个消费者
           for (int i = 0; i < 10; i++) {
               new Thread(()->{
                   for (int i1 = 0; i1 < 5; i1++) {
                       System.out.println(resource.consumer());
                   }
               }, "c" + i).start();
           }
   
           try {
               TimeUnit.SECONDS.sleep(2);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
   
           for (int i = 0; i < 2; i++) {
               new Thread(()->{
                   for (int i1 = 0; i1 < 25; i1++) {
                       resource.product(Thread.currentThread().getName() + " " + i1);
                   }
               }, "p" + i).start();
           }
       }
   }
   ```

   

#### 问题：

1. A线程正在执行一个对象中的同步方法，B线程是否可以同时执行同一个对象中的非同步方法
2. 同上，B线程是否可以同时执行同一个对象中的另一个同步方法
3. 线程抛出异常会释放吗？
4. volatile和synchronized区别
5. 证明AtomXXX类比synchronized更高效 
6. AtomXXX类可以保证可见性
7. 证明AtomXXX类的多个方法并不构成原子性
8. 写一个程序模拟死锁
9. 写一个程序，在main线程中启动100个线程，100个线程完成后，主线程打印“完成”

### 并发容器

#### ConcurrentHashMap

#### CopyOnWriteArrayList



### 线程池等高阶用法

### 高并发主要涉及的内容

1. synchronizer
2. 同步容器
3. ThreadPool 、executor