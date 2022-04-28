package com.andy.tiger;

import com.andy.ds.graph.AbstractGraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class TreeNodeOperation {
     static public void main(String[] args) {
        TreeNode root_3=new TreeNode(3,null,null);
        TreeNode root_7=new TreeNode(7,null,null);
        TreeNode root_4=new TreeNode(4,root_7,null);
        TreeNode root_2=new TreeNode(2,root_3,root_4);

        TreeNode root_6=new TreeNode(6,null,null);
        TreeNode root_5=new TreeNode(5,null,root_6);

        TreeNode root=new TreeNode(1,root_2,root_5);
LinkedList res=root.InOrderIterator2(root);

        System.out.println(res);
        //root.preOrderIterator(root);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public    void preOrder(TreeNode root){
        if(root!=null) {


            System.out.println(root.val);
                preOrder(root.left);


                preOrder(root.right);
        }


    }
    //层序遍历 队列
    public    void leverOrderIterator(TreeNode root){
        Deque que=new ArrayDeque();
        que.add(root);
        while(!que.isEmpty())
        {

           TreeNode node= (TreeNode) que.pop();
            System.out.println(node.val);
            if(node.left!=null)
            que.add(node.left);
            if(node.right!=null)
            que.add(node.right);
        }



    }
    //以下为三种的遍历的栈的第一 种解法
    //先序遍历 栈
    public    void preOrderIterator(TreeNode root){
        LinkedList stack=new LinkedList();
      TreeNode tmp=root;
        while(tmp!=null||!stack.isEmpty())
        {


            if(tmp!=null)
            {
                System.out.println(tmp.val);
                stack.push(tmp);
                tmp=tmp.left;

            }
            else{
                TreeNode node= (TreeNode) stack.pop();
                tmp=node.right;
            }
        }


    }
//以下为三种的遍历的栈的第二种解法----------------------------
    //先序遍历2 栈
    public    LinkedList preOrderIterator2(TreeNode root){
        LinkedList result=new LinkedList();
        LinkedList stack=new LinkedList();
       stack.push(root);
       while(!stack.isEmpty()){
         TreeNode top= (TreeNode) stack.peek();
           stack.pop();
           result.add(top);
           if(top.right!=null) stack.push(top.right);
           if(top.left!=null) stack.push(top.left);

       }

        return result;
    }
    //后序遍历2 栈
    public    LinkedList postOrderIterator2(TreeNode root) {
        LinkedList result = new LinkedList();
        LinkedList stack = new LinkedList();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = (TreeNode) stack.peek();
            stack.pop();
            result.add(top.val);

            if (top.left != null) stack.push(top.left);
            if (top.right != null) stack.push(top.right);

        }
        return result;
    }

    //中序遍历2 栈
    public    LinkedList InOrderIterator2(TreeNode root) {
        LinkedList result = new LinkedList();
        LinkedList stack = new LinkedList();
      TreeNode tmp=root;
        while (tmp!=null||!stack.isEmpty()) {
            if (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                 tmp = (TreeNode) stack.peek();
                stack.pop();
                result.add(tmp.val);
                tmp=tmp.right;

            }
        }
        return result;
    }
}