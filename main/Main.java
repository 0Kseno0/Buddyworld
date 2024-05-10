package main;
import main.klassen.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        String[] laskdj = new String[2];
        SQL sql = new SQL();
        Buddy buddy = new Buddy();
        Buddy buddy2 = new Buddy();

        try {
            sql.pokemonWahl(buddy);

            System.out.println(buddy.getId() + " " + buddy.getName());

            double[] stats = buddy.getStats();

            for(int i = 0; i < 7; i++){
                System.out.println(stats[i]);
            }
            buddy.zufaelligeAngriffe();

            System.out.println("");

            buddy.holeTyp();

            System.out.println("");

            buddy.ansichtAngriffe();

            sql.pokemonWahl(buddy2);

            System.out.println(buddy2.getId() + " " + buddy2.getName());

            double[] stats2 = buddy2.getStats();

            for(int i = 0; i < 7; i++){
                System.out.println(stats2[i]);
            }
            buddy2.zufaelligeAngriffe();

            System.out.println("");

            buddy2.holeTyp();

            System.out.println("");

            buddy2.ansichtAngriffe();
        }
        catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            main(laskdj);
        }

    }

}