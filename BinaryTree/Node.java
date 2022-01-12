package BinaryTree;

import com.sun.source.tree.BinaryTree;

public class Node {
    private Comparable data;
    private Node left;
    private Node right;

    public Node (Comparable d)
    {
        data = d;
        left = null;
        right = null;
    }

    public Comparable getData() { return data; }

    public Node getLeft() { return left; }

    public Node getRight() { return right; }

    public void setData(Comparable d) { data = d; }

    public void setLeft(Node l)  {left = l;}

    public void setRight(Node r) {right = r;}

    public void addNode(Node x) {
        if (this.data.compareTo(x.data) >= 0)
        {
            if (left == null)
            {
                this.setLeft(x);
            }
            else {
                left.addNode(x);
            }
        }
        else {
            if(right == null)
            {
                this.setRight(x);
            }
            else
            {
                right.addNode(x);
            }
        }
    }

    public void printInOrder(Node node)
    {
        if (node != null)
        {
            printInOrder(node.left);
            System.out.print(" " + node.data);
            printInOrder(node.right);
        }

    }

    public void printPreOrder(Node node)
    {
        System.out.print(" " + node.data);
        if(left != null)
        {
            left.printPreOrder(node.left);
        }
        if(right != null)
        {
            right.printPreOrder(node.right);
        }
    }

    public void printPostOrder(Node node)
    {
        if(left != null)
        {
            left.printPostOrder(node.left);
        }
        if(right != null)
        {
            right.printPostOrder(node.right);
        }

        System.out.print(" " + node.data);

    }
}
