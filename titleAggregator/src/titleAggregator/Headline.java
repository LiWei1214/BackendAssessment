package titleAggregator;

public class Headline {
    private String title;
    private String link;
    private String date;

    public Headline(String title, String link, String date) {
        this.title = title;
        this.link = link;
        this.date = date;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
