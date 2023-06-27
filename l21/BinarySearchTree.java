public class BinarySearchTree {
    private MyNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(MyData aData) {
        MyNode newNode = new MyNode(aData);
        if (null == this.root) {
            this.root = newNode;
            return;
        }
        MyNode currentNode = this.root;
        while (true) {
            if (currentNode.getData().compareTo(aData) > 0) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(newNode);
                    return;
                }
                currentNode = currentNode.getLeft();
            } else {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(newNode);
                    return;
                }
                currentNode = currentNode.getRight();
            }
        }
    }

    public void printRoot() {
        System.out.println(this.root);
        System.out.println(this.root.getLeft());
        System.out.println(this.root.getRight());
    }
}
