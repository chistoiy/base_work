package com.test.thread_08;

/*
 *   线程调度：
 *        分时调度（平分时间）
 *        抢占式调度（优先级）java的调度
 *   创建线程的方法：
 *       1，直接实例Thread
 *       2，extends Thread，重写run()方法
 *       3，实现Runnable接口，重写run方法RunnableImpl，
 *           实例Runnable接口的实现类对象rimpl，
 *           实例Thread对象t时将实现类对象rimpl传过去，
 *               使用t的start()启动线程
 *           避免单继承局限性，争抢程序扩展性（解耦），将设置线程任务与开启新线程进行分离（解耦）
 *               实现类RunnableImpl重写run方法设置线程任务
 *               t对象启动线程,传递不同的runnable实现类，开启不同任务
 *       4.匿名内部类创建线程
 *
 *       两种获取线程名称的方式，
 *             在线程内，使用getName()即可；
 *             外部，则使用Thread的currentThread()静态方法即可获取
 *       修改线程名称：
 *            1.setName()
 *            2.构造方法中交由super来设置
 *
 *   线程的方法：
 *       static sleep();休眠，单位为毫秒，静态方法
 *
 *
 * */
public class ThreadTest01 {

    public static void main(String[] args) {
//线程的类继承，线程名获取与设置
//            baseTest();
//线程的sleep()方法，单位为毫秒
//            threadSleep();
//实现runnable接口来创建线程
//                runnableImplTest();
//匿名内部类创建线程
//        anonymousClassCreateThread();



    }

    static void baseTest() {//线程的类继承，线程名获取与设置

        MyThread mt = new MyThread();
        mt.start();
        MyThread mt2 = new MyThread("线程小黑");
        mt2.start();
        Thread t = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            System.out.println(t.getName() + "主线程正在执行" + i);
        }

    }

    static void threadSleep() {//线程的sleep()方法，单位为毫秒
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    static void runnableImplTest() {//实现runnable接口来创建线程

        RunnableImpl ripl = new RunnableImpl();

        Thread t = new Thread(ripl);
        t.start();


    }

    static void anonymousClassCreateThread() {//匿名内部类创建线程
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(i);
                }
            }
        }.start();

        Runnable r = new Runnable() {//匿名内部类接口方式创建线程
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(i);
                }
            }
        };
        new Thread(r).start();


    }
}

class MyThread extends Thread {
    public MyThread() {
        super();
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "：正在执行" + i);
        }
    }
}

class RunnableImpl implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

    }
}
