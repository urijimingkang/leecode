package com.andy.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by aweng on 8/12/2016.
 */
public class MyCondition {
    public static void main(String args[]){
        final  MyResource res=new MyCondition.MyResource(0);
        Thread thread1=new Thread(new Runnable() {
            @Override

            public void run() {
                int i=0;
            while(true)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("in production thread: i="+ res.incCount());
            }


            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(true)
                {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("in consumer :"+res.decCount());
                }

            }
        });
        thread1.start();
        thread2.start();

    }

    static class MyResource {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        boolean flag = true;

        private int count;
        MyResource(int count)
        {
            this.count=count;

        }

        public   int incCount(){
            lock.lock();
            try {
                while (count>0) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        /*        for (int i = 0; i < 10; i++) {
                    System.out.println("incCount  " + i);
                }*/
                flag = true;
                ++count;

                condition.signal();
            } finally {
                lock.unlock();
            }
          return count;
        }
        public  int decCount(){
            lock.lock();
            lock.lock();
            try {
                    while (count<1) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                    }
        /*        for (int i = 0; i < 10; i++) {
                    System.out.println("incCount  " + i);
                }*/
                  flag = false;
                --count;

                condition.signal();
            } finally {
                lock.unlock();
            }
           return count;
        }
        public void setCount(int count){
            this.count=count;
        }
        public int getCount(){
            return count;
        }
    }
}

