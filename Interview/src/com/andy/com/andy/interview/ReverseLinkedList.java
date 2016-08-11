package com.andy.com.andy.interview;
import com.andy.datastructure.*;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * Created by aweng on 7/6/2016.
 */
public class ReverseLinkedList<T> {

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




        if(p!=null&&p.data!=null) {
            if(p.next!=null)
            System.out.print(p.data + "->");
            else
                System.out.print(p.data );
            iteratePrint(p = p.next);
        }



        System.out.println();


    }
    public void reversePrint(){
        LinkNode<T> p=head.next;
        Stack<T> mystack=new Stack<T>();
        while(p!=null)
        {
            mystack.push(p.data);
            p=p.next;
        }
        while(!mystack.isEmpty())
        {
            if(mystack.size()>1)
            System.out.print(mystack.pop()+"->");
            else
                System.out.print(mystack.pop());


        }
        System.out.println();
    }

    public LinkNode<T> reverseLink(){
        LinkNode<T> pre=head;
        LinkNode<T> p=pre.next;
        LinkNode<T> next=null;


        while(p!=null)
        {
            next=p.next;
            p.next=pre;
            pre=p;
           p=next;

        }
        head.next.next=null;
        return pre;

    }
    public LinkNode<T> reverseLink(LinkNode<T> start,int n){
        LinkNode<T> pre=start;
        LinkNode<T> p=pre.next;
        LinkNode<T> next=null;

        int i=0;
        while(p!=null&&i<n)
        {i++;
            next=p.next;
            p.next=pre;
            pre=p;
            p=next;

        }

        start.next=p;
        return pre;

    }

    public LinkNode<T> switchPair(){
        LinkNode<T> pre=head;
        LinkNode<T> p=pre.next;
        LinkNode<T> next=null;


        while(p!=null)
        {
            next=p.next;
            p.next=pre;
            pre=p;
            p=next;

        }
        //head.next=null;
        // head.next=pre;
        return pre;

    }


    public static void main(String [] args){
        Integer[] arr=new Integer[]{1,2,3,4,5,6};
        ReverseLinkedList t=new ReverseLinkedList();

        LinkNode head= t.arrayToLinkedList(arr);  //注意这里的head为哨兵节点
        t.iteratePrint(head.next);

        LinkNode inVhead=null;

        inVhead =t.reverseLink();      //反转列表
        t.iteratePrint(inVhead);

        head= t.arrayToLinkedList(arr);
       inVhead=t.reverseLink(head.next,3);//反转从head开始的部分链表 1->2->3->4->5->6  4->3->2->1->5->6
        t.iteratePrint(inVhead);

    }
}
