package com.andy.zju.binarytree;

import com.andy.ds.TreeNode;

class MinDepth111 {
    public int minDepth(TreeNode root) {
  if(root==null)
        return 0;
        if(root!=null&&root.left!=null&&root.right!=null)
return Math.min(minDepth(root.left),minDepth(root.right))+1;
else{
    return Math.max(minDepth(root.left),minDepth(root.right))+1;
}
    }
}