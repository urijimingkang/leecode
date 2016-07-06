package com.andy.datastructure;

public class LinkNode<T>{
    //LinkedList t;
    public T data;

    public LinkNode<T> next;

    public LinkNode(T data){
        this.data=data;
        next=null;
    }
    public LinkNode(T data,LinkNode<T> next){
        this.data=data;
        this.next=next;
    }

}