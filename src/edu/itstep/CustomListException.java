package edu.itstep;

public class CustomListException extends Exception {
    public CustomListException(String message) {
        super("Ошибка*  " + message);
    }
}
