public class Lesson19_1 {
    public static void main(String[] args) {
        System.out.println("---- MyStack ----");
        MyStack stack = new MyStack(4);
        stack.push("AAA");
        stack.push("BBB");
        stack.push("CCC");
        stack.push("DDD");
        stack.checkStack();
        stack.printAll();

        System.out.println("-- MyStack peek --");
        System.out.println("Object at the top: " + stack.peek());
        stack.checkStack();
        stack.printAll();

        System.out.println("-- MyStack printAllReverse --");
        stack.checkStack();
        stack.printAllReverse();

        System.out.println("-- MyStack clear --");
        stack.clear();
        stack.checkStack();
        stack.printAll();

        System.out.println("-- MyStack peek --");
        System.out.println("Object at the top: " + stack.peek());
        stack.printAll();
    }
}
