import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        Statistics statistics = new Statistics();

        statistics.addEntry(
                LocalDateTime.now().minusHours(3),
                200,
                "192.168.0.1",
                new UserAgent("Mozilla/5.0 Chrome")
        );

        statistics.addEntry(
                LocalDateTime.now().minusHours(2),
                404,
                "192.168.0.2",
                new UserAgent("Mozilla/5.0 Firefox")
        );

        statistics.addEntry(
                LocalDateTime.now().minusHours(1),
                500,
                "192.168.0.3",
                new UserAgent("Googlebot")
        );

        statistics.addEntry(
                LocalDateTime.now(),
                200,
                "192.168.0.1",
                new UserAgent("Mozilla/5.0 Chrome")
        );

        System.out.println("Average visits per hour: "
                + statistics.getAverageVisitsPerHour());

        System.out.println("Average error requests per hour: "
                + statistics.getAverageErrorRequestsPerHour());

        System.out.println("Average visits per user: "
                + statistics.getAverageVisitsPerUser());
    }
}
