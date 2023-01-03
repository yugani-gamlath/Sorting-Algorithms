
public class stack {

    public static class Node {

        public Node next;
        private Object data;

        private Node(Object data) {
            this.data = data;
        }
    }

    private Node top;

    public boolean isEmplty() {
        return top == null;
    }

    public Object peek() {
        return top.data;
    }

    public void push(Object data) {
        Node node = new Node(data);
        node.next = top;

        top = node;
    }

    public Object pop() {
        Object temp = top.data;
        top = top.next;

        return temp;
    }

}
