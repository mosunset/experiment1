public class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(1, "one");
        list.insert(1, "two");
        list.insert(1, "three");
        list.insert(2, "four");
        list.printAll();
        list.remove(3);
        list.printAll();
        list.remove(1);
        list.printAll();
    }
}
