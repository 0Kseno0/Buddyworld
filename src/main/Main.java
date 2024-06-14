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
    static int eingabe = 0;

    public static void main(String[] args) throws SQLException {

        System.out.println("\b");

            buddy = sql.pokemonWahl();
            sql.pokemonWahlRandom(buddy2);

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

            buddy.holeTyp();
            buddy2.holeTyp();

            buddy.angriffAuswahl();
            buddy2.zufaelligeAngriffe();

            //System.out.println();

            /*
            System.out.println();

            buddy.getAngriffsListe();
        
            buddy.ansichtAngriffe();
            */

            while(buddy.getHp() != 0 && buddy2.getHp() != 0) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                kampf.kampf(buddy, buddy2, wetter);
                System.out.println("\n" + buddy.getName() + ": " + buddy.getHp() + "/" + buddy.getMaxHp() + " hp.");
                System.out.println("Statuseffekt: " + buddy.getStatusEffekt().getName());
                System.out.println();
                System.out.println(buddy2.getName() +  ": " + buddy2.getHp() + "/" + buddy2.getMaxHp() + " hp.");
                System.out.println("Statuseffekt: " + buddy2.getStatusEffekt().getName());
                System.out.println("\nWetter: " + wetter.getName());
            }

            mech.gewinnerCheck(buddy, buddy2);
    }
}