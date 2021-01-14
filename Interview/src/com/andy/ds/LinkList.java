package com.andy.ds;

/**
 * Created by aweng on 6/30/2016.
 */
public class LinkList<T> {
    private LinkNode<T> head=new  LinkNode<T>(null,null);//哨兵节点，辅助作用
    public int size;
    public static void main(String [] args){
        Integer[] arr=new Integer[]{1,2,3,4};
        LinkList<Integer> t=new LinkList<Integer>();
       t.arrayToLinkedList(arr);
        t.print();
        t.insert(5,1);
        t.print();
        t.remove(t.getSize()-1);
        t.print();
    }
    public int getSize()
    {return this.size;}
    public   LinkNode<T> arrayToLinkedList(T[] array){
       //  LinkNode<T> head=new LinkNode<T>(null,null);
        LinkNode<T> p=head;
        for(T t:array){
            LinkNode<T> node=new LinkNode<T>(t);
            p.next=node;
            p=node;
            size++;
        }
        return head;
    }

    public   void arrayToLinkedList2(T[] array){
          LinkNode<T> head=new LinkNode<T>(null,null);

        for(T t:array){
            addLast(t);
        }

    }

    public void addFirst(T data){
        LinkNode<T> node=new LinkNode<T>(data);
        if(head.next==null) {
            head.next = node;
            size++;
            return;
        }

        node.next=head.next;
        head.next = node;
        size++;

    }
    public void addLast(T data){//加在队列尾部，这是通常情况，因为LinkedList通常是被当做Queue
        LinkNode<T> node=new LinkNode<T>(data);

        LinkNode<T> pre=head;
        for(int i=0;i<size;i++)
        {
            pre=pre.next;
        }

        pre.next=node;     //这是pre节点为末尾节点，把node添加到末尾节点后面
        size++;

    }
    public void insert(T data,int index){
        LinkNode<T> pre=head.next;
        if(index>(this.size-1)||index<0)
            return ;
        for(int i=0;i<index;i++)
        {
            pre=pre.next;
        }
        LinkNode<T> node=new LinkNode<T>(data);
        node.next=pre.next;  //在index之后的节点插入
        pre.next=node;
        size++;
    }
    public void remove(int index){
        if(index>(this.size-1)||index<0)
            return ;
        LinkNode<T> pre=head;
        for(int i=0;i<index;i++)
        {
            pre=pre.next;
        }
        LinkNode<T> node=pre.next;//node 为要删除的节点
        pre.next=node.next;
        node=null;
        size--;
    }
    public void print(){
        LinkNode<T> pre=head.next;
        for(int i=0;i<size;i++)
        {
            System.out.print(pre.data+" ");
            pre=pre.next;


        }
        System.out.println();

    }

}
