package datastructure;

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
            return find(parent[vertex]);
        }
        return vertex;
    }

    public void union(int sVertex, int dVertex){
        int sParentSet = find(sVertex);
        int dParentSet = find(dVertex);
        parent[dParentSet] = sParentSet;
    }
}
