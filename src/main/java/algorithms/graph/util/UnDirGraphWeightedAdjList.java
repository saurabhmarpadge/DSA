package algorithms.graph.util;

import java.util.LinkedList;

public class UnDirGraphWeightedAdjList {
    LinkedList<EdgeWeighted> verticeList[];
    int noOfVertices;

    public LinkedList<EdgeWeighted>[] getVerticesList(){
        return verticeList;
    }

    public int getNoOfVertices(){
        return noOfVertices;
    }

    public UnDirGraphWeightedAdjList(int noOfVertices){
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


