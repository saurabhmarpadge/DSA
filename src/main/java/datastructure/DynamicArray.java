/*
-size() - number of items
-capacity() - number of items it can hold
-is_empty()
-get(index) - returns item at given index, blows up if index out of bounds
-add(item)
-insertAt(index, item) - inserts item at index, shifts that index's value and trailing elements to the right
-prepend(item) - can use insert above at index 0
-pop() - remove from end, return value
-delete(index) - delete item at index, shifting all trailing elements left
-remove(item) - looks for value and removes index holding it (even if in multiple places)
-firstOccur(item) - looks for value and returns first index with that value, -1 if not found
-resize(new_capacity) // private function
    when you reach capacity, resize to double the size
    when popping an item, if size is 1/4 of capacity, resize to half
*/
package datastructure;

import java.util.Arrays;

public class DynamicArray<T> {
    private Object[] baseArray;
    private int capacity;
    private int currentCapacity;
    DynamicArray(){
        this.capacity = 10;
        this.baseArray = new Object[capacity];
        this.currentCapacity = 0;
    }

    public int size(){
        return currentCapacity;
    }
    public int capacity(){
        return capacity;
    }
    public boolean isEmpty(){
        return currentCapacity==0;
    }


    public T get(int index){
        rangeCheck(index);
        return (T) baseArray[index];
    }

    private void rangeCheck(int index) {
        if(index<0||index>=currentCapacity){
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(T item){
        ensureCapacity();
        baseArray[currentCapacity++] = item;
    }

    public void insertAt(T item,int index){
        rangeCheck(index);
        ensureCapacity();
        System.arraycopy(baseArray,index,baseArray,index+1,size()-index+1);
        baseArray[index] = item;
    }

    public void prepend(T item){
        insertAt(item,0);
    }

    public T pop() throws IllegalAccessException {
        if(isEmpty()){
            throw new IllegalAccessException();
        }
        T result = (T)baseArray[currentCapacity--];
        ensureCapacity();
        return result;
    }

    public T delete(int index){
        rangeCheck(index);
        T result = (T)baseArray[index];
        System.arraycopy(baseArray,index+1,baseArray,index,currentCapacity-index-1);
        currentCapacity--;
        return result;
    }

    public void remove(T item){
        Object[] temp = new Object[capacity];
        int tempIdx = 0;
        for(Object num:baseArray){
            if(num!=item){
                temp[tempIdx++] = num;
            }
        }
        currentCapacity = tempIdx;
        baseArray = temp;
    }

    public void removeInPlace(T item){
        for(int idx=0;idx<currentCapacity;idx++){
            if(baseArray[idx]==item){
                delete(idx);
            }
        }
    }

    public int firstOccur(T item){
        for(int idx = 0;idx<currentCapacity;idx++){
            if(item==baseArray[idx]){
               return idx;
            }
        }
        return -1;
    }

    public void resize(int newCapacity){
        baseArray = Arrays.copyOf(baseArray,newCapacity);
    }

    void ensureCapacity(){
        if(currentCapacity==capacity){
            resize(2*capacity);
        } else if(currentCapacity<(capacity/2)){
            resize(capacity/2);
        }
    }

  public static void main(String[] args){
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        System.out.println(dynamicArray.size());
  }
}
