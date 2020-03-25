/*
    -size() - returns number of data elements in list
    -empty() - bool returns true if empty
    value_at(index) - returns the value of the nth item (starting at 0 for first)
    -push_front(value) - adds an item to the front of the list
    -pop_front() - remove front item and return its value
    -push_back(value) - adds an item at the end
    -pop_back() - removes end item and returns its value
    -front() - get value of front item
    -back() - get value of end item
    -insert(index, value) - insert value at index, so current item at that index is pointed to by new item at index
    -erase(index) - removes node at given index
    -value_n_from_end(n) - returns the value of the node at nth position from the end of the list
    -reverse() - reverses the list
    -remove_value(value) - removes the first item in the list with this value
*/
package datastructure;

import java.util.NoSuchElementException;

public class LinkedList {
    public static void main(String[] args){

    }

    class DoublyLinkedList{
        Node head;
        Node tail;
        int size;
        class Node {
            int data;
            Node next;
            Node prev;

            Node(Node prev, int data, Node next){
                this.prev = prev;
                this.data = data;
                this.next = next;
            }
        }

        DoublyLinkedList(){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public boolean isEmpty(){
            return head==null;
        }

        private void linkFirst(int data) {
            Node newNode = new Node(null,data,head);
            if(head==null){
                this.tail = newNode;
            } else {
                head.prev = newNode;
            }
            this.head = newNode;
            this.size++;
        }

        private void linkLast(int data) {
            Node newNode = new Node(tail,data,null);
            if(tail==null){
                this.head = newNode;
            } else {
                tail.next = newNode;
            }
            this.tail = newNode;
            this.size++;
        }

        public void linkAfter(Node node, int data){
            Node pred = node;
            Node succ = node.next;
            Node newNode = new Node(pred,data,succ);
            pred.next = newNode;
            if(succ==null){
                this.tail = newNode;
            } else {
                succ.prev = newNode;
            }
            this.size++;
        }

        private void linkBefore(int data, Node node){
            Node pred = node.prev;
            Node succ = node;
            Node newNode = new Node(pred,data,succ);
            succ.prev = newNode;
            if(pred==null) {
                this.head = newNode;
            } else {
                pred.next = newNode;
            }
            this.size++;
        }

        public int unlinkFirst(Node firstNode){
            Node succ = firstNode.next;
            if(succ==null){
                this.tail=null;
            } else {
                succ.prev = null;
            }
            this.head = succ;
            firstNode.next = null;
            this.size--;
            return firstNode.data;
        }

        public int unlinkLast(Node lastNode){
            Node pred = lastNode.prev;
            if(pred==null){
                this.head = null;
            } else {
                pred.next = null;
            }
            this.tail = pred;
            lastNode.prev = null;
            this.size--;
            return lastNode.data;
        }

        public int unlink(Node node){
            Node pred = node.prev;
            Node succ = node.next;
            if(pred==null){
                this.head = succ;
            } else {
                pred.next = succ;
            }

            if(succ==null){
                this.tail = pred;
            } else {
                succ.prev = pred;
            }
            node.next = null;
            node.prev = null;
            this.size--;
            return node.data;
        }

        public int getFirst() {
            if(this.head==null){
                throw new NoSuchElementException();
            }
            return this.head.data;
        }

        public int getLast() {
            if(this.tail==null){
                throw new NoSuchElementException();
            }
            return this.tail.data;
        }

        public int removeFirst() {
            Node first = this.head;
            if(first==null){
                throw new NoSuchElementException();
            }
            return unlinkFirst(first);
        }

        public int removeLast() {
            Node last = this.tail;
            if(last==null){
                throw new NoSuchElementException();
            }
            return unlinkLast(last);
        }

        public void addFirst(int data) {
            linkFirst(data);
        }

        public void addLast(int data) {
            linkLast(data);
        }

        public int size(){
            return this.size;
        }

        public void add(int data){
            linkLast(data);
        }

        public void remove(int data) {
            Node curr = this.head;
            Node succ = curr.next;
            while(curr!=null){
                if(curr.data==data){
                    succ = curr.next;
                    unlink(curr);
                }
                curr=succ;
            }
        }

        public int get(int index) {
            if(index<0||index>size){
                throw new NoSuchElementException();
            }
            Node curr = this.head;
            while(index-->0){
                curr=curr.next;
            }
            return curr.data;
        }

        public int erase(int index){
            if(index<0||index>size){
                throw new NoSuchElementException();
            }
            Node curr = this.head;
            while(index-->0){
                curr=curr.next;
            }
            return unlink(curr);
        }

        public int kthFromLast(int k){
            Node p1 = this.head;
            Node p2 = this.head;
            while(k-->0&&p2!=null){
                p2=p2.next;
            }

            while(p2!=null){
                p2=p2.next;
                p1=p1.next;
            }
            return p1.data;
        }

        public void reverse(){

        }
    }

