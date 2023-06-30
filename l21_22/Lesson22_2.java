public class Lesson22_2 {
    public static void main(String[] args) {
         BinarySearchTree tree = new BinarySearchTree();

         insert(tree, new MyData(28, "fig"));
         insert(tree, new MyData(20, "apple"));
         insert(tree, new MyData(13, "orange"));
         insert(tree, new MyData(24, "banana"));
         insert(tree, new MyData(5, "cherry"));
         insert(tree, new MyData(19, "star-fruit"));
         insert(tree, new MyData(21, "coconut"));
         insert(tree, new MyData(33, "cassis"));
         insert(tree, new MyData(30, "pineapple"));
         insert(tree, new MyData(31, "watermelon"));
         insert(tree, new MyData(50, "plum"));

         System.out.println();
         tree.printTreeInOrder();

         System.out.println("----------- Removed Level 2 -----------");
         tree.removeLevel(2);
         tree.printTreeInOrder();

         System.out.println("----------- Removed Level 0 -----------");
         tree.removeLevel(0);
         tree.printTreeInOrder();

         System.out.println("----------- Removed Level 5 -----------");
         tree.removeLevel(5);
         tree.printTreeInOrder();
     }
     
     private static void insert(BinarySearchTree tree, MyData myData) {
         System.out.println("Insert: " + myData);
         tree.insert(myData);
     }
}
