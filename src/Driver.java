class Driver {
    public static void main(String[] args) {

        // Testing singly linked lists

        System.out.println("Single linked list: ");
        SinglyLinkedList<GameCharacter> list = new SinglyLinkedList<>();

        list.addToFront(new GameCharacter("Steve"));
        list.addToFront(new GameCharacter("Nick"));
        list.addToFront(new GameCharacter("Bob"));
        list.addToFront(new GameCharacter("Steve"));

        System.out.println("Full list: " + list);
        list.remove(new GameCharacter("Steve"));
        System.out.println("Removing 'Steve': " + list);
        list.remove(new GameCharacter("notARealName"));
        System.out.println("Removing an object not in the list: " + list);
        list.removeBack();
        System.out.println("Removing the back: " + list);
        list.removeFront();
        System.out.println("Removing the front: " + list);
        list.remove(new GameCharacter("Nick"));
        System.out.println("Removing 'Nick' (from an empty list): " + list);


        // Testing doubly linked lists

        System.out.println();
        System.out.println("Double linked list: ");

        DoublyLinkedList<GameCharacter> list2 = new DoublyLinkedList<>();
        list2.addToFront(new GameCharacter("Steve"));
        list2.addToFront(new GameCharacter("Nick"));
        list2.addToFront(new GameCharacter("Bob"));
        list2.addToFront(new GameCharacter("Steve"));

        System.out.println("Full list: " + list2);
        list2.remove(new GameCharacter("Steve"));
        System.out.println("Removing 'Steve': " + list2);
        list2.remove(new GameCharacter("notARealName"));
        System.out.println("Removing an object not in the list: " + list2);
        list2.removeBack();
        System.out.println("Removing the back: " + list2);
        list2.removeFront();
        System.out.println("Removing the front: " + list2);
        list2.remove(new GameCharacter("Nick"));
        System.out.println("Removing 'Nick' (from an empty list): " + list2);
    }
}
