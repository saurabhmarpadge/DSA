package algorithms.graph.util;

public class DirGraphAdjMatrix {
    int[][] adjMat;
    int noOfVertices;

    public DirGraphAdjMatrix(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        this.adjMat = new int[noOfVertices][noOfVertices];
    }

    public void insertEdge(int src, int dest) {
        this.adjMat[src][dest] = 1;
    }

    public void deleteEdge(int src, int dest) {
        this.adjMat[src][dest] = 0;
    }

    public int[][] getAdjMat(){
        return adjMat;
    }

    public int getNoOfVertices(){
        return noOfVertices;
    }

}
