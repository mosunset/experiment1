public class Lesson16_4{
    public static void main(String args[]){
        StringArray ta = new StringArray(8);
        ta.initForLessons();
        ta.printAll();

        System.out.println("========== Result ==========");
        System.out.println("-- M2 --");
        StringArray m2 = ta.trimming(0,4);
        printStringArray(m2);
        System.out.println("-- M1 --");
        StringArray m1 = ta.trimming(5,7);
        printStringArray(m1);
        System.out.println("-- Kubota --");
        StringArray watanabe = ta.trimming(2, 2);
        printStringArray(watanabe);
        System.out.println("-- Error1(is in range) --");
        StringArray error1 = ta.trimming(3,9);
        printStringArray(error1);
        System.out.println("-- Error2(from > to) --");
        StringArray error2 = ta.trimming(6,2);
        printStringArray(error2);
        System.out.println("============================");
    }

    public static void printStringArray(StringArray sa) {
        if (sa == null) {
            System.out.println("StringArray is Null.");
            return;
            }
        sa.printAll();
    }
}