package algorithms.String.bst;/*
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
    delete_value
    get_successor // returns next-highest value in tree after given value, -1 if none
*/

public class BinarySearchTree {
    Node root;

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
        if(root==null||root.right==null){
            return root;
        }
        Node curr = root.right;
        while(curr.left!=null){
            curr = curr.left;
        }
        return curr;
    }

    public Node searchInBST(Node root, int item){
       if(root==null){
           return null;
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
        System.out.println(root.item);
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
}

class Node {
    int item;
    Node left;
    Node right;
    public Node(int item){
        this.item = item;
    }
}