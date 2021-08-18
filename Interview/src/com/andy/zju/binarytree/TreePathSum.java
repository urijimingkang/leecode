package com.andy.zju.binarytree;

import com.andy.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreePathSum {
    static List<Integer>  res=new ArrayList<>();
    public static void main(String[] args) {
        TreeNode node=new TreeNode();
        TreeNode left=new TreeNode();
        TreeNode right=new TreeNode();
        TreeNode left2=new TreeNode();
        TreeNode right2=new TreeNode();
        node.val =2;

        right.val =3;
        left.val =1;
        right2.val =5;
        left2.val =6;
        node.left=left;
        node.right=right;
        right.right=right2;
        right.left=left2;
        System.out.println(treePathSum(node,2));
    }
    public static boolean treePathSum(TreeNode root,int target) {
        if(root!=null&&root.val==target&&(root.left==null&&root.right==null)) {

            return true;
        }
        if(root!=null&&root.val==target) {
            res.add(root.val);
            return true;
        }else {
            boolean bleft=false;
            boolean bright=false;
            if(root!=null&&root.left!=null)
             bleft=treePathSum(root.left,target-root.val);
            if(root!=null&&root.right!=null)
                bright=treePathSum(root.right,target-root.val);
            return bleft|| bright;
        }





    }


}
