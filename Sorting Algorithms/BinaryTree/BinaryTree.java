
public class BinaryTree {

    public class Node {

        public int data;
        public Node left;
        public Node right;

        Node() {
            data = 0;
            left = null;
            right = null;
        }

        Node(int d) {
            data = d;
            right = left = null;
        }

        int getData() {
            return data;
        }

    }

    Node root;

    BinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean search(int d) {

        Node temp = root;

        while (temp != null) {
            if (temp.data == d) {

                return true; // if equal return true;

            } else if (temp.data > d) {

                temp = temp.left;

            } else {

                temp = temp.right;

            }

        }

        return false; // if not equal return false

    }

    public void insert(int d) {

        root = insertSub(root, d);

    }

    private Node insertSub(Node t, int d) {

        if (t == null)
            t = new Node(d);
        if (d < t.getData())
            t.left = insertSub(t.left, d);
        else if (d > t.getData()) {

            t.right = insertSub(t.right, d);

        }

        return t;

    }

    public int Max() {

        return Max(root);

    }

    private int Max(Node r) {

        if (r.right == null) {

            return r.data;

        }

        return Max(r.right);

    }

    public int Min() {

        return Min(root);

    }

    private int Min(Node r) {

        if (r.left == null) {

            return r.data;

        }

        return Min(r.left);

    }

    private void visit(Node t) {

        System.out.println(t.data + " ");

    }

    private void preOrderSubTree(Node t) {

        if (t == null)
            return;

        else {

            visit(t);
            preOrderSubTree(t.left);
            preOrderSubTree(t.right);

        }

    }

    private void inOrderSubTree(Node t) {

        if (t == null)
            return;

        else {

            preOrderSubTree(t.left);
            visit(t);
            preOrderSubTree(t.right);

        }

    }

    private void postOrderSubTree(Node t) {

        if (t == null)
            return;

        else {

            preOrderSubTree(t.left);

            preOrderSubTree(t.right);
            visit(t);

        }

    }

    private Node deleteSubTree(Node current, int x) {
        if (current == null) {
            return null;
        }

        if (x == current.data) {

            if (current.left == null && current.right == null) {
                return null;
            }
        }

        if (current.right == null)
            return current.left;
        if (current.left == null)
            return current.right;
        int smallestValue = Min(current.right);
        current.data = smallestValue;
        current.right = deleteSubTree(current.left, x);
        return current;

    }

    public void sizeTree() {

    }

}
