public class MyStack {
    private int maxSize;// スタックの大きさ
    private Object[] stackArray;// スタックを実現する配列
    private int stackPointer;// スタックポインタ

    private MyStack() {
    }

    public MyStack(int size) {
        this.maxSize = size;
        this.stackArray = new Object[size];
        this.stackPointer = 0; // push時に格納される配列のindex
    }

    // スタックが空かどうかを判定するメソッド
    public boolean isEmpty() {
        return (this.stackPointer == 0);
    }

    // スタックが一杯かどうかを判定するメソッド
    public boolean isFull() {
        return (this.stackPointer == this.maxSize);
    }

    // popメソッド
    public Object pop() {
        if (this.isEmpty()) {
            // 特にエラーメッセージを表示する場合に使うメソッド（標準エラーストリーム）
            System.err.println("Stack is Empty.");
            return null;
        }
        this.stackPointer--;
        Object popObject = this.stackArray[this.stackPointer];
        this.stackArray[this.stackPointer] = null;
        return popObject;
    }

    // pushメソッド
    public void push(Object obj) {
        if (this.isFull()) {
            System.err.println("Stack is full.");
            return;
        }
        this.stackArray[this.stackPointer] = obj;
        this.stackPointer++;
    }

    // スタックの中身を全て表示するメソッド
    public void printAll() {
        System.out.println("Contents of Stack.");
        int count = 1;
        int position = this.stackPointer - 1;
        while (position >= 0) {
            System.out.println(count + "\t" + this.stackArray[position]);
            count++;
            position--;
        }
        System.out.println();
    }

    // 課題1
    public void clear() {
        int position = 0;
        while (position <= this.stackPointer - 1) {
            this.stackArray[position] = null;
            position++;
        }
        stackPointer = 0;
    }

    public void checkStack() {
        int position = 0;
        boolean checknull = true;
        while (position <= this.stackPointer - 1) {
            if (this.stackArray[position] != null) {
                checknull = false;
            }
            position++;
        }
        if (checknull) {
            System.out.println("Stack is Empty.");
        } else {
            System.out.println("Stack is not Empty.");
        }

    }

    public Object peek() {
        if (this.isEmpty()) {
            System.err.println("Stack is Empty.");
            return null;
        }
        return this.stackArray[this.stackPointer - 1];
    }

    public void printAllReverse() {
        System.out.println("Contents of Stack(Reverse).");
        int count = 1;
        int position = 0;
        while (position <= this.stackPointer - 1) {
            System.out.println(count + "\t" + this.stackArray[position]);
            count++;
            position++;
        }
        System.out.println();
    }

    // 課題2
    public boolean exchange() {
        if (this.stackPointer >= 2) {
            Object temp = this.stackArray[this.stackPointer - 1];
            this.stackArray[this.stackPointer - 1] = this.stackArray[this.stackPointer - 2];
            this.stackArray[this.stackPointer - 2] = temp;
            return true;
        }
        System.out.println("The number of elements is less than 2.");
        return false;
    }
}
