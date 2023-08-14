public class IllegalTriangleException extends Throwable {

    String message;

    public IllegalTriangleException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
