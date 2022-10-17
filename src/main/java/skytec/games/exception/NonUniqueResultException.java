package skytec.games.exception;

public class NonUniqueResultException extends RuntimeException{
    public NonUniqueResultException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonUniqueResultException(String message) {
        super(message);
    }
}
