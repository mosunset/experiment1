public class Lesson19_2 {
    public static void main(String[] args) {
        System.out.println("---- MyStack1 ----");
        MyStack stack1 = new MyStack(4);
        stack1.push("AAA");
        stack1.push("BBB");
        stack1.push("CCC");
        stack1.push("DDD");
        stack1.printAll();

        System.out.println("-- MyStack1 exchange --");
        if (stack1.exchange()) {
            System.out.println("Exchange was successful.");
        } else {
            System.out.println("Exchange failed.");
        }
        stack1.printAll();

        System.out.println("---- MyStack2 ----");
        MyStack stack2 = new MyStack(4);
        stack2.push("AAA");
        stack2.printAll();

        System.out.println("-- MyStack2 exchange --");
        if (stack2.exchange()) {
            System.out.println("Exchange was successful.");
        } else {
            System.out.println("Exchange failed.");
        }
        stack2.printAll();
    }
}
