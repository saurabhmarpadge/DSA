package algorithms.rmq;

public class SqrtDecomposition {

    public static void main(String[] args) {
        SqrtDecomposition sqrtDecomposition = new SqrtDecomposition();
        int[] arr = new int[]{3,2,1,2,5,4,3,2,5,2,3};
        int blockSize = (int)Math.sqrt(arr.length);// Size of each block is by sqrt
        int[] blockSum = new int[arr.length/blockSize+1]; // no of blocks is total range/ sqrt block size
        sqrtDecomposition.preprocess(arr, blockSum, blockSize);
        System.out.println(sqrtDecomposition.query(1,7,arr,blockSum,blockSize));
        System.out.println(sqrtDecomposition.query(0,1,arr,blockSum,blockSize));
        System.out.println(sqrtDecomposition.query(0,2,arr,blockSum,blockSize));
        System.out.println(sqrtDecomposition.query(3,5,arr,blockSum,blockSize));
        System.out.println(sqrtDecomposition.query(4,7,arr,blockSum,blockSize));
    }

    void preprocess(int[] data, int[] blockSum, int blockSize){
        int blockIdx=-1;
        for(int idx=0;idx<data.length;idx++){
            if(idx%blockSize==0){
                blockIdx++;
            }
            blockSum[blockIdx]+=data[idx];
        }
    }

    int query(int start, int end, int[] data, int[] blockSum, int blockSize){
        int sum=0;
        // Will add elements start middle of the range and restrict to only one range block only
        while(start<end && start%blockSize !=0 && start!=0){
            sum+=data[start];
            start++;
        }
        // Will add complete block
        while (start+blockSize<=end){
            sum+=blockSum[start/blockSize];
            start+=blockSize;
        }
        // Will add remaining elements in the range, i..e last remaining one
        while (start<=end){
            sum+=data[start];
            start++;
        }
        return sum;
    }
}
