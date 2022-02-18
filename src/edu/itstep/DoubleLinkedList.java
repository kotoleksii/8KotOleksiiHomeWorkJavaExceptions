package edu.itstep;

import edu.itstep.exceptions.CustomListDeleteException;
import edu.itstep.exceptions.CustomListGetException;
import edu.itstep.exceptions.CustomListSetException;

public class DoubleLinkedList<T> {
    private Node head;
    private Node last;

    private static class Node<T> {
        private T val;
        private Node prev;
        private Node next;

        public Node(T val) {
            this.val = val;
        }

        public T getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void insertFirst(T item) throws CustomListSetException {
        Node node = new Node(item);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            //node.next = this.head;
            node.setNext(this.head);
            head.setPrev(node);
            head = node;
        }
    }

    public void insertLast(T item) throws CustomListSetException {
        Node node = new Node(item);
        if (this.head == null) {
            this.head = node;
        } else {
            last.setNext(node);
            node.setPrev(last);
        }
        this.last = node;
    }

    public void display() {
        System.out.println("DoubleLinkedList (head --> last) ");
        Node current = this.head;
        while (current != null) {
            System.out.print(current.getVal() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void addIndex(int index, T item) throws CustomListSetException, CustomListGetException {
        if (index < 0 || index > size()) {
            return;
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        if (index == size()) {
            insertLast(item);
            return;
        }
        Node cur = this.head;
        while (index != 0) {
            cur = cur.getNext();
            index--;
        }

        Node node = new Node(item);
        node.setNext(cur);
        node.setPrev(cur.getPrev());
        node.getPrev().setNext(node);
        cur.setPrev(node);
    }

    public boolean contains(T key) throws CustomListGetException {
        Node current = this.head;
        while (current != null) {
            if (current.getVal() == key) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public Node findNode(T key) throws CustomListGetException {
        Node current = this.head;
        while (current != null) {
            if (current.getVal() == key) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void remove(T key) throws CustomListDeleteException, CustomListGetException {
        Node current = this.findNode(key);
        if (current == null) {
            return;
        }
        if (current == this.head) {
            this.head = this.head.getNext();
            //this.head.prev = null;
            this.head.setPrev(null);
            return;
        }
        if (current == this.last) {
            current.getPrev().setNext(null);
            this.last = this.last.getPrev();
            return;
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
    }

    public void removeFirst() throws CustomListDeleteException {
        if (this.head != null) {
            DoubleLinkedList.Node temp = this.head;
            this.head = this.head.next;
            temp = null;
        }
    }

    public void removeLast() throws CustomListDeleteException {
        if (this.head != null) {
            if (this.head.next == null) {
                this.head = null;
            } else {
                DoubleLinkedList.Node temp = this.head;
                while (temp.next.next != null)
                    temp = temp.next;
                DoubleLinkedList.Node lastNode = temp.next;
                temp.next = null;
                lastNode = null;
            }
        }
    }

    public void removeAllKey(T key) throws CustomListDeleteException {
        Node current = this.head;
        while (current != null) {
            if (current.getVal() == key) {
                if (current == this.head) {
                    this.head = this.head.getNext();
                    this.head.setPrev(null);
                } else {
                    current.getPrev().setNext(current.getNext());
                    if (current.getNext() != null) {
                        current.getNext().setPrev(current.getPrev());
                    } else {
                        //current.next == null
                        this.last = this.last.getPrev();
                    }
                }
            }
            current = current.getNext();
        }
    }

    public int size() throws CustomListGetException {
        Node current = this.head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public void clear() {
        Node current = this.head;
        while (current != null) {
            Node curNext = current.getNext();
            current.setNext(null);
            current.setPrev(null);
            current = curNext;
        }
        this.last = null;
        this.head = null;
    }
}
