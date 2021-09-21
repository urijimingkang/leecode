package com.andy.zju.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CourseSchduleII {

    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;
    List<Integer> postOrder = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // ArrayList of integer array
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        if(!canFinish(numCourses, prerequisites, graph)) {
            return new int[]{};
        }

        visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        int[] res = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            res[i] = postOrder.get(i);
        }

        return res;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites, List<Integer>[] graph) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCycle;
    }

    public void traverse (List<Integer>[] graph, int s) {
        if(onPath[s]) hasCycle = true;

        if(visited[s] || hasCycle) return;

        visited[s] = true;
        onPath[s] = true;

        for(int t : graph[s]) {
            traverse(graph, t);
        }

        onPath[s] = false;
        postOrder.add(0, s);
    }

    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }

        return graph;
    }
}
