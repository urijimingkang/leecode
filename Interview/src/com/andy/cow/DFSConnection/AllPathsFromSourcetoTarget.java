package com.andy.cow.DFSConnection;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            if(graph == null || graph.length == 0) return res;

            List<Integer> path = new ArrayList<>();
            path.add(0);
            dfs(graph, 0, path);
            return res;
        }

        private void dfs(int[][] graph, int i, List<Integer> path) {
            if(i == graph.length -1) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int neighbor: graph[i]) {
                path.add(neighbor);
                dfs(graph, neighbor, path);
                path.remove(path.size() -1);
            }
        }
    }


}
