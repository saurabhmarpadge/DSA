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
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

  public static void main(String[] args){
      TreeNode g = new TreeNode(null,5,null);
      TreeNode h = new TreeNode(null,7,null);
      TreeNode c = new TreeNode(g,6,h);
      TreeNode d = new TreeNode(null,1,null);
      TreeNode f = new TreeNode(null,3,null);
      TreeNode b = new TreeNode(d,2,f);
      TreeNode a = new TreeNode(b,4,c);
      ArrayList<Integer> integers = postOrderItrApproach2(a);
      System.out.println(integers.toString());
      postTravItrApproachThree(a);
  }

  public static ArrayList<Integer> inOrderItr(TreeNode root){
      ArrayList<Integer> result = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      TreeNode curr = root;
      while(curr!=null){
          stack.push(curr);
          curr = curr.left;
      }
      while(!stack.isEmpty()){
          curr = stack.pop();
          result.add(curr.val);
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

    public static ArrayList<Integer> preOrderItr(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null){
            result.add(curr.val);
            stack.push(curr);
            curr = curr.left;
        }
        while(!stack.isEmpty()){
            curr = stack.pop();
            if(curr.right!=null){
                curr = curr.right;
                while(curr!=null){
                    result.add(curr.val);
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> postTravItrApproachOne(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stackPrint = new Stack<>();
        TreeNode curr = root;
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
            result.add(stackPrint.pop().val);
        }
        return result;
    }

    public static List<Integer> postTravItrApproachTwo(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if(prev==null||prev.left==null||prev.right==null){
                if(curr.left!=null){
                    stack.push(curr.left);
                } else if(curr.right!=null){
                    stack.push(curr.right);
                }
            } else if(curr.left==prev){
                if(curr.right!=null){
                    stack.push(curr.right);
                }
            } else  {
                stack.pop();
                result.add(curr.val);
            }
            prev = curr;
        }
        return result;
    }

    public static List<Integer> postTravItrApproachThree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if(prev==null||prev.left==null||prev.right==null){
                if(curr.left!=null){
                    stack.push(curr.left);
                } else if(curr.right!=null){
                    stack.push(curr.right);
                } else  {
                    stack.pop();
                    result.add(curr.val);
                }
            } else if(curr.left==prev){
                if(curr.right!=null){
                    stack.push(curr.right);
                } else  {
                    stack.pop();
                    result.add(curr.val);
                }
            } else if(curr.right==prev) {
                stack.pop();
                result.add(curr.val);
            }
            prev = curr;
        }
        return result;
    }

    public static ArrayList<Integer> postOrderItrApproach2(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stackPrint = new Stack<>();
        TreeNode curr = root;
        while(curr!=null){
            stack.push(curr);
            curr = curr.left;
        }
        while(!stack.isEmpty()){
            curr = stack.pop();
            if(!stackPrint.isEmpty()&&curr==stackPrint.peek()){
                stackPrint.pop();
                result.add(curr.val);
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
                    result.add(curr.val);
                }
            }
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode head){
      ArrayList<ArrayList<Integer>> result = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(head);
      queue.offer(null);
      ArrayList<Integer> curr = new ArrayList<>();
      while(!queue.isEmpty()){
          TreeNode temp = queue.poll();
          if(temp!=null){
              curr.add(temp.val);
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

  public static void inOrder(TreeNode treeNode){
      if(treeNode ==null){
          return;
      }
      inOrder(treeNode.left);
      System.out.println(treeNode.val);
      inOrder(treeNode.right);
  }

  public static void preOrder(TreeNode treeNode){
      if(treeNode ==null){
          return;
      }

      System.out.println(treeNode.val);
      preOrder(treeNode.left);
      preOrder(treeNode.right);
  }

  public static void postOrder(TreeNode treeNode){
      if(treeNode ==null){
          return;
      }

      postOrder(treeNode.left);
      postOrder(treeNode.right);
      System.out.println(treeNode.val);
  }
}
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(TreeNode left, int val, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }