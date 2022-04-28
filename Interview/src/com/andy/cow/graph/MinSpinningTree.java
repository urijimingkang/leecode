package com.andy.cow.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MinSpinningTree {

    public static class Edge<T> implements Comparable<Edge> {
        private T start;
        private T end;
        private int distance;

        public Edge(T start, T end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        public T getStart() {
            return start;
        }

        public void setStart(T start) {
            this.start = start;
        }

        public T getEnd() {
            return end;
        }

        public void setEnd(T end) {
            this.end = end;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        //实现边的权值从小到大进行排序
        public int compareTo(Edge obj) {
            int targetDis = obj.getDistance();
            return distance > targetDis ? 1 : (distance == targetDis ? 0 : -1);
        }
    }

    public static class UnionFind {

        public static UFNode find(UFNode x) {
            UFNode p = x;
            Set<UFNode> path = new HashSet<UFNode>();
            // 记录向上追溯的路径上的点，找到根节点，
            while (p.parent != null) {
                path.add(p);
                p = p.parent;
            }
            // 这些点的parent全部指向这个集合的代表(根节点)
            for (UFNode ppp : path) {
                ppp.parent = p;     //直接指向根节点
            }
            // root
            return p;   //找到这个顶点所在的根节点代表的集合

        }

        public static void union(UFNode x, UFNode y) {
            find(y).parent = find(x);
        }

        public static class UFNode {
            UFNode parent;
        }
    }

    private final List<Edge> edgeList;
    private final int n;// 总顶点数

    private Set<Edge> T = new HashSet<>();// 生成树的边集
    private Map pntAndNode = new HashMap();

    public Set<Edge> getT() {
        buildMST();
        return T;
    }

    public MinSpinningTree(List<Edge> edgeList, int n) {
        this.edgeList = edgeList;
        //初始化，每一个顶点对应一个集合， //为每个顶点建立一个并查集的集合，用map集合，使顶点与并查集的结点之间形成一种映射关系
        for (Edge edge : edgeList) {
            pntAndNode.put(edge.getStart(), new UnionFind.UFNode());
            pntAndNode.put(edge.getEnd(), new UnionFind.UFNode());
        }
        this.n = n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Edge> l = new ArrayList<>();       
        int k = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            l.add(new Edge(a, b, c));
        }

        List<Edge> edgeList = l;
        MinSpinningTree obj = new MinSpinningTree(edgeList, k);
        // obj.buildMST();
        long sum = 0;
        //顶点个数不等于边数-1，说明没有最小生成树
        if (obj.getT().size() != k-1) {
            System.out.println("impossible");

        }else{
            //权值求和
            for (Edge e : obj.getT()) {     
                sum += e.getDistance();
           }
            System.out.println(sum);
        }
    }


    /* 构建MST的核心方法 */
    private void buildMST() {
        Collections.sort(edgeList);// 排序
        // 迭代
        for (Edge e : edgeList) {
            //如果构成一个环
            if (!ok(e))
                continue;
            // 确认过了，就把边都加入
            T.add(e);

            if (T.size() == n - 1)
                return;             // 生成树的边数==总顶点数-1 =》 形成最小生成树

        }
    }

    // 并查集中查询e 的起点和终点是否在一个集中
    private boolean ok(Edge e) {
       //
        UnionFind.UFNode x = (UnionFind.UFNode) pntAndNode.get(e.getStart());
        UnionFind.UFNode y = (UnionFind.UFNode) pntAndNode.get(e.getEnd());
        if (UnionFind.find(x) != UnionFind.find(y)) {   // 并查集的find方法，查找顶点x和y是否在同一个集和中
            UnionFind.union(x, y);   // 不在同一个集合中，不会形成环，合并，并返回true
            return true;
        }
        return false;
    }

}

