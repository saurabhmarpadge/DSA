package algorithms.dynamicprogramming;

import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {
        int sackSize = 9;
        int[] weights = new int[]{1,2,1,2,3,4,5,6,7};
        int[] values  = new int[]{2,1,5,3,7,1,3,6,5};
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.knapsackZeroOneRec(sackSize,values,weights));
        System.out.println(knapsack.knapsackZeroOneRecMemo(sackSize,values,weights));
        System.out.println(knapsack.knapsackZeroOneTabulation(sackSize,values,weights));

        System.out.println(knapsack.knapsackUnboundedRec(sackSize,values,weights));
        System.out.println(knapsack.knapsackUnboundedRecMemo(sackSize,values,weights));
        System.out.println(knapsack.knapsackUnboundedTabulation(sackSize,values,weights));
    }

    public int knapsackZeroOneRec(int sackSize, int[] values, int[] weights){
        return knapsackZeroOneRec(sackSize,values,weights,weights.length-1);
    }
    public int knapsackZeroOneRec(int sackSize, int[] values, int[] weights, int itemNo){
        if(itemNo<0||sackSize<=0){
            return 0;
        }
        if(sackSize>=weights[itemNo]){
            return Math.max(values[itemNo]+knapsackZeroOneRec(sackSize-weights[itemNo],values,weights,itemNo-1),
                            knapsackZeroOneRec(sackSize,values,weights,itemNo-1));
        }
        return knapsackZeroOneRec(sackSize,values,weights,itemNo-1);
    }

    public int knapsackZeroOneRecMemo(int sackSize, int[] values, int[] weights){
        int[][] memo = new int[sackSize+1][weights.length+1];
        for(int[] mm:memo){
            Arrays.fill(mm,-1);
        }
        return knapsackZeroOneRecMemo(sackSize,values,weights,weights.length-1,memo);
    }

    public int knapsackZeroOneRecMemo(int sackSize, int[] values, int[] weights, int itemNo, int[][] memo){
        if(itemNo<0||sackSize==0){
            return 0;
        }
        if(memo[sackSize][itemNo]!=-1){
            return memo[sackSize][itemNo];
        }

        int maximum=Integer.MIN_VALUE;
        if(sackSize>=weights[itemNo]){
            maximum = Math.max( values[itemNo] + knapsackZeroOneRecMemo(sackSize-weights[itemNo],values,weights,itemNo-1,memo),
                    knapsackZeroOneRecMemo(sackSize,values,weights,itemNo-1,memo));
        }
        memo[sackSize][itemNo] = Math.max(maximum,knapsackZeroOneRecMemo(sackSize,values,weights,itemNo-1,memo));
        return memo[sackSize][itemNo];
    }

    public int knapsackZeroOneTabulation(int sackSize, int[] values, int[] weights){
        int[][] memo = new int[sackSize+1][weights.length+1];
        for(int rS=1;rS<memo.length;rS++){
            for(int itemIdx=1;itemIdx<memo[0].length;itemIdx++){
                if(rS-weights[itemIdx-1]>=0){
                    memo[rS][itemIdx] = Math.max(values[itemIdx-1]+memo[rS-weights[itemIdx-1]][itemIdx-1],
                                                memo[rS][itemIdx-1]);
                } else {
                    memo[rS][itemIdx] = memo[rS][itemIdx-1];
                }
            }
        }
        return memo[sackSize][weights.length];
    }

    public int knapsackUnboundedRec(int sackSize, int[] values, int[] weights){
        return knapsackUnboundedRec(sackSize,values,weights,weights.length-1);
    }

    public int knapsackUnboundedRec(int sackSize, int[] values, int[] weights, int itemNo){
        if(itemNo<0||sackSize<=0){
            return 0;
        }
        if(sackSize>=weights[itemNo]){
            return Math.max(values[itemNo]+knapsackUnboundedRec(sackSize-weights[itemNo],values,weights,itemNo),
                    knapsackUnboundedRec(sackSize,values,weights,itemNo-1));
        }
        return knapsackUnboundedRec(sackSize,values,weights,itemNo-1);
    }

    public int knapsackUnboundedRecMemo(int sackSize, int[] values, int[] weights){
        int[][] memo = new int[sackSize+1][weights.length+1];
        for(int[] mm:memo){
            Arrays.fill(mm,-1);
        }
        return knapsackUnboundedRecMemo(sackSize,values,weights,weights.length-1,memo);
    }

    public int knapsackUnboundedRecMemo(int sackSize, int[] values, int[] weights, int itemNo, int[][] memo){
        if(itemNo<0||sackSize<=0){
            return 0;
        }
        if(memo[sackSize][itemNo]!=-1){
            return memo[sackSize][itemNo];
        }
        int maximum = Integer.MIN_VALUE;
        if(sackSize>=weights[itemNo]){
            maximum = Math.max(values[itemNo]+knapsackUnboundedRecMemo(sackSize-weights[itemNo],values,weights,itemNo,memo),
                    knapsackUnboundedRecMemo(sackSize,values,weights,itemNo-1,memo));
        } else {
            maximum = Math.max(maximum,knapsackUnboundedRecMemo(sackSize,values,weights,itemNo-1,memo));
        }
        memo[sackSize][itemNo]=maximum;
        return maximum;
    }

    public int knapsackUnboundedTabulation(int sackSize, int[] values, int[] weights){
        int[][] memo = new int[sackSize+1][weights.length+1];
        for(int rS=1;rS<=sackSize;rS++){
            for(int itemIdx=1;itemIdx<=weights.length;itemIdx++){
                if(rS-weights[itemIdx-1]>=0){
                    memo[rS][itemIdx] = Math.max(values[itemIdx-1]+memo[rS-weights[itemIdx-1]][itemIdx],
                                                memo[rS][itemIdx-1]);
                } else {
                    memo[rS][itemIdx] = memo[rS][itemIdx-1];
                }
            }
        }
        return memo[sackSize][weights.length];
    }

}

