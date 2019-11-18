## JAVA 

![dart](https://github.githubassets.com/images/icons/emoji/unicode/1f3af.png)基础学习与理解

* 基础语法
* 并发
* servlet源码

### 白皮书关键术语
1. 简单性
2. 面向对象
3. 分布式
    * Java 有一个丰富的例程库, 用于处理像 HTTP 和 FIT 之类的 TCP/IP 协议 。 Java 应用
      程序能够通过 URL 打开和访问网络上的对象 , 其便捷程度就好像访问本地文件一样 。
    
4. 健壮性
5. 安全性
6. 体系结构中立
7. 可移植性
8. 解释性
9. 高性能
10. 多线程
11. 多态性

### 数据类型(8种)
|数据类型|分类|长度|范围|
|:----:|:----:|:----:|:----:|
|int|整型|4字节|-2^31 - 2^31-1|
|short|整型|2字节|-2^15 - 2^15-1|
|long|整型|8字节|-2^63 - 2^63-1|
|byte|整型|1字节|-2^7 - 2^7-1|
|flaot|浮点型|4字节|±3.402 823 47 E +38 F ( 有效位数为 6 ~ 7 位 )|
|double|浮点型|8字节|±1.797 693 134 862 315 70 E + 308( 有效位数为15位 )|
|char|字符类型|16?||
|boolean|布尔型|||
* 虚线会导致精度的缺失
* 实线无精度的缺失
![iamge](https://raw.githubusercontent.com/KongWiki/cloudImg/master/java-强制类型转换.png)
**++m和m++**
++m先自增在运算
m++ 先运行在自增

### 输入输出
* Scanner(InputStream in)
    * 用给定的输入流创建一个Scanner对象
* String nextLine()
    * 读取驶入的下一行内容
* String next()
    * 读取驶入的下一个单词
* int nextInt()
* double nextDouble()
* boolean hasNextInt()
    * 检测是否还有表示整数或浮点数的下一个字符序列
* boolean hasNextDouble()

### 大数值

### 数组

### 循环
**break**
    * 终止，直接跳出循环
**continue**
    * 继续开始循环，不执行continue一下的命令
    
### 对象和类
控制可见性的四个四个访问修饰符
* public
    * 对所有类可见
* private 
    * 仅对本类可见
* proteced
    * 对本包所有和所有子类可见
    * 在实际应用中, 要谨慎使用 protected 属性 。 假设需要将设计的类提供给其他程序员使
      用, 而在这个类中设置了一些受保护域, 由于其他程序员可以由这个类再派生出新类, 并访
      问其中的受保护域 。 在这种情况下 , 如果需要对这个类的实现进行修改 , 就必须通知所有使
      用这个类的程序员 。 这违背了 OOP 提倡的数据封装原则 。
* 对本包可见 默认，不需要修饰符
#### oop
* 对象的行为(behavior)
    * 可以对对象施加哪些操作
* 对象的状态(state)
    * 当施加那些方法时，对象如何响应
* 对象的标识(identity)
    * 如何辨别具有相同行为与状态的不同对象

#### 静态域和静态方法
* 静态域
    * 每个类都有一个这样的域，同时每个对象对所有的实例域都有自己的拷贝，但是只有一个静态域，它属于类，不属于任何对象
    
* 静态常量
    * 直接通过进行访问的常量，如Math.PI
    
* 静态方法
    * 是一种不能向对象实施操作的方法，例如Math的pow方法就是一个静态方法，使用方式为Math.pow(x, a)，运算时，不使用任何Math对象，即没有隐式参数（this）
    * 静态方法可以访问自身的静态域，可以通过类名调用这个方法
    * 以下为两种情况下使用静态方法：
        * 一个方法不需要访问对象装填，其所需参数都是通过显示参数提供(Math.pow)
        * 一个方法只需要访问类的静态域(Employee.getNextId)
        

### 继承
#### 类、超类、子类
* 已经存在的类称为父类，超类， 基类
* 新类称为子类，派生类，孩子类
如果子类的构造器没有显式地调用超类的构造器 , 则将自动地调用超类默认 ( 没有参数 )
的构造器 。 如果超类没有不带参数的构造器, 并且在子类的构造器中又没有显式地调用超类
的其他构造器 则 Java 编译器将报告错误 。

* this
    * 引用隐式参数
    * 调用该类其他的构造器
  
* super
    * 调用超类的方法
    * 调用超类的构造器

#### 继承层次
继承并不仅限于一个层次，例如：可由Manager类派生Executive类，由一个公共超类派生出来的所有类的集合被称为继承层次，在继承
层次中, 从某个特定的类到其祖先的路径被称为该类的继承链
![image](https://raw.githubusercontent.com/KongWiki/cloudImg/master/java-%E7%BB%A7%E6%89%BF%E5%B1%82%E6%AC%A1.png)

* 多态
    * 在java中，对象变量是多态的，一个Employee变量既可以引用一个Employee类对象，也可以引用Employee的任何子类对象
    ```java
    Employee e;
    e = new Employee(....);
    e = new Manager(...);
    ```
不能将一个超类的引用赋给子类变量

#### 抽象类
* 抽象方法充当占位的角色，他们的具体实现在子类中。
* 扩展抽象类可以有两种选择
    * 在抽象类中定义部分抽取类方法或不定义抽象类方法，这样子类也必须是抽象类
    * 在抽象类中定义全部的抽象方法，这样子类就是抽象的了     

#### Object: 所有类的超类

#### 泛型数组列表
ArrayLIst 是一个采用类型参数的泛型类，为了制定数组列表保存的元素对象类型，
需要用一对尖括号将类名括起来加在后面。如ArrayList<Employee>
ArrayList<Employee> staff = new ArrayList<Employee>();
ArrayList<Employee> staff = new ArrayList<>();
* E get()
    
    * 获取元素
* void set()
    * 添加元素
    * 设置数组指定位置的元素值，这个操作将覆盖原位置的原元素
* E remove()
    
    * 删除元素， 并将后面的元素前移，被删除的元素有返回值返回
* void add()
    * 向后移动元素，以便插入元素
    * 参数：
        * index 插入位置（必须介于0～size-1,其余的方法一样）
        * obj 将要插入的新的元素
* for each 循环遍历数组
    ```java
    for(Employee staff: staffs){
    do something with staff;
  }
  ```
  
  


### 接口
接口不是类，而是对类的一组需求描述，这些类要遵从接口描述的统一格式进行定义
* 主要用来描述类具有什么功能，而不给出每个功能的具体实现。
* 一个类可以实现一个或多个接口，并在需要接口的地方，随时使用实现了相应接口的对象。

提供实例域和方法实现的任务应该由实现接口的那个类来完成。所以也可以将接口看成是没有实例域的抽象类
为了让类实现一个接口，通常需要下面两个步骤：
1. 将类声明为实现给定的接口（implements）
2. 对接口中的所有方法进行定义
接口的特性：
1. 接口不是类，尤其不能使用new实例化一个接口
```java
x = new Compareble(...)//error
```
2. 能够声明一个接口变量
```java
Camparable x; //ok
```
3. 接口变量必须引用实现了接口的类对象
```java
x = new Employee()// ok  provided employee implements Comparable
```
4. 接口中不能包含实例域或静态方法，可以包含常量
与接口中的方法都自动地被设置为 public一样 , 接口中的域将被自动设为 public static final 。
**java8** 中允许接口增加静态方法
**接口和抽象类的区别**
    * 只能extends一个类
    * 可以implements多个接口
   

**解决默认方法冲突**
1. 超类优先，如果超类提供了一个具体方法，同名而且有相同的参数类型的默认方法会被忽略
2. 接口冲突： 如果一个超接口提供了一个默认方法，另一个接口提供了体格同名而且参数类型相同的方法，必须覆盖这个方法来解决

#### 接口与回调
回调为一种程序设计模式，该模式中，可以指出某个特定时间发生是应该采取的动作，如在按下鼠标或选择某个菜单项是应该采取什么行动。
定期的使用该动作。
#### 对象的clone & copy
![iamge](https://raw.githubusercontent.com/KongWiki/cloudImg/master/java-clone-copying.png)

#### lambda表达式
-> 表达式
```java
(first, second) -> first.length() - second.length()
```
其余与Python无区别

### 异常、断言、日志
![imgae](https://raw.githubusercontent.com/KongWiki/cloudImg/master/java-%E5%BC%82%E5%B8%B8%E5%B1%82%E6%AC%A1%E7%BB%93%E6%9E%84.png)

#### 记录日志
* 可以很容易地取消全部日志记录, 或者仅仅取消某个级别的日志, 而且打开和关闭这
个操作也很容易 。
* 可以很简单地禁止日志记录的输出, 因此, 将这些日志代码留在程序中的开销很小 。
* 日志记录可以被定向到不同的处理器, 用于在控制台中显示, 用于存储在文件中等 。
* 日志记录器和处理器都可以对记录进行过滤 。 过滤器可以根据过滤实现器制定的标准
丢弃那些无用的记录项 。
* 日志记录可以采用不同的方式格式化, 例如, 纯文本或 XML 。
* 应用程序可以使用多个日志记录器 , 它们使用类似包名的这种具有层次结构的名字,例如 , com . mycompany . myapp
* 在默认情况下 , 日志系统的配置由配置文件控制 。 如果需要的话, 应用程序可以替换这个配置 。

**日志记录级别**
* SERVER
* WARNING
* INFO
* CONFIG
* FINE
* FINER
* FINEST
默认只记录前三个级别，也可以自己设置
```java
lggger.setLevel(level.FINE);
```

### 泛型（参数化类型）
编写的代码可以被很多不同类型的对象所**重用**

在 Java 中增加范型类之前, 泛型程序设计是用继承实现的 。 ArrayList 类只维护一个Object 引用的数组，

这种方法有两个问题。如下代码所示：

1. 获取一个值时必须要进行强制类型转换。

   `String item = (String) arrayList.get(i);`

2. 无错误检测，可以传入任何类型，但是编译的时候会报错，如下会报

   `ava.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String`

```java
List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);
        for(int i =0; i< arrayList.size(); i++){
            String item = (String) arrayList.get(i);
            System.out.println("泛型测试： item="+item);
        }
```

对于泛型，提供了一个很好的方案，`类型参数`。

```java
 List<String> arrayList = new ArrayList<>();
//        List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);
        for(int i =0; i< arrayList.size(); i++){
            String item = (String) arrayList.get(i);
            System.out.println("泛型测试： item="+item);
```

1. 这就可以看到，该ArrayList是包含的是String类型。具有更好的可读性
2. 同时这样编译器也可以在遇到`get`方法时，不需要进行类型转换，编译器就知道放回的类型为String，而不是object
3. 同时编译器还知道，`add`方法有一个类型为String的参数，然后其就可以检查是否有插入出现错误的问题。

其可以存储任意类型的数据的意思和Python不一样，

Java不是和Python一样，在当前创建的对象中存放任意类型的数据，而是可以创建可以存储任意类型的数据类型

```
Stack<String> // 创建一个可以存储String类型的栈
Stack<int> // 创建一个可以存储int类型的栈
```



###  自动装箱、自动拆箱

**自动装箱**: int -> Integer

**自动拆箱**: Integer -> int


## 集合
![image](https://raw.githubusercontent.com/KongWiki/cloudImg/master/java-%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6.png)








