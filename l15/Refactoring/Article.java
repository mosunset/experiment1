// 雑誌論文のデータ
public class Article {
    String authors;
    String title;
    String journal;
    int volume;
    int number;
    int startpage;
    int endpage;
    int year;

    public Article(String authors, String title, String journal,
            int volume, int startpage, int endpage, int year) {
        this.authors = authors;
        this.title = title;
        this.journal = journal;
        this.volume = volume;
        this.number = -1;
        this.startpage = startpage;
        this.endpage = endpage;
        this.year = year;
    }

    public Article(String authors, String title, String journal,
            int volume, int number, int startpage, int endpage, int year) {
        this(authors, title, journal, volume, startpage, endpage, year);
        this.number = number;
    }
}
