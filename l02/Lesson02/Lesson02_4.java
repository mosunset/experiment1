//-*- coding: utf-8 -*-
public class Lesson02_4 {
    public static void main(String args[]) {
        String name = args[0]; // 引数を取得

        // nameに応じた処理を追加する
        switch (name) {
            case "Kobayashi":
                System.out.println("Shigemasu lab");
                break;
            case "Imamura":
                System.out.println("Nakahara lab");
                break;
            case "Nakayama":
                System.out.println("Matsuzaki lab");
                break;
            case "Tagashira":
                System.out.println("Takeuchi lab");
                break;
            case "Kikawa":
                System.out.println("Mendori lab");
                break;
            
            default:
                System.out.println("No such data.");
        }
    }
}
