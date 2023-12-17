package Zadanie4.DrzewoBST;

public class Node {
    private Node parent;
    private Node leftNode;
    private Node rightNode;
    private int value;

    public Node(int value) {
        this.value = value;
        parent = null;
        leftNode = null;
        rightNode = null;
    }

    public Node getParent() {
        return parent;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
