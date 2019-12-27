/*
implement with array using linear probing
-hashFunction(k, m) - m is size of hash table
-put(key, value) - if key already exists, update value
-containsKey(key)
-get(key)
-remove(key)
*/

public class HashTable {
    HashItem[] hashItem;
    int capacity;
    HashTable(int capacity){
        this.capacity = capacity;
        hashItem = new HashItem[capacity];
    }
    public static void main(String[] args){

    }

    public HashItem get(int key){
        int hashKeyIndex = hashFunction(key);
        if(!containsKey(key)){
            return null;
        }
        while(hashItem[hashKeyIndex]!=null && hashItem[hashKeyIndex].getKey()!=key){
            hashKeyIndex = (hashKeyIndex + 1 ) % this.capacity;
        }
        return this.hashItem[hashKeyIndex];
    }

    public void put(int key, int value){
        int hashKeyIndex = hashFunction(key);
        while(hashItem[hashKeyIndex]!=null && hashItem[hashKeyIndex].getKey()!=key){
            hashKeyIndex = (hashKeyIndex + 1 ) % this.capacity;
        }
        if(hashItem[hashKeyIndex]!=null&&hashItem[hashKeyIndex].getKey()==key){
            hashItem[hashKeyIndex].value = value;
            return;
        }
        hashItem[hashKeyIndex] = new HashItem(key,value);
    }

    public void remove(int key){
        int hashKeyIndex = hashFunction(key);
        while(hashItem[hashKeyIndex]!=null && hashItem[hashKeyIndex].getKey()!=key){
            hashKeyIndex = (hashKeyIndex + 1 ) % this.capacity;
        }
        if(hashItem[hashKeyIndex]!=null&&hashItem[hashKeyIndex].getKey()==key){
            hashItem[hashKeyIndex] = null;
        }
    }

    public boolean containsKey(int key){
       int hashKeyIndex = hashFunction(key);
        while(hashItem[hashKeyIndex]!=null && hashItem[hashKeyIndex].getKey()!=key){
            hashKeyIndex = (hashKeyIndex + 1 ) % this.capacity;
        }
        return hashItem[hashKeyIndex]!=null&&hashItem[hashKeyIndex].getKey()==key;
    }

    public int hashFunction(int key){
        return key%this.capacity;
    }


}

class HashItem{
    int key;
    int value;
    HashItem(int key, int value){
        this.key = key;
        this.value = value;
    }
    public int getKey(){
        return key;
    }
}