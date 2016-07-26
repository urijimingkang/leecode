package com.andy.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by aweng on 7/26/2016.
 */
public class TreeNode<T> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode()
    {}

    public TreeNode(T data)
    {
        this.data=data;
        this.left=null;
        this.right=null;

    }
    public TreeNode(T data,TreeNode<T> left,TreeNode<T> right)
    {
        this.data=data;
        this.left=left;
        this.right=right;
    }





}
