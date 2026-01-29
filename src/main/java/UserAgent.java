public class UserAgent {

    private final String value;

    public UserAgent(String value) {
        this.value = value.toLowerCase();
    }

    public boolean isBot() {
        return value.contains("bot");
    }
}
