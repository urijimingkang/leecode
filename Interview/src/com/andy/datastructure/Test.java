package com.andy.datastructure;

public class Test {
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
}
