public class Lesson16_3{
    public static void main(String args[]){
        StringArray ta = new StringArray(8);
        ta.initForLessons();
        ta.printAll();

        System.out.println("======== Result =======");
        printReplaceNum(ta.replace("Mendori", "Takeuchi"));
        printReplaceNum(ta.replace("Nakayama", "Suenobu"));
        ta.printAll();
        System.out.println();
        String tmp = "Sueno";
        tmp += "bu";
        printReplaceNum(ta.replace(tmp, "Watanabe"));
        ta.printAll();
        System.out.println("========================");
    }

    public static void printReplaceNum(int num){
        if(num == 1){
            System.out.println("Replace " + num + " Element.");
        }else if(num >= 2){
            System.out.println("Replace " + num + " Elements.");
        }else{
            System.out.println("Couldn't find ...\n");
        }
    }
}