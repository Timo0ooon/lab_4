package Enums;

public enum A_Adverbs {
    Smoothly("Плавно"),
    Up("Кверху"),
    From_below("Снизу"),
    Offended("Обиженно");


    private final String property;
    A_Adverbs(String property) {
        this.property = property;
    }

    public String get_property(){
        return this.property;
    }
}
