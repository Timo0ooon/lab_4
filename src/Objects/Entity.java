package Objects;

import Enums.*;
import Interfaces.Object_Visibility;
import Interfaces.Property;

import java.beans.Visibility;
import java.nio.file.attribute.GroupPrincipal;
import java.util.Objects;

public class Entity extends Obj implements Object_Visibility, Property {

    // Имя сущности
    private final String name;

    // Свойство сущности(прилагательное)
    private String obj_property;

    // Видимость сущности
    private Enums_visibility visibility;

    // Количество коротышек для сравнения
    private static int shorty_number;
    private static int shorty_number_1;

    // Количество людей в толпе(толпа друзей)
    private static int friend_group_number;
    private static int friend_group_number_waves_goodbye;
    private static  int friend_group_number_tosses;
    private static int friend_group_number_shouts;

    // Количество путешественников для сравнения
    private static int tourists_number;
    private static int tourists_number_feel;
    private static int tourists_number_feel_x2;
    private static int tourists_number_look_out;
    private static int tourists_number_see;
    private static  int tourists_number_waves_something;

    // Группа
    Group group = new Group();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(name.toLowerCase(), entity.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public Entity(String name, Grammatical_gender gender) {
        super(name, gender);
        this.name = name;

        if (name.toLowerCase().contains("коротышка"))
            shorty_number++;

        if (name.toLowerCase().contains("путешественник"))
            tourists_number++;

        if (name.toLowerCase().contains("друг"))
            friend_group_number++;

    }

    private static class Group {
        public boolean is_merge_entities_to_group(int number_1, int number_2) {
            return number_1 == number_2;
        }
    }



    public void do_something(Action action, Time time, Enums_visibility visibility, Verb_form form) {
        properties(visibility);

        // seem
        if (action == Action.discern && time == Time.past && this.visibility != null && form == Verb_form.negative) {
            shorty_number_1++;
            if (shorty_number == shorty_number_1 && this.visibility == Enums_visibility.not_visibility_x2)
                System.out.print(new_name(this.name.split(" ")[0]) + "ек" + " совсем нельзя было разглядеть");

            else if (shorty_number == shorty_number_1 && this.visibility == Enums_visibility.not_visibility)
                System.out.print(new_name(this.name.split(" ")[0]) + "ек" + " нельзя было разглядеть");
        }

    }

    public void do_something(Action action, Time time, String message) {
        if (action == Action.shout && time == Time.past) {
            friend_group_number_shouts++;
            if (group.is_merge_entities_to_group(friend_group_number, friend_group_number_shouts)) {
                System.out.print(
                        "Товарищи" + " кринкули: " + '"' + message + '"'
                );
            }
        }
    }

    public void do_something(Action action, Time time, Verb_form form) {
        set_plural_property_to_objects(this.obj_property);
        // feel
        if (action == Action.feel && time == Time.past && form == Verb_form.positively) {
            tourists_number_feel++;
            if (group.is_merge_entities_to_group(tourists_number, tourists_number_feel) && this.obj_property != null) {
                System.out.print(this.obj_property + " " + new_name(this.name.split(" ")[0]).toLowerCase() + "ики " + form.get_form() + "почувствовали");
            }
            else if (group.is_merge_entities_to_group(tourists_number, tourists_number_feel)) {
                System.out.print(new_name(this.name.split(" ")[0]) + "ики " + form.get_form() + "почувствовали");

            }

        }

        // feel_x2
        if (action == Action.feel_x2 && time == Time.past && form == Verb_form.negative) {
            tourists_number_feel_x2++;
            if (group.is_merge_entities_to_group(tourists_number, tourists_number_feel_x2) && this.obj_property != null) {
                System.out.print(this.obj_property + " " + new_name(this.name.split(" ")[0]).toLowerCase() + "ики " + "даже " + form.get_form() + "почувствовали");
            }
            else if (group.is_merge_entities_to_group(tourists_number, tourists_number_feel_x2)) {
                System.out.print(new_name(this.name.split(" ")[0]) + "ики " + "даже " + form.get_form() + "почувствовали");

            }
        }
    }

    public void do_something(Action action, Time verb_time, Entity[] entity_group, CoordinateEnum coordinate, Verb_form form) {
        // see
        if (action == Action.see && verb_time == Time.past && form == Verb_form.positively && coordinate == CoordinateEnum.Down) {
            tourists_number_see++;
            if (group.is_merge_entities_to_group(tourists_number, tourists_number_see) && entity_group.length >= 2) {
                System.out.print(
                        "они увидели внизу толпу друзей"
                );
            }
        }
    }

    public void do_something(Action action, Time verb_time, Entity[] other_group , Verb_form form) {
        if (action == Action.wave_goodbye && verb_time == Time.past && other_group.length >= 2) {
            friend_group_number_waves_goodbye++;
            if (group.is_merge_entities_to_group(friend_group_number, friend_group_number_waves_goodbye)) {
                System.out.print(
                        "они " + form.get_form() + "махали им на прощание"
                );
            }
        }
    }

    public void do_something(Action action, Time verb_time, Thing thing, Verb_form form, A_Adverbs adverb ) {
        if (action == Action.toss && verb_time == Time.past) {
            friend_group_number_tosses++;
            if (group.is_merge_entities_to_group(friend_group_number_tosses, friend_group_number)) {
                System.out.print(
                        "они " + form.get_form() + "подбрасывали " + adverb.get_property().toLowerCase()  + " " + new_name(thing.getName().toLowerCase().split(" ")[0]) + "ы"
                );
            }
        }
    }

    public void do_something(Action action, Time verb_time, Thing thing, Verb_form form) {
        //wave_something
        if (action == Action.wave_something && verb_time == Time.past) {
            tourists_number_waves_something++;
            if (group.is_merge_entities_to_group(tourists_number, tourists_number_waves_something)) {
                System.out.print(
                        "Они" + form.get_form() + " стали махать " + thing.getName().split(" ")[0].toLowerCase() + "ми"
                );
            }
        }
    }

    public void do_something(Action action, int time, Time verb_time, Verb_form form) {

        // look_out_from_basket
        if (action == Action.look_out && verb_time == Time.past && form == Verb_form.positively) {
            tourists_number_look_out++;
            if (group.is_merge_entities_to_group(tourists_number, tourists_number_look_out)) {
                System.out.print("Только через " + time + " мин. " + "они выглянули из корзины");

            }
        }
    }

    @Override
    public void properties(Enums_visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public void set_property_to_object(String property) {
        this.obj_property = property;
    }

    @Override
    public void set_plural_property_to_objects(String property) {

        String letters = "уеыаоэяиюй";
        String[] new_property = this.obj_property.split(" ");
        StringBuilder property_1 = new StringBuilder();

        for(int i = 0; i < new_property.length; i++) {
            while(letters.contains(new_property[i].charAt(new_property[i].length() - 1) + "")) {
                new_property[i] = new_property[i].substring(0, new_property[i].length() - 1);
            }
            new_property[i] = new_property[i] + "ые(-ие)";
        }

        for(int i = 0; i < new_property.length; i++) {
            if (i != new_property.length - 1)
                property_1.append(new_property[i]).append(" ");

            else
                property_1.append(new_property[i]);
        }

        this.obj_property = property_1 + "";

    }
}
