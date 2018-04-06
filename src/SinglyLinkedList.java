/**
 * For assignment, SinglyLinkedList class changed to use generics
 */
class SinglyLinkedList<ValueType> {
    // private variables
    // -- stores a reference to the first node in the list
    // -- 'null' if the list is empty
    private Node head;
    private Node tail;

    // constructor
    SinglyLinkedList() {
        // make an empty list
        head = null;
        tail = null;
    }

    // methods to add elements to the list
    void addToFront(ValueType value) {
        // create a node, and place it before the current head
        Node newNode = new Node(value);

        // set the next of this new node to the current head
        newNode.setNext(head);

        // if the list was empty, we need to update the tail
        // otherwise, the tail doesn't change
        if (head == null)
            tail = newNode;

        // reset the head to the new node, which is now the first node
        head = newNode;

        // these are alternatively expressed in a single line as
        // head = new Node(value, head);
    }

    public void addToBack(ValueType value) {
        // special case for an empty list
        if (head == null) {
            // the list is empty
            head = new Node(value);
            tail = head;
            return;
        }

        // for this, we have to search for the end
        // inefficient approach: searches for the end
//		Node end = head;
//		while(end.getNext() != null) {
//			end = end.getNext();
//		}
        // efficient approach: uses the saved value
        Node end = tail;

        // what do we do with the last node?
        // add another node afterwards
        Node newLast = new Node(value);
        end.setNext(newLast);

        // this new node is now the end of the list, so we should
        //   update the tail
        tail = newLast;
    }

    ValueType removeFront() {
        // check if this is possible
        if (head == null) {
            // the list is empty, crash it! (with a better error message)
            throw new IllegalStateException("cannot remove from an empty list");
        }

        // save the value from the first node
        ValueType ret = head.getValue();

        // simply skip the first node
        head = head.getNext();

        // if the list becomes empty, we need to update the tail,
        //   otherwise, the tail stays the same
        if (head == null) {
            tail = null;
        }

        // return the value that was removed
        return ret;
    }

    ValueType removeBack() {
        // 0.) a few special cases to check for
        if (head == null) {
            throw new IllegalStateException("cannot remove from an empty list");
        }

        // if we have a single-node list, there is no second-to-last node
        //   therefore, we need a special case
        if (head.getNext() == null) {
            // there is a single node, it just needs to be removed
            ValueType oldValue = head.getValue();
            head = null;
            tail = null;
            return oldValue;
        }

        // 1.) search for the second-to-last node in the list
        Node newLast = head;
        // note: because we want a node whose next is the tail
        //       and the tail is node whose next is null
        while (newLast.getNext().getNext() != null) {
            newLast = newLast.getNext();
        }

        // 2.) save the old value
        ValueType oldValue = newLast.getNext().getValue();

        // 3.) update newLast to be the tail
        newLast.setNext(null);
        tail = newLast;

        // 4.) return the old value
        return oldValue;
    }

    /**
     * Method added for assignment; Remove first item with given value from the list
     *
     * @param e The value to remove
     * @return Whether an item was removed or not
     */
    boolean remove(ValueType e) {
        // Special case 1: empty list
        if (head == null) {
            return false;
        }
        // Special case 2: Head is the value
        if (head.getValue().equals(e)) {
            head = head.getNext();
            return true;
        }

        Node node = head;
        Node prev = head;
        while (node != null) {
            if (node.getNext() == null) {
                return false;
            }

            node = node.getNext();
            if (node.getValue().equals(e)) {
                prev.setNext(node.getNext());
                return true;
            }

            prev = prev.getNext();
        }
        return false;
    }


    public String toString() {
        // String ret = "";
        StringBuilder sb = new StringBuilder();

        // add the elements in order
        // if we just wanted to first value:
        // ret += head.getValue();
//		sb.append(head.getValue());
//		// if we just wanted the second value:
//		sb.append(head.getNext().getValue());
        // let's apply the previous logic in a loop!

        // loop over the nodes, appending values
        for (Node tmp = head; tmp != null; tmp = tmp.getNext()) {
            sb.append(tmp.getValue()).append(" ");
        }

        // return the constructed string
        // return ret;
        return sb.toString();
    }

    // private inner class for the Node's of the list
    private class Node {
        // private variables
        // 1.) our piece of data
        private ValueType value;
        // 2.) a reference to the next node
        // --- this reference is null if this node has no next
        private Node next;

        // constructors
        Node(ValueType value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(ValueType value) {
            // this calls the previous constructor with the listed
            // arguments
            this(value, null);
        }

        // getters
        ValueType getValue() {
            return value;
        }

        // setters
        public void setValue(ValueType value) {
            this.value = value;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }
    }
}







