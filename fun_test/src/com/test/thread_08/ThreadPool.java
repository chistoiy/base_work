package com.test.thread_08;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
*线程池
*   因为频繁创建线程同样消耗时间，因为使用线程池
*   原理 线程池本质上是一个集合（容器）
*       程序第一次启动时，创建多个线程保存进集合内，当使用线程时，从集合内获取一个线程使用（List.remove(0)/linked.removeFirst()）
*       使用完毕后再将该线程添加会集合
*       java1.5+内置了线程池
*   使用Executors生产线程的工厂类
*       static ExecutorService newFixedThreadPool(int nThreads)
*       java.util.concurrent.ExecutorService线程池接口，其submit()方法提交一个Runnable任务用于执行
*          shutdown()销毁/关闭线程池
* */
public class ThreadPool {
    public static void main(String[] args) {

        Executor es = Executors.newFixedThreadPool(5);

        ((ExecutorService) es).submit(new RunnableImpl001());
        ((ExecutorService) es).submit(new RunnableImpl001());

        ((ExecutorService) es).shutdown();
    }
}

class RunnableImpl001 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建新的线程");
    }
}
