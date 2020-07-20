package algorithms.tree;

public class AVLTree {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        TreeNode root = null;
        root = avlTree.insertBBST(root,3);
        root = avlTree.insertBBST(root,2);
        root = avlTree.insertBBST(root,4);
        root = avlTree.insertBBST(root,5);
        root = avlTree.insertBBST(root,6);
        System.out.println(root.val);
    }

    public TreeNode insertBBST(TreeNode root, int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(val<root.val){
            root.left = insertBBST(root.left,val);
        } else if(val>root.val){
            root.right = insertBBST(root.right,val);
        }
        root.height = calculateHeight(root);
        int bal = getHeight(root.left)-getHeight(root.right);
        if(Math.abs(bal)>1){
            root = rebalance(root,bal,val);
        }
        return root;
    }

    private TreeNode rebalance(TreeNode root, int bal, int val){
        if(bal==2&&val<root.left.val){
            root = rotateRight(root);
        } else if(bal==2&&val>root.left.val){
            root.left = rotateLeft(root.left);
            root = rotateRight(root);
        } else if(bal==-2&&val>root.right.val){
            root = rotateLeft(root);
        } else if(bal==-2&&val<root.right.val){
            root.right = rotateRight(root.right);
            root = rotateLeft(root);
        }
        return root;
    }

    private TreeNode rotateRight(TreeNode root){
        TreeNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right=root;
        root.height = calculateHeight(root);
        newRoot.height = calculateHeight(newRoot);
        return newRoot;
    }

    private TreeNode rotateLeft(TreeNode root){
        TreeNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.height = calculateHeight(root);
        newRoot.height = calculateHeight(newRoot);
        return newRoot;
    }

    private int calculateHeight(TreeNode root){
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    private int getHeight(TreeNode root) {
        if(root==null){
            return -1;
        }
        return root.height;
    }
}

class TreeNode {
    int val;
    int height;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.height=0;
        this.left=null;
        this.right=null;
    }
}