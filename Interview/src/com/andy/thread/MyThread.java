package com.andy.thread;

/**
 * Created by aweng on 6/27/2016.
 */
public class MyThread {
    public static void main(String[] ss){
        System.out.println("Hello");
        MyInteger Count=new MyInteger(0);
        Thread one=new Thread(new ThreadOne(Count));
        one.start();
        Thread two=new Thread(new ThreadTwo(Count));
        two.start();
    }
}

class ThreadOne implements Runnable{
    MyInteger count;
    public ThreadOne(MyInteger count){
  this.count=count;
    }
    public void run() {
        while (count.get() < 10)
        {   synchronized (count) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + ":ThreadOne:Count=" + count.get());
                    count.set(count.get()+1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }

    }
}
class ThreadTwo extends Thread{
    MyInteger count;
    public ThreadTwo(MyInteger count){
        this.count=count;
    }
    public void run(){
     while(count.get()<10) {
        synchronized (count){
             try {
                 Thread.sleep(5);
                 System.out.println(Thread.currentThread().getName() + ":ThreadTwo:count=" + count.get());
                 count.set(count.get()+1);
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }

     }
    }
}
class MyInteger {
int count;
    public MyInteger(int count){
        this.count=count;
    }
  public int  get(){
      return count;

    }
    public void set(int count)
    {
         this.count=count;
    }
}
