package datastructure;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public static void main(String[] args){
        TrieArray trieArray = new TrieArray();
        trieArray.add("hack");
        trieArray.add("hackerrank");
        int count = trieArray.count("hac");
        int result = trieArray.count("hak");

        TrieNode trieMap = new TrieNode();
        trieMap.add("abc");
        trieMap.add("abc");
        trieMap.add("abc");
        trieMap.add("bc");
        int countTM = trieMap.count("abc",trieMap);
        trieMap.delete("abc");
        int resultTM = trieMap.count("abc",trieMap);
    }

}

class TrieArray{

    int count=0;
    TrieArray[] charArray;
    boolean endOfWord;
    TrieArray(){
        count=0;
        charArray = new TrieArray[26];
        endOfWord = false;
    }
    public void add(String str){
        if(str.isEmpty()){
            return;
        }
        if(this.charArray[str.charAt(0)-'a']==null){
            this.charArray[str.charAt(0)-'a'] = new TrieArray();
        }
        if(str.length()==1){
            this.charArray[str.charAt(0)-'a'].endOfWord=true;
        }
        this.charArray[str.charAt(0)-'a'].count++;
        this.charArray[str.charAt(0)-'a'].add(str.substring(1));
    }

    public int count(String str){
        if(str.isEmpty()||this.charArray[str.charAt(0)-'a']==null){
            return 0;
        }
        if(str.length()==1&&this.charArray[str.charAt(0)-'a'].endOfWord==true){
            return this.charArray[str.charAt(0)-'a'].count;
        }
        return charArray[str.charAt(0)-'a']!=null?charArray[str.charAt(0)-'a'].count(str.substring(1)):0;
    }

    public void delete(String str){
        if(str.isEmpty()){
            return;
        }
        if(str.length()==1&&this.charArray[str.charAt(0)-'a'].endOfWord&&this.charArray[str.charAt(0)-'a'].count==0){
            this.charArray[str.charAt(0)-'a'].endOfWord=false;
        }
        this.charArray[str.charAt(0)-'a'].count--;
        if(this.charArray[str.charAt(0)-'a'].count==0){
            this.charArray[str.charAt(0)-'a']=null;
        }
        this.charArray[str.charAt(0)-'a'].delete(str.substring(1));
    }
}


class TrieNode {

    int count=0;
    Map<Character, TrieNode> trieMap;
    boolean endOfWord;
    TrieNode(){
        this.count=0;
        this.trieMap = new HashMap<>();
        this.endOfWord = false;
    }
    public void add(String str){
        if(str.isEmpty()){
            return;
        }
        if(!this.trieMap.containsKey(str.charAt(0))){
            this.trieMap.put(str.charAt(0), new TrieNode());
        }
        if(str.length()==1){
            this.trieMap.get(str.charAt(0)).endOfWord=true;
        }
        this.trieMap.get(str.charAt(0)).count++;
        this.trieMap.get(str.charAt(0)).add(str.substring(1));
    }

    public int count(String str, TrieNode trieNode){
        if(str.isEmpty()){
            return trieNode.count;
        }
        return trieNode.trieMap.containsKey(str.charAt(0))? trieNode.count(str.substring(1),trieNode.trieMap.get(str.charAt(0))):0;
    }

    public void delete(String str){
        if(str.isEmpty()){
            return;
        }
        if(str.length()==1&&this.trieMap.get(str.charAt(0)).endOfWord&&this.trieMap.get(str.charAt(0)).count==0){
            this.trieMap.get(str.charAt(0)).endOfWord=false;
        }
        this.trieMap.get(str.charAt(0)).count--;
        if(this.trieMap.get(str.charAt(0)).count==0){
            this.trieMap.put(str.charAt(0),null);
        }
        this.trieMap.get(str.charAt(0)).delete(str.substring(1));
    }
}