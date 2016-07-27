package core.collection.bst;

public class BinarySearchTree {
    public Node root = null;

    // add and remove methods, etc.
    public void visitAllLeaves(Node root) {
        java.util.Stack<Node> stack = new java.util.Stack<Node>();
        if (root == null)
            return;
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left == null && root.right == null) {
            }
        }
    }

    /*
     * Left < Right
     */
    public void insert(Node rootNode, int data) {
        if (data < rootNode.data) {
            if (rootNode.left != null) {
                insert(rootNode.left, data);
            } else {
                rootNode.left = new Node(data);
            }
        } else if (data > rootNode.data) {
            if (rootNode.right != null) {
                insert(rootNode.right, data);
            } else {
                rootNode.right = new Node(data);
            }
        }
    }

    /**
     * Pre Order Traversing - Root Node, Left Node, Right Child
     * 
     * In Order Traversing - Left Node, Root Node, Right Child
     * 
     * Post Order Traversing - Left Node, Right Child, Root Node
     * 
     */

    public void PreOrderTraversing(Node rootNode) {
        if (rootNode != null) {
            PreOrderTraversing(rootNode.left);
            System.out.println(rootNode.data);
            PreOrderTraversing(rootNode.right);
        }
    }

    public void InOrderTraversing(Node rootNode) {
        if (rootNode != null) {
            System.out.println(rootNode.data);
            InOrderTraversing(rootNode.left);
            InOrderTraversing(rootNode.right);
        }
    }

    public void PostOrderTraversing(Node rootNode) {
        if (rootNode != null) {
            PostOrderTraversing(rootNode.left);
            PostOrderTraversing(rootNode.right);
            System.out.println(rootNode.data);
        }
    }

    public void printFrontToBack(Node rootNode, int element) {
        if (rootNode == null) {
            return;
        }
        if (rootNode.data > element) {
            // In Order Traversing
            printFrontToBack(rootNode.left, element);
            System.out.println(rootNode.data);
            printFrontToBack(rootNode.right, element);
        } else if (rootNode.data < element) {

            printFrontToBack(rootNode.right, element);
            System.out.println(rootNode.data);
            printFrontToBack(rootNode.left, element);
        } else {
            printFrontToBack(rootNode.left, element);
            printFrontToBack(rootNode.right, element);
        }
    }

}