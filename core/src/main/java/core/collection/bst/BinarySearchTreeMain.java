package core.collection.bst;

public class BinarySearchTreeMain {

    public static void main(String...args) {
        BinarySearchTree bst = new BinarySearchTree();

        // initailize root node
        Node rootNode = new Node(5);

        // insertion
        bst.insert(rootNode, 1);
        bst.insert(rootNode, 8);
        bst.insert(rootNode, 6);
        bst.insert(rootNode, 3);
        bst.insert(rootNode, 9);

        // Binary Traversing
        System.out.println("Pre Order Traversing Binary Tree : ");
        bst.PreOrderTraversing(rootNode);

        System.out.println("In Order Traversing Binary Tree : ");
        bst.InOrderTraversing(rootNode);

        System.out.println("Post Order Traversing Binary Tree : ");
        bst.PostOrderTraversing(rootNode);

        // Traverse all elements less then the given parameter
        System.out.println("Traversing tree front-to-back from location 7");
        //		bst.printFrontToBack(rootNode, 7);
    }
}