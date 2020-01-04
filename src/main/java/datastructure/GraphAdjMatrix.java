package datastructure;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class GraphAdjMatrix{
    int[][] adjMat;
    int nodes;
    public GraphAdjMatrix(int nodes){
        this.nodes = nodes;
        this.adjMat = new int[nodes][nodes];
    }

    public int getNodes(){
        return nodes;
    }

    public void insertEdge(int src, int dest){
        this.adjMat[src][dest] = 1;
        this.adjMat[dest][src] = 1;
    }

    public void deleteEdge(int src, int dest){
        this.adjMat[src][dest] = 0;
        this.adjMat[dest][src] = 0;
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
        return new int[0];
    }

    public void dfsTravserse(){
        boolean[] visited = new boolean[this.nodes];
        Stack<Integer> stack =new Stack<>();
        stack.push(this.nodes-1);
        visited[nodes-1] = true;
        while(!stack.isEmpty()){
            int node = stack.peek();
            int neighbour = getNonVisitedNeighbour(node,visited);
            if(neighbour!=-1){
                stack.push(neighbour);
            } else {
                stack.pop();
            }
        }
    }

    public int getNonVisitedNeighbour(int node, boolean[] visited) {
        for(int idx=0;idx<adjMat[0].length;idx++){
            if(adjMat[node][idx]==1&&!visited[idx]){
                return idx;
            }
        }
        return -1;
    }

}