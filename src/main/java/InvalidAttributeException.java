public class InvalidAttributeException extends RuntimeException {
    public InvalidAttributeException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return "Некорректное значение: " + super.getMessage();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InvalidAttributeException that = (InvalidAttributeException) obj;
        return java.util.Objects.equals(super.getMessage(), that.getMessage());
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.getMessage());
    }
    @Override
    public String toString() {
        return "InvalidCharacterException" + "message=" + getMessage();
    }
}
