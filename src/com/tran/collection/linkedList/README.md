## LinkedList源码解读
LinkedList实现了List接口和Deque接口的双端链表，其能够高效的实现插入删除操作, 而且也拥有了队列所拥有的特性。同时需要注意的是, **LinkedList不是线程安全的**，需要使用的别的方式实现线程安全

### 依赖

![image](https://raw.githubusercontent.com/KongWiki/cloudImg/master/LInkedList%E7%BB%93%E6%9E%84.png)



### 从节点数据结构开始

```java
private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
```

其实一个很明显的双向链表的数据结构。

### 构造函数

1. 空的构造方法

   ```java
    public LinkedList() {
       }
   ```

   用于构造一个空的链表。

2. 含有参数的构造方法(用已有的集合创建链表)

   ```java
    public LinkedList(Collection<? extends E> c) {
           this();
           addAll(c);
       }
   
   ```

   

### add相关的函数

可以看到， 初始化之后，使用无参的构造方法，返回的为一个空的链表，若是为含有参数的构造方法，

1. addAll()

   ```java
    public boolean addAll(Collection<? extends E> c) {
           return addAll(size, c);
       }
    public boolean addAll(int index, Collection<? extends E> c) {
    		// 判断当前的索引是否越界， 若是越界，
           checkPositionIndex(index);
   
           Object[] a = c.toArray();
           int numNew = a.length;
           if (numNew == 0)
               return false;
   
           Node<E> pred, succ;
           if (index == size) {
               succ = null;
               pred = last;
           } else {
               succ = node(index);
               pred = succ.prev;
           }
   
           for (Object o : a) {
               @SuppressWarnings("unchecked") E e = (E) o;
               Node<E> newNode = new Node<>(pred, e, null);
               if (pred == null)
                   first = newNode;
               else
                   pred.next = newNode;
               pred = newNode;
           }
   
           if (succ == null) {
               last = pred;
           } else {
               pred.next = succ;
               succ.prev = pred;
           }
   
           size += numNew;
           modCount++;
           return true;
       }
   ```

2. 判断越界方法

   ```java
   private void checkPositionIndex(int index) {
           if (!isPositionIndex(index))
               throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
       }
   
    private boolean isPositionIndex(int index) {
           return index >= 0 && index <= size;
       }
   ```

   直接在`if`后跑出异常，可直接跑出异常信息，并且可以根据自己定义信息跑出异常。