public class Lesson21_1 {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        showMinMax(tree);
        System.out.println();
        insert(tree, new MyData(30, "potato"));
        System.out.println();
        showMinMax(tree);
        System.out.println();
        insert(tree, new MyData(65, "onion"));
        insert(tree, new MyData(37, "peach"));
        insert(tree, new MyData(15, "apple"));
        insert(tree, new MyData(26, "pineapple"));
        System.out.println();
        showMinMax(tree);
    }

    private static void showMinMax(BinarySearchTree tree){
        System.out.println("Maximum Data: " + tree.getMaximumData());
        System.out.println("Minimum Data: " + tree.getMinimumData());
    }

    private static void insert(BinarySearchTree tree, MyData myData){
        System.out.println("Insert: " + myData);
        tree.insert(myData);
    }
}
