public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new MyData(29, "apple"));
        tree.insert(new MyData(20, "orange"));
        tree.insert(new MyData(32, "cherry"));
        tree.insert(new MyData(14, "banana"));
        tree.insert(new MyData(30, "strawberry"));
        tree.insert(new MyData(22, "lemon"));
        tree.insert(new MyData(36, "pear"));

        tree.printRoot();
        System.out.println();
        tree.showTree();
        System.out.println();
        // 葉ノードを削除
        tree.remove(new MyData(14, "banana"));
        tree.printRoot();
        System.out.println();
        tree.showTree();
        System.out.println();
        // 子を持つノードの削除
        tree.remove(new MyData(20, "orange"));
        tree.printRoot();
        System.out.println();
        tree.showTree();
        System.out.println();
        // ルートノードを削除
        tree.remove(new MyData(29, "apple"));
        tree.printRoot();
        System.out.println();
        tree.showTree();
        System.out.println();
    }
}