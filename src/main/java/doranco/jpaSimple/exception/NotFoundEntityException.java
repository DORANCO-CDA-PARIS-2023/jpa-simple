package doranco.jpaSimple.exception;

public class NotFoundEntityException extends Exception {

    public NotFoundEntityException() {
        super();
    }

    public NotFoundEntityException(String message) {
        super(message);
    }
}
