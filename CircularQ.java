public class CircularQ
{
    private Node head;

    public boolean isEmpty()
    {
        return head==null;
    }

    public void add(Object ob)
    {
        Node newNode=new Node();
        newNode.setData(ob);
        if(head==null)
        {
            head=newNode;
        }
        else
        {
            Node temp=new Node();
            temp=head;
            newNode.setNext(temp);
            head=newNode;
        }

    }

    public Object remove()
    {
        Object ob=head.getData();
        head=head.getNext();
        return ob;
    }

    public void reverse()
    {
        LinkedList copy=new LinkedList();
        while(!isEmpty())
        {
            copy.insertAtHead(this.remove());
        }
        while(!copy.isEmpty())
        {
            this.add(copy.removeHead());
        }
    }
}
