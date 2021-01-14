package com.andy.interview;
import com.andy.ds.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by aweng on 7/26/2016.
 */
public class MyBinaryTree<T> {
    public void printTreePre(TreeNode root)
    {
        if(root!=null) {
            System.out.println(root.data);
            printTreePre(root.left);
            printTreePre(root.right);
        }
    }
    public void printTreeIn(TreeNode root)
    {
        if(root!=null) {
            printTreeIn(root.left);
            System.out.println(root.data);
            printTreeIn(root.right);
        }
    }
    public void printTreePro(TreeNode root)
    {
        if(root!=null) {
            printTreePro(root.left);
            printTreePro(root.right);
            System.out.println(root.data);
        }
    }
    public void printTreeLevel(TreeNode root)
    {  Queue queue=new LinkedList<T>();
        queue.offer(root);
        while(!queue.isEmpty()){

            TreeNode<T> node=(TreeNode<T>)queue.poll();

            System.out.println(node.data);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }

    }



    //比较有创意的层序遍历，创建二叉树 //int []arr=[1,2,3,null,4,null, 5]，数组顺序是刚好层序遍历的次序，2 和3为1的子节点
    static int i=0;
    public void  createTree(TreeNode root,T[] array){
        Queue queue=new LinkedList<T>();
        TreeNode tmp1,tmp2;
        if(i==0){
            queue.offer(root);
            i++;
        }

        while(!queue.isEmpty()&&i<array.length){
            if(i<array.length&&array[i]!=null)
                tmp1=new TreeNode(array[i]);else
                tmp1=null;
            if((i+1)<array.length&&array[i+1]!=null)
                tmp2=new TreeNode(array[i+1]);else
                tmp2=null;
            i+=2;
            TreeNode<T> node=(TreeNode<T>)queue.poll();
            node.left=tmp1;
            node.right=tmp2;

            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }

    }
    public  TreeNode arrayToList(T[] array){   //int []arr=[1,2,3,null,4,null, 5]

        TreeNode root=new TreeNode(array[0]);
        createTree(root,array);
        return root;
    }
    //对称翻转一棵二叉树
    public void reverseTree(TreeNode<T> root)
    {
        if(root!=null) {
            reverseTree(root.left);
            TreeNode<T> tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            reverseTree(root.left);
        }

    }

    //求一棵树高度
    public int maxDepth(TreeNode<T> root)
    {
        if(root==null)
            return 0;
        int leftDep=maxDepth(root.left);
        int rightDep=maxDepth(root.right);
       return Math.max(leftDep, rightDep)+1;

    }

    public static void main(String[] ss){
        MyBinaryTree t=new MyBinaryTree();
        Integer [] arr=new Integer[]{1,2,3,null,4,null, 5};
        TreeNode ret=  t.arrayToList(arr);
        t.printTreePre(ret);
      //  t.printTreeLevel(ret);
      //  t.reverseTree(ret);
      //  t.printTreeLevel(ret);
       System.out.println(t.maxDepth(ret));
    }
}
