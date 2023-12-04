package Enums;

public enum Verb_form {
    negative("не "),
    positively("");

    private final String message;

    Verb_form(String message) {
        this.message = message;
    }

    public String get_form() {
        return this.message;
    }
}
