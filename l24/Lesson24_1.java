public class Lesson24_1 {
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

        System.out.println("Number of added elements: 11");
        System.out.println("Number of elements in the hashtable: " + ht.getElementNum());
        System.out.println();

        ht.clear();

        System.out.println("------------ MyHashtable ------------");
        ht.printAll();

        System.out.println("Number of elements in the hashtable: " + ht.getElementNum());
    }
}
