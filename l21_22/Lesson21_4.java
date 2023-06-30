public class Lesson21_4 {
    public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    insert(tree, new MyData(30, "potato"));
    insert(tree, new MyData(65, "onion"));
    insert(tree, new MyData(37, "peach"));
    insert(tree, new MyData(15, "apple"));
    insert(tree, new MyData(26, "pineapple"));
    insert(tree, new MyData(42, "avocado"));
    insert(tree, new MyData(71, "corn"));
    insert(tree, new MyData(29, "cabbage"));
    insert(tree, new MyData(50, "banana"));
    System.out.println();
    System.out.println("========== Binary Search Tree ==========");
    tree.showTree();
  }
  private static void insert(BinarySearchTree tree, MyData myData) {
    System.out.println("Insert: " + myData);
    tree.insert(myData);
  }
}
