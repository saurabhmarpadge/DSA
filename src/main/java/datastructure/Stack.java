/*
Implement Stack with Array
-push(x)
-pop()
-peek()
-size()
-isEmpty()
-isFull()
Implement Stack with LinkedList
-push(x)
-pop()
-peek()
-size()
-isEmpty()
-isFull()
*/

public class Stack {
  public static void main(String[] args){

  }

    class StackArray{
        int size;
        int[] sArray;
        int top;
        StackArray(int size){
            this.size = size;
            sArray = new int[size];
        }

        public boolean isEmpty(){
            return top==-1;
        }

        public int size(){
            return size;
        }

        public int peek() throws Exception{
            if(isEmpty()){
                throw new Exception();
            }
            return sArray[top];
        }

        public boolean isFull(){
            return top+1==size;
        }

        public int pop()throws Exception{
            if(isEmpty()){
                throw new Exception();
            }
            return sArray[top--];
        }


        public void push(int item)throws Exception{
            if(isFull()){
                throw new Exception();
            }
            sArray[top++]=item;
        }
    }

    class StackLinkedList{
        class Node{
            int item;
            Node next;
            Node(int item){
                this.item = item;
                this.next = null;
            }
        }

        Node head;
        int capacity;
        int size;
        StackLinkedList(int capacity){
            this.head = null;
            this.size = 0;
            this.capacity = capacity;
        }

        public boolean isEmpty(){
            return size==0;
        }

        public int size(){
            return size;
        }

        public int peek() throws Exception{
            if(isEmpty()){
                throw new Exception();
            }
            return head.item;
        }

        public boolean isFull(){
            return size==capacity;
        }

        public int pop() throws Exception{
            if(isEmpty()){
                throw new Exception();
            }
            Node node = head;
            head = head.next;
            size--;
            return node.item;
        }


        public void push(int item) throws Exception{
            if(isFull()){
                throw new Exception();
            }
            Node node = new Node(item);
            node.next = head;
            head = node;
            size++;
        }
    }


}
