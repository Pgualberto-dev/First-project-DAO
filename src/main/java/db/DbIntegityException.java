package db;

public class DbIntegityException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public  DbIntegityException(String message) {
        super(message);
    }
}
