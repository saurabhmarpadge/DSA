package algorithms.graph;

import datastructure.DisjointSet;
import datastructure.graph.UndirGraphAdjList;

import java.util.ArrayList;
import java.util.List;

public class CycleDetection {
    public static void main(String[] args) {
        CycleDetection undirectedGraphCycle =new CycleDetection();
        UndirGraphAdjList undirectedGraphAdjList = new UndirGraphAdjList(6);
        undirectedGraphAdjList.insertEdge(0,1);
        undirectedGraphAdjList.insertEdge(1,2);
        undirectedGraphAdjList.insertEdge(2,3);
        undirectedGraphAdjList.insertEdge(3,4);
        undirectedGraphAdjList.insertEdge(4,5);
        undirectedGraphAdjList.insertEdge(5,2);
        System.out.println(undirectedGraphCycle.isCycle(undirectedGraphAdjList));
        List<Edge> allEdges = new ArrayList<>();
        allEdges.add(new Edge(0,1));
        allEdges.add(new Edge(0,2));
        allEdges.add(new Edge(1,3));
        allEdges.add(new Edge(2,3));
        allEdges.add(new Edge(3,4));
        System.out.println(undirectedGraphCycle.isCycle(allEdges,5));
    }

    private boolean isCycle(List<Edge> allEdges, int nodes) {
        DisjointSet disjointSet = new DisjointSet(nodes);
        for(Edge edge:allEdges){
            int sVer = disjointSet.find(edge.s);
            int dVer = disjointSet.find(edge.d);
            if(sVer==dVer){
                return true;
            } else {
                disjointSet.union(edge.s,edge.d);
            }
        }
        return false;
    }

    public boolean isCycle(UndirGraphAdjList adjList){
        boolean[] visited = new boolean[adjList.getNodes()];
        for(int idx=0;idx<adjList.getNodes();idx++){
            if(!visited[idx]&&isCycleUtil(idx,visited,-1,adjList)){
                return true;
            }
        }
        return false;
    }

    private boolean isCycleUtil(int currVertex, boolean[] visited, int parent, UndirGraphAdjList adjList) {
        visited[currVertex]=true;
        for(int idx=0;idx<adjList.getAdjList()[idx].size();idx++){
            int vertex = adjList.getAdjList()[idx].get(idx);
            if(vertex!=parent&&(visited[vertex]||isCycleUtil(vertex,visited,currVertex,adjList))){
                return true;
            }
        }
        return false;
    }
}

class Edge {
    int s;
    int d;

    public Edge(int s, int d) {
        this.s=s;
        this.d=d;
    }
}