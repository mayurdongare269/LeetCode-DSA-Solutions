class LRUCache {
    // doubly LL node class
    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int _key, int _val) {
            key = _key;
            val = _val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    int cap; // capacity of cache
    HashMap<Integer, Node> m = new HashMap<>();// Hash map to store key-node mapping


    public LRUCache(int capacity) { // onstructor to initialize LRU cache
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // fun to add node right after head
    void addNode(Node newNode) { // done....
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    void deleteNode(Node delNode) { // to remove given node from list
        Node delPrev = delNode.prev;
        Node delNext = delNode.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
    }
    
    public int get(int key) {
        if(m.containsKey(key)) {
            Node resNode = m.get(key);
            int res = resNode.val;
            //remove old mapping
            m.remove(key);
            //move accessed node to front
            deleteNode(resNode);
            addNode(resNode);
            //update map
            m.put(key, head.next);
            return res;
        }

        return -1; // not found
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)) { // if key already exists
            Node existingNode = m.get(key);
            m.remove(key);
            deleteNode(existingNode);
        }
        // if capacity reached
        if(m.size() == cap) {
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        //insert new node at front
        addNode(new Node(key, value)); // remember...
        m.put(key, head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */