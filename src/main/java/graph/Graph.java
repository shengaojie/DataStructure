package graph;


import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author shengaojie
 * @Date 2023/1/26 11:20
 * @Version 1.0
 */

public class Graph {
    //顶点的数目
    private final int V;

    //边的数目
    private  int E;

    //队列用来存储每个顶点连通的边
    private Queue<Integer>[] adj;

    public Graph(int v) {
        V = v;
        this.E = 0;
        this.adj = new Queue[V];
        //初始化所有的队列
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayDeque<>();
        }
    }


    public int getV(){
        return V;
    }

    public int getE(){
        return E;
    }

    //增加一条边，因为是无向图，所有v和w对应的队列中都要加入对方
    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;   //边的长度+1
    }

    //获取一个顶点相邻的所有的顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }

}

class TestGraph{
    @Test
    public void createGraph(){
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);

        System.out.println(graph.getE());
        System.out.println(graph.getV());


    }
}
