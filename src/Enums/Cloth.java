package Enums;

public enum Cloth {
    Cap("Шапка");

    private final String cloth;
    Cloth(String cloth) {
        this.cloth = cloth;
    }
    public String get_name_cloth() {
        return this.cloth;
    }
}
