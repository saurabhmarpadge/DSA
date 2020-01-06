package datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.List;

public class UndirGraphAdjList {
    List<Integer> adjList[];
    int nodes;
    public UndirGraphAdjList(int nodes){
        this.nodes = nodes;
        this.adjList = new LinkedList[this.nodes];
        for(int idx=0;idx<this.nodes;idx++){
            adjList[idx] = new LinkedList<>();
        }
    }

    public void insertEdge(int src, int dest){
        this.adjList[src].add(dest);
        this.adjList[dest].add(src);
    }

    public void deleteEdge(int src, int dest){
        this.adjList[src].remove(dest);
        this.adjList[dest].remove(src);
    }

    public void bfsTravserse(){
        boolean[] visited = new boolean[this.nodes];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(this.nodes-1);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(!visited[node]){
                visited[node] = true;
                for(int neighbours:getNonVisitedNeighbours(node)){
                    queue.add(neighbours);
                }
            }
        }
    }

    private int[] getNonVisitedNeighbours(int node) {
        return null;
    }

    public void dfsTravserse(){
        boolean[] visited = new boolean[this.nodes];
        Stack<Integer> stack =new Stack<>();
        stack.push(this.nodes-1);
        visited[nodes-1] = true;
        while(!stack.isEmpty()){
            int node = stack.peek();
            int neighbour = getNonVisitedNeighbour(node);
            if(neighbour!=-1){
                stack.push(neighbour);
            } else {
                stack.pop();
            }
        }
    }

    private int getNonVisitedNeighbour(int node) {
        return 0;
    }

    public int getNodes() {
        return nodes;
    }

    public List<Integer>[] getAdjList() {
        return adjList;
    }
}