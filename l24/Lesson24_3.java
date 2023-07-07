public class Lesson24_3 {
    public static void main(String[] args) {
        MyHashtable ht = new MyHashtable(10);

        ht.put(new AddressData("Isobe", "President", "Main Build.", "VIP room"));
        ht.put(new AddressData("Mendori", "Teacher", "Mendori Lab", "A307"));
        ht.put(new AddressData("Takeuchi", "Teacher", "Takeuchi Lab", "A501"));

        ht.put(new AddressData("Imamura", "M2", "Nakahara Lab", "A209"));
        ht.put(new AddressData("Kikawa", "M2", "Mendori Lab", "A307"));
        ht.put(new AddressData("Kubota", "M2", "Matsuzaki Lab", "A310"));
        ht.put(new AddressData("Tagashira", "M2", "Takeuchi Lab", "A501"));
        ht.put(new AddressData("Watanabe", "M2", "Matsuzaki Lab", "A310"));

        ht.put(new AddressData("Kobayashi", "M1", "Shigemasu Lab", "A306"));
        ht.put(new AddressData("Suenobu", "M1", "Shigemasu Lab", "A306"));
        ht.put(new AddressData("Nakayama", "M1", "Matsuzaki Lab", "A310"));

        System.out.println("------------ MyHashtable ------------");
        ht.printAll();

        ht.exists("Mendori");
        System.out.println();
        ht.exists("Isobe");
        System.out.println();
        ht.exists("KUTinfo");
        System.out.println();
        ht.exists(null);
    }
}
