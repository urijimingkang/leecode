package com.andy.zju.binarytree;

import com.andy.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathsZJH {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
    }
    List<String> res = new ArrayList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        helper(root,sb);

        return res;
    }

    public void helper(TreeNode root, StringBuilder sb){
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
        helper(root.left, sb);
        helper(root.right, sb);
        sb.deleteCharAt(sb.length()-3);

    }

}
