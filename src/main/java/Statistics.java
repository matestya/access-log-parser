import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Statistics {

    private int totalVisits = 0;
    private int errorRequests = 0;

    private LocalDateTime firstTime = null;
    private LocalDateTime lastTime = null;

    private final Set<String> uniqueUserIps = new HashSet<>();

    public void addEntry(
            LocalDateTime time,
            int responseCode,
            String ip,
            UserAgent userAgent
    ) {

        if (firstTime == null || time.isBefore(firstTime)) {
            firstTime = time;
        }
        if (lastTime == null || time.isAfter(lastTime)) {
            lastTime = time;
        }

        if (!userAgent.isBot()) {
            totalVisits++;
            uniqueUserIps.add(ip);
        }

        if (responseCode >= 400 && responseCode < 600) {
            errorRequests++;
        }
    }

    private long getHoursPeriod() {
        if (firstTime == null || lastTime == null) {
            return 1;
        }
        long hours = java.time.Duration.between(firstTime, lastTime).toHours();
        return hours == 0 ? 1 : hours;
    }

    public double getAverageVisitsPerHour() {
        return (double) totalVisits / getHoursPeriod();
    }

    public double getAverageErrorRequestsPerHour() {
        return (double) errorRequests / getHoursPeriod();
    }

    public double getAverageVisitsPerUser() {
        if (uniqueUserIps.isEmpty()) {
            return 0;
        }
        return (double) totalVisits / uniqueUserIps.size();
    }
}

