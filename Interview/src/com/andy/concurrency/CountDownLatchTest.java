package com.andy.concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//CountDownLatch多线程，当一个线程到达指定位置执行countDown，计数器会减1，当计数器减到0时await就是释放线程
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatchTest.Business countTest = new CountDownLatchTest.Business();
        countTest.start();
    }

    static class Business {
        CountDownLatch refereeCount = new CountDownLatch(1);
        CountDownLatch athleteCount = new CountDownLatch(3);//初始化计数器大小

        public void start() {
            ExecutorService pool = Executors.newCachedThreadPool();
            for (int i = 0; i < 3; i++) {
                Runnable runable = new Runnable() {
                    @Override
                    public void run() {
                        athlete();
                    }
                };
                pool.execute(runable);
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            referee();
            pool.shutdown();
        }

        public void referee() {
            refereeCount.countDown();
            System.out.println(Thread.currentThread().getName() + " 裁判发令");
            try {
                athleteCount.await();
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 运动员跑完裁判统计时间");
        }

        public void athlete() {
            System.out.println(Thread.currentThread().getName() + " 运动等待发令");
            try {
                refereeCount.await();
                System.out.println(Thread.currentThread().getName() + " 运动收到发令");
                try {
                    System.out.println(Thread.currentThread().getName() + " 运动开始跑");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                } catch (InterruptedException e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (Exception e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            athleteCount.countDown();
        }
    }
}