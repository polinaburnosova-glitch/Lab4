import java.util.Objects;
public class TravelException extends Exception {
    private final String location;

    public TravelException(String message, String location) {
        super(message);
        if (location == null) {
            this.location = "неизвестное место";
        } else {
            this.location = location;
        }
    }

    public TravelException(String message) {
        this(message, null);
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Путешествие отменяется: " + getMessage() + ", пункт назначения: " + location;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TravelException that = (TravelException) obj;
        return java.util.Objects.equals(getMessage(), that.getMessage()) &&
                java.util.Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getMessage(), location);
    }
}
