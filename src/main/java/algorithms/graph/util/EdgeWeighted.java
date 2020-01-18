package algorithms.graph.util;

public class EdgeWeighted {
    int source;
    int destination;
    int weight;
    EdgeWeighted(int source, int destination, int weight){
        this.source =source;
        this.destination =destination;
        this.weight = weight;
    }
    public int getSource(){
        return source;
    }
    public int getDestination(){
        return destination;
    }
    public int getWeight(){
        return weight;
    }
}