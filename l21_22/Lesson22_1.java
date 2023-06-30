public class Lesson22_1 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        insert(tree, new MyData(40, "A"));
        insert(tree, new MyData(25, "B"));
        insert(tree, new MyData(15, "C"));
        insert(tree, new MyData(30, "D"));
        insert(tree, new MyData(35, "E"));
        insert(tree, new MyData(20, "F"));
        insert(tree, new MyData(10, "G"));
        insert(tree, new MyData(60, "H"));
        insert(tree, new MyData(50, "I"));
        insert(tree, new MyData(55, "J"));
        insert(tree, new MyData(70, "K"));
        insert(tree, new MyData(75, "L"));
        insert(tree, new MyData(85, "M"));

        System.out.println();

        System.out.println();

        System.out.println("===== traverse in-order =====");
        tree.printTreeInOrder();

        System.out.println("===== traverse pre-order =====");
        tree.printTreePreOrder();

        System.out.println("===== traverse post-order =====");
        tree.printTreePostOrder();

        System.out.println("===== traverse descending-order =====");
        tree.printTreeDesc();
    }
    
    private static void insert(BinarySearchTree tree, MyData myData) {
        System.out.println("Insert: " + myData);
        tree.insert(myData);
    }
}
