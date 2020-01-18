package algorithms.graph;

import algorithms.graph.util.GraphAdjMatrixUnDir;

public class GraphTopologicalSort {

    public static void main(String[] args){
        GraphAdjMatrixUnDir graphAdjMatrix = new GraphAdjMatrixUnDir(8);
        graphAdjMatrix.insertEdge(0,3);
        graphAdjMatrix.insertEdge(0,4);
        graphAdjMatrix.insertEdge(1,3);
        graphAdjMatrix.insertEdge(2,4);
        graphAdjMatrix.insertEdge(2,7);
        graphAdjMatrix.insertEdge(3,5);
        graphAdjMatrix.insertEdge(3,6);
        graphAdjMatrix.insertEdge(3,7);
        graphAdjMatrix.insertEdge(4,6);
        int[] order = graphAdjMatrix.topologicalSort();
        for(int node:order){
            System.out.println(node+" ");
        }
    }


}

