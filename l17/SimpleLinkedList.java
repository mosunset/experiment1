public class SimpleLinkedList {
    private Element firstElement;
    private int length;

    public SimpleLinkedList() {
        this.firstElement = new Element(null);
    }

    public Object get(int index) {
        Element element = this.getElement(index);
        if (null == element) {
            System.out.println("Element-" + index + " is not exist.");
            return null;
        }
        return element.getData();
    }

    public boolean insert(int index, Object obj) {
        if (index < 1) {
            System.out.println("Cannot insert: " + index);
            return false;
        }
        Element previous = this.getElement(index - 1);
        if (previous == null) {
            System.out.println("Cannot insert: " + index);
            return false;
        }
        Element element = new Element(obj);
        element.setNextElement(previous.getNextElement());
        previous.setNextElement(element);
        length++;
        return true;
    }

    public boolean remove(int index) {
        if (index < 1) {
            System.out.println("Cannot remove: " + index);
            return false;
        }
        Element removeElement = this.getElement(index);
        if (removeElement == null) {
            System.out.println("Cannot remove: " + index);
            return false;
        }
        Element previous = this.getElement(index - 1);
        previous.setNextElement(removeElement.getNextElement());
        removeElement.setNextElement(null);
        length--;
        return true;
    }

    private Element getElement(int index) {
        Element currentElement = this.firstElement;
        for (int count = 0; count < index; count++) {
            if (null == currentElement) {
                return null;
            }
            currentElement = currentElement.getNextElement();
        }
        return currentElement;
    }

    public void printAll() {
        int count = 0;
        Element currentElement = this.firstElement.getNextElement();
        while (currentElement != null) {
            count++;
            System.out.println(count + " : " + currentElement);
            currentElement = currentElement.getNextElement();
        }
        System.out.println();
    }

    public int getLength() {
        // リストの長さを返す
        return this.length;
    }

    public boolean append(Object obj) {
        // 与えられたobjをリストの末尾に追加する
        return insert(length + 1, obj);

    }

    public int search(Object obj) {
        // obj を持つ最初の要素を検索する. 見つかった場合はその要素番号を返し, 見つからなかった場合は-1 を返す
        int count = 0;
        Element currentElement = this.firstElement.getNextElement();
        while (currentElement != null) {
            count++;
            if (obj.equals(currentElement.getData())) {
                return count;
            }
            currentElement = currentElement.getNextElement();
        }
        System.out.println("Not found : " + obj.toString());
        return -1;
    }

    public boolean remove(Object obj) {
        // obj を持つ最初の要素を削除する. 見つかった場合は削除し, 見つからなかった場合は false を返す
        int searchobj = search(obj);
        if (searchobj > 0) {
            return remove(searchobj);
        }
        System.out.println("Cannot remove : " + obj.toString());
        return false;
    }

    public boolean insertList(SimpleLinkedList list, int index) {
        // 与えられえたリスト list を index 番目に挿入する. 挿入が成功した場合は true を返し, 失敗した場合は false を返す
        if (list.getLength() <= 0) {
            System.out.println("Cannot insert list: insert list is empty");
            return false;
        } else if (1 > index || index > list.getLength()) {
            System.out.println("Cannot insert list: index out of bounds");
            return false;
        } else {
            Element element = this.getElement(index - 1);
            Element next = element.getNextElement();

            Element first = list.getElement(1);
            Element end = list.getElement(list.getLength());

            element.setNextElement(first);
            end.setNextElement(next);

            length += list.getLength();
            return true;
        }
    }

    public boolean cut(int from, int to) {
        // リスト内の from 番目から to 番目の要素を削除する. 削除が成功した場合は true を返し, 失敗した場合は false を返す.
        if (from >= to) {
            System.out.println("Cannot cut list: from is bigger than ”to”");
            return false;
        } else if (from <= 0) {
            System.out.println("Cannot cut list: index out of bounds");
            return false;
        } else if (from >= this.getLength()) {
            System.out.println("Cannot cut list: index out of bounds");
            return false;
        } else {
            Element element = this.getElement(from - 1);
            Element next = this.getElement(to + 1);
            element.setNextElement(next);
            length -= to - from + 1;
            return true;
        }
    }

    public boolean stringListSort() {
        // リスト内の String オブジェクトを辞書順にソートする. 文字列の比較には String クラスの compareTo メソッドを使用する
        // SimpleLinkedList sortedList = new SimpleLinkedList();

        // while (this.getLength() != 0) {
        //     String min = (String) this.getElement(1).getData();
        //     int minindex = 1;

        //     for (int i = 2; i <= this.getLength(); i++) {//getNextElementをつかって
        //         String s1 = (String) this.getElement(i).getData();

        //         if (min.compareTo(s1) > 0) {
        //             min = s1;
        //             minindex = i;
        //         }
        //     }
        //     sortedList.append(min);
        //     this.remove(minindex);
        // }
        // this.firstElement.setNextElement(sortedList.firstElement.getNextElement());
        // this.length = sortedList.length;

        // return true;

        if (this.getLength() <= 1) {
        // リストの要素数が1以下の場合、ソートの必要はないので終了
        return true;
    }

    SimpleLinkedList sortedList = new SimpleLinkedList();
    Element currentElement = this.firstElement.getNextElement();

    while (currentElement != null) {
        // ソート済みリストの中で、現在の要素の挿入位置を探す
        Element sortedCurrent = sortedList.firstElement.getNextElement();
        Element previous = sortedList.firstElement;

        while (sortedCurrent != null && ((String) sortedCurrent.getData()).compareTo((String) currentElement.getData()) < 0) {
            previous = sortedCurrent;
            sortedCurrent = sortedCurrent.getNextElement();
        }

        // 現在の要素をソート済みリストの挿入位置に追加
        Element newElement = new Element(currentElement.getData());
        previous.setNextElement(newElement);
        newElement.setNextElement(sortedCurrent);

        // 次の要素に進む
        currentElement = currentElement.getNextElement();
    }

    // ソート済みリストの長さと、元のリストを更新する
    this.firstElement.setNextElement(sortedList.firstElement.getNextElement());
    this.length = sortedList.length;

    return true; // ソート操作が成功したことを返す
    }
}
