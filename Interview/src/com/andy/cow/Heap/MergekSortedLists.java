package com.andy.cow.Heap;

import java.util.PriorityQueue;

public class MergekSortedLists {

    public static void main(String[] args) {

    }
    public class ListNode {
      int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> Integer.compare(l1.val, l2.val));
        //basically you only need to compare with the heap
        //that's the reason why we can reduce the comparision time
        for(ListNode list : lists) {
            if(list == null) continue;
            pq.offer(list);
        }

        ListNode dummy = new ListNode(-1);
        ListNode iterator = dummy;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            iterator.next = node;
            iterator = node;
            if(node.next != null) {
                pq.offer(node.next);
            }

        }
        return dummy.next;
    }
}
