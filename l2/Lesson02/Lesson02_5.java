//-*- coding: utf-8 -*-
public class Lesson02_5 {
    public static void main(String args[]) {
        System.out.print("自然数を入力してください : ");

        // 入力を受け付け、inputに格納（コマンドライン引数ではない）
        int input = Integer.parseInt(new java.util.Scanner(System.in).nextLine());

        // input以下の自然数をすべて出力する
        for (int i = 1; i <= input; i++) {
            System.out.println(i);
        }

    }
}
