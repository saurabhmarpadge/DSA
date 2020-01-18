package algorithms.graph.util;

public class Edge {
    int source;
    int destination;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }
    public int getSource(){
        return source;
    }
    public int getDestination(){
        return destination;
    }
}
