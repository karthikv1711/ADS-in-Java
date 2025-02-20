import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    int h;  // height
    Node leftChild;
    Node rightChild;

    public Node() {
        data = 0;
        h = 0;
        leftChild = null;
        rightChild = null;
    }

    public Node(int value) {
        this.data = value;
        h = 0;
        leftChild = null;
        rightChild = null;
    }
}

class ConstructAVLTree {
    private Node root;

    public ConstructAVLTree() {
        root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private int getHeight(Node node) {
        return node == null ? -1 : node.h;
    }

    private int max(int l, int r) {
        return l > r ? l : r;
    }

    private Node insert(Node node, int value) {
        if (node == null)
            node = new Node(value);
        else if (value < node.data) {
            node.leftChild = insert(node.leftChild, value);
            if (getHeight(node.leftChild) - getHeight(node.rightChild) == 2)
                if (value < node.leftChild.data)
                    node = rotateWithLeftChild(node);
                else
                    node = doubleWithLeftChild(node);
        } else if (value > node.data) {
            node.rightChild = insert(node.rightChild, value);
            if (getHeight(node.rightChild) - getHeight(node.leftChild) == 2)
                if (value > node.rightChild.data)
                    node = rotateWithRightChild(node);
                else
                    node = doubleWithRightChild(node);
        }
        node.h = max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
        return node;
    }

    private Node rotateWithLeftChild(Node node) {
        Node left = node.leftChild;
        node.leftChild = left.rightChild;
        left.rightChild = node;
        node.h = max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
        left.h = max(getHeight(left.leftChild), getHeight(left.rightChild)) + 1;
        return left;
    }

    private Node rotateWithRightChild(Node node) {
        Node right = node.rightChild;
        node.rightChild = right.leftChild;
        right.leftChild = node;
        node.h = max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
        right.h = max(getHeight(right.leftChild), getHeight(right.rightChild)) + 1;
        return right;
    }

    private Node doubleWithLeftChild(Node node) {
        node.leftChild = rotateWithRightChild(node.leftChild);
        return rotateWithLeftChild(node);
    }

    private Node doubleWithRightChild(Node node) {
        node.rightChild = rotateWithLeftChild(node.rightChild);
        return rotateWithRightChild(node);
    }

    // Horizontal printing of AVL tree with formatted connections
    public void printTreeWithFormattedConnections() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        printTree(root, 0, false, " ");
    }

    private void printTree(Node node, int level, boolean isRight, String indent) {
        if (node != null) {
            printTree(node.rightChild, level + 1, true, indent + (isRight ? "        " : " |      "));
            System.out.print(indent);
            if (level > 0) {
                System.out.print(isRight ? " /" : " \\");
                System.out.print("----- ");
            }
            System.out.println(node.data);
            printTree(node.leftChild, level + 1, false, indent + (isRight ? " |      " : "        "));
        }
    }

    // Search
    public void search(int key) {
        Node n = search(root, key);
        if (n == null)
            System.out.println("Key is not found in the Tree");
        else
            System.out.println("Key is found");
    }

    private Node search(Node node, int key) {
        if (node == null || node.data == key)
            return node;
        else if (key < node.data)
            return search(node.leftChild, key);
        else
            return search(node.rightChild, key);
    }
}

public class AVLTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConstructAVLTree avl = new ConstructAVLTree();
        while (true) {
            System.out.println("1. Insert an element");
            System.out.println("2. Search for an element");
            System.out.println("3. Print tree with formatted connections");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter element:");
                    int item = sc.nextInt();
                    avl.insert(item);
                    break;
                case 2:
                    System.out.println("Enter the key element to search");
                    int key = sc.nextInt();
                    avl.search(key);
                    break;
                case 3:
                    System.out.println("Tree structure with formatted connections:");
                    avl.printTreeWithFormattedConnections();
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}


/*
1. Insert an element
2. Search for an element
3. Print tree with formatted connections
4. Exit
Enter your choice: 
3
Tree structure with formatted connections:
  |       /----- 30
  |       |       \----- 24
 20
          |       /----- 14
          \----- 10
                  \----- 7
                          \----- 3






*/
