package edu.itstep;

public class CustomListException extends Exception {
    public CustomListException(String message) {
        super("Ошибка*  " + message);
    }

    public CustomListException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomListException(Throwable cause) {
        super(cause);
    }

    public CustomListException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CustomListException() {
    }
}
