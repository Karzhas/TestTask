package skytec.games.model;

// в проде лучше это не использовать)) only for testing purposes
public class ResponseEntity<T> {
    private T value;
    private Exception exception;
    private String msg;

    public ResponseEntity(String msg) {
        this.msg = msg;
    }

    public ResponseEntity(Exception exception) {
        this.exception = exception;
    }

    public ResponseEntity(T value, Exception exception) {
        this.value = value;
        this.exception = exception;
    }

    public ResponseEntity(T value) {
        this.value = value;
    }

    public ResponseEntity() {

    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "value=" + value +
                ", exception=" + exception +
                '}';
    }
}
