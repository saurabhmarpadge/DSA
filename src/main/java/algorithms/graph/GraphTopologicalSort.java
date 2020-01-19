package algorithms.graph;

import algorithms.graph.util.DirGraphAdjMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTopologicalSort {

    public static void main(String[] args){
        DirGraphAdjMatrix graph = new DirGraphAdjMatrix(8);
        graph.insertEdge(0,3);
        graph.insertEdge(0,4);
        graph.insertEdge(1,3);
        graph.insertEdge(2,4);
        graph.insertEdge(2,7);
        graph.insertEdge(3,5);
        graph.insertEdge(3,6);
        graph.insertEdge(3,7);
        graph.insertEdge(4,6);
        int[] order = topologicalSort(graph);
        for(int node:order){
            System.out.println(node+" ");
        }
    }

    public static int[] topologicalSort(DirGraphAdjMatrix graph){
        int[] indegree = new int[graph.getAdjMat().length];
        int[] order = new int[graph.getAdjMat().length];
        boolean[] visited = new boolean[graph.getAdjMat().length];
        int idxC=0;
        Queue<Integer> queue = new LinkedList<>();

        for(int r=0;r<graph.getAdjMat().length;r++){
            for(int c=0;c<graph.getAdjMat().length;c++){
                if(graph.getAdjMat()[r][c]==1){
                    indegree[c]++;
                }
            }
        }

        for(int idx=0;idx<graph.getAdjMat().length;idx++){
            if(indegree[idx]==0){
                queue.add(idx);
                visited[idx]=true;
            }
        }

        while(!queue.isEmpty()){
            int currNode = queue.poll();
            order[idxC++]=currNode;
            for(int c=0;c<graph.getAdjMat().length;c++){
                if(graph.getAdjMat()[currNode][c]==1&&!visited[c]){
                    indegree[c]--;
                    if(indegree[c]==0){
                        visited[c]=true;
                        queue.add(c);
                    }
                }
            }
        }
        return order;
    }
}

