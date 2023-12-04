package Objects;

import Enums.Action;
import Enums.Grammatical_gender;
import Enums.Time;
import Enums.Verb_form;

public abstract class Obj {
    protected final String name;
    protected final Grammatical_gender gender;
    public Obj(String name, Grammatical_gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    protected String new_name(String name) {
        String letters = "уеыаоэяиюк";
        while(letters.contains(name.charAt(name.length() - 1) + "")) {
            name = name.substring(0, name.length() - 1);
        }
        return name;
    }

}
