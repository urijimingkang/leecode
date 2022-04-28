package com.andy.cow.binarytree;

import com.andy.ds.TreeNode;

class LowestCommonAncestor {
    class Result {
        public TreeNode ans;
        public int count; 
        Result(TreeNode a, int c) {
            ans = a; count = c; 
        }
    }
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        return helper(root, p, q).ans; 
    }
    
    Result helper(TreeNode root, int p, int q) {
        if(root == null) {
            return new Result(null, 0); 
        }
        
        Result left = helper(root.left, p, q); 
        Result right = helper(root.right, p, q); 
        
        if(left.ans != null) {
            return new Result(left.ans, 2); 
        }
        if(right.ans != null) {
            return new Result(right.ans, 2); 
        }
        
        int count = root.val == p || root.val == q ? 1 : 0;
        
        count += left.count + right.count; 
        
        return new Result(count == 2 ? root:null, count);
    }
}