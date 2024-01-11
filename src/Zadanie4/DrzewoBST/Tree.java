package Zadanie4.DrzewoBST;

import java.io.FileWriter;
import java.io.IOException;

public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getNood(String key) {
        Node current = root;
        while (current != null) {
            int value = whichBigger(current.getValue(), key);
            if (value == 2) {
                current = current.getRightNode();
            } else if (value == 1) {
                current = current.getLeftNode();
            } else {
                return current;
            }
        }
        return null;
    }

    public String getNumer(String key) {
        Node node = getNood(key);
        try{
            return node.getAbonent().getNumber();
        } catch (NullPointerException e) {
            return "Nie znaleziono Abonenta";
        }
    }

    public void addNood(Abonent abonent) {
        Node parent = null;
        Node current = root;

        while (current != null) {
            parent = current;
            if (current.getValue().equals(abonent.getName())) {
                return;
            }
            int which = whichBigger(current.getValue(), abonent.getName());
            if (which == 2) {
                current = current.getRightNode();
            } else if (which == 1) {
                current = current.getLeftNode();
            }
        }

        Node tmp = new Node(abonent);
        if (parent == null) {
            root = tmp;
        } else {
            int value = whichBigger(parent.getValue(), abonent.getName());

            if (value == 2) {
                parent.setRightNode(tmp);
                tmp.setParent(parent);
            } else if (value == 1) {
                parent.setLeftNode(tmp);
                tmp.setParent(parent);
            }

            balanceTree(tmp);
        }
    }

    private void balanceTree(Node node) {
        updateWeight(node);

        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.getLeftNode()) < 0) {
                // Rotacja LR
                rotateLeft(node.getLeftNode());
            }
            // Rotacja LL
            rotateRight(node);
        } else if (balance < -1) {
            if (getBalance(node.getRightNode()) > 0) {
                // Rotacja RL
                rotateRight(node.getRightNode());
            }
            // Rotacja RR
            rotateLeft(node);
        }

        // Aktualizuj wagę dla węzła i jego rodzica po rotacjach
        updateWeight(node);
        if (node.getParent() != null) {
            balanceTree(node.getParent());
        }
    }

    private void updateWeight(Node node) {
        if (node != null) {
            node.setWeight(getHeight(node.getLeftNode()) - getHeight(node.getRightNode()));
        }
    }

    private void rotateRight(Node node) {
        Node leftChild = node.getLeftNode();
        node.setLeftNode(leftChild.getRightNode());
        if (leftChild.getRightNode() != null) {
            leftChild.getRightNode().setParent(node);
        }
        leftChild.setParent(node.getParent());
        if (node.getParent() == null) {
            root = leftChild;
        } else if (node == node.getParent().getLeftNode()) {
            node.getParent().setLeftNode(leftChild);
        } else {
            node.getParent().setRightNode(leftChild);
        }
        leftChild.setRightNode(node);
        node.setParent(leftChild);

        updateWeightAndHeight(node);
        updateWeightAndHeight(leftChild);
    }


    private void rotateLeft(Node node) {
        Node rightChild = node.getRightNode();
        node.setRightNode(rightChild.getLeftNode());
        if (rightChild.getLeftNode() != null) {
            rightChild.getLeftNode().setParent(node);
        }
        rightChild.setParent(node.getParent());
        if (node.getParent() == null) {
            root = rightChild;
        } else if (node == node.getParent().getLeftNode()) {
            node.getParent().setLeftNode(rightChild);
        } else {
            node.getParent().setRightNode(rightChild);
        }
        rightChild.setLeftNode(node);
        node.setParent(rightChild);

        updateWeightAndHeight(node);
        updateWeightAndHeight(rightChild);
    }


    private int getHeight(Node node) {
        return (node == null) ? 0 : Math.max(getHeight(node.getLeftNode()), getHeight(node.getRightNode())) + 1;
    }


    private int getBalance(Node node) {
        return (node == null) ? 0 : getHeight(node.getLeftNode()) - getHeight(node.getRightNode());
    }

    private void updateHeight(Node node) {
        if (node != null) {
            node.setWeight(Math.max(getHeight(node.getLeftNode()), getHeight(node.getRightNode())) + 1);
        }
    }

    private void updateWeightAndHeight(Node node) {
        if (node != null) {
            updateHeight(node);
        }
    }


    public void deleteNood(String name) {
        Node deletedNode = getNood(name);

        if (deletedNode == null) {
            System.out.println("Nie znaleziono węzła do usunięcia.");
            return;
        }

        Node parent = deletedNode.getParent();

        if (deletedNode.getLeftNode() == null && deletedNode.getRightNode() == null) {
            deleteWithNoChildren(deletedNode); // 0
        } else if (deletedNode.getLeftNode() != null && deletedNode.getRightNode() != null) {
            deleteNodeWithTwoChildren(deletedNode); // 2
        } else {
            deleteNodeWithOneChild(deletedNode); // 1
        }

        if (parent != null) {
            balanceTree(parent);
        }

        System.out.println("Usunięto " + name);
    }

    private void deleteWithNoChildren(Node deletedNode) {
        Node parent = deletedNode.getParent();
        if (parent == null) {
            root = null;
        } else {
            if (parent.getLeftNode() == deletedNode) {
                parent.setLeftNode(null);
            } else {
                parent.setRightNode(null);
            }
        }
    }

    private void deleteNodeWithOneChild(Node deletedNode) {
        Node parent = deletedNode.getParent();
        Node child = (deletedNode.getLeftNode() != null) ? deletedNode.getLeftNode() : deletedNode.getRightNode();

        if (parent == null) {
            root = child;
        } else {
            if (parent.getLeftNode() == deletedNode) {
                parent.setLeftNode(child);
            } else {
                parent.setRightNode(child);
            }
            child.setParent(parent);
        }
    }

    private void deleteNodeWithTwoChildren(Node deletedNode) {
        Node successor = getSuccessor(deletedNode);
        deleteNood(successor.getValue());
        deletedNode.setValue(successor.getAbonent());
    }

    private Node getSuccessor(Node node) {
        Node successor = node.getRightNode();
        while (successor.getLeftNode() != null) {
            successor = successor.getLeftNode();
        }
        return successor;
    }

    private int whichBigger(String pierwszy, String drugi) {
        int result = pierwszy.compareTo(drugi);
        if (result < 0) {
            return 2; // w Prawo
        } else if (result > 0) {
            return 1; // w Lewo
        }
        return 0;
    }

    private void print(Node node) {
        if (node != null) {
            print(node.getLeftNode());
            System.out.println(node.getValue() + " -> " + node.getAbonent().getNumber());
            print(node.getRightNode());
        }
    }

    public void print() {
        print(root);
    }

    private int counter(Node node) {
        int count = 0;
        if (node != null) {
            count += counter(node.getLeftNode());
            count++;
            count += counter(node.getRightNode());
        }
        return count;
    }

    public int counter() {
        return counter(root);
    }

    private void save(Node node, FileWriter fw) throws IOException {
        if (node != null) {
            save(node.getLeftNode(), fw);
            String userData = node.getAbonent().getName() + ";" + node.getAbonent().getNumber()+ "\n";
            fw.write(userData);
            save(node.getRightNode(), fw);
        }
    }

    public void save() {
        try (FileWriter fw = new FileWriter("src/Zadanie4/DrzewoBST/Abonenci.csv", false)) {
            save(root, fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
