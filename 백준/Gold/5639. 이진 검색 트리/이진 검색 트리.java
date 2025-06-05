import java.util.*;
import java.io.*;

class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return this.value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
    
    public void setRight(Node right) {
        this.right = right;
    }
    
    public Node getLeft() {
        return this.left;
    }
    
    public Node getRight() {
        return this.right;
    }
}

class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return this.root;
    }

    public StringBuilder postOrder() {
        StringBuilder sb = new StringBuilder();
        sb = postOrder(root, sb);

        return sb;
    }

    private StringBuilder postOrder(Node node, StringBuilder sb) {
        if(node.getLeft() != null) postOrder(node.getLeft(), sb);
        if(node.getRight() != null) postOrder(node.getRight(), sb);
        sb.append(node.getValue()).append("\n");

        return sb;
    }
}


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = 0;
        int[] preOrder = new int[10_001];

        while(true) {
            String value = br.readLine();
            if(value == null) break;
            else preOrder[size++] = Integer.parseInt(value);
        }

        // root -> left -> right
        // 50 30 24 5 28 45 98 52 60

        Node root = new Node(preOrder[0]);
        Tree tree = new Tree(root);
        for(int i = 1; i < size; i++) {
            searchPosition(new Node(preOrder[i]), root);
        }

        StringBuilder sb = tree.postOrder();
        System.out.println(sb.toString());
    }

    public static void searchPosition(Node node, Node parent) {
        if(node.getValue() < parent.getValue()) {
            if(parent.getLeft() == null) parent.setLeft(node);
            else searchPosition(node, parent.getLeft());
        } else {
            if(parent.getRight() == null) parent.setRight(node);
            else searchPosition(node, parent.getRight());
        }
    }
}