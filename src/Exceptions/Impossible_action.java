package Exceptions;

public class Impossible_action extends NoSuchMethodException{
    private final String message;
    public Impossible_action(String message) {
        this.message = message;

    }

    public String get_message() {
        return this.message;
    }
}
