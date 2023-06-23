public class Lesson19_4 {
    public static void main(String[] args) {
        System.out.println("---- MyQueue ----");
        MyQueue que = new MyQueue(4);
        que.enqueue("AAA");
        que.enqueue("BBB");
        que.enqueue("CCC");
        que.enqueue("DDD");
        que.printAll();
        System.out.println();

        System.out.println("-- MyQueue rotate(1) --");
        que.rotate(1);
        que.printAll();
        System.out.println();

        System.out.println("-- MyQueue rotate(5) --");
        que.rotate(5);
        que.printAll();
        System.out.println();

        System.out.println("-- MyQueue dequeue --");
        que.dequeue();
        que.printAll();
        System.out.println();

        System.out.println("-- MyQueue rotate(5) --");
        que.rotate(5);
        que.printAll();
        System.out.println();

        System.out.println("-- MyQueue clear --");
        que.clear();
        que.printAll();
        System.out.println();

        System.out.println("-- MyQueue rotate(2) --");
        que.rotate(2);
        que.printAll();
    }
}
