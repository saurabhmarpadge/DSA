/*
Implement a max-heap:
-insert
-heapifyUp - needed for insert
-peek - returns the max item, without removing it
-size() - return number of elements stored
-isEmpty() - returns true if heap contains no elements
-poll - returns the max item, removing it
-heapifyDown - needed for extract_max
-remove(i) - removes item at index x
 heapify - create a heap from an array of elements, needed for heap_sort
 heap_sort() - take an unsorted array and turn it into a sorted array in-place using a max heap
 note: using a min heap instead would save operations, but double the space needed (cannot do in-place).
*/

import java.io.*;
import java.util.*;

class Heap{

    int size = 0;
    int capacity = 5;

    long[] array = new long[capacity];

    public boolean hasLeftChild(int index){
        return getLeftChildIndex(index)<size;
    }

    public boolean hasRightChild(int index){
        return getRightChildIndex(index)<size;
    }

    public boolean hasParent(int index){
        return getParentIndex(index)>=0;
    }

    public int getLeftChildIndex(int index){
        return (index*2)+1;
    }

    public int getRightChildIndex(int index){
        return (index*2)+2;
    }

    public int getParentIndex(int index){
        return (index-1)/2;
    }

    public long leftChild(int index){
        return array[getLeftChildIndex(index)];
    }

    public long rightChild(int index){
        return array[getRightChildIndex(index)];
    }

    public long parent(int index){
        return array[getParentIndex(index)];
    }

    public void swap(long[] array, int first, int second){
        long temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public void heapifyUp(){
        int index = size-1;
        while(hasParent(index)&&array[index]<parent(index)){
                swap(array,index,getParentIndex(index));
                index = getParentIndex(index);
        }
    }

    public void heapifyDown(){
        int index = 0;
        while(index<size&&hasLeftChild(index)){
            int smallerIndex = array[index]<leftChild(index) ? index : getLeftChildIndex(index);
            if(hasRightChild(index)){
                smallerIndex = array[smallerIndex]<rightChild(index) ? smallerIndex : getRightChildIndex(index);
            }
            if(smallerIndex==index){
                break;
            }
            swap(array,index,smallerIndex);
            index = smallerIndex;
        }
    }

    public void ensureCapacity(){
        if(size==capacity){
            array = Arrays.copyOf(array,capacity*2);
            capacity = capacity * 2;
        }
    }

    public long peek(){
        return array[0];
    }

    public long poll(){
        long temp = array[0];
        array[0] = array[size-1];
        size--;
        heapifyDown();
        return temp;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void insert(long data){
        ensureCapacity();
        array[size] = data;
        size++;
        heapifyUp();
    }

}