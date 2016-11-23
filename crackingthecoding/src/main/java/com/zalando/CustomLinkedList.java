package com.zalando;

/**
 * Created by ehimnay on 22/11/2016.
 */
class LinkedList {
    private Node first;

    public LinkedList() {
        first = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (first == null) {
            first = newNode;
            return;
        }

        Node ptr = first;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = newNode;
    }

    public Node remove() {

        if (first.next == null) {
            Node tempNode = first;
            first = first.next;
            return tempNode;
        }

        Node previous = null;
        Node current = first;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;
        return current;
    }

    public Node reverse(Node start) {
        Node previousNode = null;
        while (start != null) {
            Node nextNode = start.next;
            start.next = previousNode;
            previousNode = start;
            start = nextNode;
        }
        this.first = previousNode;
        return first;
    }

    public void display() {
        Node temp = first;
        while (temp != null) {
            temp.displayNode();
            temp = temp.next;
        }
        System.out.println();
    }

    public Node getFirst() {
        return first;
    }

}

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public void displayNode() {
        System.out.print(data + " ");
    }
}

public class CustomLinkedList {
    public static void main(String... args) {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.display();

        linkedList.reverse(linkedList.getFirst());
        linkedList.display();

        Node deletedNode = linkedList.remove();
        deletedNode.displayNode();
        linkedList.display();

    }
}
