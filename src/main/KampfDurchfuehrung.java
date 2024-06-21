package main;

import main.klassen.Buddy;
import main.klassen.Kampf;
import main.klassen.Mechaniken;
import main.klassen.Wetter;

import java.sql.SQLException;

public class KampfDurchfuehrung {


    static SQL sql = new SQL();
    static Buddy buddy = new Buddy();
    static Buddy buddy2 = new Buddy();
    static Wetter wetter = new Wetter();
    static Mechaniken mech = new Mechaniken();
    static GUI gui;
    static Kampf kampf = new Kampf();

    public void start() throws SQLException{

        //pokemonWahl() erlaubt einem in der Konsole ein Pokemon und die Angriffe auszuwählen
        // ^ Pokemon durch ID und Name (Englisch) wählbar, Angriffe nur mit ID
        //pokemonParameterWahl(...) wählt ein Pokemon mit dem ersten Parameter, und die Angriffe mit den folgenden 4 Parametern (nur ID!)
        //pokemonWahlRandom() weist ein zufälliges Pokemon mit zufälligen Angriffen dem Objekt zu

        //buddy = sql.pokemonWahl();
        //Rayquaza
        buddy = sql.pokemonParameterWahl(384, 337, 315, 304, 339);
        //Charmander
        //buddy = sql.pokemonParameterWahl(4, 44, 349, 246, 241);

        buddy2 = sql.pokemonWahlRandom();
        //Carracosta
        //buddy2 = sql.pokemonParameterWahl(565, 89, 57, 58, 157);

        gui = new GUI(buddy, buddy2);
        while (buddy.getHp() != 0 && buddy2.getHp() != 0) {

            gui.addChatMessage("\n\n");
            try {
                kampf.kampf(buddy, buddy2, wetter, gui);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            switch(wetter.getId()){
                case 1:
                    gui.addChatMessage("\nDie Sonne scheint.");
                    break;
                case 2:
                    gui.addChatMessage("\nEs regnet.");
                    break;
                case 3:
                    gui.addChatMessage("\nEin Sandsturm plagt das Schlachtfeld.");
                    break;
                case 4:
                    gui.addChatMessage("\nEs hagelt.");
                    break;
            }
        }

        mech.gewinnerCheck(buddy, buddy2, gui);
        gui.panel2Loeschen(buddy, buddy2);
    }
}
