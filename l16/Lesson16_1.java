public class Lesson16_1 {
    public static void main(String[] args) {
        StringArray ta = new StringArray(8);
        ta.initForLessons();
        ta.printAll();

        StringArray check = new StringArray(4);
        check.set("Imamura", 0);
        check.set("Mendori", 1);
        check.set("Tagashira", 2);
        String temp = "Kika";
        temp += "wa";
        check.set(temp, 3);
        System.out.println("========= Result =========");
        System.out.println("! Searched the Number !");
        for (int i = 0; i < check.length; i++) {
            if (ta.search(check.get(i)) != -1) {
                System.out.println(String.format(check.get(i) + " found!!"));
                System.out.println(String.format(check.get(i) +
                        " : Index Number is " + ta.search(check.get(i))));
            } else {
                System.out.println(String.format(check.get(i) + " not found..."));
                System.out.println(String.format(check.get(i) +
                        " : Index Number can not be found."));
            }
            if (i != check.length - 1)
                System.out.println();
        }
        System.out.println("==========================");
    }
}