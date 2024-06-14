package main.klassen;

import java.util.Random;

public class KI {

    public KI(){

    }

    public Angriff angriffAuswahl(Buddy b2, Angriff[] angriffe){

        int index = 0;
        Random random = new Random();

        index = random.nextInt(4);

        return angriffe[index];
    }
}
