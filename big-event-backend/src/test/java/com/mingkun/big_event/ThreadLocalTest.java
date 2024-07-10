package com.mingkun.big_event;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {
    
    @Test
    public void testThreadLocalSetAndGet() {
        // 提供一个ThreadLocal对象
        ThreadLocal tl = new ThreadLocal();
        
        // 开启两个线程
        new Thread(()->{
            tl.set("君莫笑");
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        }, "蓝色").start();

        new Thread(()->{
            tl.set("包子入侵");
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        }, "绿色").start();
    }
}
