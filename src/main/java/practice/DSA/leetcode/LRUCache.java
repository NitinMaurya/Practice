package practice.DSA.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head;
    Node tail;
    int frameSize;
    Map<Integer, Node> cache;

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache (int capacity) {
        this.frameSize = capacity;
        this.cache = new HashMap<>();
    }

    public int get (int key) {
        if (!cache.containsKey(key)) {
            return -1;
        } else {
            Node node = cache.get(key);
            moveToLast(node);
            return node.value;
        }
    }

    public void put (int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToLast(node);
        } else {
            if (cache.size() >= frameSize) {
                cache.remove(head.key);
                removeNode(head);
            }
            Node node = new Node(key, value);
            offerNode(node);
            cache.put(key, node);
        }
    }

    private void moveToLast(Node node) {
        removeNode(node);
        offerNode(node);
    }

    // Adds the node to the tail of the linked list.
    private void offerNode(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }
    }

    // Removes the node from the linked list
    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.get(1);
    }
}