package com.andy.cow.graph;

import java.util.*;

public class FindCheapestPrice787 {

    static int INF = 1000007;

    //method2
    static int final_sum=10000;

    //method3
    static int minSum = Integer.MAX_VALUE;
    static int K=2;
    // static int dst;
    static Map<Integer, Map<Integer, Integer>> costs;
    public static void main(String[] args) {
        int n = 4;
        int [][] edges1 =new int[][]{{0,1,100},{1,2,100},{0,2,500},{2,3,700}};
        int src = 0, dst = 3, k = 2;
        System.out.println(findCheapestPrice(n,edges1,src,dst,k+1));


    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
     //method1
      // return bfs(n,flights,src,dst,k);

        //method2
       // dfs_frombfs(n, flights,null,src, dst,k,0,new HashSet<Integer>(),null);
       // return final_sum;

        //method3
        costs = generateMap(flights);
        dfs(src, 3, 0,0, new HashSet<Integer>());
       return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }




    private static void  dfs_frombfs(int n, int[][] flights, List<int[]>[] g,int src, int dst, int k,   int sum,Set<Integer> visited,int[] ans  ) {
        visited.iterator().next();
        if(ans==null)
        {
             ans = new int[n];
            Arrays.fill(ans, INF);
        }
        if(g==null){
            g = new List[n];

            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();

            }

            for (int[] flight : flights) {
                g[flight[0]].add(new int[] {flight[1], flight[2]});
            }
        }

        if(k<0)
            return;
        if (src==dst)
            final_sum=Math.min(final_sum,sum);
        if (visited.contains(src) || k ==0 || sum >= final_sum) {
            return;
        }

        //if (!g[].containsKey(src) || visited.contains(src) || k == K + 1 || sum >= minSum) {
       //     return;
       // }
        visited.add(src);
        //  int[] poll = g[src];
        for (int[] path : g[src]) {

            sum +=   path[1];
            // ??????1????????? i ???????????????????????????????????? dst ????????????????????????
          if ( !visited.contains(path[0])&&sum < ans[path[0]] && sum <final_sum) {
               ans[path[0]] = sum;
            dfs_frombfs(n,flights,g,path[0],dst,k-1,path[1],visited,ans);
            }
        }
        visited.remove(src);
        return ;

    }
   /* private static void dfs(int n, int[][] flights, List<int[]>[] g,int src, int dst, int k,   int[] ans,boolean[]visited ) {

            if(k<0)
                return;
            if (src==dst)
                return;
        visited[src]=true;
              //  int[] poll = g[src];
                for (int[] path : g[src]) {
                    int distance =0;
                    distance +=   path[1];
                    // ??????1????????? i ???????????????????????????????????? dst ????????????????????????
                    if ( !visited[path[0]]&&distance < ans[path[0]] && distance < ans[dst]) {
                        ans[path[0]] = distance;
                    }
                    dfs(n,flights,g,path[0],dst,k-1,ans,visited);
                }
        return ;
       // return 0;
    }*/
   // ?????????tong-zhu
   //?????????https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/solution/tong-ge-lai-shua-ti-la-yi-ti-si-jie-bfs-deqpt/
   //???dfs??????????????????memo??????
   private int dfs2(int[][] flights, int i, int dst, int k, int[][] memo) {
       if (k < 0) {
           return INF;
       }

       if (i == dst) {
           return 0;
       }

       if (memo[i][k] != 0) {
           return memo[i][k];
       }

       int min = INF;
       for (int[] flight : flights) {
           // ?????? i ??????????????????
           if (flight[0] == i) {
               min = Math.min(min, dfs2(flights, flight[1], dst, k - 1, memo) + flight[2]);
           }
       }

       memo[i][k] = min;

       return min;
   }

    private static void dfs(int src, int dst, int k, int sum, Set<Integer> visited) {
        if (src == dst) {
            minSum = Math.min(minSum, sum);
        }

        // P1: ???????????????DFS?????????TLE?????????????????????sum >= minSum??????????????????????????????dfs???????????????????????????
        if (!costs.containsKey(src) || visited.contains(src) || k == K + 1 || sum >= minSum) {
            return;
        }

        Map<Integer, Integer> map = costs.get(src);
        visited.add(src);
        for (int next : map.keySet()) {
            dfs(next, dst,k + 1, sum + map.get(next), visited);
        }
        visited.remove(src);
    }

    private static Map<Integer, Map<Integer, Integer>> generateMap(int[][] flights) {
        Map<Integer, Map<Integer, Integer>> ans = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            ans.putIfAbsent(flights[i][0], new HashMap<Integer, Integer>());
            ans.get(flights[i][0]).put(flights[i][1], flights[i][2]);
        }
        return ans;
    }
    private static int bfs(int n, int[][] flights, int src, int dst, int k) {
        // ?????????????????????flights?????????????????????????????????????????????
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            g[flight[0]].add(new int[] {flight[1], flight[2]});
        }

        // ??????src???i???????????????
        int[] ans = new int[n];
        Arrays.fill(ans, INF);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src, 0});
        // ?????????????????? k ?????????
        while (!queue.isEmpty() && k + 1 > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] path : g[poll[0]]) {
                    int distance = poll[1] + path[1];
                    // ??????1????????? i ???????????????????????????????????? dst ????????????????????????
                    if (distance < ans[path[0]] && distance < ans[dst]) {
                        ans[path[0]] = distance;
                        // ??????2?????? dst ???????????????????????????
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
        // dp[i][k]?????????i??????dst???k??????????????????
        // dp[i][k]=min(dp[i_next][k-1] + g[i][j])
        int ans = INF;

        int[][] dp = new int[2][n];
        Arrays.fill(dp[0], INF);
        dp[0][dst] = 0;
        for (int k = 1; k <= K + 1; k++) {
            // ????????????????????????????????????????????????
            Arrays.fill(dp[k & 1], INF);
            for (int[] flight : flights) {
                dp[k & 1][flight[0]] = Math.min(dp[k & 1][flight[0]], dp[(k - 1) & 1][flight[1]] + flight[2]);
            }
            ans = Math.min(ans, dp[k & 1][src]);
        }

        return ans >= INF ? -1 : ans;
    }






}
