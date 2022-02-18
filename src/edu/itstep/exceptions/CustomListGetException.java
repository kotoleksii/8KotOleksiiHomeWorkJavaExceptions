package edu.itstep.exceptions;

public class CustomListGetException extends Exception {
    public CustomListGetException() {
        super("Ошибка! Такого єлемента не существует");
    }
}
