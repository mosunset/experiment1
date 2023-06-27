public class MyData implements Comparable {
    private Object data;
    private int id;

    private MyData() {
    }

    public MyData(int number, Object obj) {
        this.id = number;
        this.data = obj;
    }

    public int compareTo(Object obj) {
        int target = ((MyData) obj).getId();
        if (this.id == target) {
            return 0;
        }
        if (this.id > target) {
            return 1;
        }
        return -1;
    }

    public Object getData() {
        return this.data;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return "(" + this.id + ", " + this.data + ")";
    }
}