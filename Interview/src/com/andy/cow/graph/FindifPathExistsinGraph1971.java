package com.andy.cow.graph;

import java.util.*;

class FindifPathExistsinGraph1971 {
    public static void main(String[] args) {
          //int[][] edges=new int[][]{{0,1},{1,2},{2,0}};
         // System.out.println(validPath(3,edges,0,2));
      //  int[][] edges=new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}};
      //  System.out.println(validPath(6,edges,0,5));

      //  int[][] edges=new int[][]{{       0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
      //  System.out.println(validPath(10,edges,7,5));
        int [][] edges=new int[][]
             {{31,5},{10,46},{19,31},{5,1},{31,28},{28,29},{8,26},{13,23},{16,34},{30,1},{16,18},{33,46},{27,35},{2,25},{49,33},{44,19},{22,26},{30,13},{27,12},{8,16},{42,13},{18,3},{21,20},{2,17},{5,48},{41,37},{39,37},{2,11},{20,26},{19,43},{45,7},{0,21},{44,23},{2,39},{27,36},{41,48},{17,42},{40,32},{2,28},{35,38},{3,9},{41,30},{5,11},{24,22},{39,5},{40,31},{18,35},{23,39},{20,24},{45,12}};
        System.out.println(validPath(50,edges,29,46));
    }
    public static boolean validPath(int n, int[][] edges, int start, int end) {
        boolean flag=false;
        List<List<Integer>> g=new ArrayList();
         for(int i=0;i<n;i++){
            List<Integer> item=new ArrayList();
           g.add(item);
           }
        for(int i=0;i<edges.length;i++){
           //  List<Integer> numlist=new ArrayList();
           //  numlist.add();
           g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);

        }
        Queue<List<Integer>> q=new LinkedList();
        Set visited=new HashSet();
        visited.add(start);
            q.offer(g.get(start));

            while(!q.isEmpty()){
             List<Integer> pol=q.poll();
             for(Integer nod:pol){
                 if(!visited.contains(nod)){
                     visited.add(nod);
                     q.offer(g.get(nod));
                     System.out.println(nod);
                 }
                 if(nod==end)
                 {flag=true;
                 return true;
                 }

             }

            }

            return flag;

    }
}