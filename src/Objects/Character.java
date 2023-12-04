package Objects;

import Enums.*;
import Exceptions.Empty_message;
import Exceptions.Impossible_action;


public class Character extends Obj {
    protected Cloth_on_human cloth;
    static private int character_number;
    static private int character_number_laughs;
    public Character(String name, Grammatical_gender gender, Cloth cloth) {
        super(name, gender);
        this.cloth = new Cloth_on_human(cloth);
        character_number++;
    }

    public Character(String name, Grammatical_gender gender) {
        super(name, gender);
    }

    public void do_something(Action action, Action action_1, Time time, Verb_form form) throws Impossible_action {
        throw new Impossible_action(" Не возможно выполнить 2 действия!");
    };

    public void do_something(Action action, String message, Time time, Verb_form form) {

        try {
            if (message == null) {
                throw new Empty_message(super.name + " проигнорировал" + super.gender.get_ending());
            } else if (message.isEmpty()) {
                throw new Empty_message(super.name + " промолчал" + super.gender.get_ending());
            } else if (action == Action.shout && time == Time.past) {
                System.out.print('"' + message + '"' + " - " + form.get_form() + "крикнул" + super.gender.get_ending() + " " + super.name);
            } else if (action == Action.grumble && time == Time.past) {
                System.out.print('"' + message + '"' + " - " + form.get_form() + "проворчал" + super.gender.get_ending() + " " + super.name);
            } else if (action == Action.say && time == Time.past) {
                System.out.print('"' + message + '"' + " - " + form.get_form() + "сказал" + super.gender.get_ending() + " " + super.name);
            } else if (action == Action.shout_x2 && time == Time.past) {
                System.out.print('"' + message + '"' + " - " + form.get_form() + "закричал" + super.gender.get_ending() + " " + super.name);
            } else if (action == Action.take_offense && time == Time.past) {
                System.out.print('"' + message + '"' + " - " + form.get_form() + "обиделся" + super.gender.get_ending() + " " + super.name);
            } else if (action == Action.ask && time == Time.past) {
                System.out.print('"' + message + '"' + " - " + form.get_form() + " спросил" + super.gender.get_ending()  + " " + super.name);
            }
        }
        catch (Empty_message e) {
            System.out.print(e.get_message());
        }
    }

    public void do_something(Action action, Thing thing, String something, Time time, Verb_form form) {
        if (action == Action.get_something_from_somewhere && something != null && thing.getName() != null && time == Time.past) {
            System.out.print(
                    super.name + form.get_form() + " достал из " + something + "а " + thing.getName().toLowerCase()
            );
        }
    }

    public void do_something(Action action, Time time, Verb_form form, String something) {
        if (action == Action.start_define_something && time == Time.past && something != null) {
            System.out.print(
                    "он" + form.get_form() + " начал определять " + something
            );
        }
    }

    public void do_something(Action action, String message, Time time, Verb_form form, A_Adverbs adverb) {
        if (action == Action.ask && adverb != null && time == Time.past) {
            System.out.print('"' + message + '"' + " - " + form.get_form() + " " + adverb.get_property().toLowerCase()  + " спросил " + super.name);
        }

    }

    public void do_something(Action action, Thing thing, Time time, Verb_form form) {
        if (action == Action.forget && time == Time.past) {
            System.out.print(super.name + form.get_form() + " забыл " + new_name(thing.getName().toLowerCase()) + "ку");
        }
    }

    public void do_something(Action action, Time time, Verb_form form) {
        if (action == Action.laugh && time == Time.past) {
            character_number_laughs++;
            if (character_number_laughs == character_number) {
                System.out.print("Все" + form.get_form() + " засмеялись");
            }
        }
    }

    protected class Cloth_on_human {
        private Cloth cloth;
        public Cloth_on_human(Cloth cloth) {
            this.cloth = cloth;

        }

        public String is_lost(Time time, Verb_form form) {
            if (time == Time.past && cloth != null) {
                return this.cloth.get_name_cloth().toLowerCase() + " " + form.get_form() + " потеряна";
            }
            return ""; // Здесь будет обшибка
        }
    }
}
