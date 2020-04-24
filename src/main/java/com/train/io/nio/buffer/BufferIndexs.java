package com.train.io.nio.buffer;

import java.nio.ByteBuffer;

/**
 * @Time: 2020/4/23下午8:21
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BufferIndexs {
    public static void main(String[] args) {
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //buffer中四个变量的值
        System.out.println("初始时---->limit---->" + buffer.limit());
        System.out.println("初始时---->capacity---->" + buffer.capacity());
        System.out.println("初始时---->position---->" + buffer.position());
        System.out.println("初始时---->mark---->" + buffer.mark());

        System.out.println("--------------------------------");

        String s = "abcd";
        buffer.put(s.getBytes());

        //buffer添加数据之后，四个变量的值
        System.out.println("put完之后---->limit---->" + buffer.limit());
        System.out.println("put完之后---->capacity---->" + buffer.capacity());
        System.out.println("put完之后---->position---->" + buffer.position());
        System.out.println("put完之后---->mark---->" + buffer.mark());
        buffer.flip();
        System.out.println("-------------------------------------------");
        System.out.println("flip()之后---->limit---->" + buffer.limit());
        System.out.println("flip()之后---->capacity---->" + buffer.capacity());
        System.out.println("flip()之后---->position---->" + buffer.position());
        System.out.println("flip()之后---->mark---->" + buffer.mark());
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println("-------------------------------------------");
        System.out.println("读完之后---->limit---->" + buffer.limit());
        System.out.println("读完之后---->capacity---->" + buffer.capacity());
        System.out.println("读完之后---->position---->" + buffer.position());
        System.out.println("读完之后---->mark---->" + buffer.mark());
        System.out.println("----------------清空缓冲区-------------");
        buffer.clear();
        System.out.println("清空之后---->limit---->" + buffer.limit());
        System.out.println("清空之后---->capacity---->" + buffer.capacity());
        System.out.println("清空之后---->position---->" + buffer.position());
        System.out.println("清空之后---->mark---->" + buffer.mark());


    }
}
