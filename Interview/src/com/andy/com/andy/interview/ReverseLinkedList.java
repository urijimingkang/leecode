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
    /**
     * 回顾链表的reverseLink(start,n) 方法，注意start是从意义的开始节点，即传入head.next…
     …,因为ReverseLinkedList的类head为无意义的哨兵节点。

     代码实现最后，要注意start.next=p,以保持反转部分与原来的部分保持连接
     */

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
//反转指定部分链表
    public LinkNode<T> reverseLink(LinkNode<T> start,int m,int n){
        LinkNode<T> first=start;

    if(start==null||start.next==null||m>=n)
    return start;


        int i=1;
        while(i<m)
        {
            i++;
            first=first.next;
        }
        LinkNode<T> pre=first.next;
        LinkNode<T> top=first.next;//top不动
        LinkNode<T> p=pre.next;
        LinkNode<T> next=null;
        while(p!=null&&i<n)
        {i++;
            next=p.next;
            p.next=pre;
            pre=p;
            p=next;

        }

        top.next=p;
        first.next=pre;
        return start.next;

    }
    /**
     * 链表反转，递归算法
     */
    public LinkNode<T> reverseListRecursive(LinkNode<T> head){
        if(head==null||head.next==null){
            return head;
        }else{
            LinkNode<T> tail=reverseRecursive(head);
            head.next=null;
            return tail;
        }
    }
    public LinkNode<T> reverseRecursive(LinkNode<T> p)
    {
        if(p.next==null)
            return p;

        LinkNode<T> next=p.next;
        LinkNode<T> tail=reverseRecursive(next);
        next.next=p;
        return tail;
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

        head= t.arrayToLinkedList(arr);
        inVhead=t.reverseLink(head,3,5);//反转从m开始到n的部分链表 1->2->3->4->5->6  1->2->5->4->3->6 ,这里的head本身就是哨兵节点，
                                        // 所以reverseLink函数里面first可以直接等于head，而不需要想subvoid老师那样new一个哨兵节点。
                                        // first=2,top=3
        t.iteratePrint(inVhead);

        head= t.arrayToLinkedList(arr);
        inVhead=t.reverseListRecursive(head.next);
        t.iteratePrint(inVhead);

    }
}
