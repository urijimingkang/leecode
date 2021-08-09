package com.andy.zju.DFSConnection;

import java.util.HashSet;
import java.util.Set;

public class NumberofProvinces {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet();
        int cnt = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(!visited.contains(i)) {
                dfs(isConnected, visited, i);
                cnt++;
            }
        }
        return cnt;
    }

    private void dfs(int[][] isConnected, Set<Integer> visited, int i) {
        for(int j = 0; j < isConnected.length; j++) {
            if(isConnected[i][j] == 1 && !visited.contains(j)) {
                visited.add(j);
                dfs(isConnected, visited, j);
            }
        }
    }
}
