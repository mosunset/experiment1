public class Lesson22_3 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        
        insert(tree, new MyData(35, "apple"));
        insert(tree, new MyData(17, "lemon"));
        insert(tree, new MyData(69, "banana"));
        insert(tree, new MyData(21, "orange"));
        insert(tree, new MyData(38, "cherry"));
        insert(tree, new MyData(75, "grape"));
	    insert(tree, new MyData(79, "pineapple"));

    	System.out.println();
    	tree.printTreeInOrder();
    	// copyした木をtree2に入れる
        BinarySearchTree tree2 = tree.cutTree(new MyData(69, "banana"));

    	System.out.println("/* Tree1 */");
    	tree.printTreeInOrder();
        
    	System.out.println("/* Tree2 */");
    	tree2.printTreeInOrder();

        BinarySearchTree tree3 = tree2.cutTree(new MyData(69, "banana"));

        System.out.println("/* Tree2 */");
    	tree2.printTreeInOrder();

        System.out.println("/* Tree3 */");
        tree3.printTreeInOrder();

        BinarySearchTree tree4 = tree3.cutTree(new MyData(0, "dummy"));
        System.out.println("/* Tree3 */");
        tree3.printTreeInOrder();

        System.out.println("/* Tree4 */");
        tree4.printTreeInOrder();
    }

    private static void insert(BinarySearchTree tree, MyData myData) {
        System.out.println("Insert: " + myData);
        tree.insert(myData);
    }
}