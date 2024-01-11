package Zadanie4.DrzewoBST;

public class Node {
    private Node parent;
    private Node leftNode;
    private Node rightNode;
    private Abonent abonent;
    private int weight;

    public Node(Abonent abonent) {
        this.abonent = abonent;
        parent = null;
        leftNode = null;
        rightNode = null;
        weight = 0;
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

    public String getValue() {
        return abonent.getName();
    }
    public Abonent getAbonent() {
        return abonent;
    }

    public void setValue(Abonent abonent) {
        this.abonent = abonent;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
