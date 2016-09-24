package core.collection.linkedlist;

import java.util.Scanner;

class LinkedList {
    public static void main(String...args) {
        Scanner in = new Scanner(System.in);
        int data, ch, size = 0;
        // 2 pointer to keep track of first and last node.
        LinkedNode head = null, tail = head;
        while (true) {
            System.out.println("1.Insert\n2.Display\n3.Delete\n4.Exit");
            ch = in.nextInt();
            switch (ch) {
            case 1:
                System.out.println("Enter your Element");
                data = in.nextInt();
                LinkedNode newNode = new LinkedNode(data);
                if (head == null) {
                    head = newNode;
                    tail = head;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
                size++;
                break;
            case 2:
                if (size > 0) {
                    for (LinkedNode temp = head; temp != null; temp = temp.next)
                        System.out.print(temp.data + "\t");
                    System.out.println();
                } else
                    System.out.println("LinkedList is empty");
                break;
            case 3:
                if (size > 0) {
                    System.out.println("Enter your element");
                    data = in.nextInt();
                    if (head.data == data)
                        head = head.next;
                    else {
                        tail = head;
                        LinkedNode temp = head.next;
                        while (temp != null) {
                            if (temp.data == data) {
                                tail.next = temp.next;
                                size--;
                                break;
                            }
                            tail = temp;
                            temp = temp.next;
                        }
                    }
                } else
                    System.out.println("LinkedList is empty");
                break;
            default:
                System.exit(0);
            }
        }
    }
}