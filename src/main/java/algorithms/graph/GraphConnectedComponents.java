package algorithms.graph;


import datastructure.GraphAdjMatrix;

public class GraphConnectedComponents {
    public static void main(String[] args) {
        GraphAdjMatrix graph = new GraphAdjMatrix(5);
        graph.insertEdge(0,1);
        graph.insertEdge(1,2);
        graph.insertEdge(0,2);
        graph.insertEdge(3,4);
        System.out.println(getNoOfConnectedComponent(graph));
    }

    private static int getNoOfConnectedComponent(GraphAdjMatrix graph) {
        boolean[] visited = new boolean[graph.getNodes()];
        int count=0;
        for(int nodeIdx=0;nodeIdx<graph.getNodes();nodeIdx++){
            if(!visited[nodeIdx]){
                dfs(nodeIdx,graph,visited);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int node, GraphAdjMatrix graph, boolean[] visited) {
        if(!visited[node]){
            visited[node]=true;
            int neighbour = graph.getNonVisitedNeighbour(node,visited);
            if(neighbour!=-1){
                dfs(neighbour,graph,visited);
            }
        }
    }


}
