import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Statistics statistics = new Statistics();

        statistics.addEntry("/index.html", 200, "Chrome");
        statistics.addEntry("/about.html", 404, "Firefox");
        statistics.addEntry("/contact.html", 404, "Chrome");
        statistics.addEntry("/products.html", 200, "Chrome");
        statistics.addEntry("/index.html", 200, "Safari");
        statistics.addEntry("/old-page.html", 404, "Firefox");

        Set<String> notFoundPages = statistics.getNotFoundPages();
        System.out.println("Not found pages (404):");
        for (String page : notFoundPages) {
            System.out.println(page);
        }

        System.out.println();

        Map<String, Double> browserStats = statistics.getBrowserStatistics();
        System.out.println("Browser statistics:");
        for (Map.Entry<String, Double> entry : browserStats.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

