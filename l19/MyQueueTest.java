public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        System.out.println(queue.enqueue("apple"));
        System.out.println(queue.enqueue("orange"));
        System.out.println(queue.enqueue("cherry") + "\n");
        queue.printAll();
        System.out.println(queue.dequeue() + "\n");
        queue.printAll();
        System.out.println("\n" + queue.enqueue("banana"));
        System.out.println(queue.enqueue("grape"));
        System.out.println(queue.enqueue("melon"));
        System.out.println(queue.enqueue("lemon") + "\n");
        queue.printAll();
        System.out.println();
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
        System.out.println(queue.dequeue());
    }
}
