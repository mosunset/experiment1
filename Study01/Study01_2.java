import java.util.*;

public class Study01_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int oldnum = 0;
        int newnum = 0;

        top: while (true) {
            System.out.print("検索したい文字列を入力してください（終了時は入力なしで Enter）: ");
            String words = scan.nextLine();

            if (words.equals("")) {
                System.out.println("処理を終了します");
                break top;
            } else {

                int arlen = args.length;
                for (int a = 0; a < arlen; a++) {

                    String[] word = words.split("");

                    int wrlen = word.length;
                    for (int i = 0; i < wrlen; i++) {
                        int index = args[a].indexOf(word[i]); // 文字検索
                        System.out.println(word[i] + (index + 1));

                        if (i == 0) {

                            if (index == -1) {
                                break;
                            } else {

                                if (wrlen == 1) { // 検索文字が一文字のときに一致した場合
                                    System.out.println(args[a]);
                                } else { // 検索文字が二文字以上のときに一致した場合
                                    oldnum = index; // 初期位置保存->43
                                    newnum = index + 1;
                                }
                            }
                        } else {
                            if (newnum + 1 == index + 1) { // 一致した場所が前一致した場所の次の場合
                                newnum = index + 1;

                                if (newnum == oldnum + wrlen) { // 検索文字数+初期位置と検索された場所が同じ時
                                    System.out.println(args[a]);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
