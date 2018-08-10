package com.andy.interview;

import com.andy.datastructure.LinkNode;

/**
 * Created by aweng on 7/6/2016.
 */
public class RotateLinkedList<T> {


    public void iteratePrint(LinkNode<T> p){




        if(p!=null&&p.data!=null) {
            System.out.print(p.data + " ");
            iteratePrint(p = p.next);
        }



        System.out.println();


    }


    public LinkNode<T> rotateLink(LinkNode<T> head ){
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


    public LinkNode<T>  rotateLinkAtPosition(LinkNode start,int k){ // 1->2->3->4->5->6 k=2  =>3->4->5->6->1->2
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




    public static void main(String [] args){
        int[] arr=new int[]{1,2,3,4,5,6};
        RotateLinkedList t=new RotateLinkedList();
        LinkNode head= LinkNode.arrayToList(arr);


       LinkNode tmpNode= t.rotateLinkAtPosition(head,2);
        LinkNode.printList(tmpNode);

    }
}
