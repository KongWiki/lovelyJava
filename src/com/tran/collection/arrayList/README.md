## ArrayList 源码解读

### 从构造函数开始

```java
    /**
     * Default initial capacity.
     * 默认初始化容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Shared empty array instance used for empty instances
     * 空实例的共享数组实例
     * 若是无参构造方法 使用 DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
     * 若是含参构造方法 使用 EMPTY_ELEMENTDATA 
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * Shared empty array instance used for default sized empty instances. We
     * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
     * first element is added.
     * 
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer. Any
     * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
     * will be expanded to DEFAULT_CAPACITY when the first element is added.
     */
    transient Object[] elementData; // non-private to simplify nested class access

    /**
     * The size of the ArrayList (the number of elements it contains).
     *
     * @serial
     */
    private int size;

    /**
     * 构造函数1 带初始容量参数的构造函数, (用户自己定义容量)
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {// >0
            // 创建initialCapacity容量
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {// =0
            // 创建空数组
            this.elementData = EMPTY_ELEMENTDATA;
        } else { // ＜0 抛出异常
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        }
    }

    /**
     * 构造函数2: 默认构造函数, 
     * DEFAULTCAPACITY_EMPTY_ELEMENTDATA = 0, 初始化为10
     * 初始是一个空数组, 当添加一个元素的时候, 扩充为10
     * 原因详见 transient Object[] elementData;注释
     */
    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     * 构造包含指定collection元素的列表 这些元素利用该集合的迭代按顺序返回
     * 如果指定的集合为null, 抛出 NullPointerException
     */
    public ArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
        if ((size = elementData.length) != 0) {
            // c.toArray might (incorrectly) not return Object[] (see 6260652)
            if (elementData.getClass() != Object[].class)
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            // replace with empty array.
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }
```

**总结**

1. **常量EMPTY_ELEMENTDATA和DEFAULTCAPACITY_EMPTY_ELEMENTDATA是为了初始化elementData的。如果为无参构造函数，使用DEFAULTCAPACITY_EMPTY_ELEMENTDATA；如果为含参构造函数，使用EMPTY_ELEMENTDATA**
2. 以无参构造方法创建arraylist时, 实际上初始化的值是一个空数组. 添加第一个元素时 扩容为10

### ArrayList扩容机制

####  add 方法

```java
/**
* 将指定的元素添加到列表末尾
*/
public boolean add(E e) {
    //在添加元素之前 预先调用该方法
        ensureCapacityInternal(size + 1);  // Increments modCount!!
    // 最简单的给数组进行赋值
    // size++ 先赋值 后自增
        elementData[size++] = e;
        return true;
    }

```

#### ensureCapacityInternal 方法

在查看该方法时, 发现其调用了其他的方法, 然后其他的方法也调用了另外的方法, 所有全部粘上

```java
private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * Increases the capacity to ensure that it can hold at least the
     * number of elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
```

