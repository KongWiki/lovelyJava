# JVM 初探

## 基础学习

* 谈谈你对JVM的理解， Java8虚拟机和之前的变化
* 什么是OOM， 什么是溢栈(StackOverFlow Error)？ 如何分析
* JVM中常用的调优参数有哪些
* 内存快照如何抓取， 怎么分析dump文件
* 谈谈JVM中， 类加载器的认识

### JVM位置

![](https://raw.githubusercontent.com/KongWiki/cloudImg/master/jvm.png)





### JVM体系结构

![](https://raw.githubusercontent.com/KongWiki/cloudImg/master/java%E8%99%9A%E6%8B%9F%E6%9C%BA%E8%BF%90%E8%A1%8C%E6%97%B6%E6%95%B0%E6%8D%AE%E5%8C%BA.png)



### 类加载器

#### **基本概念**

顾名思义，类加载器（class loader）用来加载 Java 类到 Java 虚拟机中。一般来说，Java 虚拟机使用 Java 类的方式如下：Java 源程序（.java 文件）在经过 Java 编译器编译之后就被转换成 Java 字节代码（.class 文件）。类加载器负责读取 Java 字节代码，并转换成 `java.lang.Class`类的一个实例。每个这样的实例用来表示一个 Java 类。通过此实例的 `newInstance()`方法就可以创建出该类的一个对象。实际的情况可能更加复杂，比如 Java 字节代码可能是通过工具动态生成的，也可能是通过网络下载的。

#### **类加载器的主要功能示意图**

![imgae](/home/kongweikun/IdeaProjects/JavaTrain/src/com/train/jvm/README.assets/类加载器-1581910732753.png)

#### **类加载器的树状组织结构**

Java 中的类加载器大致可以分成两类，一类是系统提供的，另外一类则是由 Java 应用开发人员编写的。系统提供的类加载器主要有下面三个：

1. **启动（Bootstrap）类加载器**：是用本地代码实现的类装入器，它负责将 `/lib`下面的类库加载到内存中（比如`rt.jar`）。由于引导类加载器涉及到虚拟机本地实现细节，开发者无法直接获取到启动类加载器的引用，所以不允许直接通过引用进行操作。
2. **标准扩展（Extension）类加载器**：是由 Sun 的 `ExtClassLoader（sun.misc.Launcher$ExtClassLoader）`实现的。它负责将`< Java_Runtime_Home >/lib/ext`或者由系统变量 `java.ext.dir`指定位置中的类库加载到内存中。开发者可以直接使用标准扩展类加载器。
3. **系统（System）类加载器**：是由 Sun 的 `AppClassLoader（sun.misc.Launcher$AppClassLoader）`实现的。它负责将系统类路径（`CLASSPATH`）中指定的类库加载到内存中。开发者可以直接使用系统类加载器。

除了系统提供的类加载器以外，开发人员可以通过继承 `java.lang.ClassLoader`类的方式实现自己的类加载器，以满足一些特殊的需求。

#### **Java 虚拟机是如何判定两个 Java 类是相同的：**

1. ==类的全名是否相同（com.xxx.xxx.xx）==
2. ==加载此类的类加载器是否一样==

只有满足上述的两个条件， 才能认为两个类是相同的。

比如一个 Java 类 `com.example.Sample`，编译之后生成了字节代码文件 `Sample.class`。两个不同的类加载器 `ClassLoaderA`和 `ClassLoaderB`分别读取了这个 `Sample.class`文件，并定义出两个 `java.lang.Class`类的实例来表示这个类。这两个实例是不相同的。对于 Java 虚拟机来说，它们是不同的类。试图对这两个类的对象进行相互赋值，会抛出运行时异常 `ClassCastException`

#### 如何编写自己的类加载器

自己编写的ClassLoader继承ClassLoader即可， 只需要覆写父类的`findClass()`即可，最好不要覆写 `loadClass()`方法

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



### PC寄存器

==线程私有==

每个线程都有一个程序计数器， 是线程私有的。

**此内存区域是唯一一个在Java虚拟机规范中没有规定任何OutOfMemoryError情况的区域**



### Native（本地方法栈）

==线程私有==

凡是带了native关键字的，说明java的作用范围达不到了，会去调用底层c语言的库

会进入本地方法栈

调用本地方法栈接口; JNI(Java Native Interface)

JNI: 拓展java的使用，融合不同的编程语言

在内存区域中专门开辟了一块标记区域： Native Method Stack ， 登记Native方法



### Java虚拟机栈

==线程私有==

8大基本类型， 对象引用， 实例的方法

会出现OutOfMemoryError 和 StackOverFlowError异常

**它的生命周期与线程相同。虚拟机栈描述的是Java方法执行的内存模型：**每个方法被执行的时候都会同时创建一个栈帧（Stack Frame）用于存储局部变量表、操作栈、动态链接、方法出口等信息。**每一个方法被调用直至执行完成的过程，就对应着一个栈帧在虚拟机栈中从入栈到出栈的过程。**

### Java堆

==线程共享==

![image](/home/kongweikun/IdeaProjects/JavaTrain/src/com/train/jvm/README.assets/java堆.png)

Heap, 一个JVM只有一个堆内存，堆内存的大小可以调节

此内存区域的唯一目的就是存放对象实例，**几乎所有的对象实例都在这里分配内存**。

Java堆是垃圾收集器管理的主要区域，因此很多时候也被称做“**GC堆**”

如果在堆中没有内存完成实例分配，并且堆也无法再扩展时，将会抛出OutOfMemoryError异常。

**细分为两个个区域**

* 新生区

* 养老区

* ~~永久区~~

  常驻内存， 用来存放JDK自身携带的Class对象， Interface元数据， 存储java运行时的一些环境

  ==该区域不存在垃圾回收==

  * jdk1.6之前; 永久代， 常量池在方法区
  * jdk1.7       :  永久代， 但是慢慢退化了， `去永久代`， 常量池在堆中
  * jdk1.8       : 无永久代， 常量池在元空间



#### 新生区、老年区

新生区可以细分为三个部分：

* EdenSpace
* FromSpace
* ToSpace

默认三者的分配比例为==8:1:1==



#### 永久区

#### 堆内存调优

![image](/home/kongweikun/IdeaProjects/JavaTrain/src/com/train/jvm/README.assets/参数对应的各区域的图.jpeg)

**控制参数**:

- -Xms设置堆的初始空间大小。
- -Xmx设置堆的最大空间大小。
- -XX:NewSize设置新生代最小空间大小。
- -XX:MaxNewSize设置新生代最大空间大小。
- -XX:PermSize设置永久代最小空间大小。
- -XX:MaxPermSize设置永久代最大空间大小。
- -Xss设置每个线程的堆栈大小。

调节程序所占总内存的大小：

```java
-Xms 1024m -Xmx 1024m -XX:+PrintGCDetails
```

MAT, Jprofiler作用:

* 分析Dump内存文件， 快速定位内存泄露
* 获得堆中的数据
* 获得大的对象



### 方法区

==线程共享==

方法区（Method Area）与Java堆一样，是各个线程共享的内存区域，**它用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。**虽然Java虚拟机规范把方法区描述为堆的一个逻辑部分，但是它却有一个别名叫做Non-Heap（非堆），目的应该是与Java堆区分开来。

==运行时的常量池存在方法区中， 但是实例变量在堆内存中， 和方法区无关==

static、 final、Class、常量池

线程共享区域，为了与Java堆区分， 方法区还有一个别名： Non-Heap（非堆）

**栈又分为java虚拟机栈和本地方法栈主要用于方法的执行。**

方法区有时被称为持久代（PermGen）

方法的执行都是伴随着线程的。原始类型的本地变量以及引用都存放在线程栈中。而引用关联的对象比如String，都存在在堆中。

```java
public class HelloWorld {
    private static Logger logger = Logger.getLogger(HelloWorld.class.getName());
    public void sayHello(String message){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY");
        String today = format.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(HelloWorld.class.getName());
    }
}
```

![image](/home/kongweikun/IdeaProjects/JavaTrain/src/com/train/jvm/README.assets/Screenshot from 2020-02-19 17-22-49.png)

### 三种JVM

1. HotSpot
2. JRockit
3. J9VM JIT(IBM)

###  GC（垃圾回收）

#### 概述：

垃圾收集 Garbage Collection 通常被称为“GC”，它诞生于1960年 MIT 的 Lisp 语言，经过半个多世纪，目前已经十分成熟了。 jvm 中，程序计数器、虚拟机栈、本地方法栈都是随线程而生随线程而灭，栈帧随着方法的进入和退出做入栈和出栈操作，实现了自动的内存清理，因此，我们的内存垃圾回收主要集中于 java 堆和方法区中，在程序运行期间，这部分内存的分配和使用都是动态的

#### 对象存活判断

判断对象是否存活一般有两种方式：

**引用计数**：每个对象有一个引用计数属性，新增一个引用时计数加1，引用释放时计数减1，计数为0时可以回收。此方法简单，无法解决对象相互循环引用的问题。

每个对象都有对应的计数

![image](/home/kongweikun/IdeaProjects/JavaTrain/src/com/train/jvm/README.assets/Screenshot from 2020-02-18 10-47-13.png)





**可达性分析**（Reachability Analysis）：从GC Roots开始向下搜索，搜索所走过的路径称为引用链。当一个对象到GC Roots没有任何引用链相连时，则证明此对象是不可用的。不可达对象。

在Java语言中，GC Roots包括：

- 虚拟机栈中引用的对象。
- 方法区中类静态属性实体引用的对象。
- 方法区中常量引用的对象。
- 本地方法栈中JNI引用的对象

JVM在进行垃圾回收的时候， 并不是对这三个区域进行统一回收， 大部分时候，回收的都是新生代

* 新生代
* 幸存去（from, to）
* 老年区

GC两类：轻GC（普通GC）、 重GC（全局GC）

题目： 

* JVM的内存模型和分区---详细到每一个区放什么
* 堆里面的分区有哪些？ eden、from、to、老年区， 阐述特点
* GC的算法 有哪些？ 标记清除算法、标记整理算法、复制算法、引用计数算法、
* 轻GC和中GC分别在什么时候发生的

#### **标记-清除**

顾名思义， 该算法共分为两个步骤， 首先会标记所有需要回收的对象（根据上述的判断对象是否存活的算法）

之后，标记完所有的需要回收的对象之后，全部清除即可。这是最基础的算法， 因为一下的算法都是对该算法的优化。

![image](README.assets/Screenshot from 2020-02-20 11-46-24.png)

#####  缺点

**效率低**：标记和清除的效率都不高，所以导致该算法的整体的效率不高。

**空间利用率低**： 标记清除之后会产生大量不连续的内存碎片，导致后续需要分配较大的内存给对象的时候， 没有满足的空间空间

#### **复制算法**

将内存按照内存大小划分等量的两块儿，每次只能使用其中的一块儿， 当一块用完之后， 将可用的对象移到另一块中， 然后再把已使用过的内存空间一次清空

这样使得每次都是对其中的一块进行内存回收，内存分配时也就不用考虑内存碎片等复杂情况，只要移动堆顶指针，按顺序分配内存即可，实现简单，运行高效。只是这种算法的代价是将内存缩小为原来的一半，持续复制长生存期的对象则导致效率降低。 

![image](README.assets/Screenshot from 2020-02-20 11-46-33.png)

#### **标记-整理**

复制算法在存活率较高的区域，需要进行多次的复制， 效率会降低，如果不想浪费50%的空间，任然需要一定的空间进行分配担保，若是遇到极端的情况， 也就是存活率100%， 则该算法不适用（老年区）

根据老年区的特点， 提出了标记-整理算法， 标记方式与标记-清除算法一样， 但是后续的步骤不同， 标记-清除是直接清除，而标记-整理算法沿用了复制算法的思想， 先将存活的对象都向一端移动，然后直接清除该端以外的内存。

![image](README.assets/Screenshot from 2020-02-20 11-46-40-1582170500724.png)

#### 分代收集算法

GC分代的基本假设：绝大部分对象的生命周期都非常短暂，存活时间短。

“分代收集”（Generational Collection）算法，把Java堆分为新生代和老年代，这样就可以根据各个年代的特点采用最适当的收集算法。在新生代中，每次垃圾收集时都发现有大批对象死去，只有少量存活，那就选用复制算法，只需要付出少量存活对象的复制成本就可以完成收集。而老年代中因为对象存活率高、没有额外空间对它进行分配担保，就必须使用“标记-清理”或“标记-整理”算法来进行回收。

#### 算法总结

分析维度： 内存效率、内存整齐度、内存利用率

内存效率： 复制算法---> 标记清除算法 ---> 标记整理算法

内存整齐度： 复制算法 =标记整理算法=> 标记清除算法

内存利用率： 标记整理算法=标记清除算法>复制算法

**年轻代**：

* 存活率低
* 复制算法

**老年代**：

* 区域大：存活率
* 标记清除（内存碎片不多）+标记整理算法 

### 垃圾收集器

> 如果说收集算法是内存回收的方法论，垃圾收集器就是内存回收的具体实现

#### Serial收集器

串行收集器是最古老，最稳定以及效率高的收集器，可能会产生较长的停顿，只使用一个线程去回收。新生代、老年代使用串行回收；新生代复制算法、老年代标记-压缩；垃圾收集的过程中会Stop The World（服务暂停）

参数控制： `-XX:+UseSerialGC` 串行收集器

#### ParNew收集器 

ParNew收集器其实就是Serial收集器的多线程版本。新生代并行，老年代串行；新生代复制算法、老年代标记-压缩

参数控制：

`-XX:+UseParNewGC` ParNew收集器
`-XX:ParallelGCThreads` 限制线程数量

#### Parallel收集器

Parallel Scavenge收集器类似ParNew收集器，Parallel收集器更关注系统的吞吐量。可以通过参数来打开自适应调节策略，虚拟机会根据当前系统的运行情况收集性能监控信息，动态调整这些参数以提供最合适的停顿时间或最大的吞吐量；也可以通过参数控制GC的时间不大于多少毫秒或者比例；新生代复制算法、老年代标记-压缩

参数控制： `-XX:+UseParallelGC` 使用Parallel收集器+ 老年代串行

#### Parallel Old 收集器

Parallel Old是Parallel Scavenge收集器的老年代版本，使用多线程和“标记－整理”算法。这个收集器是在JDK 1.6中才开始提供

参数控制： `-XX:+UseParallelOldGC` 使用Parallel收集器+ 老年代并行

#### CMS收集器

CMS（Concurrent Mark Sweep）收集器是一种以获取最短回收停顿时间为目标的收集器。目前很大一部分的Java应用都集中在互联网站或B/S系统的服务端上，这类应用尤其重视服务的响应速度，希望系统停顿时间最短，以给用户带来较好的体验。

从名字（包含“Mark Sweep”）上就可以看出CMS收集器是基于“标记-清除”算法实现的，它的运作过程相对于前面几种收集器来说要更复杂一些，整个过程分为4个步骤，包括：

- 初始标记（CMS initial mark）
- 并发标记（CMS concurrent mark）
- 重新标记（CMS remark）
- 并发清除（CMS concurrent sweep）

其中初始标记、重新标记这两个步骤仍然需要“Stop The World”。初始标记仅仅只是标记一下GC Roots能直接关联到的对象，速度很快，并发标记阶段就是进行GC Roots Tracing的过程，而重新标记阶段则是为了修正并发标记期间，因用户程序继续运作而导致标记产生变动的那一部分对象的标记记录，这个阶段的停顿时间一般会比初始标记阶段稍长一些，但远比并发标记的时间短。

由于整个过程中耗时最长的并发标记和并发清除过程中，收集器线程都可以与用户线程一起工作，所以总体上来说，CMS收集器的内存回收过程是与用户线程一起并发地执行。老年代收集器（新生代使用ParNew）

**优点**: 并发收集、低停顿
**缺点**: 产生大量空间碎片、并发阶段会降低吞吐量

参数控制：

`-XX:+UseConcMarkSweepGC` 使用CMS收集器
`-XX:+ UseCMSCompactAtFullCollection` Full GC后，进行一次碎片整理；整理过程是独占的，会引起停顿时间变长
`-XX:+CMSFullGCsBeforeCompaction` 设置进行几次Full GC后，进行一次碎片整理
`-XX:ParallelCMSThreads` 设定CMS的线程数量（一般情况约等于可用CPU数量）

#### G1收集器

G1是目前技术发展的最前沿成果之一，HotSpot开发团队赋予它的使命是未来可以替换掉JDK1.5中发布的CMS收集器。与CMS收集器相比G1收集器有以下特点：

1. **空间整合**，G1收集器采用标记整理算法，不会产生内存空间碎片。分配大对象时不会因为无法找到连续空间而提前触发下一次GC。
2. **可预测停顿**，这是G1的另一大优势，降低停顿时间是G1和CMS的共同关注点，但G1除了追求低停顿外，还能建立可预测的停顿时间模型，能让使用者明确指定在一个长度为N毫秒的时间片段内，消耗在垃圾收集上的时间不得超过N毫秒，这几乎已经是实时Java（RTSJ）的垃圾收集器的特征了。

上面提到的垃圾收集器，收集的范围都是整个新生代或者老年代，而G1不再是这样。使用G1收集器时，Java堆的内存布局与其他收集器有很大差别，它将整个Java堆划分为多个大小相等的独立区域（Region），虽然还保留有新生代和老年代的概念，但新生代和老年代不再是物理隔阂了，它们都是一部分（可以不连续）Region的集合。

## reference

* [JVM基础系列第3讲：到底什么是虚拟机?](https://www.cnblogs.com/chanshuyi/p/jvm_serial_03_the_nature_of_jvm.html)

* [关于Java类加载双亲委派机制的思考（附一道面试题）](https://www.cnblogs.com/lanxuezaipiao/p/4138511.html)
* [java中的安全模型(沙箱机制)](https://www.cnblogs.com/MyStringIsNotNull/p/8268351.html)
* Java虚拟机II
