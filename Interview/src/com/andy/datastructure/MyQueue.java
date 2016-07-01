package com.andy.datastructure;

/**
 * Created by aweng on 6/30/2016.
 */
public class MyQueue<T> {
    private LinkNode<T>  head;
    private LinkNode<T> last;
    private int size;
    public MyQueue(){
        head=new LinkNode<T>(null,null);
        last=head;
    }

    public void offer(T data){
        LinkNode<T> tmp=new LinkNode<T>(data);
        last.next=tmp;
        last=tmp;
        size++;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public  T peek(){
        return size==0?null:head.next.data;
    }
    public T poll(){
        if(isEmpty()){
            return null;
        }
        else
        {LinkNode<T> tmp=head.next;
            head.next =tmp.next;
            size--;
            if(size==0)
            {
                last=head;
            }

            return tmp.data;
        }

    }
    public static void main(String[]as){
        MyQueue<Integer> myQueue=new MyQueue<Integer>();

        for(int i=0;i<1000000;i++)
        {myQueue.offer(i);

        }
        while(!myQueue.isEmpty())
        System.out.print(myQueue.poll());
        System.out.println();
    }






}
