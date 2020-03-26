/*
    Implement using linked-list, with tail pointer:
        -enqueue(value) - adds value at position at tail
        -dequeue() - returns value and removes least recently added element (front)
        -empty()
    Implement using fixed-sized array:
        -enqueue(value) - adds item at end of available storage
        -dequeue() - returns value and removes least recently added element
        -empty()
        -full()
*/

package datastructure;

public class Queue {
  public static void main(String[] args){

  }
class Node<T>{
    T val;
    Node next;
    Node(T item){
        this.val = item;
        next = null;
    }
}
 class QueueLinkedList<T>{
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

      public T dequeue() throws Exception{
          if(isEmpty()){
              throw new Exception();
          }
          T result = (T) front.val;
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

  public class QueueArray<T>{
      int size;
      int capacity;
      Object[] qArray;
      int front;
      int rear;
      QueueArray(int capacity){
          this.capacity = capacity;
          front = rear = -1;
          qArray = new Object[capacity];
          size=0;
      }

      void enqueue(T item)  throws Exception{
          if(isFull()){
              throw new Exception();
          }
          if(front==-1&&rear==-1){
              front = 0;
              rear = 0;
              qArray[rear]=item;
          } else {
              rear = (rear+1)%this.capacity;
              qArray[rear]=item;
          }
          size++;
      }

      T dequeue()  throws Exception{
          if(isEmpty()){
              throw new Exception();
          }
          T result = (T) qArray[front];
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
