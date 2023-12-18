package Zadanie4.DrzewoBST;

public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getWezel(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.getValue()) {
                return current;
            } else if (key > current.getValue()) {
                current = current.getRightNode();
            } else {
                current = current.getLeftNode();
            }
        }
        throw new NullPointerException("Nie znaleziono wezla");
    }

    public void addWezel (int value) {
        Node parent = null;
        Node current = root;

        while(current != null) {
            parent = current;
            if(current.getValue() == value) {
                return;
            }

            if(value > current.getValue()) {
                current = current.getRightNode();
            } else if (value < current.getValue()) {
                current = current.getLeftNode();
            }
        }

        Node tmp = new Node(value);
        if(parent == null) {
            root = tmp;
        } else if( value > parent.getValue()) {
            parent.setRightNode(tmp);
            tmp.setParent(parent);
        } else if(value < parent.getValue()) {
            parent.setLeftNode(tmp);
            tmp.setParent(parent);
        }
    }

    public boolean findNood(int value) {
        Node current = root;

        while(true) {
            if(current.getValue() > value) {
                current = current.getLeftNode();
            } else if (current.getValue() < value) {
                current = current.getRightNode();
            }

            if(current == null) {
                return false;
            }else if(current.getValue() == value) {
                return true;
            }
        }
    }


    public void deleteNood(int value) {
        Node current = root;
        Node parent;
        Node deletedNode;

        if (!findNood(value)) {
            return;
        } else {
            deletedNode = getWezel(value);
        }


        if (deletedNode.getRightNode() == null && deletedNode.getLeftNode() == null) {
            extracted(deletedNode);
            System.out.println("0");
        } else if(deletedNode.getRightNode() != null && deletedNode.getLeftNode() != null) {
            extracted2(deletedNode);
            System.out.println("2");
        } else {

            extracted1(deletedNode);
            System.out.println("1");
        }

    }

    private static void extracted2(Node deletedNode) {
        Node right = deletedNode.getRightNode();
        boolean licznik = true;
        while (right.getLeftNode() != null) {
            right = right.getLeftNode();
            licznik = false;
        }
        deletedNode.setValue(right.getValue());

        if(licznik) {
            right.getParent().setLeftNode(null);
        } else {
            right.getParent().setLeftNode(right.getRightNode());
        }
    }

    private void extracted1(Node deletedNode) {
        Node parent;
        parent = deletedNode.getParent();
        if(deletedNode == parent.getRightNode()) {
            if(deletedNode.getRightNode() == null) {
                parent.setRightNode(deletedNode.getLeftNode());
            } else {
                parent.setRightNode(deletedNode.getRightNode());
            }
        } else {
            if(deletedNode.getRightNode() == null) {
                parent.setLeftNode(deletedNode.getLeftNode());
            } else {
                parent.setLeftNode(deletedNode.getRightNode());
            }
        }

    }

    private void extracted(Node deletedNode) {
        Node parent;
        if (deletedNode == root) {
            root = null;
        } else {
           parent = deletedNode.getParent();
           if(parent.getRightNode() == deletedNode) {
               parent.setRightNode(null);
           } else {
               parent.setLeftNode(null);
           }
        }
    }


}
