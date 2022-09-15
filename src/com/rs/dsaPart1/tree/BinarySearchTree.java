package com.rs.dsaPart1.tree;

public class BinarySearchTree {

    class Node {

        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    private static Node root;

    //wrapper function where we are not passing the root
    private void insert(int value) {
        root = insertNode(root, value);
    }

    //wrapper function where we are not passing the root
    private void inorderTraversal() {
        inorderTraversal(root);
    }

    //inorder traversal
    private void inorderTraversal(Node root) {

        if (root != null) {
            //left->printRoot->right
            inorderTraversal(root.leftChild);
            System.out.println(root.value);
            inorderTraversal(root.rightChild);
        }
    }

    private Node insertNode(Node root, int value) {
        //case when root itself is null
        if (root == null) {
            //make the new node as the root and return it
            root = new Node(value);
            return root;
        }

        //case when root is there
        if (value < root.value) {
            root.leftChild = insertNode(root.leftChild, value);
        } else if (value > root.value) {
            root.rightChild = insertNode(root.rightChild, value);
        } else {
            throw new RuntimeException("the value you are trying to insert is already taken, duplicate values not allowed in BST");
        }

        return root;
    }

    private int getMin() {
        return getMinElement(root);
    }

    private int getMinElement(Node root) {

        Node current = root;
        while (current.leftChild != null) {
            current = current.leftChild;
        }

        //here we are at the node with the min-value i.e. present in leftmost node of the tree
        return current.value;
    }

    private int getMax() {
        return getMaxElement(root);
    }

    private int getMaxElement(Node root) {

        Node current = root;
        while (current.rightChild != null) {
            current = current.rightChild;
        }

        //here we are at the node with the min-value i.e. present in leftmost node of the tree
        return current.value;
    }

    private int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node root) {

        //base case
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
    }

    private boolean search(int value) {
        return searchNodeWithAGivenValue(value, root);
    }

    private boolean searchNodeWithAGivenValue(int value, Node root) {

        //base case
        if (root == null) {
            throw new RuntimeException("Sorry !! There happens to be no node with the given value");
        }
        if (value == root.value) {
            return true;
        } else if (value > root.value) {
            //search in right subtree
            return searchNodeWithAGivenValue(value, root.rightChild);
        } else {
            //search in left subtree
            return searchNodeWithAGivenValue(value, root.leftChild);
        }

    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(4);
        bst.insert(6);
        bst.insert(12);
        bst.insert(3);
        bst.insert(1);
        bst.insert(7);
        bst.insert(14);
        bst.insert(2);
        bst.insert(17);

        //print inorder traversal
        bst.inorderTraversal();
        System.out.println("The minimum element in the binary search tree is: " + bst.getMin());
        System.out.println("The maximum element in the binary search tree is: " + bst.getMax());
        System.out.println("The height of the binary search tree is: " + bst.getHeight());

        System.out.println(bst.search(1));

    }
}
