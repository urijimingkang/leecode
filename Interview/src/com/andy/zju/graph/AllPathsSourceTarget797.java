package com.andy.zju.graph;

import java.util.*;

class AllPathsSourceTarget797 {
    public static void main(String[] args) {
        int[][] edges=new int[][]{{1},{2},{3},{}};
         System.out.println(allPathsSourceTarget3(edges));
    }

   //错误的方法，需要修改b//  add in brasdfaanch  merger test  // add to masfsdfter
    public static List<List<Integer>> allPathsSourceTarget3(int[][] graph) {
        List<List<Integer>> paths=new ArrayList<List<Integer>>();
        List<Integer>[] g=new List[graph.length]; //
         //Map<Integer,List<Integer>> g=new HashMap();
        for(int i=0;i<graph.length;i++){
           // List<Integer> item=new ArrayList();
            g[i]=new ArrayList<>();
        }
        for(int i=0;i<graph.length;i++){

            for(int j=0;j<graph[i].length;j++)
            {
                g[i].add(graph[i][j]);
            }

        }
        Queue<List<Integer>> q=new LinkedList();
        Stack stack=new Stack();
        Set visited=new HashSet();
        visited.add(0);
        ArrayList path=new ArrayList();
        path.add(0);
        q.offer(g[0]);
        int dstNode= graph.length - 1;

        while(!q.isEmpty()) {
            List<Integer> pol = q.poll();
            //   List<Integer> neighs=g.get();
            // else {
            // if (pol.get(pol.size()-1)==dstNode) {
            //     paths.add((new ArrayList<>(pol)));
            // }else
            for (Integer nod : pol) {

                if (!visited.contains(nod)) {
                path.add(nod);
               List<Integer> newpath = new ArrayList(path);

                   visited.add(nod);
                    path.remove(path.size()-1);
                   q.add(g[nod]);
                if (nod==dstNode) {
                    paths.add((new ArrayList<>(path)));
                 }else{

                }
                   }

            }
        }
        return paths;

    }
// correct
    public static List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> paths=new ArrayList<List<Integer>>();
        List<List<Integer>> g=new ArrayList();
        for(int i=0;i<graph.length;i++){
            List<Integer> item=new ArrayList();
            g.add(item);
        }
        for(int i=0;i<graph.length;i++){

            for(int j=0;j<graph[i].length;j++)
            {
                g.get(i).add(graph[i][j]);
            }

        }
        Queue<List<Integer>> q=new LinkedList();
        Set visited=new HashSet();
        visited.add(0);
        ArrayList path=new ArrayList();
        path.add(0);
        q.offer(Arrays.asList(0));
        int dstNode= graph.length - 1;
        //ArrayList newpath=new ArrayList();
        while(!q.isEmpty()) {
            List<Integer> pol = q.poll();
            if (pol.get(pol.size() - 1) ==dstNode) {
                paths.add((new ArrayList<>(pol)));

            } else {
                for (Integer nod :graph[pol.get(pol.size() - 1)]) {

                // if (!visited.contains(nod)) {

                    List<Integer>   newpath = new ArrayList(pol);
                        newpath.add(nod);
                        visited.add(nod);
                        q.add(newpath);

             //     }




                }

            }
        }
        return paths;

    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths=new ArrayList<List<Integer>>();
List<List<Integer>> g=new ArrayList();
         for(int i=0;i<graph.length;i++){
            List<Integer> item=new ArrayList();
           g.add(item);
           }
        for(int i=0;i<graph.length;i++){
           //  List<Integer> numlist=new ArrayList();
           //  numlist.add();
           for(int j=0;j<graph[i].length;j++)
           {
                g.get(i).add(graph[i][j]);
           }
          
        }
         Queue<Node> q=new LinkedList();
        q.offer(new Node(0));
        Set visited=new HashSet();
        visited.add(0);
      //  ArrayList path=new ArrayList();
       // path.add(0);
        //    q.offer(g.get(0));

            while(!q.isEmpty()){
             Node pol=q.poll();
                if(pol.index==graph.length-1)
                {
                    paths.add(pol.path);

                };
             for(int nod:graph[pol.index]){

               //  if(!visited.contains(nod)){



                     visited.add(nod);
                     q.offer(new Node(nod,pol.path));



                 

             }

            }
            return paths;

    }
    static class Node {
        int index;
        List<Integer> path;

        Node(int index) {
            this.index = index;
            this.path = new ArrayList<>();
            // 把当前节点加入路径
            this.path.add(index);
        }

        Node(int index, List<Integer> path) {
            this.index = index;
            // 复制一个新的List
            this.path = new ArrayList<>(path);
            // 把当前节点加入路径
            this.path.add(index);
        }
    }


}