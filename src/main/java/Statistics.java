import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Statistics {

    private final Map<Integer, Integer> visitsPerSecond = new HashMap<>();

    private final Set<String> refererDomains = new HashSet<>();

    private final Map<String, Integer> visitsPerUser = new HashMap<>();

    public void addEntry(
            LocalDateTime time,
            String ip,
            UserAgent userAgent,
            String referer
    ) {

        if (!userAgent.isBot()) {

            int second = time.getSecond();
            visitsPerSecond.put(
                    second,
                    visitsPerSecond.getOrDefault(second, 0) + 1
            );

            visitsPerUser.put(
                    ip,
                    visitsPerUser.getOrDefault(ip, 0) + 1
            );
        }

        if (referer != null && !referer.isEmpty()) {
            try {
                URI uri = URI.create(referer);
                if (uri.getHost() != null) {
                    refererDomains.add(uri.getHost());
                }
            } catch (Exception ignored) {
            }
        }
    }

    public int getPeakVisitsPerSecond() {
        int max = 0;
        for (int count : visitsPerSecond.values()) {
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public Set<String> getRefererDomains() {
        return refererDomains;
    }

    public int getMaxVisitsPerUser() {
        int max = 0;
        for (int count : visitsPerUser.values()) {
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
