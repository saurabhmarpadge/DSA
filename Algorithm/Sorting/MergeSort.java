import java.io.*;
import java.util.*;

public class MergeSort {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0) {
            int size = Integer.parseInt(br.readLine());
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            mergeSort(input);
            Arrays.stream(input).forEach(System.out::print);
            System.out.println();
        }
    }

    private static void mergeSort(int[] input) {
        mergeSort(input, 0, input.length-1);
    }

    public static void mergeSort(int[] lists, int low, int high){
        if(low==high){
            return;
        }
        int mid = low + ((high-low)>>1);
        mergeSort(lists,low,mid);
        mergeSort(lists,mid+1,high);
        merge(lists,low,high,mid);
    }

    private static void merge(int[] lists, int low, int high, int mid) {
        int p1 = low;
        int p2 = mid+1;
        int[] temp = new int[high-low+1];
        int tIdx = 0;
        while(p1<=mid&&p2<=high){
            if(lists[p1]<=lists[p2]){
                temp[tIdx++] = lists[p1++];
            } else {
                temp[tIdx++] = lists[p2++];
            }
        }
        while(p1<=mid){
            temp[tIdx++] = lists[p1++];
        }
        while(p2<=high){
            temp[tIdx++] = lists[p2++];
        }
        System.arraycopy(temp,0,lists,low,high-low+1);
    }
}
