package algorithms.sorting;

import java.util.*;

public class InsertionSort{
    public static void main(String[] args){
        InsertionSort iSort = new InsertionSort();
        List<Integer> list = Arrays.asList(4,3,5,2,6,7);
        iSort.insertionSort(list);
        list.forEach(System.out::print);
    }
    public void insertionSort(List<Integer> list){
        for(int idx=1;idx<list.size();idx++){
            int x = list.get(idx);
            int swapIdx = idx-1;
            while(swapIdx>=0&&x<=list.get(swapIdx)){
                Collections.swap(list,swapIdx,swapIdx+1);
                swapIdx--;
            }
            list.set(swapIdx+1,x);
        }
    }
}