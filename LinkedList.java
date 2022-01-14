public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtHead(Object ob) {
        Node newNode = new Node();
        newNode.setData(ob);
        newNode.setNext(head);
        head = newNode;
    }

    public Object removeHead() {
        Object ob = head.getData();
        head = head.getNext();
        return ob;
    }
}

