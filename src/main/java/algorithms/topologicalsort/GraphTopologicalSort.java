package algorithms.topologicalsort;

import java.util.*;

public class GraphTopologicalSort {

    public static void main(String[] args){
        GraphAdjMatrix graphAdjMatrix = new GraphAdjMatrix(8);
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

class GraphAdjMatrix {
    int[][] adjMat;
    int nodes;

    GraphAdjMatrix(int nodes) {
        this.nodes = nodes;
        this.adjMat = new int[nodes][nodes];
    }

    public void  insertEdge(int src, int dest) {
        this.adjMat[src][dest] = 1;
    }

    public void deleteEdge(int src, int dest) {
        this.adjMat[src][dest] = 0;
    }

    public int[] topologicalSort(){
        int[] indegree = new int[adjMat.length];
        int[] order = new int[adjMat.length];
        int[] visited = new int[adjMat.length];
        int idxC=0;
        Queue<Integer> queue = new LinkedList<>();

        for(int r=0;r<adjMat.length;r++){
            for(int c=0;c<adjMat.length;c++){
                if(adjMat[r][c]==1){
                    indegree[c]++;
                }
            }
        }

        for(int idx=0;idx<adjMat.length;idx++){
            if(indegree[idx]==0){
                queue.add(idx);
                visited[idx]=1;
            }
        }

        while(!queue.isEmpty()){
            int currNode = queue.poll();
            order[idxC++]=currNode;
            for(int c=0;c<adjMat.length;c++){
                if(adjMat[currNode][c]==1&&visited[c]==0){
                    indegree[c]--;
                    if(indegree[c]==0){
                        visited[c]=1;
                        queue.add(c);
                    }
                }
            }
        }
        return order;
    }
}