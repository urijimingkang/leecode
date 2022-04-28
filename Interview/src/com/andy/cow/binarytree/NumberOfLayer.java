package com.andy.cow.binarytree;

import com.andy.ds.TreeNode;

public class NumberOfLayer {
    public static void main(String[] args) {
        TreeNode node=new TreeNode();
        TreeNode left=new TreeNode();
        TreeNode right=new TreeNode();
        node.val =2;

        right.val =3;
        left.val =1;
        node.left=left;
        node.right=right;
        System.out.println(numberOfLayer(node));
    }
    public static int numberOfLayer(TreeNode root) {
        if(root==null)
            return 0;

            return Math.max(numberOfLayer(root.left),numberOfLayer(root.right))+1;



    }

    public static TreeNode Max(TreeNode root){
        if(root==null)
            return null;

        TreeNode left;
        TreeNode right;
        TreeNode max=root;
        left= Max(root.left);
        right = Max(root.right);
        if(left!=null&&root.val <left.val) {
            max=left;

        }
        if(right!=null&&root.val <right.val) {
            max=right;
        }
        return max;



    }
    public static TreeNode Min(TreeNode root){
        if(root==null)
            return null;

        TreeNode left;
        TreeNode right;
        TreeNode min=root;
        left= Min(root.left);
        right = Min(root.right);
        if(left!=null&&root.val >left.val) {
            min=left;

        }
        if(right!=null&&root.val >right.val) {
            min=right;
        }
        return min;



    }
}
