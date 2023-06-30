public class MyNode {
    private MyData data;
    private MyNode left, right;

    private MyNode() {
    }

    public MyNode(MyData mydata) {
        this.data = mydata;
    }

    public MyData getData() {
        return this.data;
    }

    public MyNode getLeft() {
        return this.left;
    }

    public MyNode getRight() {
        return this.right;
    }

    public void setLeft(MyNode node) {
        this.left = node;
    }

    public void setRight(MyNode node) {
        this.right = node;
    }

    public String toString() {
        MyData leftdata = null;
        MyData rightdata = null;
        if (this.left != null) {
            leftdata = this.left.getData();
        }
        if (this.right != null) {
            rightdata = this.right.getData();
        }
        return ("{" + leftdata + ", " + this.data + ", " + rightdata + "}");
    }
}
