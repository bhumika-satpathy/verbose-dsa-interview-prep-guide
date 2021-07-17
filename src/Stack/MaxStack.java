package Stack;

import java.util.*;

// Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.
//
//Implement the MaxStack class:
//
//    MaxStack() Initializes the stack object.
//    void push(int x) Pushes element x onto the stack.
//    int pop() Removes the element on top of the stack and returns it.
//    int top() Gets the element on the top of the stack without removing it.
//    int peekMax() Retrieves the maximum element in the stack without removing it.
//    int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.
// https://leetcode.com/problems/max-stack/
public class MaxStack {
    DoubleLinkedList dll;
    TreeMap<Integer, List<Node>> map;

    /** initialize your data structure here. */
    public MaxStack() {
        map = new TreeMap();
        dll = new DoubleLinkedList();
    }

    public void push(int x) {
        Node node = dll.add(x);
        if(!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(node);
    }

    public int pop() {
        Node node = dll.pop();
        List<Node> l = map.get(node.val);
        l.remove(l.size() - 1);

        if(l.isEmpty()) {
            map.remove(node.val);
        }
        return node.val;
    }

    public int top() {
        return dll.peek();
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = map.lastKey();
        List<Node> l = map.get(max);
        Node node = l.remove(l.size() - 1);
        dll.unlink(node);

        if(l.isEmpty()) {
            map.remove(max);
        }

        return max;
    }
}

class DoubleLinkedList {
    Node head, tail;

    DoubleLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    Node add(int val) {
        Node node = new Node(val);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = tail.prev.next = node;

        return node;
    }

    Node unlink(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;

        return node;
    }

    Node pop() {
        return unlink(tail.prev);
    }

    int peek() {
        return tail.prev.val;
    }
}

class Node {
    int val;
    Node prev;
    Node next;

    Node(int val) {
        this.val = val;
        prev = null;
        next = null;
    }
}
