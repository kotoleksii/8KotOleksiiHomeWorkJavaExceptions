package edu.itstep;


import edu.itstep.exceptions.CustomListDeleteException;
import edu.itstep.exceptions.CustomListGetException;

public class Main {

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.insertLast("string");
//        doubleLinkedList.insertLast(32.1);
//        doubleLinkedList.insertLast(12.0f);
//        doubleLinkedList.insertLast('c');
//        doubleLinkedList.insertLast(12);
//        doubleLinkedList.insertFirst(1);
        doubleLinkedList.display();
        System.out.println("===============");
        doubleLinkedList.clear();

        try {
            doubleLinkedList.removeLast();
        } catch (CustomListDeleteException e) {
            e.printStackTrace();
        }
        try {
            doubleLinkedList.removeFirst();
        } catch (CustomListDeleteException e) {
            e.printStackTrace();
        }
        try {
            doubleLinkedList.remove(7);
        } catch (CustomListDeleteException e) {
            e.printStackTrace();
        }

        doubleLinkedList.display();

        SinglyLinkedList linkedList = new SinglyLinkedList();
//        linkedList.insertFirst(4);
//        linkedList.insertFirst('З');
//        linkedList.insertFirst(2.0);
//        linkedList.insertFirst(1);
//        linkedList.insertLast("string");

        //linkedList.removeLast();

        linkedList.display();
        System.out.println("===============");
//        linkedList.removeLast();
//        linkedList.removeFirst();
        try {
            linkedList.clear();
        } catch (CustomListGetException e) {
            e.printStackTrace();
        }
        linkedList.display();
    }
}
