package com.andy.cow.binarytree;

import com.andy.ds.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class ZigzagLayerTranverseBinaryTree {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(36);
        TreeNode left=new TreeNode(26);
        TreeNode right=new TreeNode(47);

        TreeNode left2=new TreeNode(19);
        TreeNode right2=new TreeNode(56);
        TreeNode right3=new TreeNode(27);

        node.left=left;
        node.right=right;
        left.left=left2;
        right.right=right2;
        left2.right=right3;
        List<List> res=zigzagLayerTranverseBinaryTree(node);
        System.out.println(res);

    }
    public static List<List>  zigzagLayerTranverseBinaryTree(TreeNode root){
        List<List> res=new ArrayList<List>();
        if(root==null){
            return res;
        }
//hashtable ->hashmap->sychronoizedhasmmap(currcencyHashmap)
        Queue q= new LinkedList();
        q.offer(root);
        int cnt=0;
        while(!q.isEmpty())
        {
            cnt=cnt+1;
            Deque<Integer> list=new LinkedList<Integer>();
            int n=q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node= (TreeNode) q.poll();
                if(cnt%2==1) {
                    list.add(node.val);
                }
                else{
                    list.addFirst(node.val);
                }
                //System.out.println(q.size());
               // if(cnt%2==0) {
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
               // }else{
               //     if (node.right != null) q.offer(node.right);
                //    if (node.left != null) q.offer(node.left);

              //  }
            }
            res.add(list.stream().collect(Collectors.toList()));



        }
        return  res;
    }
}
