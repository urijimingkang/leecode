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
            System.out.print(p.data + " ");
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
        head.next=null;
       // head.next=pre;
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
        head.next=null;

        return pre;

    }

    public LinkNode<T>  reverseLinkAtPosition(LinkNode start,int k){ // 1->2->3->4->5->6 k=2  =>3->4->5->6->1->2
        LinkNode<T> p=start;
        LinkNode<T> secondHead=null;
        LinkNode<T> secondEnd=null;
        LinkNode<T> firstHead=p;
        LinkNode<T> firstEnd=null;
      int i=1;
        while(i<k)
        {
            p=p.next;
            i++;
        }
        secondHead=p.next;
        secondEnd=secondHead;
        firstEnd=p;

        while(secondEnd.next!=null){

            secondEnd=secondEnd.next;
        }
        secondEnd.next=firstHead;//第二个表的尾部连着第一个表的头
        firstEnd.next=null;

return secondHead;

    }

    public LinkNode<T> swichPair(){
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
        head.next=null;
        // head.next=pre;
        return pre;

    }


    public static void main(String [] args){
        int[] arr=new int[]{1,2,3,4,5,6};
        ReverseLinkedList t=new ReverseLinkedList();
        LinkNode head= LinkNode.arrayToList(arr);
        t.print();
       // t.reversePrint();
       // System.out.println("iteratePrint");
     //  t.iteratePrint(head.next);
     //  LinkNode inVhead=t.reverseLink();
     //   System.out.println( "reverseLink and then iteratePrint");
      //  t.iteratePrint(inVhead);
       LinkNode tmpNode= t.reverseLinkAtPosition(head,2);
        LinkNode.printList(tmpNode);
        t.print();
    }
}
