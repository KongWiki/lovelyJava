## 对象包装器和自动装箱
有时, 需要将 int 这样的基本类型转换为对象 。 所有的基本类型都冇一个与之对应的类。例如,
Integer类对应基本类型 int 。 通常 , 这些类称为包装器 ( wrapper ) 这些对象包装器类
拥有很明显的名字 : `Integer` 、 `Long` 、 `Float` 、 `Double` 、 `Short` 、 `Byte` 、 `Character` 、 `Void` 和 `Boolean` ( 前
6 个类派生于公共的超类 `Number` ) 。 对象包装器类是不可变的, 即一旦构造了包装器, 就不
允许更改包装在其中的值 。 同时, 对象包装器类还是 `final` , 因此不能定义它们的子类 。