package com.andy.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//本示例针对多线程Demo-主线程和子线程交替运行  改造，使用ReentrantLock和condition 替换synchronized和wait、notify

public class ConditionTest {
    public static void main(String[] args) {
        final ConditionTest.Business business = new ConditionTest.Business();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    business.subThread();
                }
            }
        }.start();

        for (int i = 0; i < 5; i++) {
            business.mainThread();
        }
    }

    static class Business {

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        boolean flag = true;

        public void mainThread() {
            lock.lock();
            try {
                while (flag) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println("mainThread  " + i);
                }
                flag = true;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }

        public void subThread() {
            lock.lock();
            lock.lock();
            try {
                while (!flag) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 50; i++) {
                    System.out.println("subThread  " + i);
                }
                flag = false;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}