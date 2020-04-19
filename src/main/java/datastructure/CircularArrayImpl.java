package datastructure;

import java.util.Iterator;

public class CircularArrayImpl {
    public static void main(String[] args) {
        CircularArray<String> circularArray = new CircularArray<>(5);
        for(int idx=0;idx<5;idx++){
            circularArray.set(idx,String.valueOf(idx));
        }

        circularArray.rotate(3);

        for(int idx=0;idx<5;idx++){
            System.out.println(circularArray.get(idx));
        }
        circularArray.rotate(5);
        Iterator itr = circularArray.iterator();
        System.out.println("Print using iterator");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}

class CircularArray<T> implements Iterable<T> {
    private T[] array;
    private int head=0;
    CircularArray(int capacity){
        array = (T[]) new Object[capacity];
    }

    private int convert(int index){
        if(index<0){
            index+=array.length;
        }
        return (head+index)%array.length;
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public T get(int index){
        if(index<0||index>=array.length){
            throw new IndexOutOfBoundsException();
        }
        return array[convert(index)];
    }

    public void set(int index, T item){
        if(index<0||index>=array.length){
            throw new IndexOutOfBoundsException();
        }
        array[convert(index)] = item;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator();
    }

    private class CircularArrayIterator implements Iterator<T>{
        int currIdx=-1;
        @Override
        public boolean hasNext() {
            return currIdx<array.length-1;
        }

        @Override
        public T next() {
            return (T) array[convert(++currIdx)];
        }
    }
}

