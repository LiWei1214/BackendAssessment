package titleAggregator;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class website {

    public static void main(String[] args) throws IOException {
        TitleScraper scraper = new TitleScraper();
        List<Headline> headlines = scraper.fetchTitles();

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String response = "<!DOCTYPE html><html><head><title>Headlines</title></head><body><h1>Article Headlines</h1><ul>";
                for (Headline headline : headlines) {
                    response += "<li><a href=\"" + headline.getLink() + "\" target=\"_blank\">" + headline.getTitle() + "</a> <span>" + headline.getDate() + "</span></li>";
                }
                response += "</ul></body></html>";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });
        server.setExecutor(null); 
        server.start();
        System.out.println("Server started on port 8000");
    }
}
