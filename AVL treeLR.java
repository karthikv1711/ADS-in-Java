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

    // Horizontal printing of AVL tree with connections
    public void printTreeWithConnections() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        q.add(root);
        levels.add(0);
        int currentLevel = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int level = levels.poll();
            if (level != currentLevel) {
                currentLevel = level;
                System.out.println();
            }
            if (node.leftChild != null) {
                q.add(node.leftChild);
                levels.add(level + 1);
            }
            if (node.rightChild != null) {
                q.add(node.rightChild);
                levels.add(level + 1);
            }
            System.out.print(node.data);
            if (node.leftChild != null || node.rightChild != null) {
                System.out.print(" -> ");
                if (node.leftChild != null) {
                    System.out.print("L: " + node.leftChild.data + " ");
                }
                if (node.rightChild != null) {
                    System.out.print("R: " + node.rightChild.data + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
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
            System.out.println("3. Print tree with connections");
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
                    System.out.println("Tree structure with connections:");
                    avl.printTreeWithConnections();
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
3. Print tree with connections
4. Exit
Enter your choice: 
3
Tree structure with connections:
10 -> L: 3 R: 15 

3 -> L: 2 R: 4 
15 -> R: 36 

2
4 -> R: 7 
36

7




*/
