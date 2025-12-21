public class InvalidCharacterAttributeException extends RuntimeException {
    public InvalidCharacterAttributeException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return "Некорректное хначение: " + super.getMessage();
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InvalidCharacterAttributeException that = (InvalidCharacterAttributeException) obj;
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
