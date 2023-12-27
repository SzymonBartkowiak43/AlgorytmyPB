package Zadanie4.DrzewoBST;

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
        throw new NullPointerException("Nie znaleziono wezla");
    }

    public String getNumer(String key) {
        Node node = getNood(key);
        return node.getAbonent().getNumber();
    }

    public void addNood(Abonent abonent) {
        Node parent = null;
        Node current = root;

        while(current != null) {
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
                return;
            }
            int value = whichBigger(parent.getValue(), abonent.getName());

            if (value == 2) {
                parent.setRightNode(tmp);
                tmp.setParent(parent);
            } else if (value == 1) {
                parent.setLeftNode(tmp);
                tmp.setParent(parent);
            }
        }

    public void deleteNood(String name) {
        Node deletedNode = getNood(name);

        if (deletedNode == null) {
            System.out.println("Nie znaleziono węzła do usunięcia.");
            return;
        }

        if (deletedNode.getLeftNode() == null && deletedNode.getRightNode() == null) {
            deleteWithNoChildren(deletedNode); //0
        } else if (deletedNode.getLeftNode() != null && deletedNode.getRightNode() != null) {
            deleteNodeWithTwoChildren(deletedNode); //2
        } else {
            deleteNodeWithOneChild(deletedNode); //1
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
            System.out.print(node.getValue() + " |||| ");
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
}
