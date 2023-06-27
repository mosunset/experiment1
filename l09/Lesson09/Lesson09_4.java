public class Lesson09_4 {
    public static void main(String[] args) {
        Book book1 = new Book("スッキリわかるJava 入門", "中山清喬", 3500);
        // Add here - 1冊目の表示
        book1.showBook();

        Book book2 = new Book("入門bash", "キャメロン・ニューハム", 3000);
        // Add here - 2冊目の表示 & インスタンス数の出力
        book2.showBook();
        System.out.println("このプログラムはBookクラスから" + Book.getCount() + "つのインスタンスを生成しました。");
        
        Book book3 = new Book("詳解シェルスクリプト", "ネルソン・H.f.ベーブ", 3200);
        // Add here - 3冊目の表示 & インスタンス数の出力
        book3.showBook();
        System.out.println("このプログラムはBookクラスから" + Book.getCount() + "つのインスタンスを生成しました。");

    }
}
