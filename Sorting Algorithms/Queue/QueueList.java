
public class QueueList {

    public static class Node {

        public Node next;
        private Object data;

        private Node(Object data) {
            this.data = data;
        }
    }

    private Node head; // remove from the tail
    private Node tail; // add things here

    public boolean isEmplty() {
        return head == null;
    }

    public Object peek() {
        return head.data;
    }

    public void add(Object data) {
        Node node = new Node(data);

        if (tail != null)
            tail.next = node;

        tail = node;

        if (head == null)
            head = node;
    }

    public Object remove() {
        Object temp = head.data;
        head = head.next;

        if (head == null)
            tail = null;

        return temp;
    }

}
