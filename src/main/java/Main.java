import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Statistics statistics = new Statistics();

        statistics.addEntry("/index.html", 200, "Windows");
        statistics.addEntry("/about.html", 200, "Linux");
        statistics.addEntry("/index.html", 200, "Windows");
        statistics.addEntry("/contact.html", 404, "MacOS");
        statistics.addEntry("/products.html", 200, "Windows");
        statistics.addEntry("/about.html", 200, "Linux");

        Set<String> pages = statistics.getAllPages();
        System.out.println("Pages:");
        for (String page : pages) {
            System.out.println(page);
        }

        System.out.println();

        Map<String, Double> osStats = statistics.getOsStatistics();
        System.out.println("OS statistics:");
        for (Map.Entry<String, Double> entry : osStats.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
