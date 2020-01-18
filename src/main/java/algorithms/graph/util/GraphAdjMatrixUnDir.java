package algorithms.graph.util;

import java.util.LinkedList;
import java.util.Queue;

public class GraphAdjMatrixUnDir {
    int[][] adjMat;
    int nodes;

    public GraphAdjMatrixUnDir(int nodes) {
        this.nodes = nodes;
        this.adjMat = new int[nodes][nodes];
    }

    public void insertEdge(int src, int dest) {
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
