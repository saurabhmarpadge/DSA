package algorithms.graph.mst;

import datastructure.disjointset.DisjointSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GraphKruskal {

    public static void main(String[] args) {
        List<Edge> allEdges = new ArrayList<>();
        allEdges.add(new Edge(1,2,1));
        allEdges.add(new Edge(1,3,2));
        allEdges.add(new Edge(3,4,2));
        allEdges.add(new Edge(0,2,3));
        allEdges.add(new Edge(0,1,4));
        allEdges.add(new Edge(2,3,4));
        allEdges.add(new Edge(4,5,6));
        GraphKruskal graphKruskal = new GraphKruskal();
        List<Edge> result = graphKruskal.getKruskalMST(allEdges,6);
        System.out.println(result.stream().mapToInt(t->t.w).sum());
    }

    public List<Edge> getKruskalMST(List<Edge> allEdges, int nodes){
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing(o->o.w));
        for(Edge edge:allEdges){
            queue.offer(edge);
        }
        DisjointSet disjointSet = new DisjointSet(nodes);
        List<Edge> result = new ArrayList<>();
        while(result.size()<nodes-1){
            Edge edge = queue.poll();
            if(disjointSet.find(edge.s)!=disjointSet.find(edge.d)){
                result.add(edge);
                disjointSet.union(edge.s,edge.d);
            }
        }
        return result;
    }

    private static class Edge {
        int s;
        int d;
        int w;

        public Edge(int s, int d, int w) {
            this.s=s;
            this.d=d;
            this.w=w;
        }
    }
}
