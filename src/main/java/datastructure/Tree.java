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
        -inorder (DFS: left, self, right)
        -postorder (DFS: left, right, self)
        -preorder (DFS: self, left, right)

*/

package datastructure;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

  public static void main(String[] args){
      Node g = new Node(null,5,null);
      Node h = new Node(null,7,null);
      Node c = new Node(g,6,h);
      Node d = new Node(null,1,null);
      Node f = new Node(null,3,null);
      Node b = new Node(d,2,f);
      Node a = new Node(b,4,c);
      ArrayList<Integer> integers = postOrderItr(a);
  }

  public static ArrayList<Integer> inOrderItr(Node root){
      ArrayList<Integer> result = new ArrayList<>();
      Stack<Node> stack = new Stack<>();
      Node curr = root;
      while(curr!=null){
          stack.push(curr);
          curr = curr.left;
      }
      while(!stack.isEmpty()){
          curr = stack.pop();
          result.add(curr.item);
          if(curr.right!=null){
              curr = curr.right;
              while(curr!=null){
                  stack.push(curr);
                  curr = curr.left;
              }
          }
      }
      return result;
  }

    public static ArrayList<Integer> preOrderItr(Node root){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr!=null){
            result.add(curr.item);
            stack.push(curr);
            curr = curr.left;
        }
        while(!stack.isEmpty()){
            curr = stack.pop();
            if(curr.right!=null){
                curr = curr.right;
                while(curr!=null){
                    result.add(curr.item);
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> postOrderItr(Node root){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Stack<Node> stackPrint = new Stack<>();
        Node curr = root;
        stack.push(curr);
        while(!stack.isEmpty()){
            curr = stack.pop();
            stackPrint.push(curr);
            if(curr.left!=null){
                stack.push(curr.left);
            }
            if(curr.right!=null){
                stack.push(curr.right);
            }
        }
        while(!stackPrint.isEmpty()){
            result.add(stackPrint.pop().item);
        }
        return result;
    }

    public static ArrayList<Integer> postOrderItrApproach2(Node root){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Stack<Node> stackPrint = new Stack<>();
        Node curr = root;
        while(curr!=null){
            stack.push(curr);
            curr = curr.left;
        }
        while(!stack.isEmpty()){
            curr = stack.pop();
            if(!stackPrint.isEmpty()&&curr==stackPrint.peek()){
                stackPrint.pop();
                result.add(curr.item);
                continue;
            } else {
                if(curr.right!=null){
                    stack.push(curr);
                    stackPrint.push(curr);
                    curr = curr.right;
                    while(curr!=null){
                        stack.push(curr);
                        curr = curr.left;
                    }
                } else {
                    result.add(curr.item);
                }
            }
        }
        return result;
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