package algorithms.graph.shortestpath;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class GraphDijkstra {
    public static void main(String[] args) {
        UnDirGraphWeightedAdjList graph = new UnDirGraphWeightedAdjList(5);
        graph.addEdge(1,2,4);
        graph.addEdge(2,4,3);
        graph.addEdge(1,3,1);
        graph.addEdge(2,3,2);
        graph.addEdge(3,5,5);
        int[] distance = getShortestPath(graph);
    }

    private static int[] getShortestPath(UnDirGraphWeightedAdjList graph) {
        int[] distances = new int[graph.noOfVertices];
        boolean[] SPT = new boolean[graph.noOfVertices];
        for(int idx=0;idx<distances.length;idx++){
            distances[idx]=Integer.MAX_VALUE;
        }
        distances[1]=0;
        PriorityQueue<Pair<Integer,Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o->o.getKey()-o.getKey()));
        priorityQueue.offer(new Pair<>(distances[1],1));
        while(!priorityQueue.isEmpty()){
            Pair<Integer,Integer> currPair = priorityQueue.poll();
            if(!SPT[currPair.getValue()]){
                for(EdgeWeighted edge:graph.verticeList[currPair.getValue()]){
                    if(!SPT[edge.d]){
                        if(distances[edge.d]>distances[edge.s]+edge.w){
                            distances[edge.d]=distances[edge.s]+edge.w;
                            priorityQueue.offer(new Pair<>(distances[edge.d],edge.d));
                        }
                    }
                }
            }
        }
        return distances;
    }
}

class UnDirGraphWeightedAdjList {
    LinkedList<EdgeWeighted> verticeList[];
    int noOfVertices;
    UnDirGraphWeightedAdjList(int noOfVertices){
        this.noOfVertices =noOfVertices+1;
        verticeList = new LinkedList[this.noOfVertices];
        for(int idx=0;idx<this.noOfVertices;idx++){
            verticeList[idx] =  new LinkedList<>();
        }
    }
    public void addEdge(int s, int d, int w){
        EdgeWeighted edgeWeighted =new EdgeWeighted(s,d,w);
        verticeList[s].addFirst(edgeWeighted);
        edgeWeighted =new EdgeWeighted(d,s,w);
        verticeList[d].addFirst(edgeWeighted);
    }
}

class EdgeWeighted {
    int s;
    int d;
    int w;
    EdgeWeighted(int s, int d, int w){
        this.s=s;
        this.d=d;
        this.w=w;
    }
}
