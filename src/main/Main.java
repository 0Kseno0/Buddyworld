package main;
import main.klassen.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        String[] laskdj = new String[2];
        SQL sql = new SQL();
        Buddy buddy = new Buddy();

        try {
            sql.pokemonWahl(buddy);

            System.out.println(buddy.getId() + " " + buddy.getName());

            buddy.printStats();

            buddy.zufaelligeAngriffe();

            System.out.println("");

            buddy.holeTyp();

            System.out.println("");

            //buddy.getAngriffsListe();

            //buddy.ansichtAngriffe();
        }
        catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            main(laskdj);
        }

    }

}