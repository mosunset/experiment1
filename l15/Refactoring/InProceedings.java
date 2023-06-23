// 会議論文のデータ
public class InProceedings {
    String authors;
    String title;
    String conference;
    int startpage;
    int endpage;
    int year;

    public InProceedings(String authors, String title, String conference,
            int startpage, int endpage, int year) {
        this.authors = authors;
        this.title = title;
        this.conference = conference;
        this.startpage = startpage;
        this.endpage = endpage;
        this.year = year;
    }
}
