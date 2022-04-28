package com.andy.cow.binarytree;

import com.andy.ds.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LevelTranverseBinaryTreeFromBottom {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(36);
        TreeNode left=new TreeNode(26);
        TreeNode right=new TreeNode(47);

        TreeNode left2=new TreeNode(19);
        TreeNode right2=new TreeNode(56);
        TreeNode right3=new TreeNode(27);

        node.left=left;
        node.right=right;
       // left.left=left2;
     //   right.right=right2;
       // left2.right=right3;
        List<List<Integer>> res=levelOrderBottom(node);
        System.out.println(res);

    }
  static  Deque<List<Integer>> res=new LinkedList<List<Integer>>();
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null)
            return null;
        Queue q=new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int cnt=q.size();

            List<Integer> cur=new ArrayList<>();
            for (int i = 0; i <cnt ; i++) {
                TreeNode node=(TreeNode)q.poll();
                cur.add(Integer.valueOf(node.val));
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
            }
            res.addFirst(cur);

        }
        List<List<Integer>> ret=  res.stream().collect(Collectors.toList());

        return ret;
    }
}