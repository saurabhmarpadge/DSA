/*
-size() - number of items
-capacity() - number of items it can hold
-is_empty()
-get(index) - returns item at given index, blows up if index out of bounds
-push(item)
-insert(index, item) - inserts item at index, shifts that index's value and trailing elements to the right
-prepend(item) - can use insert above at index 0
-pop() - remove from end, return value
-delete(index) - delete item at index, shifting all trailing elements left
-remove(item) - looks for value and removes index holding it (even if in multiple places)
-find(item) - looks for value and returns first index with that value, -1 if not found
-resize(new_capacity) // private function
    when you reach capacity, resize to double the size
    when popping an item, if size is 1/4 of capacity, resize to half
*/

public class Arrays {
    private int[] baseArray;
  private int capacity;
    private int currentCapacity;
    Arrays(){
        this.capacity = 10;
        this.baseArray = new int[capacity];
        this.currentCapacity = 0;
    }

    public int size(){
        return currentCapacity;
    }
    public int capacity(){
        return capacity;
    }
    public boolean isEmpty(){
        return currentCpacity==0;
    }


    public int get(int index){
        rangeCheck(index);
        return baseArray[index];
    }

    public void push(int item){
        ensureCapacity();
        baseArray[currentCapacity++] = item;
    }

    public void insert(int index, int item){
        rangeCheck(index);
        ensureCapacity();
        System.copyarray(baseArray,index,baseArray,index+1,size()-index+1);
        baseArray[index] = item;
    }

    public void prepend(int item){
        insert(item,0);
    }

    public int pop(){
        if(isEmpty()){
            throw new Exception();
        }
        int result = baseArray[currentCpacity--];
        ensureCapacity();
        return result;
    }

    public int delete(int index){
        rangeCheck(index);
        int result = baseArray[index];
        System.copyarray(baseArray,index+1,baseArray,index,size()-index+2);
        return result;
    }

    public void remove(int item){
        int[] temp = new int[capacity];
        int tempIdx = 0;
        for(int num:baseArray){
            if(num!=temp){
                temp[tempIdx++] = num;
            }
        }
        currentCpacity = tempIdx;
        baseArray = temp;
    }

    public int find(int item){
        rangeCheck(index);
        for(int idx = 0;idx<currentCapacity;idx++){
            if(item==baseArray[idx]){
               return idx;
            }
        }
        return -1;
    }

    public void resize(int newCapacity){
        baseArray = Array.copyOf(baseArray,newCapacity);
    }

    void ensureCapacity(){
        if(currentCapcity==capacity){
            resize(2*capacity);
        } else if(currentCapcity<(capacity/2)){
            resize(capacity/2);
        }
    }

  public static void main(String[] args){

  }
}
