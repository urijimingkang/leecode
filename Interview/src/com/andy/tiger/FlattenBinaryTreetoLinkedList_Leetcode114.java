package com.andy.tiger;
//未完成
import java.util.LinkedList;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
/*Input: root = [1,2,5,3,4,null,6]
        Output: [1,null,2,null,3,null,4,null,5,null,6]*/
public class FlattenBinaryTreetoLinkedList_Leetcode114 {

    static LinkedList list = new LinkedList();

    public static void main(String[] args) {

    }

    public static void flatten(InnerTreeNode root) {

        if (root != null) {

            list.add(root);
            //System.out.println(root.val);
            preOrder(root.left);


            preOrder(root.right);
        }
        return;
    }

    public static void preOrder(InnerTreeNode root) {


    }
}
   class InnerTreeNode {
      int val;
       InnerTreeNode left;
       InnerTreeNode right;
       InnerTreeNode() {}
       InnerTreeNode(int val) { this.val = val; }
       InnerTreeNode(int val, InnerTreeNode left, InnerTreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
