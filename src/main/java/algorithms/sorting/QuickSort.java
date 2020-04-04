package algorithms.sorting;

import java.util.*;

public class QuickSort {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(5,4,3,2,1));
        quickSort(list,0,list.size()-1);
        list.forEach(System.out::println);
    }

    public static void quickSort(List<Integer> list, int low , int high){
        if(low>=high){
            return;
        }
        int pivot = partition(list,low,high);
        quickSort(list,low,pivot-1);
        quickSort(list,pivot+1,high);
    }

    public static int partition(List<Integer> list,int low, int high){
        int mid = low + ((high-low)>>1);
        while(low<high){
            while(list.get(low)<list.get(mid)){
                low++;
            }
            while(list.get(high)>list.get(mid)){
                high--;
            }
            if(low<high){
                Collections.swap(list,low,high);
                low++;
                high--;
            }
        }
        return low;
    }

}
