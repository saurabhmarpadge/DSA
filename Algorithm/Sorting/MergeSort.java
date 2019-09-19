import java.util.*;

public class MergeSort{
    public static void main(String[] args){

    }

    public void mergeSort(ArrayList<Integer> list, int low, int high){
        int mid = low + (high-low)/2;
        mergeSort(list,low,mid);
        mergeSort(list,mid+1,high);
        merge(list,low,high);
    }

    public void merge(ArrayList<Integer> list, int low, int high){
        int mid = low+(high-low)/2;
        ArrayList<Integer> temp = new ArrayList<>();
        int secondStart = mid+1;
        int firstStart = low;
        while(firstStart<=mid&&secondStart<=high){
            if(list.get(firstStart)<=list.get(secondStart)){
                temp.add(list.get(firstStart));
                firstStart++;
            } else {
                temp.add(list.get(secondStart));
                secondStart++;
            }
        }
        while(firstStart<=mid){
            temp.add(list.get(firstStart));
            firstStart++;
        }
        while(secondStart<=high){
            temp.add(list.get(secondStart));
            secondStart++;
        }
        System.arraycopy(temp,0,list,low,high-low+1);
    }
}