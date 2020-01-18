package algorithms.graph.mst;

import algorithms.graph.util.EdgeWeighted;
import algorithms.graph.util.UnDirGraphWeightedAdjList;
import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;


public class GraphPrim {
    public static void main(String[] args) {
        UnDirGraphWeightedAdjList graph = new UnDirGraphWeightedAdjList(5);
        graph.addEdge(1,2,4);
        graph.addEdge(2,4,3);
        graph.addEdge(1,3,1);
        graph.addEdge(2,3,2);
        graph.addEdge(3,5,5);
        ResultSet[] resultSets = getMST(graph);
        for(int edgeIdx=1;edgeIdx<resultSets.length;edgeIdx++){
            System.out.println("Edge "+edgeIdx+"-"+resultSets[edgeIdx].path+" key: "+resultSets[edgeIdx].distance);
        }
    }

    private static ResultSet[] getMST(UnDirGraphWeightedAdjList graph) {
        ResultSet[] resultSet = new ResultSet[graph.getNoOfVertices()];
        boolean[] mst = new boolean[graph.getNoOfVertices()];
        for(int idx=0;idx<resultSet.length;idx++){
            resultSet[idx]=new ResultSet();
            resultSet[idx].distance=Integer.MAX_VALUE;
        }
        resultSet[1].distance=0;
        resultSet[1].path=-1;
        PriorityQueue<Pair<Integer,Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o->o.getKey()-o.getKey()));
        priorityQueue.offer(new Pair<>(resultSet[1].distance,1));
        while(!priorityQueue.isEmpty()){
            Pair<Integer,Integer> currPair = priorityQueue.poll();
            if(!mst[currPair.getValue()]){
                mst[currPair.getValue()]=true;
                for(EdgeWeighted edge:graph.getVerticesList()[currPair.getValue()]){
                    if(!mst[edge.getDestination()]){
                        if(resultSet[edge.getDestination()].distance>edge.getWeight()){
                            resultSet[edge.getDestination()].distance=edge.getWeight();
                            resultSet[edge.getDestination()].path=currPair.getValue();
                            priorityQueue.offer(new Pair<>(resultSet[edge.getDestination()].distance,edge.getDestination()));
                        }
                    }
                }
            }
        }
        return resultSet;
    }
}

class ResultSet{
    int path;
    int distance;
}
