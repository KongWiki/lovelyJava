## 泛型

容器没有指定存储数据类型，这种情况下，可以向 `List` 添加任意类型数据，编译器不会做类型检查，而是默默的将所有数据都转为 `Object`。

假设，最初我们希望向 `List` 存储的是整形数据，假设，某个家伙不小心存入了其他数据类型。当你试图从容器中取整形数据时，由于 `List` 当成 `Object` 类型来存储，你不得不使用类型强制转换。在运行时，才会发现==`List` 中数据不存储一致的问题==，这就为程序运行带来了很大的风险（无形伤害最为致命）。==而泛型的出现，解决了类型安全问题。==

### 优点

* 避免类型转换

  ```java
  // 未使用泛型
  List list = new ArrayList();
  list.add("hello");
  String s = (String) list.get(0);
  // 使用泛型
  List<String> list = new ArrayList<String>();
  list.add("hello");
  String s = list.get(0);   // 不需要进行类型转换
  ```

* 编译时强类型检测

  泛型要求在声明时指定实际数据类型，Java 编译器在编译时会对泛型代码做强类型检查，并在代码违反类型安全时发出告警。早发现，早治理，把隐患扼杀于摇篮，在编译时发现并修复错误所付出的代价远比在运行时小。

* 泛型编程可实现通用算法

  通过使用泛型，可以实现通用算法，这些算法可以处理不同类型的集合，可以自定义，并且类型安全且易于阅读。

### 泛型类型

**`泛型类型`是被参数化的类或接口**

#### 泛型类

```java
class name<T1, T2, ... Tn>{}
```

一般将泛型中的类名称为**原型**，而将 `<>` 指定的参数称为**类型参数**。

#### 单类型参数（T）

```java
public class SingleInfo<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SingleInfo{" +
                "value=" + value +
                '}';
    }
}
```

#### 多类型参数（K，V）

```java
public class MultiInfo<K, V> {
    private K key;
    private V value;

    public MultiInfo(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MultiInfo{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
```

#### 泛型类的嵌套

```java
MultiInfo<Integer, MultiInfo<Integer, String>> multi = new MultiInfo<>(1, new MultiInfo<>(1,"32"));
System.out.println(multi);
// MultiInfo{key=1, value=MultiInfo{key=1, value=32}}
```

#### 泛型接口

```java
public interface Content<T> {
    T text();
}
```

#### 实现接口的子类型声明具体的类型

```java
public class ImplInterface implements MyInterface<Integer> {
    private int a = 100;

    public ImplInterface(int a) {
        this.a = a;
    }

    @Override
    public Integer getT() {
        return a;
    }
}

```

#### 实现接口的子类型不声明具体类型

```java
public class NoImplInterface<T> implements MyInterface<T> {
    private T text;

    public NoImplInterface(T text) {
        this.text = text;
    }

    @Override
    public T getT() {
        return text;
    }
}
```

### 泛型方法

泛型方法是引入其自己的类型参数的方法。泛型方法可以是普通方法、静态方法以及构造方法。

泛型方法语法形式如下：

```java
public <T> T func(T obj) {}
// 类型变量放在修饰符 (这里是 public static ) 的后面 , 返回类型的前面
```

**是否拥有泛型方法，与其所在的类是否是泛型没有关系。**

```java
public class GenericsMethodDemo01 {
    public static <T> void printClass(T obj) {
        System.out.println(obj.getClass().toString());
    }

    public static void main(String[] args) {
        printClass("abc");
        printClass(10);
    }
}
// Output:
// class java.lang.String
// class java.lang.Integer
```



泛型方法中也可以使用可变参数列表

```java
public class GenericVarargsMethodDemo {
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<T>();
        Collections.addAll(result, args);
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
    }
}
// Output:
// [A]
// [A, B, C]
```



### 类型擦除

==**Java中的泛型基本上都是在编译器这个层次来实现的。**==

Java 语言引入泛型是为了在编译时提供更严格的类型检查，并支持泛型编程。不同于 C++ 的模板机制，**Java 泛型是使用类型擦除来实现的，使用泛型时，任何具体的类型信息都被擦除了**。

==Java编译器会在编译时尽可能的发现可能出错的地方，但是仍然无法避免在运行时刻出现类型转换异常的情况==

类型擦除做了以下工作：

- 把泛型中的所有类型参数替换为 Object，如果指定类型边界，则使用类型边界来替换。因此，生成的字节码仅包含普通的类，接口和方法。
- 擦除出现的类型声明，即去掉 `<>` 的内容。比如 `T get()` 方法声明就变成了 `Object get()` ；`List` 就变成了 `List`。如有必要，插入类型转换以保持类型安全。
- 生成桥接方法以保留扩展泛型类型中的多态性。类型擦除确保不为参数化类型创建新类；因此，泛型不会产生运行时开销。

示例：

```java
public class GenericsErasureTypeDemo {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<Object>();
        List<String> list2 = new ArrayList<String>();
        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
    }
}
// Output:
// class java.util.ArrayList
// class java.util.ArrayList
```

### 泛型和继承

**泛型不能用于显式地引用运行时类型的操作之中，例如：转型、instanceof 操作和 new 表达式。因为所有关于参数的类型信息都丢失了**。

泛型无法向上转型

> 向上转型是指用子类实例去初始化父类，这是面向对象中多态的重要表现。

这是因为，泛型类并没有自己独有的 `Class` 类对象。比如：并不存在 `List.class` 或是 `List.class`，Java 编译器会将二者都视为 `List.class`。

### 类型边界

有时您可能希望限制可在参数化类型中用作类型参数的类型。**`类型边界`可以对泛型的类型参数设置限制条件**。例如，对数字进行操作的方法可能只想接受 `Number` 或其子类的实例。

要声明有界类型参数，请列出类型参数的名称，然后是 `extends` 关键字，后跟其限制类或接口。

类型边界的语法形式如下：

```java
<T extends XXX>
```



### 类型通配符

`类型通配符`一般是使用 `?` 代替具体的类型参数。例如 `List` 在逻辑上是 `List` ，`List` 等所有 `List<具体类型实参>` 的父类

#### 上界通配符

可以使用**`上界通配符`**来缩小类型参数的类型范围。

它的语法形式为：`<? extends Number>`

```java
public class GenericsUpperBoundedWildcardDemo {
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        return s;
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));
    }
}
// Output:
// sum = 6.0
```

#### 下界通配符

**`下界通配符`**将未知类型限制为该类型的特定类型或超类类型。

> 🔔 注意：**上界通配符和下界通配符不能同时使用**。

它的语法形式为：`<? super Number>`

```java
public class GenericsLowerBoundedWildcardDemo {
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        addNumbers(list);
        System.out.println(Arrays.deepToString(list.toArray()));
    }
}
// Output:
// [1, 2, 3, 4, 5]
```

#### 无界通配符

无界通配符有两种应用场景：

- 可以使用 Object 类中提供的功能来实现的方法。
- 使用不依赖于类型参数的泛型类中的方法。

#### 通配符和向上转型

**泛型不能向上转型。但是，我们可以通过使用通配符来向上转型**。

```java
public class GenericsWildcardDemo {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        List<Number> numList = intList;  // Error

        List<? extends Integer> intList2 = new ArrayList<>();
        List<? extends Number> numList2 = intList2;  // OK
    }
}
```

### 泛型约束

[Restrictions on Generics](https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html#instantiate)



### 泛型实践

#### 泛型命名

泛型一些约定俗成的命名：

- E - Element
- K - Key
- N - Number
- T - Type
- V - Value
- S,U,V etc. - 2nd, 3rd, 4th types

