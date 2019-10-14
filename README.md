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
    
### 面向对象
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
        
        