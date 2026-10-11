public abstract class MediathequeException extends Exception {

    public MediathequeException(String message) {
        super(message);
    }

    // Constructeur avec message et cause
    public MediathequeException(String message, Throwable cause) {
        super(message, cause);
    }
}