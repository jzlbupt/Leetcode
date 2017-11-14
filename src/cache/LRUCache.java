package cache;

/**
 * Created by ziljin on 14/11/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache( 2 /* capacity  );

        cache.put(1, 1);                               // head -> 1 -> tail
        cache.put(2, 2);                               // head -> 1 -> 2 -> tail
        cache.get(1);       // returns 1               // head -> 2 -> 1 -> tail
        cache.put(3, 3);    // evicts key 2            // head -> 1 -> 3 -> tail
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1            // head -> 3 -> 4 -> tail
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3               // head -> 4 -> 3 -> tail
        cache.get(4);       // returns 4               // head -> 3 -> 4 -> tail
 */
public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }

    }

    HashMap<Integer, Node> cache;
    int capacity;
    Node head;
    Node tail; // most recently be used , include get & set

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        cache = new HashMap<>();
    }

    public int get(int key) {
        if(cache.get(key) == null) {
            return -1;
        }
        Node current = cache.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        moveToTail(current);

        return cache.get(key).value;
    }

    public void put(int key, int value) {
        if(get(key) != -1) {
            cache.get(key).value = value;
            return;
        }
        if(cache.size() == capacity) {
            cache.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        moveToTail(newNode);

    }

    private void moveToTail(Node node) {
        node.prev = tail.prev;
        node.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }
}
