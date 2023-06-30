public class Lesson21_2 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println("Num: " + tree.getNumOfNodes());
        System.out.println();
        insert(tree, new MyData(30, "potato"));
        System.out.println();
        System.out.println("Num: " + tree.getNumOfNodes());
        System.out.println();
        insert(tree, new MyData(65, "onion"));
        insert(tree, new MyData(37, "peach"));
        insert(tree, new MyData(15, "apple"));
        insert(tree, new MyData(26, "pineapple"));
        System.out.println();
        System.out.println("Num: " + tree.getNumOfNodes());
    }
    private static void insert(BinarySearchTree tree, MyData myData) {
        System.out.println("Insert: " + myData);
        tree.insert(myData);
    }
}
