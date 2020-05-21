package algorithms.tree;/*
 Implement:
    -insertInBST // insert value into tree
    get_node_count // get count of values stored
    -printValues // prints the values in the tree, from min to max
    -deleteTree
    -searchInBST // returns true if given value exists in the tree
    -getHeight // returns the height in nodes (single node's height is 1)
    -getMin // returns the minimum value stored in the tree
    -getMax // returns the maximum value stored in the tree
    -isBinarySearchTree
    -delete_value
    -get_successor // returns next-highest value in tree after given value, -1 if none
*/

public class BinarySearchTree {
    Node root;

    public static void main(String[] args){
        int[] input = {4,2,6,1,3,5,7};
        BinarySearchTree bst = new BinarySearchTree();
        for(int num:input){
            bst.root = bst.insertInBST(bst.root,num);
        }
        bst.printValues(bst.root);
        System.out.println();
        bst.deleteNode(bst.root,4);
        bst.printValues(bst.root);
        System.out.println();
        bst.deleteNode(bst.root,6);
        bst.printValues(bst.root);
        System.out.println();
        bst.deleteNode(bst.root,3);
        bst.printValues(bst.root);
    }

    public Node insertInBST(Node root, int item){
        if(root==null){
            root = new Node(item);
        } else if(root.item>item){
            root.left = insertInBST(root.left,item);
        } else {
            root.right = insertInBST(root.right,item);
        }
        return root;
    }

    public void deleteTree(Node root){
       root = null;
    }

    public int getHeight(Node root){
        if(root==null){
            return -1;
        }
        return 1 + Math.max(getHeight(root.left),getHeight(root.right));
    }

    public Node getSuccessor(Node root){
        if(root==null){
            return root;
        }
        Node curr = root;
        while(curr.left!=null){
            curr = curr.left;
        }
        return curr;
    }

    public Node searchInBST(Node root, int item){
       if(root==null){
           return root;
       }
       if(root.item>item){
           return searchInBST(root.left,item);
       }
       if(root.item<item){
           return searchInBST(root.right,item);
       }
       return root;
    }

    public Node getMin(Node root, int item){
        Node curr = root;
       if(root==null){
           return root;
       }
       while(curr.left!=null){
           curr = curr.left;
       }
       return curr;
    }

    public Node getMax(Node root, int item){
        Node curr = root;
       if(root==null){
           return root;
       }
       while(curr.right!=null){
           curr = curr.right;
       }
       return curr;
    }

    public void printValues(Node root){
        if(root == null){
            return;
        }
        printValues(root.left);
        System.out.print(root.item+" ");
        printValues(root.right);
    }

    public boolean isBinarySearchTree(Node root,int min,int max){
        if(root == null){
            return true;
        }
        if(root.item>=max||root.item<=min){
            return false;
        }
        return isBinarySearchTree(root.left,min,root.item) && isBinarySearchTree(root.right,root.item,max);
    }

    public Node deleteNode(Node root, int value){
        if(root==null){
            return root;
        }

        if(root.item>value){
            root.left = deleteNode(root.left,value);
        } else if(root.item<value){
            root.right = deleteNode(root.right, value);
        } else {
            if(root.left==null&& root.right==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }
            if(root.right==null) {
                return root.left;
            }
            Node succ = getSuccessor(root.right);
            root.item=succ.item;
            root.right = deleteNode(root.right,succ.item);
        }
        return root;
    }
}

class Node {
    int item;
    Node left;
    Node right;
    public Node(int item){
        this.item = item;
    }
}