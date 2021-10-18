package com.andy.zju.binarytree;

import com.andy.ds.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        int ans = 0; 
        while(queue.size() > 0) {
            int size = queue.size(); 
            int start = 0; 
            int end = 0; 
            
            for(int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> cur = queue.poll(); 
                TreeNode curNode = cur.getKey(); 
                Integer idx = cur.getValue(); 
                
                if(i == 0) start = idx; 
                if(i == size -1) end = idx; 
                
                if(curNode.left != null) {
                    queue.offer(new Pair<>(curNode.left, 2 * idx)); 
                }
                
                if(curNode.right != null) {
                    queue.offer(new Pair<>(curNode.right, 2 * idx + 1)); 
                }
            }
            
            int val = end - start + 1; 
            ans = Math.max(ans, val); 
        }
        return ans; 
        
    }
}