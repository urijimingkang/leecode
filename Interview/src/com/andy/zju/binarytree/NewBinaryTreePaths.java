package com.andy.zju.binarytree;

import com.andy.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NewBinaryTreePaths {
    static List<String> res = new ArrayList<String>();

    public static void main(String[] args) {
        TreeNode node=new TreeNode();
        TreeNode left=new TreeNode();
        TreeNode right=new TreeNode();
        TreeNode left2=new TreeNode();
        TreeNode right2=new TreeNode();
        node.val =1;

        right.val =3;
        left.val =2;
        right2.val =5;
        //  left2.val =6;
        node.left=left;
        node.right=right;
        left.right=right2;
        // right.left=left2;
        System.out.println(binaryTreePaths(node));
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        helper(root,sb);

        return res;
    }

    public static void helper(TreeNode root, StringBuilder sb){
        if(root == null){
            return ;
        }
        //到leaf node了
        if(root.left == null && root.right == null){
            sb.append(root.val);
            res.add(sb.toString());
            return;
        }

        sb.append(root.val + "->");
        helper(root.left, new  StringBuilder(sb));
        helper(root.right, new  StringBuilder(sb));
    }
}
