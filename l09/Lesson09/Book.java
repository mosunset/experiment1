class Book {
    private String title;
    private String author;
    private int price;

    Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.count++;
    }

    private static int count;

    public static int getCount() {
        return count;
    }

    public void showBook() {
        System.out.println("----------");
        System.out.println("タイトル: " + this.title);
        System.out.println("著者: " + this.author);
        System.out.println("価格: " + this.price);
        System.out.println("----------");
    }
}
