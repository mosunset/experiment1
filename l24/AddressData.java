public class AddressData {
    // フィールド
    private String name;
    private String metropolice;
    private String city;
    private String zipcode;

    // コンストラクタ
    private AddressData() {
    }

    public AddressData(String aName, String aMetropolice,
            String aCity, String aZipcode) {
        // 格納するデータに null が含まれているか調べる
        if (null == aName || null == aMetropolice ||
                null == aCity || null == aZipcode) {
            throw new NullPointerException(); // 例外をスロー
        }
        this.name = aName;
        this.metropolice = aMetropolice;
        this.city = aCity;
        this.zipcode = aZipcode;
    }

    // メソッド
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.metropolice + ", " + this.city + ", "
                + this.zipcode;
    }

    public String toString() {
        return this.name + ": " + this.metropolice + ", "
                + this.city + ", " + this.zipcode;
    }

}
