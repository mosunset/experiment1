public class DoublyLinkedList {
    private DoublyElement firstElement;
    private DoublyElement lastElement;

    public DoublyLinkedList() {
        this.firstElement = new DoublyElement(null);
        this.lastElement = new DoublyElement(null);
        this.firstElement.setNextElement(this.lastElement);
        this.lastElement.setPreviousElement(this.firstElement);
    }

    // index番目のデータを取得するメソッド
    public Object get(int index) {
        DoublyElement element = this.getElement(index);
        // 指定された場所にDoublyElementオブジェクトがあるか調べる
        if (null == element) {
            // 指定された場所にDoublyElementオブジェクトがないので
            // エラーメッセージを出力して処理を抜ける public Object get(int index) {
            System.out.println("Not exist: " + index);
            return null;
        }
        return element.getData();
    }

    // index番目にデータを挿入するメソッド
    public boolean insert(int index, Object obj) {
        // 指定された場所が正しいかどうか
        if (index < 1) {
            System.out.println("Cannot insert: " + index);
            return false;
        }
        DoublyElement previous = this.getElement(index - 1);
        if (previous == null) {
            System.out.println("Cannot insert: " + index);
            return false;
        }
        DoublyElement element = new DoublyElement(obj);
        element.setNextElement(previous.getNextElement());
        previous.getNextElement().setPreviousElement(element);
        previous.setNextElement(element);
        element.setPreviousElement(previous);
        length++;
        return true;
    }

    // index番目の要素を削除するメソッド
    public boolean remove(int index) {
        // 指定された場所が正しいかどうか
        if (index < 1) {
            System.out.println("Cannot remove: " + index);
            return false;
        }
        DoublyElement removeElement = this.getElement(index);
        if (removeElement == null) {
            System.out.println("Cannot remove: " + index);
            return false;
        }
        DoublyElement previous = this.getElement(index - 1);
        previous.setNextElement(removeElement.getNextElement());
        removeElement.getNextElement().setPreviousElement(previous);
        removeElement.setNextElement(null);
        removeElement.setPreviousElement(null);
        length--;
        return true;
    }

    // index番目の要素を取得するメソッド
    private DoublyElement getElement(int index) {
        DoublyElement currentElement = this.firstElement;
        // 指定された場所まで、先頭から順番に移動する
        for (int count = 0; count < index; count++) {
            // 次の要素へ移動
            currentElement = currentElement.getNextElement();
            // リストの最後まで到達
            if (currentElement == this.lastElement) {
                return null;
            }
        }
        return currentElement;
    }

    public void printAll() {
        DoublyElement currentElement = this.firstElement.getNextElement();
        while (currentElement != this.lastElement) {
            System.out.println(currentElement);
            currentElement = currentElement.getNextElement();
            if (currentElement != this.lastElement) {
                System.out.println("<->");
            }
        }
        System.out.println();
    }

    // 課題1
    public void printAllReverse() {
        DoublyElement currentElement = this.lastElement.getPreviousElement();
        while (currentElement != this.firstElement) {
            System.out.println(currentElement);
            currentElement = currentElement.getPreviousElement();
            if (currentElement != this.firstElement) {
                System.out.println("<->");
            }
        }
        System.out.println();
    }

    // 課題2
    private int length;

    public int getLength() {
        return length;
    }

    public int searchForward(Object obj) {
        int count = 0;
        DoublyElement currentElement = this.firstElement.getNextElement();
        while (currentElement != null) {
            count++;
            if (obj.equals(currentElement.getData())) {
                return count;
            }
            currentElement = currentElement.getNextElement();
        }
        return -1;
    }

    public int searchBackward(Object obj) {
        int count = length;
        DoublyElement currentElement = this.lastElement.getPreviousElement();
        while (currentElement != null) {
            if (obj.equals(currentElement.getData())) {
                return count;
            }
            count--;
            currentElement = currentElement.getPreviousElement();
        }
        return -1;
    }

    // 課題3
    public boolean removeFromFirst(Object obj) {
        int searchobj = searchForward(obj);
        return remove(searchobj);
    }

    public boolean removeFromLast(Object obj) {
        int searchobj = searchBackward(obj);
        return remove(searchobj);
    }

    // 課題4
    public DoublyLinkedList split(int index) {
        DoublyLinkedList splitlist = new DoublyLinkedList();
        if (index >= this.length || index <= 0) {
            return splitlist;
        }

        DoublyElement originalEndElement = getElement(index);

        DoublyElement splitfirstElement = getElement(index + 1);
        DoublyElement splitEndElement = this.lastElement.getPreviousElement();

        this.lastElement.setPreviousElement(originalEndElement);
        originalEndElement.setNextElement(lastElement);

        splitlist.length = this.length - index;
        this.length = index;

        splitlist.firstElement.setNextElement(splitfirstElement);
        splitlist.lastElement.setPreviousElement(splitEndElement);

        splitfirstElement.setPreviousElement(splitlist.firstElement);
        splitEndElement.setNextElement(splitlist.lastElement);

        return splitlist;
    }
}
