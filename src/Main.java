import Exceptions.Impossible_action;
import Objects.*;
import Enums.*;
import Objects.Character;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        // Воздушный шар
        Thing balloon = new Thing("Воздушный шар", Grammatical_gender.masculine_gender);

        // Цветочный город
        Thing flower_city = new Thing("Цветочный город", Grammatical_gender.masculine_gender);

        // Компас
        Thing compass = new Thing("Компас", Grammatical_gender.masculine_gender);

        // Земля
        Thing earth = new Thing("Земля", Grammatical_gender.feminine_gender);

        // Шапка
        Thing cap = new Thing("Шапка", Grammatical_gender.masculine_gender) {
             
        };

        // Герои
        Character Znayka = new Character("Знайка", Grammatical_gender.masculine_gender);
        Character Confused = new Character("Растеряйка", Grammatical_gender.masculine_gender, Cloth.Cap) {
            @Override
            public void do_something(Action action, Action action_1, Time time,Verb_form form) {
                if (action == Action.understand_that && action_1 == Action.lose) {
                    if (time == Time.past) {
                        System.out.print(
                                name + " понял, что " + cloth.is_lost(Time.past, form)
                        );
                    }
                }
            }
        };

        Character Grumpy = new Character("Ворчун", Grammatical_gender.masculine_gender);
        Character Donut = new Character("Пончик", Grammatical_gender.masculine_gender);
        Character Dunno = new Character("Незнайка", Grammatical_gender.masculine_gender);

        // группа героев
        Character[] characters_group = new Character[] {
                Donut,
                Dunno,
                Confused,
                Znayka,
                Grumpy
        };

        // Толпа друзей
        int group_number = 100;
        Entity[] friend_group = new Entity[group_number];

        for (int i = 1; i < friend_group.length + 1; i++) {
            friend_group[i - 1] = new Entity("Друг " + i, Grammatical_gender.masculine_gender);
        }

        // Дома
        int houses_number = 100;
        Thing[] houses = new Thing[houses_number];

        for(int i = 1; i < houses_number + 1; i++) {
            houses[i - 1] = new Thing("Дом " + i, Grammatical_gender.masculine_gender);
        }

        // Шляпы
        int hat_number = 100;
        Thing[] hats = new Thing[hat_number];

        for(int i = 1; i < hat_number + 1; i++) {
            hats[i - 1] = new Thing("Шляпа " + i, Grammatical_gender.masculine_gender);
        }

        // Город(цветочный)
        Thing city = new Thing("Город", Grammatical_gender.masculine_gender);

        // Коротышки
        int shorties_number = 100;
        Entity[] shorties = new Entity[shorties_number];

        for(int i = 1; i < shorties_number + 1; i++) {
            shorties[i - 1] = new Entity("Коротышка " + i, Grammatical_gender.feminine_gender);
        }

        // Путешественники
        int tourists_number = 100;
        Entity[] tourists = new Entity[tourists_number];

        for(int i = 1; i < tourists_number + 1; i++) {
            tourists[i - 1] = new Entity("Путешественник " + i, Grammatical_gender.masculine_gender);
            tourists[i - 1].set_property_to_object("Отважный");
        }

        // Крик
        int scream_number = 100;
        Thing[] screams = new Thing[scream_number];

        for(int i = 1; i < screams.length + 1; i++) {
            screams[i - 1] = new Thing("Крик " + i, Grammatical_gender.masculine_gender);
        }


        // История
        class Story {
            void makeStory() {
                for(int i = 0; i < tourists_number; i++) {
                    tourists[i].do_something(Action.feel_x2, Time.past, Verb_form.negative);
                }

                System.out.print(", как ");
                balloon.do_something(Action.move, Time.past, CoordinateEnum.special_phrase);

                System.out.print(", настолько ");
                balloon.do_something(Action.secede, Time.past, A_Adverbs.Smoothly, earth);
                System.out.println(".");

                for (Entity tourist : tourists) {
                    tourist.do_something(Action.look_out, 1, Time.past, Verb_form.positively);
                }
                System.out.print(" и ");

                for(Entity tourist: tourists) {
                    tourist.do_something(Action.see, Time.past, friend_group, CoordinateEnum.Down, Verb_form.positively);
                }
                System.out.print(", ");

                for(Entity friend: friend_group) {
                    friend.do_something(Action.wave_goodbye, Time.past, tourists, Verb_form.positively);
                }
                System.out.print(" и ");

                for(int i = 0; i < friend_group.length; i++) {
                    friend_group[i].do_something(Action.toss, Time.past, hats[i], Verb_form.positively, A_Adverbs.Up);
                }
                System.out.println(".");

                for (Thing scream : screams) {
                    scream.do_something(Action.to_come_sounds, Time.past, A_Adverbs.From_below, Verb_form.positively);
                }
                System.out.println(".");

                System.out.print("-");
                for (Entity friend: friend_group) {
                    friend.do_something(Action.shout, Time.past, "До свиданья!");
                }
                System.out.println();

                for(int i = 0; i < tourists.length; i++) {
                    tourists[i].do_something(Action.wave_something, Time.past, hats[i], Verb_form.positively);
                }
                System.out.print(". ");


                try {
                    Confused.do_something(Action.understand_that, Action.lose, Time.past, Verb_form.positively);
                } catch (Impossible_action e) {
                    System.out.print(e.get_message());
                }
                System.out.println(".");

                Confused.do_something(Action.shout, "Стойте, братцы! Остановите шар!", Time.past, Verb_form.positively);
                System.out.print(". ");

                Confused.do_something(Action.forget, cap, Time.past, Verb_form.positively);
                System.out.println(".");

                Grumpy.do_something(Action.grumble, "Вечно ты что-нибудь забываешь!", Time.past, Verb_form.positively);
                System.out.println(".");

                Znayka.do_something(Action.say, "Теперь уже нельзя остановить шар. Он будет летать, пока в нем не остынет воздух, и только тогда опустится вниз.", Time.past, Verb_form.positively);
                System.out.println(".");

                Confused.do_something(Action.ask, "Что же, я без шапки должен лететь?", Time.past, Verb_form.positively, A_Adverbs.Offended);
                System.out.println(".");

                Donut.do_something(Action.say, "Ты ведь нашел свою шапку под кроватью", Time.past, Verb_form.positively);
                System.out.println(".");

                Confused.do_something(Action.say, "Найти-то я нашел, да мне было в ней жарко, ну я и положил ее на стол, а потом в самый последний момент забыл надеть", Time.past, Verb_form.positively);
                System.out.println(".");

                Grumpy.do_something(Action.say, "Ты всегда что-нибудь в самый последний момент забываешь", Time.past, Verb_form.positively);
                System.out.println(".");

                Dunno.do_something(Action.shout_x2, "Смотрите, братцы, наш домик остался внизу!", Time.past, Verb_form.positively);
                System.out.println(".");

                for(int i = 0; i < characters_group.length; i++) {
                    characters_group[i].do_something(Action.laugh, Time.past, Verb_form.positively);
                }
                System.out.println(". ");

                Grumpy.do_something(Action.say, "А ты, должно быть, думал, что и домик полетит с нами?", Time.past, Verb_form.positively);
                System.out.println(".");

                Dunno.do_something(Action.take_offense, "Ничего я такого не думал!", Time.past, Verb_form.positively);
                System.out.println(".");

                Dunno.do_something(Action.say, "Просто я увидел, что наш домик стоит, вот и сказал. Раньше мы все время в домике жили, а теперь на воздушном шаре летим.", Time.past, Verb_form.positively);
                System.out.println(".");

                Grumpy.do_something(Action.grumble, "Вот и летим, куда-то еще залетим!", Time.past, Verb_form.positively);
                System.out.println(".");

                Dunno.do_something(Action.say, "Ты, Ворчун, все ворчишь, от тебя и на воздушном шаре покою нету.", Time.past, Verb_form.positively);
                System.out.println(".");

                Grumpy.do_something(Action.shout_x2, "Ну и уходи, раз тебе не нравится!", Time.past, Verb_form.positively);
                System.out.println(".");

                Dunno.do_something(Action.ask, "Куда же я тут уйду?", Time.past, Verb_form.positively);
                System.out.println(".");

                Znayka.do_something(Action.shout, "Ну, довольно! Что это еще за споры на воздушном шаре?", Time.past, Verb_form.positively);
                System.out.println(".");

                balloon.do_something(Action.move, Time.past, CoordinateEnum.Up_x2);
                System.out.print(". ");

                flower_city.do_something(Action.be_seen, Time.past, Enums_visibility.fraze_tiny_1);
                System.out.print(". ");

                for(int i = 0; i < houses_number; i++) {
                    houses[i].do_something(Action.seem, Time.past, Enums_visibility.tiny);
                }
                System.out.print(". ");

                for(int i = 0; i < shorties_number; i++) {
                    shorties[i].do_something(Action.discern, Time.past, Enums_visibility.not_visibility_x2, Verb_form.negative);
                }
                System.out.println(".");

                balloon.do_something(Action.blow_away, Time.past);
                System.out.print(". ");

                city.do_something(Action.be_seen, Time.past, CoordinateEnum.behind_x2);
                System.out.println(".");

                Znayka.do_something(Action.get_something_from_somewhere, compass, "карман", Time.past, Verb_form.positively);
                System.out.print(" и ");

                Znayka.do_something(Action.start_define_something, Time.past, Verb_form.positively, "направление");
                System.out.print(", в котором ");

                balloon.do_something(Action.fly, Time.past, Verb_form.positively);
                System.out.println(".");

                Znayka.do_something(Action.say, "Компас – это такая маленькая металлическая коробочка с магнитной стрелкой", Time.past, Verb_form.positively);

            }
        }
        Story story = new Story();
        story.makeStory();

    }
}