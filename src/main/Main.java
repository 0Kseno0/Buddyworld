package main;
import main.klassen.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        SQL sql = new SQL();
        Buddy buddy = new Buddy();
        Buddy buddy2 = new Buddy();

            sql.pokemonWahl(buddy);
            sql.pokemonWahl(buddy2);

            //System.out.println(buddy.getId() + " " + buddy.getName() + " " + buddy.getGewicht());

            //buddy.printBaseStats();

            buddy.calculateStats();
            buddy2.calculateStats();

            /*
            System.out.println();

            buddy.printNature();

            System.out.println();

            buddy.printStats();
            */

            buddy.angriffAuswahl();
            buddy2.zufaelligeAngriffe();

            //System.out.println();

            buddy.holeTyp();
            buddy2.holeTyp();

            /*
            System.out.println();

            buddy.getAngriffsListe();

            buddy.ansichtAngriffe();
             */

        GUI gui = new GUI(buddy, buddy2);

    }
}