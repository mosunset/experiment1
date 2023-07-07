public class OpenAddressHashtable {
    // フィールド
    private final AddressData removedData = new AddressData("", "", "", "");
    private AddressData[] table;

    // コンストラクタ
    private OpenAddressHashtable() {
    }

    public OpenAddressHashtable(int aMaxSize) {
        this.table = new AddressData[aMaxSize];
    }

    public AddressData get(String aKey) {
        if (null == aKey) {
            throw new NullPointerException();
        }
        int hashCode = this.calculateHashCode(aKey);
        if (null == this.table[hashCode]) {
            return null;
        }
        if (this.removedData != this.table[hashCode]) {
            if (this.table[hashCode].getName().equals(aKey)) {
                return (this.table[hashCode]);
            }
        }
        int limit = this.table.length - 1;
        for (int count = 0; count < limit; count++) {
            hashCode = this.calculateHashCodeAgain(aKey, hashCode);
            if (null == this.table[hashCode]) {
                return null;
            }
            if (this.removedData != this.table[hashCode]) {
                if (this.table[hashCode].getName().equals(aKey)) {
                    return (this.table[hashCode]);
                }
            }
        }
        return null;
    }

    public void printAll() {
        for (int count = 0; count < this.table.length; count++) {
            if (null == this.table[count]) {
                System.out.println(this.table[count]);
            } else if (this.removedData == this.table[count]) {
                System.out.println("removed");
            } else {
                System.out.println(this.table[count]);
            }
        }
        System.out.println();
    }

    public boolean put(AddressData anAddressData) {
        // 格納対象のデータが null か調べる
        if (null == anAddressData) {
            // 格納対象のデータは null なので false を返し処理を抜ける
            return false;
        }
        // ハッシュ値を求める
        int hashCode = this.calculateHashCode(anAddressData.getName());
        // ハッシュ値の場所に挿入可能か調べる
        if (null == this.table[hashCode] ||
                this.removedData == this.table[hashCode]) {
            // ハッシュ値の場所に挿入可能なので挿入して true を返し
            // 処理を抜ける
            this.table[hashCode] = anAddressData;
            return true;
        }
        int limit = this.table.length - 1;
        String key = anAddressData.getName();
        for (int count = 0; count < limit; count++) {
            // 再ハッシュ値を求める
            hashCode = this.calculateHashCodeAgain(key, hashCode);
            // 再ハッシュ値の場所に挿入可能か調べる
            if (null == this.table[hashCode] ||
                    this.removedData == this.table[hashCode]) {
                // 再ハッシュ値の場所に挿入可能なので挿入して
                // true を返し処理を抜ける
                this.table[hashCode] = anAddressData;
                return true;
            }
        }
        return false;
    }

    public boolean remove(String aKey) {
        if (null == aKey) {
            throw new NullPointerException();
        }
        int hashCode = this.calculateHashCode(aKey);
        if (null == this.table[hashCode]) {
            return false;
        }
        if (this.removedData != this.table[hashCode]) {
            if (this.table[hashCode].getName().equals(aKey)) {
                this.table[hashCode] = removedData;
                return true;
            }
        }
        int limit = this.table.length - 1;
        for (int count = 0; count < limit; count++) {
            hashCode = this.calculateHashCodeAgain(aKey, hashCode);
            if (null == this.table[hashCode]) {
                return false;
            }
            if (this.removedData != this.table[hashCode]) {
                if (this.table[hashCode].getName().equals(aKey)) {
                    this.table[hashCode] = removedData;
                    return true;
                }
            }
        }
        return false;
    }

    private int calculateHashCode(String aKey) {
        if (null == aKey) {
            throw new NullPointerException();
        }
        int intKey = 0;
        for (int count = 0; count < aKey.length(); count++) {
            intKey += 0xffff & aKey.charAt(count);
        }
        return intKey % this.table.length;
    }

    private int calculateHashCodeAgain(String aKey, int aHashCode) {
        if (null == aKey) {
            throw new NullPointerException();
        }
        int intKey = 0;
        for (int count = 0; count < aKey.length(); count++) {
            intKey += 0xffff & aKey.charAt(count);
        }
        int rehashCode = (aHashCode + 3 - (intKey % 3)) %
                this.table.length;
        System.err.println("rehash: " + aKey + " " +
                aHashCode + " -> " + rehashCode);
        return rehashCode;
    }
}
