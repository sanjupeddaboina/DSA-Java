/* LRU Cache:
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
*/

class LRUCache {
    public class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer,Node> map;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            insertAtHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            insertAtHead(node);
        }else{
            if(map.size() == capacity){
                Node node = tail.prev;
                deleteNode(node);
                map.remove(node.key);
            }
            Node node = new Node(key,value);
            map.put(key,node);
            insertAtHead(node);
        }
    }
    public void deleteNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public void insertAtHead(Node node){
        Node nextNode = head.next;
        head.next = node;
        node.next = nextNode;
        node.prev = head;
        nextNode.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
