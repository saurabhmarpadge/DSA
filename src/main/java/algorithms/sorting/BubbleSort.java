package algorithms.sorting;

import java.util.*;

public class BubbleSort{
    public static void main(String[] args){
        BubbleSort bSort = new BubbleSort();
        List<Integer> list = Arrays.asList(4,3,5,2,6,7);
        bSort.bubbleSort(list);
        list.forEach(System.out::print);
    }

    public void bubbleSort(List<Integer> list){
        for(int bigBubble=0;bigBubble<list.size();bigBubble++){
            boolean noSortNeeded = false;
            for(int bubbleIdx = bigBubble; bubbleIdx<list.size()-1; bubbleIdx++){
                if(list.get(bubbleIdx)>list.get(bubbleIdx+1)){
                    Collections.swap(list,bubbleIdx,bubbleIdx+1);
                    noSortNeeded = true;
                }
            }
            if(!noSortNeeded){
                break;
            }
        }
    }
}