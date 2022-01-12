package BinaryTree;
import java.util.*;

public class BinarySearchTree
{
    private Node root;

    public  BinarySearchTree()
    {
        root = null;
    }

    public void add(Comparable item)
    {
        if(root == null)
        {
            root.setData(item);
        }
        else
        {
            root.addNode(new Node(item));
        }
    }


    public void printTree(char data)
    {
        Scanner input = new Scanner(System.in);
        String userin = "";

        System.out.print("1) Print in order 'Type I'\n 2) Print pre order 'Type P'\n 3) Print Post order 'Type PO'");
        userin = input.nextLine();

        if(userin.equals("P") || userin.equals("p"))
        {
            root.printInOrder(root);
        }
        else if(userin.equals("I") || userin.equals("i"))
        {
            root.printPreOrder(root);
        }
        else if(userin.equals("PO") || userin.equals("po"))
        {
            root.printPostOrder(root);
        }
    }
}
