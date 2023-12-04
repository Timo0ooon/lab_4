package Enums;


public enum Grammatical_gender {
    masculine_gender(""),  // мужской род
    feminine_gender("а"),  // женский род
    neuter_gender("о"), // средний род
    no_gender("и"); // множественное число объектов

    private final String ending;

    Grammatical_gender(String ending) {
        this.ending = ending;
    }

    public String get_ending() {
        return this.ending;
    }
}
