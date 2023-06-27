public class Lesson05_4 {
    public static void main(String[] args) {
        switch (args[0]) {
            // Add here==========================
            case "1":
                System.out.println("一");
                break;
            case "2":
                System.out.println("二");
                break;
            case "3":
                System.out.println("三");
                break;
            case "4":
                System.out.println("四");
                break;
            case "5":
                System.out.println("五");
                break;
            default:
                System.out.println("無効な入力です. 1から5のいずれかを入力してください");
                break;
            // =========================================
        }
    }
}
