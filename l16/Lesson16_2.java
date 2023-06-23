public class Lesson16_2{
    public static void main(String[] args){
        StringArray ta = new StringArray(8);
        ta.initForLessons();
        ta.printAll();

        System.out.println("========== Result1 ==========");
        System.out.println("! Exchange the StringArray !");
        System.out.println();
        ta.exchange(0,1);
        ta.exchange(1,5);
        ta.exchange(2,4);
        ta.exchange(3,6);
        ta.printAll();
        System.out.println("============================");

        ta.initForLessons();
        System.out.println();
        System.out.println("========== Result2 ==========");
        System.out.println("! Exchange the StringArray !");
        System.out.println();
        ta.exchange(-1,3);
        ta.printAll();
        System.out.println("============================");
    }
}