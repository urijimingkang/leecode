package com.andy.com.andy.interview;
import com.andy.datastructure.*;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * Created by aweng on 7/6/2016.
 */
public class ReverseLinkedList<T> {
    public static void main(String [] args){
        Integer[] arr=new Integer[]{1,2,3,4};
        ReverseLinkedList t=new ReverseLinkedList();
        LinkNode head= t.arrayToLinkedList(arr);
        t.print();
        t.reversepPrint();
        t.iteratePrint(head.next);

    }
 private LinkNode<T> next;
    private int size=0;
    private LinkNode<T> head=new LinkNode<T>(null,null);
    public int getLen(){
         LinkNode<T> p=head;
        int i=0;
        while(p!=null)
        {
            p=p.next;
            i++;
        }


        return i;
    }
    public   LinkNode<T> arrayToLinkedList(T[] array){

        LinkNode<T> p=head;
        for(T t:array){
            LinkNode<T> node=new LinkNode<T>(t);
            p.next=node;
            p=node;
            size++;
        }
        return head;
    }
    public void print(){
        LinkNode<T> p=head.next;

        while(p!=null)
        {
            System.out.print(p.data + "->");
            p=p.next;


        }
        System.out.println();


    }
    public void iteratePrint(LinkNode<T> p){



        System.out.println("iteratePrint");
        if(p!=null) {
            System.out.print(p.data + " ");
            iteratePrint(p = p.next);
        }



        System.out.println();


    }
    public void reversepPrint(){
        LinkNode<T> p=head.next;
        Stack<T> mystack=new Stack<T>();
        while(p!=null)
        {
            mystack.push(p.data);
            p=p.next;
        }
        while(!mystack.isEmpty())
        {
            System.out.print(mystack.pop());

        }
        System.out.println();
    }
}
