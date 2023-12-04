package Exceptions;

public class Empty_message extends RuntimeException{
    private final String message;
    public Empty_message(String message) {
        this.message = message;
    }
    public String get_message() {
        return this.message;
    }
}
