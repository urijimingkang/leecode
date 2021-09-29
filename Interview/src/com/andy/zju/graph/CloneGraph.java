package com.andy.zju.graph;

import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {
        Node node1=new Node();
        Node node2=new Node();
        Node node3=new Node();
        Node node4=new Node();
        node1.val=1;
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.val=2;
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.val=3;
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.val=4;
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        cloneGraph(node1);


    }
    public static Node cloneGraph(Node node) {

        Map<Node,Node> Map=new HashMap();
       // Map<Node,Node> Map2=new HashMap<>();

        //return DFS_findneighbor(node,Map);
        return BFS_findneighbor(node,Map);
        
    }
     public static Node DFS_findneighbor(Node node, Map<Node,Node> Map) {
         Node src=new Node(node.val,new ArrayList<>());
         if(Map.containsKey(node))
             return Map.get(node);
         Map.put(node,src);
        for(Node neighbor:node.neighbors){

                src.neighbors.add(DFS_findneighbor(neighbor,Map));


        }
        return src ;

     }
    public static Node BFS_findneighbor(Node node, Map<Node,Node> Map) {
        Node dst=new Node(node.val,new ArrayList<>());
        Map.put(node,dst);

        Queue<Node> q=new LinkedList<>();
        q.offer(node);
       while (!q.isEmpty()){
           Node tmp=q.poll();
           for (Node nod:tmp.neighbors){
               if(!Map.containsKey(nod)){
                  Node srctmp=new Node(nod.val,new ArrayList<>());
                   Map.put(nod,srctmp);
                   q.offer(nod);
               }
               Map.get(tmp).neighbors.add(Map.get(nod));
           }

       }
return dst;
    }
}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}