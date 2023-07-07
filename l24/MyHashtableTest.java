public class MyHashtableTest {
    public static void main(String[] args) {
        MyHashtable ht = new MyHashtable(11);
        ht.put(new AddressData("Takatsu", "Swalloes", "Jinguu", "Asia"));
        ht.put(new AddressData("Yano", "Tigers", "Koushien", "Tohoku"));
        ht.put(new AddressData("Hara", "Giants", "Tokyo", "Tokai"));
        ht.put(new AddressData("Sasaoka", "Carp", "Hiroshima", "Yamero"));
        ht.put(new AddressData("Tatsunami", "Dragons", "Nagoya", "PL"));
        ht.put(new AddressData("Miura", "Baystars", "Yokohama", "Nara"));
        ht.printAll();
        ht.put(new AddressData("Nakajima", "Buffaloes", "Ossaka", "Akita"));
        ht.put(new AddressData("Iguchi", "Marines", "Chiba", "Aoyama"));
        ht.put(new AddressData("Ishii", "Eagles", "Sendai", "Chiba"));
        ht.put(new AddressData("Fujimoto", "Hawks", "Fukuoka", "Nara"));
        ht.put(new AddressData("BigBoss", "Fighters", "Hokkaido", "NewYork"));
        ht.put(new AddressData("Tsuji", "Lions", "Tokorozawa", "Saga"));
        ht.printAll();
        System.out.println(ht.get("Hara"));
        ht.remove("Sasaoka");
        ht.remove("Nomura");
        ht.printAll();
    }
}
