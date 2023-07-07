public class MyHashtable {
    // フィールド
    private AddressData[] table;

    // コンストラクタ
    private MyHashtable() {
    }

    public MyHashtable(int aMaxSize) {
        this.table = new AddressData[aMaxSize];
    }

    public AddressData get(String aKey) {
        if (null == aKey) {
            throw new NullPointerException(); // 鍵がnull
        }
        // ハッシュ値を計算してデータを取得する
        return this.table[this.calculateHashCode(aKey)];
    }

    public boolean put(AddressData anAddressData) {
        if (null == anAddressData) {
            return false; // データがnull
        }
        if (this.table[this.calculateHashCode(anAddressData.getName())] == null) {
            elementNum++;
        } else {
            collision++;
        }
        this.table[this.calculateHashCode(anAddressData.getName())] = anAddressData;
        return true;
    }

    public void printAll() {
        // テーブルの内容を順番に全て表示
        for (int count = 0; count < this.table.length; count++) {
            System.out.println(count + "\t" + this.table[count]);
        }
        System.out.println();
    }

    public boolean remove(String aKey) {
        if (null == aKey) {
            return false;
        }
        if (this.table[this.calculateHashCode(aKey)] != null) {
            elementNum--;
        }
        this.table[this.calculateHashCode(aKey)] = null;
        return true;
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
            intKey += 0xffff & aKey.charAt(count);
        }
        // 合計値からハッシュ値を求める
        return intKey % this.table.length;
    }

    // lesson24_1
    private int elementNum;

    public int getElementNum() {
        return elementNum;
    }

    public void clear() {
        for (int i = 0; i < this.table.length; i++) {
            this.table[i] = null;
        }
        elementNum = 0;
    }

    // lesson24_2
    private int collision;

    public int getCollision() {
        return collision;
    }

    // lesson24_3
    public void exists(String aKey) {
        if (aKey == null) {
            System.out.println("Key is null.");
        } else if (get(aKey) == null) {
            System.out.println(aKey + "\tdoes not exist.");
        } else if (get(aKey).getName().equals(aKey)) {
            System.out.println(aKey + "\texist.");
            System.out.println(get(aKey));
        } else {
            System.out.println(aKey + "\tdoes not exist.");
        }
    }
}
