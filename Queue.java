import javax.sql.rowset.serial.SQLInputImpl;

public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void add(Object ob) {
        Node newNode = new Node();
        newNode.setData(ob);
        newNode.setNext(null);

        if(front==null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public Object remove() {
        Object ob = front.getData();
        front = front.getNext();
        if(front == null) {
            rear = null;
        }
        return ob;
    }


    public void reverse() {

        LinkedList rev = new LinkedList();

        while (!this.isEmpty()) {
            rev.insertAtHead(this.remove());
        }

        while (!rev.isEmpty()) {
            this.add(rev.removeHead());
        }
    }
    }
