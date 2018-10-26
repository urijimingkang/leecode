package com.andy.newds.graph;

import java.util.*;

public class Dijkstra {
    private int numNode; //结点的个数
    private int[][] matrix; //存放结点之间的权值
    private int startVertex; //开始结点
    private int[] distance; //存放开始结点到其他结点的最短距离
    private int[] preVertex; //存放路径的前一个结点

    public Dijkstra(int[][] matrix, int numNode, int startVertex) {
        this.matrix = matrix;
        this.numNode = numNode;
        this.startVertex = startVertex;
        distance = new int[numNode];
        preVertex = new int[numNode];
    }

    public void Dijstra() { //创建一个数组，用来标记结点是否已经在集合S中
        boolean[] isInS = new boolean[numNode]; //初始化distance和preVertex
        for (int i = 0; i < numNode; i++) {
            distance[i] = matrix[startVertex][i];
            if (matrix[startVertex][i] < Integer.MAX_VALUE) {
                preVertex[i] = startVertex;
            } else preVertex[i] = -1; //-1表示该结点的前一结点尚未找到或者没有前一结点
        }
        preVertex[startVertex] = -1; //先把开始结点加入集合S中
        isInS[startVertex] = true; //nextVertex表示下一个最新加入S中的结点，该结点到开始结点的距离在非集合S中是最小的
        int nextVertex = startVertex;
        for (int i = 0; i < numNode; i++) {
            int tmMinDistance = Integer.MAX_VALUE; //找到不在S中且到开始结点的距离最小的结点，
// tmMinDistance表示开始结点到结点nextVertex的最小值
            for (int j = 0; j < numNode; j++) {
                if (isInS[j] == false && distance[j] < tmMinDistance) {
                    nextVertex = j;
                    tmMinDistance = distance[j];
                }
            }
            isInS[nextVertex] = true; //更新开始结点到其他结点的距离
            for (int j = 0; j < numNode; j++) {
                if (isInS[j] == false && matrix[nextVertex][j] < Integer.MAX_VALUE) {
                    int temp = matrix[nextVertex][j] + tmMinDistance;
                    if (temp < distance[j]) {
                        distance[j] = temp;
                        preVertex[j] = nextVertex;
                    }
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < numNode; i++) {
            int index = i;
            Stack<Integer> trace = new Stack<Integer>();
            while (preVertex[index] != -1) {
                trace.push(preVertex[index]);
                index = preVertex[index];
            }
            System.out.print("Path: ");
            while (!trace.empty()) {
                System.out.print(trace.pop() + " --> ");
            }
            System.out.print("" + i);
            System.out.println("  Distance: " + distance[i]);
        }
    }

    public static void main(String[] args) {
        final int INT_MAX = Integer.MAX_VALUE;
        int graph[][] =
                {{INT_MAX, INT_MAX, INT_MAX, INT_MAX, 2, 5},
                        {INT_MAX, INT_MAX, 5, INT_MAX, 4, INT_MAX},
                        {INT_MAX, INT_MAX, INT_MAX, 2, INT_MAX, INT_MAX},
                        {5, INT_MAX, INT_MAX, INT_MAX, INT_MAX, 4},
                        {INT_MAX, INT_MAX, 6, 2, INT_MAX, INT_MAX},
                        {INT_MAX, 4, 3, INT_MAX, INT_MAX, INT_MAX}};
        Dijkstra gr = new Dijkstra(graph, 6, 1);
        gr.Dijstra();
        gr.print();
    }
}
