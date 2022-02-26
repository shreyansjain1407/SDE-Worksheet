/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
*/


class Solution {
  public static void main(String[] args) {
    
  }
}

//c = LruCache(2)
//c.put(1, 1) 1
//c.put(2, 2) 2, 1
//c.put(3, 3) 3, 2
//c.get(1)  
//c.get(2) 2, 3


class Node{
  int key;
  int val;
  Node next;
  Node prev;
  public Node(){}
  public Node(int key, int val){
    this.key = key;
    this.val = val;
  }
}

class LRUCache{
  Map<Integer, Node> nodeMap;
  DoublyLinkedList dll;
  int maxCapacity;
  public LRUCache(int capacity){
    this.maxCapacity = capacity;
    nodeMap = new HashMap<>();
    dll = new DoublyLinkedList();
  }
  
  
  // Time Complexity: O(1)
  // Worst Case (HashMap Value Clash): Log(n)
  public void put(int key, int val){
    if(nodeMap.containsKey(key)){
        Node cur = nodeMap.get(key);
        dll.remove(cur);
        cur.val = val;
        dll.addNodeToFront(cur);
    }
    Node cur = new Node(key, val);
    nodeMap.put(key, Node);
    if(nodeMap.size() < maxCapacity){
      dll.addNodeToFront(cur);
    }else{
      Node throwAway = dll.tail.prev;
      nodeMap.remove(throwAway.val);
      dll.remove(throwAway);
      dll.addNodeToFront(cur);
    }
  }
  
  // Time Complexity: O(1)
  public int get(int key){
    if(nodeMap.containsKey(key){
      Node cur = nodeMap.get(key);
      dll.remove(cur);
      dll.addNodeToFront(cur);
      return cur.val;
    }
    return -1;
  }
}

class DoublyLinkedList{
  Node head;
  Node tail;
  DoublyLinkedList(){
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
  }
  
  // Time Complexity: O(1)
  public void addNodeToFront(Node current){
    current.next = head.next;
    current.prev = head;
    current.next.prev = current;
  }
  
  public Node remove(Node current){
    current.prev.next = current.next;
    current.next.prev = current.prev;
  }
}