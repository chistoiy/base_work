package com.test.thread_08;

/*
 * 线程通信
 *       多线程执行时默认时随机切换线程的，为了能有一定依据的来执行，协同多线程通信共同操作一份数据
 *等待唤醒机制
 *       多线程的一种协作机制
 *           wait：线程不在活动，不再参与调度，进入wait set中，不浪费cpu资源，不竞争锁，线程状态未WAITING，等待其他线程执行通知（notify）将此线程从waitset中释放出来，重新回到ready queue中
 *           notify：选取所通知对象的wait set中的一个线程释放
 *                   但是，通知了一个等待的线程，这个线程也不会立即回复执行，因为中断时在同步块中，此刻线程不持有锁对象（BLOCKED状态），需要获得锁后才会恢复，由WATING到RUNNABLE
 *           notifyAll 释放所通知对象的wait set上的所有线程
 *
 *           wait与notify必须由同一个锁对象调用，
 *
 *
 *    计时等待
 *    锁阻塞
 *          因为没有抢夺到锁而阻塞
 *    无限等待状态
 *          最普遍的模型，生产者消费者模型
 *
 * */
public class ThreadWaitAwake03 {
    public static void main(String[] args) {

        BaoZi bz = new BaoZi();
        BaoZiPu bzp = new BaoZiPu(bz);


        ChiHuo ch=new ChiHuo(bz);
        ch.start();
        bzp.start();
    }
}

class BaoZi {

    String pi;
    String xian;
    Boolean flag = false;

}

class BaoZiPu extends Thread {
    private BaoZi bz;
        public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }
    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (bz) {
                if (bz.flag) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (count % 2 == 0) {
                    bz.pi = "薄皮";
                    bz.xian = "三鲜";
                } else {
                    bz.pi = "冰皮";
                    bz.xian = "牛肉大葱";
                }
                count++;
                System.out.println("正在生成" + bz.pi + bz.xian + "包子");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz.flag = true;
                bz.notify();
                System.out.println("已经做好了" + bz.pi + bz.xian + "包子" + ",可以开始消费了");
            }
        }
    }
}

class ChiHuo extends Thread{
    private BaoZi bz;
    public  ChiHuo(BaoZi bz){
        this.bz = bz;
    }
    @Override
    public void run(){
        while(true){
            synchronized (bz){
                if(!bz.flag){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            System.out.println("正在吃："+bz.pi+bz.xian+"的包子");
            bz.flag=false;
            bz.notify();
            System.out.println("吃完了刚才的包子，包子铺快做包子");
            System.out.println("-----------------------");
        }}
    }

}