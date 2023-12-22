package Zadanie4.DrzewoBST;

public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getWezel(String key) {
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

    public void addWezel (Abonent abonent) {
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

    public boolean findNood(String name) {
        Node current = root;

        while(true) {
            int value = whichBigger(current.getValue(), name);
            if(value == 1) {
                current = current.getLeftNode();
            } else if (value == 2) {
                current = current.getRightNode();
            }

            if(current == null) {
                return false;
            }else if(current.getValue().equals(name)) {
                return true;
            }
        }
    }


    public void deleteNood(String name) {
        Node deletedNode;

        if (!findNood(name)) {
            return;
        } else {
            deletedNode = getWezel(name);
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

    private void extracted2(Node deletedNode) {
        Node max = deletedNode.getRightNode();
        boolean licznik = true;
        while (max.getLeftNode() != null) {
            max = max.getLeftNode();
            licznik = false;
        }
        //deletedNode.setValue(max.getValue());

        if(licznik) {
            deletedNode.setRightNode(max.getRightNode());
        } else {
            max.getParent().setLeftNode(null);
        }
    }

    private void extracted1(Node deletedNode) {
        Node parent = deletedNode.getParent();
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
    private int whichBigger(String pierwszy, String drugi) {
        int result = pierwszy.compareTo(drugi);
        if (result < 0) {
            return 2; // w Prawo
        } else if (result > 0) {
            return 1; // w Lewo
        }
        return 0;
    }

    private void extracted(Node deletedNode) {
        if (deletedNode == root) {
            root = null;
        } else {
           Node parent = deletedNode.getParent();
           if(parent.getRightNode() == deletedNode) {
               parent.setRightNode(null);
           } else {
               parent.setLeftNode(null);
           }
        }
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


}
