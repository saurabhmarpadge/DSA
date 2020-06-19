package algorithms.rmq;

public class SparseTable {
    int[] data;
    int[][] stable;
    SparseTable(int[] data){
        this.data = data;
        int k = (int) Math.ceil(Math.log(data.length)/Math.log(2));
        this.stable = new int[data.length][k+1];
        precompute();
    }

    public int queryFinMin(int start, int end){
        int min=Integer.MAX_VALUE;
        for(int k=stable[0].length-1;k>=0;k--){
            if((1<<k)<=end-start+1){
                min = Math.min(min,stable[start][k]);
                start+= (1<<k);
            }
        }
        return min;
    }

    public void precompute(){
        for(int idx=0;idx<stable.length;idx++){
            stable[idx][0] = data[idx];
        }
        for(int k=1;k<stable[0].length;k++){
            for(int idx=0;idx+(1<<(k-1))<stable.length;idx++){
                stable[idx][k] = Math.min(stable[idx][k-1],
                                    stable[idx+(1<<(k-1))][k-1]);
            }
        }
    }

    public static void main(String[] args) {
        SparseTable sparseTable = new SparseTable(new int[]{1,4,1});
        System.out.println(sparseTable.queryFinMin(1,1));
        System.out.println(sparseTable.queryFinMin(1,2));
    }
}
