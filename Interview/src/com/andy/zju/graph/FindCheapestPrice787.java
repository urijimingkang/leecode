package com.andy.zju.graph;

import com.andy.ds.graph.AbstractGraph;
import com.andy.ds.graph.Graph;
import com.andy.ds.graph.UnweightedGraph;

import java.util.*;

public class FindCheapestPrice787 {

    static int INF = 1000007;

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return bfs(n, flights, src, dst, k);
    }

    private static int bfs(int n, int[][] flights, int src, int dst, int k) {
        // 整理题目给定的flights，转换成每个节点的子节点有哪些
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            g[flight[0]].add(new int[] {flight[1], flight[2]});
        }

        // 表示src到i到最小价格
        int[] ans = new int[n];
        Arrays.fill(ans, INF);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src, 0});
        // 退出条件加上 k 的限制
        while (!queue.isEmpty() && k + 1 > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] path : g[poll[0]]) {
                    int distance = poll[1] + path[1];
                    // 剪枝1，小于 i 之前记录的最小值，且小于 dst 之前记录的最小值
                    if (distance < ans[path[0]] && distance < ans[dst]) {
                        ans[path[0]] = distance;
                        // 剪枝2，到 dst 了就不用继续往下了
                        if (path[0] != dst) {
                            queue.offer(new int[] {path[0], distance});
                        }
                    }
                }
            }
            k--;
        }

        return ans[dst] >= INF ? -1 : ans[dst];
    }
    private int dp(int n, int[][] flights, int src, int dst, int K) {
        // dp[i][k]表示从i点到dst走k步的最少价格
        // dp[i][k]=min(dp[i_next][k-1] + g[i][j])
        int ans = INF;

        int[][] dp = new int[2][n];
        Arrays.fill(dp[0], INF);
        dp[0][dst] = 0;
        for (int k = 1; k <= K + 1; k++) {
            // 防止之前的值干扰，每次都要初始化
            Arrays.fill(dp[k & 1], INF);
            for (int[] flight : flights) {
                dp[k & 1][flight[0]] = Math.min(dp[k & 1][flight[0]], dp[(k - 1) & 1][flight[1]] + flight[2]);
            }
            ans = Math.min(ans, dp[k & 1][src]);
        }

        return ans >= INF ? -1 : ans;
    }



    public static void main(String[] args) {
       int n = 4;
       int [][] edges1 =new int[][]{{0,1,100},{1,2,100},{0,2,500},{2,3,700}};
        int src = 0, dst = 3, k = 2;
        findCheapestPrice(n,edges1,src,dst,k);







        String[] vertices = {"Settle", "San Francisco", "los angeles",
                "denver", "kansas City", "chicago", "Boston", "new york",
                "atlanta", "miami", "dallas", "houston"};
        int[][] edges = {
               // {0, 1}, {0, 3}, {0, 5}, {1, 0}, {1, 2}, {1, 3}, {2, 1}, {2, 3}, {2, 4}, {2, 10}, {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5}, {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10}, {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7}, {6, 5}, {6, 7}, {7, 4}, {7, 5}, {7, 6}, {7, 8}, {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11}, {9, 8}, {9, 11}, {10, 2}, {10, 4}, {10, 8}, {10, 11}, {11, 8}, {11, 9}, {11, 10}
                {0, 1,1}, {0, 3,2}, {0, 5,3},  {1, 2,4}, {1, 3,2},  {2, 3,5}, {2, 4,5}, {2, 10,6},  {3, 1,5},  {3, 4,8}, {3, 5,4},  {4, 5,}, {4, 7,3}, {4, 8,2}, {4, 10,3},  {5, 6,2}, {5, 7,1}, {6, 7,3},  {7, 8,1},  {8, 9,1}, {8, 10,1}, {8, 11,1}, {9, 11,1},  {10, 11,1}
        };
        Graph<String> graph1 = new UnweightedGraph<String>(edges, vertices);
        System.out.println("the number of vertices of graph1 is " + graph1.getSize());
        System.out.println("the vertices with index 1 is: " + graph1.getVertex(1));
        System.out.println("the index for miami is " + graph1.getIndex("miami"));
        System.out.println("The edges for graph1:");
        graph1.printEdges();
        AbstractGraph.Tree tr=graph1.bfs(0);
        System.out.println("Adjacency matrix for graph1:");
        graph1.printAdjacencyMatrix();


       /* String[] names = {"Peter", "Jane", "Mark", "Cindy", "Wendy"};
        java.util.ArrayList<AbstractGraph.Edge> edgeList = new java.util.ArrayList<AbstractGraph.Edge>();
        edgeList.add(new AbstractGraph.Edge(0, 2));
        edgeList.add(new AbstractGraph.Edge(1, 2));
        edgeList.add(new AbstractGraph.Edge(2, 4));
        edgeList.add(new AbstractGraph.Edge(3, 4)); // Create a graph with 5 vertices
        Graph<String> graph2 = new UnweightedGraph<String>(edgeList, Arrays.asList(names));
        System.out.println("The number of vertices in graph2: " + graph2.getSize());
        System.out.println("The edges for graph2:");
        graph2.printEdges();
        System.out.println("\nAdjacency matrix for graph2:");
        graph2.printAdjacencyMatrix();
        for (int i = 0; i < 5; i++) System.out.println("vertex " + i + ": " + graph2.getVertex(i));*/


     /*   int[][] edge = {
                {
                        0, 1
                }, {
                0, 3
        }, {
                0, 4
        }, {
                1, 2
        }, {
                1, 4
        }, {
                2, 0
        }, {
                2, 2
        }, {
                2, 4
        }, {
                3, 0
        }, {
                3, 2
        }, {
                3, 4
        }, {
                4, 0
        }, {
                4, 2
        }, {
                4, 4
        }
        };
        Graph<Integer> graph3 = new UnweightedGraph<Integer>(edge, 5);
        System.out.println("the number of vertices in graph3: " + graph3.getSize());
        graph3.printAdjacencyMatrix();
        graph3.printEdges();*/
    }
}