/*
basic tree construction
-traversal
manipulation algorithms
BFS(breadth-first search) and DFS(depth-first search) (video)
    BFS notes:
        -level order (BFS, using queue)
        time complexity: O(n)
        space complexity: best: O(1), worst: O(n/2)=O(n)
    DFS notes (Implement Recursively):
        time complexity: O(n)
        space complexity: best: O(log n) - avg. height of tree worst: O(n)
        -inorder (DFS: left, self, right)
        -postorder (DFS: left, right, self)
        -preorder (DFS: self, left, right)
    DFS notes (Implement Iteratively):
        time complexity: O(n)
        space complexity: best: O(log n) - avg. height of tree worst: O(n)
        inorder (DFS: left, self, right)
        postorder (DFS: left, right, self)
        preorder (DFS: self, left, right)

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {

  public static void main(String[] args){
      Node c = new Node(null,3,null);
      Node d = new Node(null,4,null);
      Node f = new Node(null,5,null);
      Node b = new Node(d,2,f);
      Node a = new Node(b,1,c);

      inOrder(a);
  }

  public static ArrayList<ArrayList<Integer>> levelOrder(Node head){
      ArrayList<ArrayList<Integer>> result = new ArrayList<>();
      Queue<Node> queue = new LinkedList<>();
      queue.offer(head);
      queue.offer(null);
      ArrayList<Integer> curr = new ArrayList<>();
      while(!queue.isEmpty()){
          Node temp = queue.poll();
          if(temp!=null){
              curr.add(temp.item);
              if(temp.left!=null){
                  queue.offer(temp.left);
              }
              if(temp.right!=null){
                  queue.offer(temp.right);
              }
          } else {
              result.add(new ArrayList<>(curr));
              curr.clear();
              if(!queue.isEmpty()){
                  queue.offer(null);
              }
          }
      }
      return result;
  }

  public static void inOrder(Node node){
      if(node==null){
          return;
      }
      inOrder(node.left);
      System.out.println(node.item);
      inOrder(node.right);
  }

  public static void preOrder(Node node){
      if(node==null){
          return;
      }

      System.out.println(node.item);
      preOrder(node.left);
      preOrder(node.right);
  }

  public static void postOrder(Node node){
      if(node==null){
          return;
      }

      postOrder(node.left);
      postOrder(node.right);
      System.out.println(node.item);
  }
}
    class Node {
        int item;
        Node left;
        Node right;
        Node(Node left,int item,Node right){
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }