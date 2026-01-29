import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        Statistics statistics = new Statistics();

        statistics.addEntry(
                LocalDateTime.now().withSecond(10), "192.168.0.1",
                new UserAgent("Mozilla/5.0 Chrome"),
                "https://nova-news.ru/wp-login.php");

        statistics.addEntry(
                LocalDateTime.now().withSecond(10),
                "192.168.0.2",
                new UserAgent("Mozilla/5.0 Firefox"),
                "https://google.com/search");

        statistics.addEntry(
                LocalDateTime.now().withSecond(10),
                "192.168.0.1",
                new UserAgent("Mozilla/5.0 Chrome"),
                "https://nova-news.ru/news");

        statistics.addEntry(
                LocalDateTime.now().withSecond(20),
                "192.168.0.3",
                new UserAgent("GoogleBot"),
                "https://yandex.ru");

        System.out.println("Peak visits per second: " + statistics.getPeakVisitsPerSecond());

        System.out.println("Referer domains: " + statistics.getRefererDomains());

        System.out.println("Max visits per user: " + statistics.getMaxVisitsPerUser());
    }
}