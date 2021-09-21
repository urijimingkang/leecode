package com.andy.zju.graph;

import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];

        onPath = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCycle;
    }

    private void traverse (List<Integer>[] graph, int s) {
        if(onPath[s]) {
            hasCycle = true;
        }

        if(visited[s] || hasCycle) {
            return;
        }

        visited[s] = true;
        onPath[s] = true;

        for(int t : graph[s]) {
            traverse(graph, t);
        }

        onPath[s] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
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
