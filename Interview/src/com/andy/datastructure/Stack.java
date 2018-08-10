package com.andy.datastructure;

/**
 * Created by aweng on 6/30/2016.
 */
public class Stack<T> {
    private int size=0;                  //  |  |<-size=2  始终指向栈顶再往上面一格为空的位置
                                         //  | 1|->1
                                         //  | 2|->0
    public Object[] arr=new Object[10];
    public void push(T data){
        arr[size]=data;
        size++;
        if(size==arr.length)
        {
            Object[] newarr=new Object[10*2];

            System.arraycopy(arr,0,newarr,0,size);
            arr=newarr;
        }
    }

    public T pop()
    {
        T t =(T)arr[size-1];
       arr[size-1]=null;
        size--;
        return t;

    }
    public Object peek()
    {
        if(size==0)
            return null;
        return arr[size-1];

    }
    public boolean isEmpty(){
        return size==0;
    }
    public static  void main(String[] as){
        Stack<Integer> mystack=new Stack<Integer>();
        mystack.push(1);
        mystack.push(2);
        mystack.push(3);
        System.out.println(mystack.pop());
        mystack.push(4);
        System.out.println(mystack.pop());
    };



}

