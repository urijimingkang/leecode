package com.andy.thread;

/**
 * Created by aweng on 6/27/2016.
 */
public class MyConsumeProduceThread {


    /**
     * Created by aweng on 6/27/2016.
     */

    public static void main(String[] ss) {
        System.out.println("Hello");
        MyInteger2 Count = new MyInteger2(0);

        Thread two = new Thread(new Producer2(Count));
        two.start();
        try{
            Thread.sleep(500) ;
        }catch(InterruptedException e){
            e.printStackTrace() ;
        }
        Thread one = new Thread(new Consumer2(Count));
        one.start();
    }
}

    class Consumer2 implements Runnable{
        MyInteger2 count;
        public Consumer2(MyInteger2 count){
            this.count=count;
        }
        public void run() {
while(true)
{count.get();}


        }
    }
    class Producer2 extends Thread{
        MyInteger2 count;
        public Producer2(MyInteger2 count){
            this.count=count;
        }
        public void run(){
            while(true)
            {count.set();}
        }
    }
    class MyInteger2 {
        int num;
        boolean flag = true ;   // 设置标志位,初始时先生产
        public MyInteger2(int num){
            this.num=num;
        }
        public void  get(){
            synchronized (this) { while(num<=0) {

                try {
                    //   Thread.sleep(5);
                    wait();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
                System.out.println(":Consumer:count=" +num);
                num--;
                flag=true;
                try {
                    Thread.sleep(200);


                } catch (Exception e) {
                    e.printStackTrace();
                }
                notify();
            }
        }
        public void set()
        {
            synchronized (this) {
                while(num>2) {

                    try {
                        System.out.println("before wait:Producer:count=" +num);
                        wait();
                        System.out.println("after wait:Producer:count=" +num);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.println(":Producer:count=" +num);
                flag=false;
                try {
                      Thread.sleep(100);


                } catch (Exception e) {
                    e.printStackTrace();
                }
                notify();
            }
        }
    }


