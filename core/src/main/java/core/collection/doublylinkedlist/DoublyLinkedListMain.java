package core.collection.doublylinkedlist;

import java.util.Scanner;

class DoublyLinkedListMain {
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        DoublyLinkedList obj = new DoublyLinkedList();
        while (true) {
            System.out.println("*******Please select the option.*********");
            System.out.println("\t1.Insert the element at first in the list." + "\n\t2.Insert at element at end."
                    + "\n\t3.Insert element at certain positon." + "\n\t4.Insert element at last."
                    + "\n\t5.Delete the element." + "\n\t6.Search element." + "\n\t7.display the Linked list."
                    + "\n\t8.Exit from the program.");
            int num = scan.nextInt();
            switch (num) {
            case 1:
                System.out.println("Insert the element.");
                int n = scan.nextInt();
                obj.insertfront(n);
                break;
            case 2:
                System.out.println("Insert the element.");
                n = scan.nextInt();
                obj.insertend(n);
                break;
            case 3:
                System.out.println("Insert the element.");
                n = scan.nextInt();
                System.out.println("POSITION");
                int p = scan.nextInt();
                obj.insertatPosition(n, p);
                break;
            case 7:
                obj.display();
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("U entered invalied data.So,enter valied data.");
            }
        }
    }
}