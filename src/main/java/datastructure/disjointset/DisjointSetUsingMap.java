package datastructure.disjointset;

import java.util.HashMap;

public class DisjointSetUsingMap {
    HashMap<Integer,Integer> map;
    DisjointSetUsingMap(){
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
