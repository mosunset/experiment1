public class ChainHashtable {
    // フィールド
    private MyLinkedList[] table;

    // コンストラクタ
    private ChainHashtable() {
    }

    public ChainHashtable(int aMaxSize) {
        this.table = new MyLinkedList[aMaxSize];
    }

    public AddressData get(String aKey) {
        if (null == aKey) {
            throw new NullPointerException(); // aKeyがnull
        }
        MyLinkedList list = this.table[this.calculateHashCode(aKey)];
        if (null == list) {
            return null; // listがnull
        }
        int limit = list.size();
        int count = 1;
        AddressData address = null;
        while (count <= limit) {
            address = (AddressData) list.get(count);
            if (address.getName().equals(aKey)) {
                return address;
            }
            ++count;
        }
        return null;
    }

    public boolean put(AddressData anAddressData) {
        if (null == anAddressData) {
            return false;
        }
        int hashCode = this.calculateHashCode(anAddressData.getName());
        if (null == this.table[hashCode]) {
            this.table[hashCode] = new MyLinkedList();
        }
        this.table[hashCode].insert(anAddressData);
        return true;
    }

    public boolean remove(String aKey) {
        if (null == aKey) {
            return false;
        }
        MyLinkedList list = this.table[this.calculateHashCode(aKey)];
        if (null == list) {
            return false;
        }
        int limit = list.size();
        int count = 1;
        AddressData address = null;
        while (count <= limit) {
            address = (AddressData) list.get(count);
            if (address.getName().equals(aKey)) {
                return list.remove(count);
            }
            ++count;
        }
        return false;
    }

    public void printAll() {
        // テーブルの内容を順番にすべて表示
        for (int count = 0; count < this.table.length; count++) {
            if (null == this.table[count]) {
                System.out.println(this.table[count]);
            } else {
                this.table[count].printAll();
            }
        }
        System.out.println();
    }

    private int calculateHashCode(String aKey) {
        // 鍵が null であるか調べる
        if (null == aKey) {
            // 鍵が null なので例外を報告して処理を抜ける
            throw new NullPointerException();
        }
        // 文字列の各文字を Unicode 数値として扱い、足し合わせる
        int intKey = 0;
        for (int count = 0; count < aKey.length(); count++) {
            intKey += 0xFFFF & aKey.charAt(count);
        }
        // 合計値からハッシュ値を求める
        return intKey % this.table.length;
    }
}
