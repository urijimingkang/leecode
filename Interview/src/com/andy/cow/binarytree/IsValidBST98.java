package com.andy.cow.binarytree;

import com.andy.ds.TreeNode;

public class IsValidBST98 {
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
        System.out.println(isValidBST(node));
    }
    public static boolean isValidBST(TreeNode root) {
           if(root==null)
            return true;

       // if(isValidBST(root.left) &&root.left!=null&&root.val>Max(root.left)) return true;
      //  if(isValidBST(root.right) &&root.right!=null&&root.val>Min(root.right)) return true;
    //   if(isValidBST(root.left) &&root.left!=null&&root.val<Max(root.left)) return false;
   //   if(isValidBST(root.right) &&root.right!=null&&root.val>Min(root.right)) return false;
        if(isValidBST(root.left)) {
                if(root.left!=null&&root.val<Max(root.left))
                return false;
            }
        else{
                return false;
            }

         if(isValidBST(root.right)){
                if(root.right!=null&&root.val>Min(root.right))
                    return  false;
            }
            else{
                return false;
            }



return true;
    }

    public static int Min(TreeNode root) {
        int min = root.val;
        while (root != null) {
            if (root.val <= min) {
                min = root.val;
            }
            root = root.left;
        }
        return min;
    }

    public  static int Max(TreeNode root) {
        int max = root.val;
        while (root != null) {
            if (root.val >= max) {
                max = root.val;
            }
            root = root.right;
        }
        return max;
    }
}
