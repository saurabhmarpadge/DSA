/*
Implement using linked-list, with tail pointer:
  enqueue(value) - adds value at position at tail
  dequeue() - returns value and removes least recently added element (front)
  empty()
Implement using fixed-sized array:
  enqueue(value) - adds item at end of available storage
  dequeue() - returns value and removes least recently added element
  empty()
  full()
*/

public class Queue {
  public static void main(String[] args){

  }
class Node{
    int val;
    Node next;
    Node(int item){
        this.val = item;
        next = null;
    }
}
 class QueueLinkedList{
      int size;
      int capacity;
      Node front;
      Node rear;
      QueueLinkedList(int capacity){
          Node front = null;
          Node rear = null;
          this.capacity = capacity;
          this.size = 0;
      }

      void enqueue(int item)  throws Exception{
          if(isFull()){
              throw new Exception();
          }
          Node node = new Node(item);
          if(front==null&&rear==null){
             front = node;
             rear = node;
          } else {
             node.next = front;
             front = node;
          }
          size++;
      }

      public int dequeue() throws Exception{
          if(isEmpty()){
              throw new Exception();
          }
          int result = front.val;
          if(front==rear){
              front = null;
              rear = null;
          } else {
              front = front.next;
          }
          size--;
          return result;
      }

      boolean isEmpty(){
          return front==null;
      }

      boolean isFull(){
          return size==capacity;
      }
  }

  public class QueueArray{
      int size;
      int capacity;
      int[] qArray;
      int front;
      int rear;
      QueueArray(int capacity){
          this.capacity = capacity;
          front = rear = -1;
          qArray = new int[capacity];
          size=0;
      }

      void enqueue(int item)  throws Exception{
          if(isFull()){
              throw new Exception();
          }
          if(front==-1&&rear==-1){
              front = 0;
              rear = 0;
              qArray[rear]=item;
          } else {
              rear = (rear+1)%capacity;
              qArray[rear]=item;
          }
          size++;
      }

      int dequeue()  throws Exception{
          if(isEmpty()){
              throw new Exception();
          }
          int result = qArray[front];
          front = (front+1)%this.capacity;
          size--;
          return result;
      }

      boolean isEmpty(){
          return size==0;
      }

      boolean isFull(){
          return size==capacity;
      }
  }
}
