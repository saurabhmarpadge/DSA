package datastructure;

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

class DSU {
    HashMap<Integer,Integer> map;
    DSU(){
        map = new HashMap<>();
    }

    public void union(int x, int y){
        map.put(find(y),find(x));
    }

    public int find(int x){
        if(map.putIfAbsent(x,x)==null){
            return x;
        }
        if(x!=map.get(x)){
            map.put(x,find(map.get(x)));
        }
        return map.get(x);
    }

}