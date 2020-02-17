## JVM 初探

### 基本尝试	问题

* 谈谈你对JVM的理解， Java8虚拟机和之前的变化
* 什么是OOM， 什么是溢栈(StackOverFlow Error)？ 如何分析
* JVM中常用的调优参数有哪些
* 内存快照如何抓取， 怎么分析dump文件
* 谈谈JVM中， 类加载器的认识

#### JVM位置

![](https://raw.githubusercontent.com/KongWiki/cloudImg/master/jvm.png)





#### JVM体系结构

![](https://raw.githubusercontent.com/KongWiki/cloudImg/master/java%E8%99%9A%E6%8B%9F%E6%9C%BA%E8%BF%90%E8%A1%8C%E6%97%B6%E6%95%B0%E6%8D%AE%E5%8C%BA.png)



#### 类加载器

**基本概念**

顾名思义，类加载器（class loader）用来加载 Java 类到 Java 虚拟机中。一般来说，Java 虚拟机使用 Java 类的方式如下：Java 源程序（.java 文件）在经过 Java 编译器编译之后就被转换成 Java 字节代码（.class 文件）。类加载器负责读取 Java 字节代码，并转换成 `java.lang.Class`类的一个实例。每个这样的实例用来表示一个 Java 类。通过此实例的 `newInstance()`方法就可以创建出该类的一个对象。实际的情况可能更加复杂，比如 Java 字节代码可能是通过工具动态生成的，也可能是通过网络下载的。

**类加载器的主要功能示意图**

![imgae](/home/kongweikun/IdeaProjects/JavaTrain/src/com/train/jvm/README.assets/类加载器-1581910732753.png)

**类加载器的树状组织结构**

Java 中的类加载器大致可以分成两类，一类是系统提供的，另外一类则是由 Java 应用开发人员编写的。系统提供的类加载器主要有下面三个：

1. **启动（Bootstrap）类加载器**：是用本地代码实现的类装入器，它负责将 `/lib`下面的类库加载到内存中（比如`rt.jar`）。由于引导类加载器涉及到虚拟机本地实现细节，开发者无法直接获取到启动类加载器的引用，所以不允许直接通过引用进行操作。
2. **标准扩展（Extension）类加载器**：是由 Sun 的 `ExtClassLoader（sun.misc.Launcher$ExtClassLoader）`实现的。它负责将`< Java_Runtime_Home >/lib/ext`或者由系统变量 `java.ext.dir`指定位置中的类库加载到内存中。开发者可以直接使用标准扩展类加载器。
3. **系统（System）类加载器**：是由 Sun 的 `AppClassLoader（sun.misc.Launcher$AppClassLoader）`实现的。它负责将系统类路径（`CLASSPATH`）中指定的类库加载到内存中。开发者可以直接使用系统类加载器。

除了系统提供的类加载器以外，开发人员可以通过继承 `java.lang.ClassLoader`类的方式实现自己的类加载器，以满足一些特殊的需求。

**Java 虚拟机是如何判定两个 Java 类是相同的：**

1. ==类的全名是否相同（com.xxx.xxx.xx）==
2. ==加载此类的类加载器是否一样==

只有满足上述的两个条件， 才能认为两个类是相同的。

比如一个 Java 类 `com.example.Sample`，编译之后生成了字节代码文件 `Sample.class`。两个不同的类加载器 `ClassLoaderA`和 `ClassLoaderB`分别读取了这个 `Sample.class`文件，并定义出两个 `java.lang.Class`类的实例来表示这个类。这两个实例是不相同的。对于 Java 虚拟机来说，它们是不同的类。试图对这两个类的对象进行相互赋值，会抛出运行时异常 `ClassCastException`



#### 双亲委派机制

![image](/home/kongweikun/IdeaProjects/JavaTrain/src/com/train/jvm/README.assets/类加载器-1581910649767.png)

保证安全， 如明明有冲突等

某个特定的类加载器在接到加载类的请求时，首先将加载任务委托给父类加载器，**依次递归**，如果父类加载器可以完成类加载任务，就成功返回；只有父类加载器无法完成此加载任务时，才自己去加载。

1. 类加载器收到类加载的请求
2. 将这个请求向上委托给父类加载器去完成， 一直向上委托， 直到对应的启动的类加载器
3. 启动类加载器知道是否能够加载当前这个类， 能加载就是用当前加载器， 否则跑出异常，通知子类加载器进行加载
4. 重复步骤3

**思考**

Java虚拟机的第一个类加载器是Bootstrap，这个加载器很特殊，**它不是Java类，因此它不需要被别人加载，它嵌套在Java虚拟机内核里面，也就是JVM启动的时候Bootstrap就已经启动，它是用C++写的二进制代码（不是字节码）**，它可以去加载别的类。

**委派机制的意义 --- 防止内存中出现多份同样的字节码**

比如两个类A和类B都要加载System类：

- 如果不用委托而是自己加载自己的，那么类A就会加载一份System字节码，然后类B又会加载一份System字节码，**这样内存中就出现了两份System字节码。**
- 如果使用委托机制，会递归的向父类查找，也就是**首选用Bootstrap尝试加载**，如果找不到再向下。这里的System就能在Bootstrap中找到然后加载，如果此时类B也要加载System，也从Bootstrap开始，此时**Bootstrap发现已经加载过了System那么直接返回内存中的System即可而不需要重新加载**，这样内存中就只有一份System的字节码了。

#### 沙箱安全机制

#### Native（本地方法栈）

凡是带了native关键字的，说明java的作用范围达不到了，会去调用底层c语言的库

会进入本地方法栈

调用本地方法栈接口; JNI(Java Native Interface)

JNI: 拓展java的使用，融合不同的编程语言

在内存区域中专门开辟了一块标记区域： Native Method Stack ， 登记Native方法

#### PC寄存器

每个线程都有一个程序计数器， 是线程私有的。

#### 方法区

==静态变量、常量、类信息（构造方法、接口定义）、运行时的常量池存在方法区中， 但是实例变量在堆内存中， 和方法区无关==

static、 final、Class、常量池

#### Java虚拟机栈

8大基本类型， 对象引用， 实例的方法

#### 三种JVM

1. HotSpot
2. JRockit
3. J9VM JIT(IBM)

#### Java堆

Heap, 一个JVM只有一个堆内存，堆内存的大小可以调节

类加载器读了类文件之后，方法、变量等保存我们的引用类型的真实对象

**细分为三个区域**

* 新生区

* 养老区

* 永久区

  常驻内存， 用来存放JDK自身携带的Class对象， Interface元数据， 存储java运行时的一些环境

  ==该区域不存在垃圾回收==

  * jdk1.6之前; 永久代， 常量池在方法区
  * jdk1.7       :  永久代， 但是慢慢退化了， `去永久代`， 常量池在堆中
  * jdk1.8       : 无永久代， 常量池在元空间



#### 新生区、老年区

#### 永久区

#### 堆内存调优

调节程序所占总内存的大小：

```java
-Xms 1024m -Xmx 1024m -XX:+PrintGCDetails
```

MAT, Jprofiler作用:

* 分析Dump内存文件， 快速定位内存泄露
* 获得堆中的数据
* 获得大的对象



####  GC（垃圾回收器）

1. 常用算法

#### JMM



## reference

* [JVM基础系列第3讲：到底什么是虚拟机?](https://www.cnblogs.com/chanshuyi/p/jvm_serial_03_the_nature_of_jvm.html)

* [关于Java类加载双亲委派机制的思考（附一道面试题）](https://www.cnblogs.com/lanxuezaipiao/p/4138511.html)
* [java中的安全模型(沙箱机制)](https://www.cnblogs.com/MyStringIsNotNull/p/8268351.html)

