import java.time.LocalDate;

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

    // Lesson21_1
    public MyData getMaximumData() {
        if (null == this.root) {
            return null;
        }
        MyNode currentNode = this.root;
        while (true) {
            if (currentNode.getRight() == null) {
                return currentNode.getData();
            }
            currentNode = currentNode.getRight();
        }
    }

    public MyData getMinimumData() {
        if (null == this.root) {
            return null;
        }
        MyNode currentNode = this.root;
        while (true) {
            if (currentNode.getLeft() == null) {
                return currentNode.getData();
            }
            currentNode = currentNode.getLeft();
        }
    }

    // Lesson21_2
    public int getNumOfNodes() {
        return countNodes(this.root);
    }

    private int countNodes(MyNode currentNode) {
        if (null == currentNode) {
            return 0;
        }
        return 1 + countNodes(currentNode.getLeft()) + countNodes(currentNode.getRight());
    }

    // Lesson21_3
    public int getHeight() {
        return getNodeHeight(this.root);
    }

    private int getNodeHeight(MyNode currentNode) {
        if (null == currentNode) {
            return 0;
        }
        int left = 1 + getNodeHeight(currentNode.getLeft());
        int right = 1 + getNodeHeight(currentNode.getRight());
        if (left > right) {
            return left;
        } else {
            return right;
        }
    }

    // Lesson21_4
    public void showTree() {
        System.out.println(showSubTree(root, 0));
    }

    public String showSubTree(MyNode localNode, int counter) {
        if (localNode == null) {
            return "";
        }

        StringBuffer bf = new StringBuffer();
        bf.append(showSubTree(localNode.getRight(), counter + 1));

        align(bf, counter);
        bf.append(counter + ":");
        bf.append(localNode.getData().toString());
        bf.append("\n");

        bf.append(showSubTree(localNode.getLeft(), counter + 1));

        return bf.toString();
    }

    private void align(StringBuffer bf, int counter) {
        for (int i = 0; i < counter; i++) {
            bf.append("  ");
        }
    }

}
