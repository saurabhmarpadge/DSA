package algorithms.tree;

import algorithms.bits.NextPowerOf2;

public class SegmentTreeWithLazyPropagation {
    int[] segmentTree;
    int[] data;
    int[] lazySegTree;

    SegmentTreeWithLazyPropagation(int[] data){
        int segTreeSize = 2*NextPowerOf2.nextPowerOf2(data.length);
        this.data = data;
        this.segmentTree = new int[segTreeSize];
        this.lazySegTree = new int[segTreeSize];
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,2,4,2,4,1};
        SegmentTreeWithLazyPropagation segmentTreeLP = new SegmentTreeWithLazyPropagation(input);
        segmentTreeLP.buildSegmentTree(0,input.length-1,0);
        System.out.println(segmentTreeLP.queryRangeSum(0,5,0,5,0));
        System.out.println(segmentTreeLP.queryRangeSum(0,2,0,5,0));
        System.out.println(segmentTreeLP.queryRangeSum(2,5,0,5,0));
        segmentTreeLP.updateRangeBy(0,5,0,5,0,1);
        System.out.println(segmentTreeLP.queryRangeSum(0,5,0,5,0));
        System.out.println(segmentTreeLP.queryRangeSum(0,2,0,5,0));
        System.out.println(segmentTreeLP.queryRangeSum(2,5,0,5,0));
    }

    public void buildSegmentTree(int start, int end, int segIdx){
        if(start==end){
            segmentTree[segIdx] = data[start];
            return;
        }
        int mid = start + ((end-start)/2);
        buildSegmentTree(start,mid,getLeftChildIndex(segIdx));
        buildSegmentTree(mid+1,end,getRightChildIndex(segIdx));
        segmentTree[segIdx] = segmentTree[getLeftChildIndex(segIdx)] + segmentTree[getRightChildIndex(segIdx)];
    }

    public void updateRangeBy(int qstart, int qend, int start, int end, int segIdx, int value){
       if(lazySegTree[segIdx]!=0){
            segmentTree[segIdx]+=(end-start+1)*lazySegTree[segIdx];
            if(start!=end){
                lazySegTree[getLeftChildIndex(segIdx)] = lazySegTree[segIdx];
                lazySegTree[getRightChildIndex(segIdx)] = lazySegTree[segIdx];
            }
            lazySegTree[segIdx]=0;
       }
       if(qend<start||end<qstart){
           return;
       }
       if(qstart<=start&&qend>=end){
            segmentTree[segIdx]+=(end-start+1)*value;
            if(start!=end){
                lazySegTree[getLeftChildIndex(segIdx)] = value;
                lazySegTree[getRightChildIndex(segIdx)] = value;
            }
            return;
       }
       int mid = start + ((end-start)/2);
       updateRangeBy(qstart,qend,start,mid,value,getLeftChildIndex(segIdx));
       updateRangeBy(qstart,qend,mid+1,end,value,getRightChildIndex(segIdx));
       segmentTree[segIdx] = segmentTree[getLeftChildIndex(segIdx)] + segmentTree[getRightChildIndex(segIdx)];
    }

    public int queryRangeSum(int qstart, int qend, int start, int end, int segIdx){
        if(start>end){
            return 0;
        }
        if(lazySegTree[segIdx]!=0){
            segmentTree[segIdx] += (end-start+1)*lazySegTree[segIdx];
            if(start!=end){
                lazySegTree[getLeftChildIndex(segIdx)] += lazySegTree[segIdx];
                lazySegTree[getRightChildIndex(segIdx)] += lazySegTree[segIdx];
            }
            lazySegTree[segIdx]=0;
        }
        // No overlap
        if(qend<start||qstart>end){
            return 0;
        }
        //Total overlap
        if(qstart<=start&&qend>=end){
            return segmentTree[segIdx];
        }
        //Partial overlap
        int mid = start + ((end-start)/2);
        return queryRangeSum(qstart,qend,start,mid,getLeftChildIndex(segIdx))
                + queryRangeSum(qstart,qend,mid+1,end,getRightChildIndex(segIdx));
    }


    private int getLeftChildIndex(int segIdx) {
        return 2*segIdx+1;
    }

    private int getRightChildIndex(int segIdx) {
        return 2*segIdx+2;
    }
}
