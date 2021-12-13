package edu.itstep;

public class SinglyLinkedList<T> {
    private Node head;

    private static class Node<T> {
        private T val;
        public Node next;
        public T data;

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }
    }

    public void insertFirst(T item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(T item) {
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        Node newNode = new Node();
        newNode.data = item;
        current.next = newNode;
    }

    public void removeFirst() {
        if (this.head != null) {
            Node temp = this.head;
            this.head = this.head.next;
            temp = null;
        }
    }

    public void removeLast() {
        if (this.head != null) {
            if (this.head.next == null) {
                this.head = null;
            } else {
                Node temp = this.head;
                while (temp.next.next != null)
                    temp = temp.next;
                Node lastNode = temp.next;
                temp.next = null;
                lastNode = null;
            }
        }
    }

    public void clear() {
        SinglyLinkedList.Node current = this.head;
        while (current != null) {
            SinglyLinkedList.Node curNext = current.getNext();
            current.setNext(null);
            current = curNext;
        }
        this.head = null;
    }

    public void display() {
        System.out.println("LinkedList (head --> last) ");
        Node current = this.head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
