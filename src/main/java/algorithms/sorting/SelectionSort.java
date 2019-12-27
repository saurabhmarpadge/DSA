package algorithms.sorting;

import java.util.*;

public class SelectionSort{
    public static void main(String[] SelectionSort){
        SelectionSort sSort = new SelectionSort();
        List<Integer> list = Arrays.asList(4,3,5,2,6,7);
        sSort.selectionSort(list);
        list.forEach(System.out::print);
    }
    public void selectionSort(List<Integer> list){
        for(int index = 0; index<list.size()-1;index++){
            int smallestIdx = index;
            for(int sIdx=index+1;sIdx<list.size();sIdx++){
                if(list.get(sIdx)<list.get(smallestIdx)){
                    smallestIdx = sIdx;
                }
            }
            Collections.swap(list,smallestIdx,index);
        }
    }
}