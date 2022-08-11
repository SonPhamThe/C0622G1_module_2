package ss10_dsa.practice.simple_linkedlist.controller;

import ss10_dsa.practice.simple_linkedlist.model.MyLinkedList;

public class MyLinkedListController {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);

        ll.add(4,9);
        ll.add(4,9);
        ll.printList();
    }
}
