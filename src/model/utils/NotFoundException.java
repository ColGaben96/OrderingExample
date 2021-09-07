package model.utils;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("Item can't be found. Probably won't exist");
    }
}
