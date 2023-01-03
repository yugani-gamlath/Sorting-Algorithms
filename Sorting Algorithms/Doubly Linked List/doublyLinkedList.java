//package doubly.linked.list;

public class doublyLinkedList {

    /*Varibles for doubly link list
    both head and tail are class variables.
    Because they are used to link the nodes.
     */
    DoublyNode head;
    DoublyNode tail;
    Object data;

    /*
    Data type Object is a data type which is use as common data type.
    This variable is used to store the contain of the node.
     */

    //Sub class for particular one node of the list
    public class DoublyNode {

        /*
        Variables for Node class
        Both next and previous variables are class variables.
        Because they are used to link the nodes.
         */
        DoublyNode next;
        DoublyNode previous;
        Object data;

        /*
        Data type Object is a data type which is use as common data type.
        This variable is used to store the contain of the node.
         */

 /*Constructor to create new node
        next and previous are intialized as null
         */
        public DoublyNode(Object dat) {
            data = dat;
            next = previous = null;
        }

        //Parameterized constructor to create new node in specific place of list
        public DoublyNode(Object x, DoublyNode nextNode, DoublyNode nextPrevious) {
            data = x;
            next = nextNode;
            previous = nextPrevious;
        }

        //Get method for contain of node
        public Object getData() {
            return data;
        }

        //Get method for link which is use for linking next node
        DoublyNode getNext() {
            return next;
        }

        //Get method for link which is use for linking prevoius node
        DoublyNode getPrevoius() {
            return previous;
        }
    }

    //Main class default constructor
    public doublyLinkedList() {
        head = null;
        tail = null;
    }

    //Method to check whether the list is empty or not
    public boolean IsEmpty() {
        return head == null;
    }

    //Method to insert a new node to the list at the position of head
    public void insertFirst(Object data) {

        //Allocate a node and put in the data
        DoublyNode newNode = new DoublyNode(data);

        //Check whether the list is empty or not
        if (IsEmpty()) /*
            miss:
            head = tail = new DoublyNode(data);
         */ {
            tail = newNode; //If the list is empty both head and tail change into new node
        } else /*
            Miss :
            head = head.previous = new DoublyNode(data,head,null); 
         */ {
            head.previous = newNode; //current head's previous link assign to new node
        }
        newNode.next = head; //new node's link assign as the new head
        head = newNode; //head changes as the new node
    }

    //Method to insert a new node to the list at the position of tail
    public void insertLast(Object data) {

        //Allocate a node and put in the data
        DoublyNode newNode = new DoublyNode(data);

        //Check whether the list is empty or not
        if (IsEmpty()) {
            head = newNode;//If the list is empty both head and tail change into new node
        } else {
            tail.next = newNode;//current tail's next link assign to new node
            newNode.previous = tail; //new node's link assign as the new tail 
        }

        tail = newNode; //tail changes as the new node
    }

    //Method to delete the node from head
    public void deleteFirst() {

        //Miss : 
        Object item = null;

        if (IsEmpty()) {
            item = head.data;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        head.previous = null;

    }

    //Method to delete the node from tail
    public void deleteLast() {

        //Miss :
        Object item = null;

        if (IsEmpty()) {
            item = tail.data;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.previous;
        }
        tail.next = null;

    }

    //Method of insert a new node after the given position
    public boolean InsertAfterKey(Object key, Object data) {

        //Create a temporary node to allocate data of head
        DoublyNode temp = head;

        //Iteration to found the position
        while (temp.data != key) {
            temp = temp.next;

            //key doesn't found
            if (temp == null) {
                return false;
            }

            //Insert a new node
            DoublyNode newNode = new DoublyNode(data);

            if (temp == tail) {
                newNode.next = null;
                tail = newNode;
            } else {
                newNode.next = temp.next;
                temp.next.previous = newNode;
            }

            newNode.previous = temp;
            temp.next = newNode;
        }

        return true;
    }

    //Method of delete a node after the given position
    public boolean DeleteKey(Object key) {

        //Create a temporary node to allocate data of head
        DoublyNode temp = head;

        //Iteration to found the key position
        while (temp.data != key) {
            temp = temp.next;

            //Key doesn't found
            if (temp == null) {
                return false;
            }
        }

        //delete the node
        if (temp == head) {
            head = temp.next;
        } else {
            temp.previous.next = temp.next;
        }

        if (temp == tail) {
            tail = temp.previous;
        } else {
            temp.next.previous = temp.previous;
        }

        return true;

    }

    //Method to print data of the list
    public void DisplayList() {
        System.out.println("List of head to tail");

        //Create a temporary node to put data of head
        DoublyNode temp = head;

        //Iteration will continue until the temp is equal to null
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.next;

        }

        System.out.println("");

    }

    //Method to print data of the list in reverse
    public void DisplayListBackward() {

        System.out.println("List of tail to head");

        //Create a temporary node to put data of tail
        DoublyNode temp = tail;

        //Iteration will continue until the temp is equal to null
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.previous;

        }
        System.out.println("");
    }

    //Main Method
    public static void main(String[] args) {

        //Allocate a common node
        doublyLinkedList list1 = new doublyLinkedList();

        //Futions Calling 
        list1.insertFirst(12);
        list1.insertFirst(25);
        list1.insertFirst(62);
        list1.insertLast(51);
        list1.insertLast(78);
        //list1.DisplayList();
        //list1.DisplayListBackward();
        //list1.InsertAfterKey(25,32);
        //list1.DisplayList();
        //list1.DeleteKey(32);
        //list1.DisplayList();
        //list1.deleteFirst();
        //list1.DisplayList();
        list1.deleteLast();
        list1.DisplayList();
    }

}
