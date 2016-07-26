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
    public static void printList(LinkNode head){
        LinkNode p=head;
        while(p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println();
    }
    public static LinkNode arrayToList(int[] array){
        LinkNode head=new LinkNode(null);
        LinkNode p=head;
        for(int value:array){
            p.next=new LinkNode(value);
            p=p.next;
        }
        return head.next;
    }

}