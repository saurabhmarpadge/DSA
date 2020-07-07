package algorithms.tree;

import algorithms.bits.NextPowerOf2;

public class SegmentTree {
    int[] data;
    int[] segmentTree;
//    Size of segment tree is 2 * (2^log(n) base 2) - 1
//    Size of Segment tree is 2 * (next of power from size of data) -1
    public static void main(String[] args){
        int[] input = {7,12,23,13,6,9,17};
        SegmentTree segmentTree = new SegmentTree(input);
        segmentTree.createSegmentTree(0,input.length-1,0);
        System.out.println(segmentTree.queryTree(0,3,0,input.length-1,0));
        segmentTree.updateTree(17,0,0,input.length-1,0);
        System.out.println(segmentTree.queryTree(0,0,0,input.length-1,0));
    }
    SegmentTree(int[] input){
        this.data = input;
        //int x = (int)Math.ceil(Math.log(data.length)/Math.log(2));
        //int segTreeSize = 2*(int)Math.pow(2,x)+1;
        int segTreeSize = NextPowerOf2.nextPowerOf2(input.length)*2-1;
        this.segmentTree = new int[segTreeSize];
    }

    public void createSegmentTree(int low, int high, int segIdx){
        if(low==high){
            segmentTree[segIdx] = data[low];
            return;
        }
        int mid = low + ((high-low)/2);
        createSegmentTree(low,mid,segIdx*2+1);
        createSegmentTree(mid+1,high,segIdx*2+2);
        segmentTree[segIdx] = segmentTree[segIdx*2+1] + segmentTree[segIdx*2+2];
    }

    public int queryTree(int qstart, int qend,int low, int high, int segIdx){
        if(low>high){
            return 0;
        }
        // No overlap
        if(qstart>high||qend<low){
            return 0;
        }
        //Total overlap
        if(qstart<=low&&qend>=high){
            return segmentTree[segIdx];
        }
        //Partial overlap
        int mid = low + ((high-low)/2);
        return queryTree(qstart,qend,low,mid,segIdx*2+1) + queryTree(qstart,qend,mid+1,high,segIdx*2+2);
    }

    public void updateTree(int x,int pos,int low, int high, int segIdx){
        if(low==high&&low==pos){
            segmentTree[segIdx] = x;
            return;
        }
        if(low==high){
            return;
        }
        int mid = low + ((high-low)/2);
        updateTree(x,pos,low,mid,segIdx*2+1);
        updateTree(x,pos,mid+1,high,segIdx*2+2);
        segmentTree[segIdx] = segmentTree[segIdx*2+1] + segmentTree[segIdx*2+2];
    }

}