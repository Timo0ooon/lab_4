package Objects;

import Enums.Action;
import Enums.*;
import Interfaces.Coordinate;
import Interfaces.Object_Visibility;


public class Thing extends Obj implements Coordinate, Object_Visibility {
    private final String name;
    private String coordinate;
    private CoordinateEnum coordinate_1;
    private String visibility;
    String action_property;
    private Enums_visibility visibility_1;

    // Количество домов
    private static int home_number;
    private static int home_number_1;

    // Количество криков
    private static int scream_number;
    private static int scream_number_comes;

    @Override
    public String toString() {
        return this.name;
    }

    public Thing(String name, Grammatical_gender gender) {
        super(name, gender);
        this.name = name;
        if (this.name.toLowerCase().contains("дом"))
            home_number++;
        if (this.name.toLowerCase().contains("крик"))
            scream_number++;
    }

    public void do_something(Action action, Time time, CoordinateEnum coordinate) {
        setCoordinate(coordinate);
        //действие двигаться
        if (action == Action.move && time == Time.past && this.coordinate != null) {
            if(this.coordinate_1 == CoordinateEnum.Up_x2 || this.coordinate_1 == CoordinateEnum.Up || this.coordinate_1 == CoordinateEnum.special_phrase) {
                System.out.print(this.name + " поднялся " + this.coordinate);
            }
            else if(this.coordinate_1 == CoordinateEnum.Down_x2 || this.coordinate_1 == CoordinateEnum.Down) {
                System.out.print(this.name + " опустился " + this.coordinate);
            }
            else {
                System.out.println(this.name + " улетел " + this.coordinate);
            }
        }

        // действие быть видным в пр. времени с координатами
        if(action == Action.be_seen && time == Time.past && this.coordinate_1 != null) {
            if (this.gender == Grammatical_gender.masculine_gender) {
                System.out.print(this.name + " виднелся " + this.coordinate);
            }
            else if (this.gender == Grammatical_gender.feminine_gender) {
                System.out.print(this.name + " виднелась " + this.coordinate);
            }
        }
    }

    public void do_something(Action action, Time time, Verb_form form) {
        if (action == Action.fly && time == Time.past) {
            System.out.print(
                    super.name.toLowerCase() + " " + form.get_form() + "летел"
            );
        }
    }

    public void do_something(Action action, Time time) {
        //действие уносить ветром
        if(action == Action.blow_away && time == Time.past) {
            System.out.print(this.name + " уносило ветром");

        }
    }

    public void do_something(Action action, Time time, A_Adverbs adverb, Verb_form form) {
        if (action == Action.to_come_sounds && time == Time.past) {
            scream_number_comes++;
            if (scream_number_comes == scream_number) {
                System.out.print(
                        adverb.get_property() + " " + form.get_form() + "доносились " + this.name.split(" ")[0].toLowerCase() + "и"
                );
            }
        }

    }

    public void do_something(Action action, Time time, A_Adverbs action_property, Thing something) {
        if (action == Action.secede && time == Time.past && action_property != null && this.gender == Grammatical_gender.masculine_gender) {
            System.out.print(action_property.get_property().toLowerCase() + " он отделился от " + new_name(something.name).toLowerCase() + "и");
        }
    }

    public void do_something(Action action, Time time, Enums_visibility visibility) {
        properties(visibility);

        // действие казаться, для домов в пр. времени
        if(action == Action.seem && time == Time.past && this.name.toLowerCase().contains("дом")) {
            home_number_1++;
            if(home_number_1 == home_number && this.visibility != null) {
                System.out.print(new_name(this.name.split(" ")[0]) + "а" + " казались " + this.visibility + "ыми");
            }
        }

        // действие быть видным в пр. времени с видимостью
        if(action == Action.be_seen && time == Time.past && this.visibility != null) {
            if (this.gender == Grammatical_gender.masculine_gender) {
                if(this.visibility_1 == Enums_visibility.fraze_tiny_1)
                    System.out.print(this.name + " был виден " + this.visibility);
                else
                    System.out.print(this.name + " был виден " + this.visibility + "им(ым)");
            }
            else if (this.gender == Grammatical_gender.feminine_gender) {
                if(this.visibility_1 == Enums_visibility.fraze_tiny_1)
                    System.out.print(this.name + " была видна" + this.visibility);
                else
                    System.out.print(this.name + " была видна" + this.visibility + "ой");
            }
        }
    }



    @Override
    public void setCoordinate(CoordinateEnum coordinate) {
        this.coordinate_1 = coordinate;
        switch (coordinate) {
            case Up -> this.coordinate = "высоко";
            case Up_x2 -> this.coordinate = "еще выше";
            case Down -> this.coordinate = "вниз";
            case Down_x2 -> this.coordinate = "еще ниже";
            case North -> this.coordinate = "севернее";
            case North_x2 -> this.coordinate = "еще севернее";
            case South -> this.coordinate = "южнее";
            case South_x2 -> this.coordinate = "еще южнее";
            case West -> this.coordinate = "западнее";
            case West_x2 -> this.coordinate = "еще западнее";
            case East -> this.coordinate = "восточнее";
            case East_x2 -> this.coordinate = "еще восточнее";
            case behind -> this.coordinate = "позади";
            case behind_x2 -> this.coordinate = "далеко позади";
            case ahead -> this.coordinate = "впереди";
            case right -> this.coordinate = "справа";
            case left -> this.coordinate = "слева";
            case special_phrase -> this.coordinate = "в воздух";
        }
    }

    @Override
    public void properties(Enums_visibility visibility) {
        this.visibility_1 = visibility;
        switch (visibility) {
            case big -> this.visibility = "больш";
            case small -> this.visibility = "маленьк";
            case giant -> this.visibility = "гиганстк";
            case tiny -> this.visibility = "крошечн";
            case e_visibility -> this.visibility = "видим";
            case not_visibility -> this.visibility = "невидим";
            case fraze_tiny_1 -> this.visibility = "как на ладони";
        }
    }
}
