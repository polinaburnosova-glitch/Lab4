public class TravelException extends Exception{
    private final String location;
    public TravelException(String message, String location) {
        super(message);
        this.location = location;
    }
    public TravelException(String message){
        this(message, "неизвестное место");
    }
    @Override
    public String getMessage() {
        return "Путешествие отменяется:" + super.getMessage() + "пункт назначения" + location;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TravelException that = (TravelException) obj;
        return java.util.Objects.equals(super.getMessage(), that.getMessage()) && java.util.Objects.equals(location, that.location);
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.getMessage(), location);
    }
    @Override
    public String toString() {
        return "main.java.TravelException{" + "message=" + getMessage() + ", location=" + location;
    }
}
