package com.test.thread_08;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 线程安全
 *      多线程访问共享数据，会导致数据紊乱，数据不安全/不可靠
 *
 *      解决方案;
 *              1.同步代码块
 *                  synchronized(同步锁对象){。。。}
 *                      锁对象（对象锁，对象监视器）可以任意对象,但多线程使用的锁对象必须保证是同一个
 *                   过程：
 *                      1.抢夺到cpu执行权的线程t0，执行到同步代码块时，会检查当前同步代码块是否有锁对象，
 *                          如果有锁对象，则此线程立即获取锁对象，进入同步中执行（在未执行完毕时不会归还锁对象）
 *                       2.另一个线程t1强盗cpu执行权，执行到同步代码块时，检查是否有锁对象，如没有，则进入阻塞状态，等待t0执行完后归还同步锁对象
 *              2.同步方法
 *                      定义一个方法，然后使用synchronized来修饰该方法
 *                      默认使用的锁对象实际上是线程的实现类对象
 *                      即当同步代码块使用了this来当锁对象，本质上就是同步方法
 *                   静态同步方法的随对象不是this，而是本类的class属性
 *
 *              3.锁机制lock接口
 *                  java1.5+出现
 *                      比synchronized更广法的操作，更具可控锁对象的操作
 *                      void lock()获取锁
 *                      void unlock()释放锁
 */
public class ThreadSafe02 {

    public static void main(String[] args) throws InterruptedException {
        //线程不安全的例子测试
        //threadSafe();
        //同步代码块方式测试
//        synchronizedCodeField();
//        同步方法方式测试
//        synchronizedMethod();
//        锁方式测试
        lock();
    }


    static void threadSafe() {//线程不安全的例子测试
        RunnableImpl02 rimpl = new RunnableImpl02();
        Thread t1 = new Thread(rimpl);
        Thread t2 = new Thread(rimpl);
        Thread t3 = new Thread(rimpl);
        t1.start();
        t2.start();
        t3.start();
    }

    static void synchronizedCodeField() {//同步代码块测试
        RunnableImpl03 rimpl = new RunnableImpl03();
        Thread t1 = new Thread(rimpl);
        Thread t2 = new Thread(rimpl);
        Thread t3 = new Thread(rimpl);
        t1.start();
        t2.start();
        t3.start();
    }

    static void synchronizedMethod() {//同步代码块测试
        RunnableImpl04 rimpl = new RunnableImpl04();
        Thread t1 = new Thread(rimpl);
        Thread t2 = new Thread(rimpl);
        Thread t3 = new Thread(rimpl);
        t1.start();
        t2.start();
        t3.start();
    }

    static void lock() {
        RunnableImpl05 rimpl = new RunnableImpl05();
        Thread t1 = new Thread(rimpl);
        Thread t2 = new Thread(rimpl);
        Thread t3 = new Thread(rimpl);
        t1.start();
        t2.start();
        t3.start();
    }
}

class RunnableImpl02 implements Runnable {//线程不安全接口实现类

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "买出编号为" + ticket + "的票");
                ticket--;
            }
        }
    }
}

class RunnableImpl03 implements Runnable {//采用同步代码块来保证线程安全

    private int ticket = 100;

    Object obj = new Object();//同步锁对象

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "买出编号为" + ticket + "的票");
                    ticket--;
                }
            }
        }
    }
}

class RunnableImpl04 implements Runnable {//采用同步方法来保证线程安全
    private int ticket = 100;
    private static int staticTicket = 100;
    Object obj = new Object();//同步锁对象

    @Override
    public void run() {
        while (true) {
            payTicket();
            payTicketStatic();
        }
    }

    public synchronized void payTicket() {//普通同步方法

        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "买出编号为" + ticket + "的票");
            ticket--;
        }

    }

    public static synchronized void payTicketStatic() {//静态同步方法

        if (staticTicket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "静态->买出编号为" + staticTicket + "的票");
            staticTicket--;
        }

    }
}

class RunnableImpl05 implements Runnable {//采用同步代码块来保证线程安全

    private int ticket = 100;

    Lock l = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            l.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "买出编号为" + ticket + "的票");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    l.unlock();
                }
            }
        }
    }
}



