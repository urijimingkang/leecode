package com.andy.cow.graph;

import java.util.*;

class NetworkDelayTime743 {
    public static void main(String[] args) {


        int[][] times=new int[][]{{2,1,6},{2,3,6},{3,4,1},{1,4,2}};//{1,5,2},{4,5,6}
        int n = 4, k = 2;
     //int ret=  Dijkstra_origin(times,n,k);
      //  int ret=  Dijkstra_origin(times,n,k);
       int ret=  MyDijkstra(times,n,k);
      // int ret=  networkDelayTime(times,n,k);
        System.out.println(ret);}

    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<Integer, List<int[]>>();
        for (int[] time : times) {
            adjList.computeIfAbsent(time[0], kk -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        
        Map<Integer, Integer> dist = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((edge1, edge2) -> {
            return edge1[1] - edge2[1];
        });
        minHeap.offer(new int[]{k, 0});
        
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            if (dist.containsKey(curr[0])) continue;
            dist.put(curr[0], curr[1]);
            if (adjList.containsKey(curr[0])) {
                for (int[] edge : adjList.get(curr[0])) {
                    minHeap.offer(new int[]{edge[0], edge[1] + curr[1]});
                }
            }
        }
        
        if (dist.size() != n) return -1;
        int ret = Integer.MIN_VALUE;
        for (int kkk : dist.keySet()) {
            ret = Math.max(ret, dist.get(kkk));
        }
        
        return ret;
    }

    public static int networkDelayTime_Dijkstra(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<Integer, List<int[]>>();
        for (int[] time : times) {
            adjList.computeIfAbsent(time[0], kk -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        Map<Integer, Integer> dist = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((edge1, edge2) -> {
            return edge1[1] - edge2[1];
        });
       // Queue<int[]> minHeap=new LinkedList();      //用一般队列


        minHeap.offer(new int[]{k, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            if (dist.containsKey(curr[0])) continue;
            dist.put(curr[0], curr[1]);

           // int candNode = -1;
            //用一般队列
           /* int candDist = Integer.MAX_VALUE;
            for (int i = 1; i <= n; ++i) {
                if ( dist.get(i) < candDist) {
                    curr[1] = dist.get(i);
                  //  candNode = i;
                }
            }*/


            if (adjList.containsKey(curr[0])) {
                for (int[] edge : adjList.get(curr[0])) {

                    minHeap.offer(new int[]{edge[0],edge[1] + curr[1]});
                }
            }
        }

        if (dist.size() != n) return -1;
        int ret = Integer.MIN_VALUE;
        for (int kkk : dist.keySet()) {
            ret = Math.max(ret, dist.get(kkk));
        }

        return ret;
    }

    static Map<Integer, Integer> dist;
    public static int Dijkstra_origin(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        dist = new HashMap();
        for (int node = 1; node <= N; ++node)
            dist.put(node, Integer.MAX_VALUE);

        dist.put(K, 0);
        boolean[] seen = new boolean[N+1];

        while (true) {
            int candNode = -1;
            int candDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; ++i) {
                if (!seen[i] && dist.get(i) < candDist) {
                    candDist = dist.get(i);
                    candNode = i;
                }
            }

            if (candNode < 0) break;
            seen[candNode] = true;
            if (graph.containsKey(candNode))
                for (int[] info: graph.get(candNode))
                    dist.put(info[0],
                            Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
        }

        int ans = 0;
        for (int cand: dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }
    public static int MyDijkstra(int[][] times, int N, int K){
        HashMap<Integer, List<int[]>> graph=new HashMap();
        for (int [] time:times
             ) {
            graph.computeIfAbsent(time[0], kk -> new ArrayList<>()).add(new int[]{time[1], time[2]});

        }
        /*for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }*/
        HashMap<Integer, Integer> dist=new HashMap();

        boolean[] seen = new boolean[N+1];
        for (int i = 1; i <=N ; ++i) {
            dist.put(i, Integer.MAX_VALUE);
        }
        dist.put(K,0);

        while(true){
            int cadNode=-1;
            int candDist = Integer.MAX_VALUE;
            for (int i = 1; i <=N; ++i) {
                if(!seen[i] &&dist.get(i)<candDist){
                    candDist=dist.get(i);
                    cadNode=i;
                }
            }
            if(cadNode==-1) break;
            seen[cadNode]=true;
            if (graph.containsKey(cadNode))
            for (int[] edge:
                 graph.get(cadNode)) {
                dist.put(edge[0],Math.min(dist.get(edge[0]),dist.get(cadNode)+edge[1]));
            }

        }
        int ans = 0;
        for (int cand: dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;

    }
}