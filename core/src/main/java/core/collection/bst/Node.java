package core.collection.bst;

class Node {
    public Node left;
    public Node right;
    int data;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
