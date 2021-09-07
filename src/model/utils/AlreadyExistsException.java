package model.utils;

public class AlreadyExistsException extends Exception {

    public AlreadyExistsException() {
        super("Item already exists on this execution.");
    }
}
