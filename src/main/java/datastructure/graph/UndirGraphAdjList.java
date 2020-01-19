package datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.List;

public class UndirGraphAdjList {
    LinkedList<Integer> adjList[];
    int noOfVertices;
    public UndirGraphAdjList(int noOfVertices){
        this.noOfVertices = noOfVertices;
        this.adjList = new LinkedList[this.noOfVertices];
        for(int idx = 0; idx<this.noOfVertices; idx++){
            adjList[idx] = new LinkedList<>();
        }
    }

    public void insertEdge(int src, int dest){
        this.adjList[src].addFirst(dest);
        this.adjList[dest].addFirst(src);
    }

    public void deleteEdge(int src, int dest){
        int index = this.adjList[src].indexOf(dest);
        if(index!=-1){
            this.adjList[src].remove(index);
        }
        index = this.adjList[dest].indexOf(dest);
        if(index!=-1){
            this.adjList[dest].remove(index);
        }
    }

    public void bfsTravserse(){
        boolean[] visited = new boolean[this.noOfVertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(this.noOfVertices -1);
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
        boolean[] visited = new boolean[this.noOfVertices];
        Stack<Integer> stack =new Stack<>();
        stack.push(this.noOfVertices -1);
        visited[noOfVertices -1] = true;
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

    public int getNoOfVertices() {
        return noOfVertices;
    }

    public List<Integer>[] getAdjList() {
        return adjList;
    }
}