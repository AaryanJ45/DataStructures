package BinaryTree;

public class TreeDriver {

    public static void main(String args[])
    {
        Node n = new Node("A");
        n.addNode(new Node("E"));
        n.addNode(new Node("R"));
        n.addNode(new Node("J"));
        n.addNode(new Node("T"));
        n.addNode(new Node("D"));
        n.addNode(new Node("H"));

        n.printInOrder(n);
    }
}