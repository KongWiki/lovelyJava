## 红黑树剖析

### 二叉排序树、二叉搜索树

#### 性质： 

1. 定义的空树是BST
2. 左子树所有节点的值均小于根节点的值
3. 右子树所有节点的值均大于根节点的值
4. 中序遍历序列为升序

#### 实现二插排序树：

##### 节点定义、插入

* 节点： AVLEntry
* 字典：AVLMap
  * int compara(K a, K b) 比较关键字a和b的大小
  * boolean isEmpty() 判断map是否为空
  * V put(K key, V value) 添加元素

##### 迭代器

* LeetCode173 binary search tree iterator
* 要点： 利用中序遍历
  * 方案1： 递归添加进入线性集合， 迭代线性集合
  * 方案2： 非递归， 使左路径节点压栈
* AVL迭代器
  * 属性stack ， 存储BST的节点
  * hasNext, 是否还有下一个节点
  * next 下一个节点的值
  * remove 线程安全问题
* AVLMap继承Iterable， 并重写Iterator方法， 返回AVL迭代器即可

##### 查找

###### **原理**：



1. 若是根节点的值小于key， 递归从右子树查找
2. 若是根节点的值大于key， 递归从左子树查找
3. 如是根节点等于key， 成功
4. 若是子树为空， 失败

###### **实现**

模拟TreeMap的代码结构， 实现以下方法

1. AVLEntry getEntry(K key) 私有方法 主要查找逻辑
2. boolean containsKey(K key) 是否能找到关键字
3. V get(K key) 根据关键字返回对应的value
4. boolean containsValue(V value) 能够找到value

##### 删除（重点）

###### 原理

删除操作较为繁琐， 需要考虑断链的情况，以及删除之后， 还需满足BST的特性

共分为三种情况， 假设删除的节点为p， 父节点为f

1. p为叶子节点， 直接删除
2. p的左子树（右子树）不为空，删除之后， 其左子树（右子树）填补p的空缺位置
3. p既有左子树又有右子树， 找到右子树的最小值节点M（左子树的最大值）将该值替换p的值，之后按照1、2两种情况删除M即可

###### 实现

1. AVLEntry<K, V> deleteEntry()  递归函数（主逻辑）

2. V remote(K key) 删除关键字key 返回对应的value

3. void levelOrder 辅助函数 层次遍历

   用于输出观察



### 红黑树

#### 红黑树定义

1. 任意节点要么是红色，要么是黑色
2. 根节点为黑色
3. 所有的叶子节点为黑色
4. 如果一个节点为红色，那么它的两个子节点都为黑色
5. 任意节点从它出发， 到所有叶子节点的路径上包含相同数量的黑色节点

##### 由此衍生出的性质：

1. 任意一颗以黑色节点为根的子树也必定是一颗红黑树
2. 左（右）子树的高度最多是右（左）子树的两倍

#### 删除操作

二插排序树的删除： 情况1、情况2、情况3

AVL树的删除：情况1、情况2

红黑树的删除： 情况1、情况2、情况3、情况4



### Comparable和Comparator

#### Comparable

##### Comparable简介

**Comparable是排序接口。**

若一个类实现了Comparable接口，就意味着“**该类支持排序**”。  即然实现Comparable接口的类支持排序，假设现在存在“实现Comparable接口的类的对象的List列表(或数组)”，则该List列表(或数组)可以通过 Collections.sort（或 Arrays.sort）进行排序。

此外，“实现Comparable接口的类的对象”可以用作“有序映射(如TreeMap)”中的键或“有序集合(TreeSet)”中的元素，而不需要指定比较器。

##### Comparable 定义

Comparable 接口仅仅只包括一个函数，它的定义如下：

```java
package java.lang;
import java.util.*;

public interface Comparable<T> {
    public int compareTo(T o);
}
```

假设我们通过 x.compareTo(y) 来“比较x和y的大小”。若返回“负数”，意味着“x比y小”；返回“零”，意味着“x等于y”；返回“正数”，意味着“x大于y”。

#### Comparator

##### Comparator简介

**Comparator 是比较器接口。**

我们若需要控制某个类的次序，而该类本身不支持排序(即没有实现Comparable接口)；那么，我们可以建立一个“该类的比较器”来进行排序。这个“比较器”只需要实现Comparator接口即可。

也就是说，我们可以通过“**实现Comparator类来新建一个比较器**”，然后通过该比较器对类进行排序。

##### Comparator定义

Comparator 接口仅仅只包括两个个函数，它的定义如下：

```java
package java.util;

public interface Comparator<T> {

    int compare(T o1, T o2);

    boolean equals(Object obj);
}
```



#### 总结

##### 相同

- Comparable和Comparator都是用来实现对象的比较、排序
- 要想对象比较、排序，都需要实现Comparable或Comparator接口
- Comparable和Comparator都是Java的接口

##### 区别

- Comparator位于java.util包下，而Comparable位于java.lang包下
- Comparable接口的实现是在类的内部（如 String、Integer已经实现了Comparable接口，自己就可以完成比较大小操作），Comparator接口的实现是在类的外部（可以理解为一个是自已完成比较，一个是外部程序实现比较）
- 实现Comparable接口要重写compareTo方法, 在compareTo方法里面实现比较





