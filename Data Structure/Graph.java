/*
I'll implement:

 DFS with adjacency list (recursive)
 DFS with adjacency list (iterative with stack)
 DFS with adjacency matrix (recursive)
 DFS with adjacency matrix (iterative with stack)
 BFS with adjacency list
 BFS with adjacency matrix
 single-source shortest path (Dijkstra)
 minimum spanning tree
DFS-based algorithms (see Aduni videos above):
 check for cycle (needed for topological sort, since we'll check for cycle before starting)
 topological sort
 count connected components in a graph
 list strongly connected components
 check for bipartite graph
*/

public class Graph {
 
    public static void main(String[] args){
        
    }
    
}

class GraphAdjMatrix{
    int[][] adjMat;
    int nodes;
    GraphAdjMatrix(int nodes){
        this.nodes = nodes;
        this.adjMat = new int[nodes][nodes];
    }
    
    public insertEdge(int src, int dest){
        this.adjMat[src][dest] = 1;
        this.adjMat[dest][src] = 1;
    }
    
    public deleteEdge(int src, int dest){
        this.adjMat[src][dest] = 0;
        this.adjMat[dest][src] = 0;
    }
    
    public bfsTravserse(){
        boolean[] visited = new boolean[this.nodes];
        Queue<Integer> queue = new LinkedList<>();
        queue.push(this.nodes-1);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(!visited[node]){
                visited[node] = true;
                for(int neighbours:getNonVisitedNeighbours(node)){
                    queue.add();
                }
            }
        }
    }
    
    public dfsTravserse(){
        boolean[] visited = new boolean[this.nodes];
        Stack<Integer> stack =new Stack<>();
        stack.push(this.nodes-1);
        visited[nodes-1] = true;
        while(!stack.isEmpty()){
            int node = stack.peek();
            int neighbour = getNonVisitedNeighbour(node);
            if(neighbour!=-1){
                stack.push(neighbour);
            } else {
                stack.pop();
            }
        }
    }
}


class GraphAdjList{
    LinkedList<Integer> adjList[];
    int nodes;
    GraphAdjList(int nodes){
        this.nodes = nodes;
        this.adjList[] = new LinkedList[this.nodes];
        for(int idx=0;idx<this.nodes;idx++){
            adjList[idx] = new LinkedList<>();
        }
    }
    
    public insertEdge(int src, int dest){
        this.adjList[src].add(dest);
        this.adjList[dest].add(src);
    }
    
    public deleteEdge(int src, int dest){
        this.adjList[src].remove(dest);
        this.adjList[dest].remove(src);
    }
    
    public bfsTravserse(){
        boolean[] visited = new boolean[this.nodes];
        Queue<Integer> queue = new LinkedList<>();
        queue.push(this.nodes-1);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(!visited[node]){
                visited[node] = true;
                for(int neighbours:getNonVisitedNeighbours(node)){
                    queue.add();
                }
            }
        }
    }
    
    public dfsTravserse(){
        boolean[] visited = new boolean[this.nodes];
        Stack<Integer> stack =new Stack<>();
        stack.push(this.nodes-1);
        visited[nodes-1] = true;
        while(!stack.isEmpty()){
            int node = stack.peek();
            int neighbour = getNonVisitedNeighbour(node);
            if(neighbour!=-1){
                stack.push(neighbour);
            } else {
                stack.pop();
            }
        }
    }
}

