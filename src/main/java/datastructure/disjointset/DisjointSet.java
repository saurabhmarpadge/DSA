package datastructure.disjointset;

import java.util.HashMap;

public class DisjointSet {
    int[] parent;

    public DisjointSet(int size){
        parent = new int[size];
        makeSet();
    }

    private void makeSet(){
        for(int idx=0;idx<parent.length;idx++){
            parent[idx]=idx;
        }
    }

    public int find(int vertex){
        if(parent[vertex]!=vertex){
            parent[vertex] = find(parent[vertex]);
        }
        return parent[vertex];
    }

    public void union(int sVertex, int dVertex){
        parent[find(dVertex)] = find(sVertex);
    }
}

