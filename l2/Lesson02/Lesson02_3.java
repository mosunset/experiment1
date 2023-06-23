//-*- coding: utf-8 -*-
public class Lesson02_3 {
    public static void main(String args[]) {
        int n = new java.util.Random().nextInt(4); // ランダムな値を取得

        System.out.println("n = " + n); // nの値を出力

        // nの値に応じた処理を行う

        if(n == 0){
            System.out.println("Suenobu");
        }else if(n == 1){
            System.out.println("Kikawa");
        }else if(n == 2){
            System.out.println("Kubota");
        }else if(n == 3){
            System.out.println("Watanabe");
        }
    }
}
