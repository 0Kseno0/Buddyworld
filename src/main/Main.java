package main;
import main.klassen.*;

import java.sql.SQLException;

public class Main {

    static SQL sql = new SQL();
    static Buddy buddy = new Buddy();
    static Buddy buddy2 = new Buddy();
    static Wetter wetter = new Wetter();
    static Kampf kampf = new Kampf();
    static Mechaniken mech = new Mechaniken();
    static int schaden = 0;

    public static void main(String[] args) throws SQLException {

        System.out.println("\b");

            //buddy = sql.pokemonWahl();
            buddy = sql.pokemonParameterWahl(25, 324, 207, 174, 173);

            //buddy2 = sql.pokemonWahlRandom();
            //Medium Schwierigkeit
            buddy2 = sql.pokemonParameterWahl(565, 89, 57, 58, 157);

            //System.out.println(buddy.getId() + " " + buddy.getName() + " " + buddy.getGewicht());

            //buddy.printBaseStats();

            /*
            System.out.println();

            buddy.printNature();

            System.out.println();

            buddy.printStats();
            */

            //System.out.println();

            /*
            System.out.println();

            buddy.getAngriffsListe();
        
            buddy.ansichtAngriffe();
            */

        // noch nicht richtig, parameter selbst in einer Methode übernehmen, ansonsten jedes mal neue Erzeugung der Klasse
        GUI gui = new GUI(buddy, buddy2, buddy.getAngriffe(), schaden);
/*
            while(buddy.getHp() != 0 && buddy2.getHp() != 0) {
                kampf.kampf(buddy, buddy2, wetter, schaden);
                System.out.println("\n" + buddy.getName() + ": " + buddy.getHp() + "/" + buddy.getMaxHp() + " hp.");
                System.out.println("Statuseffekt: " + buddy.getStatusEffekt().getName());
                System.out.println();
                System.out.println(buddy2.getName() +  ": " + buddy2.getHp() + "/" + buddy2.getMaxHp() + " hp.");
                System.out.println("Statuseffekt: " + buddy2.getStatusEffekt().getName());
                System.out.println("\nWetter: " + wetter.getName());
            }
*/
            mech.gewinnerCheck(buddy, buddy2);
    }
}