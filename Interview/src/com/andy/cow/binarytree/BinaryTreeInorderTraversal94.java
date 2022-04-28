package com.andy.cow.binarytree;

import com.andy.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
   static List<Integer> list=null;
    public static void main(String[] args) {
        TreeNode node=new TreeNode();
        TreeNode left=new TreeNode();
        TreeNode right=new TreeNode();
        node.val =1;
        node.right=right;
        right.val =2;
        right.left=left;
        left.val =3;

        list=inorderTraversal(node);

    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        if(list==null)
            list=new ArrayList<Integer>();
        if(root!=null)
        {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
}