    class SinglyLinkedList{
        Node head;
        class Node{
            int data;
            Node next;
            Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        SinglyLinkedList(){
            this.head = null;
        }

        void insertFirst(int data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        void insertLast(int data){
            Node newNode = new Node(data);
            Node curr = head;
            if(curr==null){
                head = newNode;
                return;
            }
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = newNode;
        }

        void insertAt(int data, int position){
            if(position<0){
                position=0;
            }
            if(position>this.size()){
                position = this.size();
            }
            Node newNode = new Node(data);
            Node curr = head;
            for(int idx=1;idx<position;idx++){
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }

        boolean isEmpty(){
            return this.head==null;
        }

        int size(){
            if(head==null){
                return 0;
            }
            Node curr = head;
            int count = 0;
            while(curr!=null){
                count++;
                curr = curr.next;
            }
            return count;
        }

        int getValueAt(int n){
            if(n<0){
                n = 0;
            }
            if(n>this.size()){
                n = this.size()-1;
            }
            Node curr = head;
            for(int idx=0;idx<n;idx++){
                curr = curr.next;
            }
            return curr.data;
        }

        int getValueNfromEnd(int n){
            if(n<0){
                n = 0;
            }
            if(n>=this.size()){
                n = this.size()-1;
            }
            if(head==null){
                return 0;
            }
            Node pred = head;
            Node succ = head;
            while(n-->0&&succ!=null){
                succ = succ.next;
            }
            while(succ!=null){
                succ = succ.next;
                pred = pred.next;
            }
            return pred.data;
        }

        void reverseIterative(){
            if(head==null||head.next==null){
                return;
            }
            Node pred = null;
            Node curr = head;
            Node succ = head.next;
            while(curr!=null){
                curr.next = pred;
                pred = curr;
                curr = succ;
                if(succ!=null){
                    succ = succ.next;
                }
            }
            this.head = pred;
        }

        public Node reverse(Node node) {
            if(node==null||node.next==null){
               return node;
            }
            Node newNode = reverse(node.next);
            node.next.next = node;
            node.next=null;
            return newNode;
        }

        void removeValue(int target){
            Node pred = null;
            Node curr = this.head;
            while(curr.next!=null){
                if(curr.data==target){
                    break;
                }
                pred = curr;
                curr = curr.next;
            }
            pred.next = pred.next.next;
        }

        void removeFirst(){
            if(head==null||head.next==null){
                head=null;
                return;
            }
            head = head.next;
        }

        void revomeLast(){
            if(head==null||head.next==null){
                head=null;
                return;
            }
            Node prev = null;
            Node curr = head;
            while(curr.next!=null){
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
        }

        void removeAt(int position){
            if(head==null){
                return;
            }
            if(position==0){
                removeFirst();
                return;
            }
            if(position>=this.size()-1){
                revomeLast();
                return;
            }
            Node curr = head;
            for(int idx=1;idx<position;idx++){
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
    }
}
