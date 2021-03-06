package com.andy.ds.graph;

import java.util.*;

public abstract class AbstractGraph<V> implements Graph<V> {

    protected List<V> vertices; //结点列表

    protected List<List<Integer>> neighbors;
    // 储存每个结点的相邻结点 

    protected AbstractGraph(int[][] edges, V[] vertices) {
        this.vertices = new ArrayList<V>();
        for (int i = 0; i < vertices.length; i++) {
            this.vertices.add(vertices[i]);
        }
        createAdjacencyLists(edges, vertices.length);
    }

    AbstractGraph(List<Edge> edges, List<V> vertices) {
        this.vertices = vertices;
        createAdjacencyLists(edges, vertices.size());
    }

    protected AbstractGraph(List<Edge> edges, int numOfVertices) {
        this.vertices = new ArrayList<V>();
        for (int i = 0; i < numOfVertices; i++) {
            vertices.add((V) (new Integer(i)));
        }
        createAdjacencyLists(edges, numOfVertices);
    }

    protected AbstractGraph(int[][] edges, int numOfVertices) {
        vertices = new ArrayList<V>();
        for (int i = 0; i < numOfVertices; i++) {
            vertices.add((V) (new Integer(i)));
        }
        createAdjacencyLists(edges, numOfVertices);
    }

    private void createAdjacencyLists(List<Edge> edges, int numOfVertices) {
        neighbors = new ArrayList<List<Integer>>();
        for (int i = 0; i < numOfVertices; i++) {
            neighbors.add(new ArrayList<Integer>());
        }
        for (Edge edge : edges) {
            neighbors.get(edge.u).add(edge.v);
        }
    }

    private void createAdjacencyLists(int[][] edges, int numOfVertices) {
        neighbors = new ArrayList<List<Integer>>();
        for (int i = 0; i < numOfVertices; i++) {
            neighbors.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            neighbors.get(u).add(v);
        }
    } //inner class，表示边

    public static class Edge {
        public int u;
        public int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    @Override
    public int getSize() {
        return vertices.size();
    }

    @Override
    public List<V> getVertices() {
        return vertices;
    }

    @Override
    public V getVertex(int index) {
        return vertices.get(index);
    }

    @Override
    public int getIndex(V v) {
        return vertices.indexOf(v);
    }

    @Override
    public List<Integer> getNeighbors(int index) {
        return neighbors.get(index);
    }

    @Override
    public int getDegree(int v) {
        return neighbors.get(v).size();
    }

    @Override
    public int[][] getAdjacencyMatrix() {
        int[][] adjacencyMatrix = new int[getSize()][getSize()];
        for (int i = 0; i < neighbors.size(); i++) {
            for (int j = 0; j < neighbors.get(i).size(); j++) {
                int v = neighbors.get(i).get(j);
                adjacencyMatrix[i][v] = 1;
            }
        }
        return adjacencyMatrix;
    }

    @Override
    public void printAdjacencyMatrix() {
        int[][] adjacencyMatrix = getAdjacencyMatrix();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void printEdges() {
        for (int u = 0; u < neighbors.size(); u++) {
            System.out.print("Vertex" + u + ":");
            for (int i = 0; i < neighbors.get(u).size(); i++) {
                System.out.print("(" + u + "," + neighbors.get(u).get(i) + ") ");
            }
            System.out.println();
        }
    }

    public Tree dfs(int v) {
        List<Integer> searchOrders = new ArrayList<Integer>();
        int[] parent = new int[vertices.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }
        boolean[] isVisited = new boolean[vertices.size()];
        dfs(v, parent, searchOrders, isVisited);
        return new Tree(v, parent, searchOrders);
    }

    private void dfs(int v, int[] parent, List<Integer> searchOrders, boolean[] isVisited) {
        searchOrders.add(v);
        isVisited[v] = true;
        for (int i : neighbors.get(v)) {
            if (!isVisited[i]) {
                parent[i] = v;//the parent of vertex i is v
                dfs(i, parent, searchOrders, isVisited);
            }
        }
    }

    public Tree bfs(int v) {
        List<Integer> searchOrders = new ArrayList<Integer>();
        int[] parent = new int[vertices.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean[] isVisited = new boolean[vertices.size()];
        queue.offer(v);
        isVisited[v] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();//dequeue to u
            searchOrders.add(u);
            for (int w : neighbors.get(u)) {
                if (!isVisited[w]) {
                    queue.offer(w);
                    parent[w] = u;
                    isVisited[w] = true;
                }
            }
        }
        return new Tree(v, parent, searchOrders);
    }

    public Tree bfs(int v,int dest) {
        List<Integer> searchOrders = new ArrayList<Integer>();
        int[] parent = new int[vertices.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean[] isVisited = new boolean[vertices.size()];
        queue.offer(v);
        isVisited[v] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();//dequeue to u
            searchOrders.add(u);
            for (int w : neighbors.get(u)) {
                if (!isVisited[w]) {
                    queue.offer(w);
                    parent[w] = u;
                    isVisited[w] = true;
                }
            }
        }
        return new Tree(v, parent, searchOrders);
    }

    public class Tree {
        private int root;
        private int[] parent;
        private List<Integer> searchOrders;

        public Tree(int root, int[] parent, List<Integer> searchOrders) {
            this.root = root;
            this.parent = parent;
            this.searchOrders = searchOrders;
        }

        public Tree(int root, int[] parent) {
            this.root = root;
            this.parent = parent;
        }

        public int getRoot() {
            return root;
        }

        public int getParent(int v) {
            return parent[v];
        }

        public List<Integer> getSearchOrders() {
            return searchOrders;
        }

        public int getNumberOfVerticesFound() {
            return searchOrders.size();
        }

        //return the path of vertices from a vertex index to the root
        public List<V> getPath(int index) {
            ArrayList<V> path = new ArrayList<V>();
            do {
                path.add(vertices.get(index));
                index = parent[index];
            }
            while (index != -1);
            return path;
        }

        public void printPath(int index) {
            List<V> path = getPath(index);
            System.out.print("A path from " + vertices.get(root) + " to " + vertices.get(index) + ": ");
            for (int i = path.size() - 1; i >= 0; i--) {
                System.out.print(path.get(i) + " ");
            }
        }

        public void printTree() {
            System.out.println("root is: " + vertices.get(root));
            System.out.print("Edges: ");
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] != -1) {
                    System.out.println("(" + vertices.get(parent[i]) + "." + vertices.get(i) + ") ");
                }
            }
            System.out.println();
        }
    }
}

