package algorithms.graph.shortestpath;

import algorithms.graph.util.EdgeWeighted;
import algorithms.graph.util.UnDirGraphWeightedAdjList;
import javafx.util.Pair;

import java.util.Comparator;
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
        for(int vIdx=1;vIdx<distance.length;vIdx++){
            System.out.println(vIdx+" distance "+distance[vIdx]);
        }
    }

    private static int[] getShortestPath(UnDirGraphWeightedAdjList graph) {
        int[] distances = new int[graph.getNoOfVertices()];
        boolean[] SPT = new boolean[graph.getNoOfVertices()];
        for(int idx=0;idx<distances.length;idx++){
            distances[idx]=Integer.MAX_VALUE;
        }
        distances[1]=0;
        PriorityQueue<Pair<Integer,Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o->o.getKey()-o.getKey()));
        priorityQueue.offer(new Pair<>(distances[1],1));
        while(!priorityQueue.isEmpty()){
            Pair<Integer,Integer> currPair = priorityQueue.poll();
            if(!SPT[currPair.getValue()]){
                SPT[currPair.getValue()]=true;
                for(EdgeWeighted edge:graph.getVerticesList()[currPair.getValue()]){
                    if(!SPT[edge.getDestination()]){
                        if(distances[edge.getDestination()]>distances[edge.getSource()]+edge.getWeight()){
                            distances[edge.getDestination()]=distances[edge.getSource()]+edge.getWeight();
                            priorityQueue.offer(new Pair<>(distances[edge.getDestination()],edge.getDestination()));
                        }
                    }
                }
            }
        }
        return distances;
    }
}
