public class MyQueue {
    // ---- フィールド ----
    private Object[] queueArray; // キューを実現する配列
    private int head; // キューの先頭を示すインデックス
    private int tail; // キューの最後を示すインデックス
    private int maxSize; // キューを実現する配列のサイズ
    private int num; // キューに格納されているオブジェクト数

    public MyQueue(int size) {
        this.queueArray = new Object[size];
        this.head = 0;
        this.tail = 0;
        this.num = 0;
        this.maxSize = size;
    }// コンストラクタ

    private MyQueue() {
    }// 引数のないコンストラクタは使えないようにする

    // 敢えて，格納された配列のindexを返すようにしている
    public int enqueue(Object obj) {
        // 格納されているオブジェクト数が配列のサイズよりも小さいときだけ追加
        if (this.num < this.maxSize) {
            this.queueArray[this.tail] = obj; // キューの最後に追加
            int oldtail = this.tail;
            // 配列の最後であれば先頭へ
            this.tail = (this.tail + 1) % this.maxSize;
            this.num++;
            return oldtail; // objが格納されたqueueArrayのindexを返す
        } else {
            return -1; // 配列が一杯なら-1を返す
        }
    }

    public Object dequeue() {
        // 1個以上のオブジェクトが格納されているときだけ取り出し
        // isEmpty()メソッドを利用するのも可
        if (this.num > 0) {
            Object obj = this.queueArray[head];
            // 配列の最後であれば先頭へ
            this.head = (this.head + 1) % this.maxSize;
            this.num--;
            return obj;
        } else {
            return null;
        }
    }

    // キューが空かそうでないかを返すメソッド
    public boolean isEmpty() {
        return (this.num == 0);
    }

    // キューが一杯かそうでないかを返すメソッド
    public boolean isFull() {
        return (this.num == this.maxSize);
    }

    public void printAll() {
        System.out.println("Contents of Queue.");
        if (!this.isEmpty()) {
            int position = this.head;
            for (int i = 0; i < this.num; i++) {
                position = (this.head + i) % this.maxSize;
                System.out.println(this.queueArray[position]);
            }
        }
    }

    // 課題3
    public void clear() {
        if (!this.isEmpty()) {
            int position = this.head;
            for (int i = 0; i < this.num; i++) {
                position = (this.head + i) % this.maxSize;
                this.queueArray[position] = null;
            }
            this.head = 0;
            this.tail = 0;
            this.num = 0;
        }
    }

    public void checkQueue() {
        if (!this.isEmpty()) {
            System.out.println("Queue is not Empty.");
        } else {
            System.out.println("Queue is Empty.");
        }
    }

    public Object peek() {
        if (!this.isEmpty()) {
            Object obj = this.queueArray[head];
            return obj;
        }
        System.out.println("Queue is Empty.");
        return null;
    }

    public int forceEnqueue(Object obj) {
        if (this.num < this.maxSize) {
            this.queueArray[this.tail] = obj;
            int oldtail = this.tail;
            this.tail = (this.tail + 1) % this.maxSize;
            this.num++;
            return oldtail;
        } else {
            this.dequeue();
            this.queueArray[this.tail] = obj;
            int oldtail = this.tail;
            this.tail = (this.tail + 1) % this.maxSize;
            this.num++;
            return oldtail;
        }
    }

    public void rotate(int n) {
        if (!this.isEmpty()) {
            for (int i = 0; i < n; i++) {
                Object temp = this.queueArray[this.head];
                this.dequeue();
                this.enqueue(temp);
            }
        }
    }
}
