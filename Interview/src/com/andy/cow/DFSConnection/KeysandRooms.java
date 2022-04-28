package com.andy.cow.DFSConnection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0) return true;
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);
        System.out.println(visited);
        return visited.size() == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int i, Set<Integer> visited) {
        if(visited.contains(i)) return ;

        visited.add(i);
        for(int k : rooms.get(i)) {
            if(!visited.contains(k)) {
                //visited.add(k);
                //if we add k here, it will return in the next round of dfs
                dfs(rooms, k, visited);
            }
        }
    }
}
