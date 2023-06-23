public class Lesson16_5{
    public static void main(String args[]){
        StringArray ta = new StringArray(8);
        ta.initForLessons();
        ta.printAll();

        System.out.println("========== Result ==========");
        ta.sort();
        ta.printAll();
        System.out.println("============================");
    } 
}