package com.andy.cow.binarytree;

import com.andy.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LayerTranverseBinaryTree {
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
        List<List> res=layerTranverseBinaryTree(node);
        System.out.println(res);

    }
    public static List<List>  layerTranverseBinaryTree(TreeNode root){
        List<List> res=new ArrayList<List>();
        if(root==null){
            return res;
        }
//hashtable ->hashmap->sychronoizedhasmmap(currcencyHashmap)
        Queue q= new LinkedList();
        q.offer(root);
        while(!q.isEmpty())
        {
            List list=new ArrayList<>();
            int n=q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node= (TreeNode) q.poll();
                list.add(node.val);
                //System.out.println(q.size());
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            res.add(list);



        }
        return  res;
    }
}
