/*
 Implement:
    insert // insert value into tree
    get_node_count // get count of values stored
    print_values // prints the values in the tree, from min to max
    delete_tree
    is_in_tree // returns true if given value exists in the tree
    get_height // returns the height in nodes (single node's height is 1)
    get_min // returns the minimum value stored in the tree
    get_max // returns the maximum value stored in the tree
    is_binary_search_tree
    delete_value
    get_successor // returns next-highest value in tree after given value, -1 if none
*/

public class BinarySearchTree {
    Node root;
    public Node insertInBST(Node root, int item){
        Node node = new Node(item);
        if(root==null){
            root = node;
        } else if(root.item>item){
            root.left = insertInBST(root.left,item);
        } else {
            root.right = insertInBST(root.right,item);
        }
        return root;
    }
}

class Node {
    int item;
    Node left;
    Node right;
    Node(int item){
        this.item = item;
    }
}