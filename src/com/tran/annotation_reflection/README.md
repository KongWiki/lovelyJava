## 注解和反射

**正常方式**:  `引入需要的包类名称` ---> `通过 new实例化` ---> `获取实例化对象`

**反射**:  `实例化对象` ---> `getClass()方法` ---> `得到完整的包类名称`

通过反射， 使得Java具有类似动态语言的特性

### 反射所提供的功能

* 在运行时判断任意一个对象所属的类
* 在运行时构造任意一个类的对象
* 在运行时判断任意一个类所具有的成员变量和方法
* 在运行时调用任意一个对象的成员变量和方法
* 在运行时获取泛型信息
* 在运行时处理注解
* 生成动态代理
* ......

### 反射优点和缺点

**优点**: 

可以动态创建和编译，有很大的灵活性

**缺点**: 

慢于直接执行相同的操作

### 获取Class类的实例

1. 已知某个类的实例

   ```java
   User user = new User();
   Class<? extends User> aClass1 = user.getClass();
   ```

2. 已知具体的类

   ```java
   Class<User> aClass2 = User.class;
   ```

3. 已知类的全名称

   ```java
   Class<?> aClass3 = Class.forName("com.xxx.xxx");
   ```

### 类的加载过程

```
|—————————|          |——————————|           |————————————|
| 类的加载 | ------>  | 类的链接   |  -------> | 类的初始化  |
|   Load  | ----->   |   Link   |  -------> | Initialize |
|—————————|          |——————————|           |————————————|
```

### 获取Class对象之后可以做写什么

1. 创建类的对象

   ```java
   aClass.newInstance(); // 本质是调用了无参构造器
   ```

   若是没有无参构造器，可以通过明确调用对应的构造器，然后将参数传递进去即可

   ```java
   aClass.getDeclaredConstrutor(Class...parameterTypes)
   ```

2. 可以调用类中的方法

   ```java
    User user = (User) aClass.newInstance();
    Method setName = aClass.getDeclaredMethod("setName", String.class);
    // invoke: 激活
    // (对象, "方法的值")
    setName.invoke(user, "维坤坤");
    System.out.println(user.getName());
   ```

3. 操作类中的属性

   ```java
    //反射操作属性
    User user3 = (User) aClass.newInstance();
    Field name = aClass.getDeclaredField("name");
    // 不能操作私有属性 需要关闭安全检测
    name.setAccessible(true);
    name.set(user3, "孔维坤");
    System.out.println(user3.getName());
   ```