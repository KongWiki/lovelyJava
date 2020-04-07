## String、 StringBuilder、 StringBuffer
### String
观察源码会发现`String`是Immutable类，被声明为final类，
底层的数据结构是字符数组（也是被final修饰的）。
因为其的不可变性，所有的关于字符串的拼接、裁剪等操作都会产生新的String对象，
同时又因为这些操作的普遍性，所以相关的拼接等操作效率对应用的性能有明显的影响
同时也保证了基础线程安全,因为你无法对它内部数据进行任何修改


### StringBuffer
StringBuffer 是为解决上面提到拼接产生太多中间对象的问题而提供的一个类，
其是**线程安全的**。

### StringBuilder
和StringBuffer一样，但是去除了线程安全的限制，
从某种程度上减小了开销，也是绝大部分进行字符串拼接首选

