package com.andy.zju.graph;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        UnionFind unionFind = new UnionFind(len+1);
        for(int i = 0;i<len;i++){
            if(unionFind.connected(edges[i][0],edges[i][1])){
                return new int[]{edges[i][0],edges[i][1]};
            }
            else{
                unionFind.union(edges[i][0],edges[i][1]);
            }
        }
        return new int[0];
    }
}

class UnionFind{
    private int count;
    private int[] parent;
    public UnionFind(int n){
        this.count = n;
        parent = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
    }

    public void union(int a,int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA == parentB) return;
        parent[parentA] = parentB;
        count--;
    }

    public boolean connected(int a,int b){
        return find(a) == find(b);
    }

    public int find(int a){
        while(parent[a] != a){
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return parent[a];
    }
    public int getCount(){
        return this.count;
    }
}
