package core.collection.doublylinkedlist;

class DoublyLinkedList {
    Node head;
    Node tail;

    public void insertfront(int data) {
        int flag = 0;
        Node newnode = new Node(data, null, null);
        if (head == null) {
            head = newnode;
            tail = head;
            tail.right = head;
            head.left = tail;
            flag = 1;
        } else {
            newnode.right = head;
            newnode.left = tail;
            tail.right = newnode;
            head = newnode;
            flag = 1;
        }
        if (flag == 1) {
            System.out.println("element " + data + "is inserted.");
        } else
            System.out.println("element " + data + "is not inserted.");
    }

    public void insertend(int data) {
        Node newnode = new Node(data, null, null);
        Node current = head;
        while (current.right != head) {
            current = current.right;
        }
        current.right = newnode;
        newnode.left = current;
        newnode.right = head;
        tail = newnode;
    }

    public void insertatPosition(int data, int pos) {
        Node newnode = new Node(data, null, null);
        Node current = head;
        Node previous = head;
        int i = 1;
        while (i != (pos - 1)) {
            current = current.right;
            i++;
        }
        newnode.right = current.right;
        newnode.left = current;
        current.right = newnode;
        // current=current.right;
    }

    public void display() {
        Node current = head;
        do {
            System.out.print("     " + current.data);
            current = current.right;
        } while (current != head);
        System.out.println();
    }
}
