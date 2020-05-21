package algorithms.tree;

public class SegmentTreeWithoutArray {

    public static void main(String[] args) {
        SegmentTreeWithoutArray segmentTreeWithoutArray =new SegmentTreeWithoutArray();
        int[] input = {7,12,23,13,6,9,17};
        SegmentTreeNode root = segmentTreeWithoutArray.build(0, input.length-1,input);
        System.out.println(segmentTreeWithoutArray.query(root,0,3));
        segmentTreeWithoutArray.modify(root,0,20);
        System.out.println(segmentTreeWithoutArray.query(root,0,3));
    }

    SegmentTreeNode build(int start, int end, int[] data){
        if(start==end){
            return new SegmentTreeNode(start,end,data[start]);
        }
        int mid = start + ((end-start)/2);
        SegmentTreeNode root = new SegmentTreeNode(start,end,0);
        root.left = build(start,mid,data);
        root.right = build(mid+1,end,data);
        root.value = root.left.value + root.right.value;
        return root;
    }

    void modify(SegmentTreeNode root, int index, int value){
        if(root.start==root.end&&root.start==index){
            root.value = value;
            return;
        }
        if(root.start==root.end){
            return;
        }
        int mid = root.mid();
        if(index<=mid){
            modify(root.left,index,value);
        } else {
            modify(root.right,index,value);
        }
        root.value = root.left.value + root.right.value;
    }

    int query(SegmentTreeNode root, int qstart, int qend){
        if(root==null||qend<root.start||root.end<qstart){
            return 0;
        }
        if(qstart<=root.start&&root.end<=qend){
            return root.value;
        }
        return query(root.left,qstart,qend)+query(root.right,qstart,qend);
    }
}

class SegmentTreeNode{
    int start; int end;
    int value;
    SegmentTreeNode left; SegmentTreeNode right;
    SegmentTreeNode(int start, int end, int value){
        this.start = start;
        this.end = end;
        this.value = value;
    }
    public int mid(){
        return start + ((end-start)/2);
    }
}