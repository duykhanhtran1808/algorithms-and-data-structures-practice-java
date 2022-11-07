package algorithm;



public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(int value) {
        this.root = new Node(value);
    }
    public Node getRoot() {
        return this.root;
    }

    public void insert(int value) {
        
        if(value > root.getValue()) {
            if(root.getRight() == null) {
                Node right = new Node(value);
                root.setRight(right);
            } else {
                insert(value, root.getRight());
            }
            
        } 
        
        if(value < root.getValue()) {
            if(root.getLeft() == null) {
                Node left = new Node(value);
                root.setLeft(left);
            } else {
                insert(value, root.getLeft());
            }
        }

    }

    private void insert(int value, Node node) {
        
        if(value > node.getValue()) {
            if(node.getRight() == null) {
                Node right = new Node(value);
                node.setRight(right);
            } else {
                insert(value, node.getRight());
            }
            
        } 
        
        if(value < node.getValue()) {
            if(node.getLeft() == null) {
                Node left = new Node(value);
                node.setLeft(left);
            } else {
                insert(value, node.getLeft());
            }
        }

    }

    public void lookUp(int value) {
        if(value > root.getValue()) {
            if(root.getRight() == null) {
                System.out.println("Not Found");
            } else {
                lookUp(value, root.getRight());
            }
            
        } else if(value < root.getValue()) {
            if(root.getLeft() == null) {
                System.out.println("Not Found");
            } else {
                lookUp(value, root.getLeft());
            }
            
        } else if(value == root.getValue()) {
            System.out.println("Found");
        }
    }

    private void lookUp(int value, Node node) {
        if(value > node.getValue()) {
            if(node.getRight() == null) {
                System.out.println("Not Found");
            } else {
                lookUp(value, node.getRight());
            }
            
        } else if(value < node.getValue()) {
            if(node.getLeft() == null) {
                System.out.println("Not Found: " + value);
            } else {
                lookUp(value, node.getLeft());
            }
            
        } else if(value == node.getValue()) {
            System.out.println("Found: " + value);
        }
    }

    public void printAll() {
        System.out.println("-------");
        System.out.println(root.getValue());
        if(root.getLeft() != null) {
            System.out.println("Left of " + root.getValue());
            printAll(root.getLeft());
        }
        if(root.getRight() != null) {
            System.out.println("Right of " + root.getValue());
            printAll(root.getRight());
        }
    }
    private void printAll(Node node) {
        System.out.println(node.getValue());
        if(node.getLeft() != null) {
            System.out.println("Left of " + node.getValue());
            printAll(node.getLeft());
        }
        if(node.getRight() != null) {
            System.out.println("Right of " + node.getValue());
            printAll(node.getRight());
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);
        bst.printAll();
        bst.lookUp(0);
        bst.lookUp(170);
    }
}

class Node {
    private Node left;
    private Node right;
    private int value;
    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public int getValue() {return this.value;}
    public Node getLeft() {return this.left;}
    public Node getRight() {return this.right;}
}
