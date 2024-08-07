package titleAggregator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TitleScraper {

    public List<Headline> fetchTitles() {
        List<Headline> headlines = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://www.theverge.com/").get();
            for (Element element : doc.select("h2.c-entry-box--compact__title")) {
                String title = element.text();
                String link = element.select("a").attr("href");
                String date = "";
                headlines.add(new Headline(title, link, date));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return headlines;
    }
}
