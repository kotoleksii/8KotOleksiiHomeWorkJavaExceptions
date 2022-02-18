package edu.itstep;

import edu.itstep.exceptions.CustomListDeleteException;
import edu.itstep.exceptions.CustomListSetException;

public class Main {

    public static void main(String[] args) throws CustomListSetException, CustomListDeleteException {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.insertLast("string");
        doubleLinkedList.insertLast(32.1);
        doubleLinkedList.insertLast(12.0f);
        doubleLinkedList.insertLast('c');
        doubleLinkedList.insertLast(12);
        doubleLinkedList.insertFirst(1);
        doubleLinkedList.display();
        System.out.println("===============");
//        doubleLinkedList.clear();
        doubleLinkedList.removeFirst();
        doubleLinkedList.removeLast();
        doubleLinkedList.display();

        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertFirst(4);
        linkedList.insertFirst('З');
        linkedList.insertFirst(2.0);
        linkedList.insertFirst(1);
        linkedList.insertLast("string");
        linkedList.display();
        System.out.println("===============");
//        linkedList.removeLast();
//        linkedList.removeFirst();
        linkedList.clear();
        linkedList.display();
    }
}
