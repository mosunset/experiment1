public class MyStackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        System.out.println("isEmpty(): " + stack.isEmpty());
        System.out.println("isFull() : " + stack.isFull());
        stack.push("apple");
        stack.push("orange");
        stack.push("banana");
        stack.push("grape");
        stack.printAll();
        System.out.println("isEmpty(): " + stack.isEmpty());
        System.out.println("isFull() : " + stack.isFull());
        System.out.println("pop(): " + stack.pop());
        System.out.println("pop(): " + stack.pop());
        stack.printAll();
        stack.push("lemon");
        stack.push("peach");
        stack.push("melon");
        stack.push("pine");
        System.out.println("isEmpty(): " + stack.isEmpty());
        System.out.println("isFull() : " + stack.isFull());
        stack.printAll();
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.pop());
    }
}
