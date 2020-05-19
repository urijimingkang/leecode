package com.andy.thread.concurrency;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        final Business1 business1 = new Business1();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    business1.write();
                }
            }

        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    business1.read();
                }
            }

        }.start();
    }
}


class Business1 {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void write() {
        lock.writeLock().lock();
        System.out.println("start write");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            System.out.println("end write");
            lock.writeLock().unlock();
        }
    }

    public void read() {
        lock.readLock().lock();
        System.out.println("start read");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            System.out.println("end read");
            lock.readLock().unlock();
        }
    }
}