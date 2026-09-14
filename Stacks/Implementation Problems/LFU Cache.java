/* LFU Cache:
Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. 
When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. 
For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key 
in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.
*/

class LFUCache {
    class Node{
        int key,val,freq;
        Node next, prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.freq = 1;
        }

    }

    class DLL{
        Node head,tail;
        int size;

        DLL(){
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        public void insertAtHead(Node node){
            Node nextNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextNode;
            nextNode.prev = node;
            size++;
        }

        public void deleteNode(Node node){
            Node nextNode = node.next;
            Node prevNode = node.prev;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        public Node deleteLRU(){

            if(size > 0){
                Node prevNode = tail.prev;
                deleteNode(prevNode);
                return prevNode;
            }

            return null;
        }
    }

    Map<Integer,Node> nodeMap;
    Map<Integer,DLL> freqMap;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 1;
    }
    
    public int get(int key) {

        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            updateFreq(node);
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }

        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.val = value;
            updateFreq(node);
        }else{

            if(nodeMap.size() == capacity){
                DLL minFreqList = freqMap.get(minFreq);
                Node node = minFreqList.deleteLRU();
                nodeMap.remove(node.key);
            }

            Node nn = new Node(key,value);
            minFreq = 1;
            nodeMap.put(key,nn);
            DLL newEntryList = freqMap.getOrDefault(1,new DLL());
            newEntryList.insertAtHead(nn);
            freqMap.put(1,newEntryList);

        }
    }
    public void updateFreq(Node node){
        int nodeFreq = node.freq;
        DLL minList = freqMap.get(nodeFreq);
        minList.deleteNode(node);

        if(nodeFreq == minFreq && minList.size == 0){
            minFreq++;
        }
        
        node.freq++;
        DLL updateFreqList = freqMap.getOrDefault(node.freq, new DLL());
        updateFreqList.insertAtHead(node);
        freqMap.put(node.freq,updateFreqList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
