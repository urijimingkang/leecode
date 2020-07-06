package com.andy.leecode;

public class AddTwoNumbers {
/*    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.*/

    public static void main(String[]ss){
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        AddTwoNumbers twosum=new AddTwoNumbers();
        ListNode res= twosum.addTwoNumbers(l1,l2);
        System.out.println(res);
    }


        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(l1.val+l2.val);
            ListNode cur= head;
            ListNode next=null;
            while(l1!=null||l2!=null)
            {
                l1=l1.next;
                l2=l2.next;



               int tmp= (l1==null?0:l1.val)+(l2==null?0:l2.val)+(cur.next==null?0:cur.next.val);
               if(tmp<10)
                next=new ListNode(tmp%10);
               else
               {
                   next=new ListNode(tmp%10);

                   ListNode carry=new ListNode(1);
                   next.next=carry;

               }
                cur.next=next;
                cur=next;



            }

            ListNode tmp=head;
            ListNode tmp_pre=head;
            while(tmp.next!=null) {
                tmp_pre=tmp;
                tmp = tmp.next;

            }
            tmp_pre.next=null;


            return head;
        }
}

