package main.klassen;

import main.GUI;

import java.util.Random;
import java.util.Scanner;

public class Kampf {

    Mechaniken mech = new Mechaniken();
    AngriffsMechaniken aMech = new AngriffsMechaniken();
    KI ki = new KI();

    //SONIC BOOM, DRAGON RAGE, PSYWAVE, SUPER FANG KEINE SCHADENSRECHNUNG
    public Kampf(){

    }

    public void kampf(Buddy b1, Buddy b2, Wetter w, GUI gui) throws InterruptedException {

        boolean b1Zuerst = false;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int eingabe = gui.getLastPressedButton();
        Angriff kiAuswahl = ki.angriffAuswahl(b2, b1, b2.getAngriffe(), w);

        mech.prioHoch(b1, eingabe);
        mech.prioHoch(b2, kiAuswahl.getId());

        if(b1.getPrio() > b2.getPrio()){
            b1Zuerst = true;
        }   else{
            if(mech.paraCheck(b1) && !mech.paraCheck(b2)){
                b1Zuerst = mech.speedCheck(b1, b2, 0.75);
            }   else if(mech.paraCheck(b2) && !mech.paraCheck(b1)){
                b1Zuerst = !mech.speedCheck(b2, b1, 0.75);
            }   else{
                //ob beide paralysiert oder niemand paralysiert egal
                b1Zuerst = mech.speedCheck(b1, b2, 1);
            }
        }

        mech.schlafenAktion(b1, b2, gui);

        if(b1Zuerst){
            durchlauf(b1, b2, b1.getAngriffe()[eingabe], w, gui, true);

            Thread.sleep(500);

            if(b2.getHp() > 0) {
                durchlauf(b2, b1, kiAuswahl, w, gui, false);
            }   else{
                gui.addChatMessage("\n" + b2.getName() + " wurde getötet.");
            }
        }   else{
            durchlauf(b2, b1, kiAuswahl, w, gui, false);

            Thread.sleep(500);

            if(b1.getHp() > 0) {
                durchlauf(b1, b2, b1.getAngriffe()[eingabe], w, gui, true);
            }   else{
                gui.addChatMessage("\n" + b1.getName() + " wurde getötet.");
            }
        }

        mech.bindingCheck(b1, b2, gui);
        mech.sleepyToggle(b1, b2, gui);
        mech.verwirrungCounter(b1, b2);
        mech.reflectCounter(b1, b2);
        mech.lightScreenCounter(b1, b2);
        mech.statusEffektAktion(b1, b2);
        mech.wetterAktion(b1, b2, w, gui);
        mech.prioRunter(b1, eingabe);
        mech.prioRunter(b2, kiAuswahl.getId());
        b1.setFlinched(false);
        b2.setFlinched(false);

        gui.update(b1, b2);
    }

    public void durchlauf(Buddy b1, Buddy b2, Angriff a, Wetter w, GUI gui, boolean b1Dran){

        boolean kriegtSchaden = false;
        Random random = new Random();
        double wahrscheinlichkeit = random.nextDouble(100);

        if(b1.getStatusEffekt().getId() != 2 && b1.getStatusEffekt().getId() != 6 && !b1.isFlinched()) {
            if(a.getPp() != 0 ) {
                if (b1.isVerwirrt() && wahrscheinlichkeit < 50) {
                    b1.setHp(Math.max(b1.getHp() - mech.verwirrungsSchaden(b1, a), 0));
                    gui.addChatMessage("\n" + b1.getName() + " hat sich vor Verwirrung selbst verletzt.");

                    if(!b1Dran) gui.damageImageSetGegner();
                    else gui.damageImageSet();
                } else {
                    if (b1.getStatusEffekt().getId() == 3 && wahrscheinlichkeit < 25) {
                        gui.addChatMessage("\n" + b1.getName() + " ist paralysiert.");
                    }   else {
                        //b1 Angreifer
                        switch (a.getId()) {
                            case 12, 32, 329:
                                if (wahrscheinlichkeit < 30) {
                                    b2.setHp(0);
                                }
                                printAngriff(b1, a, gui);
                                kriegtSchaden = true;
                                break;
                            case 49:
                                b2.setHp(Math.max(b2.getHp() - 20, 0));
                                printAngriff(b1, a, gui);
                                gui.addChatMessage("\n" + b1.getName() + " fügt 20 Schaden zu.");
                                kriegtSchaden = true;
                                break;
                            case 82:
                                b2.setHp(Math.max(b2.getHp() - 40, 0));
                                printAngriff(b1, a, gui);
                                gui.addChatMessage("\n" + b1.getName() + " fügt 40 Schaden zu.");
                                kriegtSchaden = true;
                                break;
                            case 90:
                                if(!mech.istTyp(b2.getTyp(), 3)){
                                    if (wahrscheinlichkeit < 30){
                                        b2.setHp(0);
                                    }
                                }
                                break;
                            case 149:
                                double multiplikator = random.nextDouble(1) + 0.5;
                                b2.setHp(Math.max((b2.getHp() - (int) (b2.getLvl() * multiplikator)), 0));
                                printAngriff(b1, a, gui);
                                gui.addChatMessage("\n" + b1.getName() + " fügt " + b2.getLvl() * multiplikator + " Schaden zu.");
                                kriegtSchaden = true;
                                break;
                            case 162:
                                b2.setHp(Math.max((b2.getHp() / 2), 0));
                                printAngriff(b1, a, gui);
                                gui.addChatMessage("\n" + b1.getName() + " fügt " + b2.getHp() / 2 + " Schaden zu.");
                                kriegtSchaden = true;
                                break;
                            case 167:
                                for (int i = 0; i < 3; i++) {
                                    a.setPower((i+1) * 10);
                                    int schaden = mech.schadensBerechnung(b1, b2, a, w);
                                    b2.setHp(Math.max(b2.getHp() - schaden, 0));
                                    printEffektivitaet(b2, a, gui);
                                    gui.addChatMessage("\n" + b1.getName() + " fügt " + schaden + " Schaden zu.");

                                    if(b1Dran) gui.damageImageSetGegner();
                                    else gui.damageImageSet();
                                }
                                printAngriff(b1, a, gui);
                                break;
                            default:
                                printAngriff(b1, a, gui);
                                if (a.getKategorie() > 0) {
                                    if ((wahrscheinlichkeit / b1.getStatValue(6)) < a.getGenauigkeit()) {
                                        angriffsAusfuehrung(b1, b2, a, w, gui);
                                        kriegtSchaden = true;
                                    } else {
                                        gui.addChatMessage("\n" + b1.getName() + " hat verfehlt.");

                                        //Spezielle Effekte beim Verfehlen von einem Angriff
                                        switch (a.getId()) {
                                            case 26, 136:
                                                if (b1.getHp() > 1) {
                                                    b1.setHp(b1.getHp() / 2);
                                                }
                                                gui.addChatMessage("\n" + b1.getName() + " stürzt und verletzt sich dabei.");
                                                break;
                                            case 210:
                                                a.setPower(40);
                                                break;
                                        }
                                    }
                                } else if (a.getKategorie() == 0) {
                                    aMech.warum(b1, b2, a, w, mech.schadensBerechnung(b1, b2, a, w), gui);
                                } else gui.addChatMessage("Invalider Angriff!");
                                break;
                        }
                    }
                }
            }   else{
                gui.addChatMessage("Angriff kann nicht mehr benutzt werden!");
            }
        }   else{
            gui.addChatMessage("\n" + b1.getName() + " ist gerade nicht in der Lage anzugreifen.");
        }

        if(kriegtSchaden){
            if(b1Dran) gui.damageImageSetGegner();
            else gui.damageImageSet();
        }
    }

    public void angriffsAusfuehrung(Buddy b1, Buddy b2, Angriff a, Wetter w, GUI gui){
        int schaden = b2.getHp() - mech.schadensBerechnung(b1, b2, a, w) >= 0 ? mech.schadensBerechnung(b1, b2, a, w) : b2.getHp();

        aMech.warum(b1, b2, a, w, schaden, gui);

        b2.setHp(Math.max(b2.getHp() - schaden, 0));

        printEffektivitaet(b2, a, gui);
        gui.addChatMessage("\n" + b1.getName() + " fügt " + schaden + " Schaden zu.");

        aMech.warum2(b1, b2, a, schaden, gui);

        a.setPp(a.getPp() - 1);
    }

    public void printAngriff(Buddy b,  Angriff a, GUI gui){
        gui.addChatMessage("\n" + b.getName() + " setzt " + a.getName() + " ein.");
    }

    public void printEffektivitaet(Buddy b, Angriff a, GUI gui){
        //b ist Verteidiger nicht Angreifer!
        //Typ Buddy
        int dId1 = 0, dId2 = 0;

        if (b.getTyp().size() == 1) {
            dId1 = b.getTyp().elementAt(0).getId();
            dId2 = -1;
        } else if (b.getTyp().size() == 2) {
            dId1 = b.getTyp().elementAt(0).getId();
            dId2 = b.getTyp().elementAt(1).getId();
        } else {
            gui.addChatMessage("\nIrgendwas hat nicht richtig funktioniert.");
            dId1 = -1;
            dId2 = -1;
        }

        double effektiv = mech.getEffektivitaet(a.getTyp().getId(), dId1, dId2);

        switch(String.valueOf(effektiv)){
            case "0.0":
                gui.addChatMessage("\n" + b.getName() + " ist Immun gegen " + a.getTyp().getName() + ".");
                break;
            case "0.25", "0.5":
                gui.addChatMessage("Das war nicht sehr effektiv.");
                break;
            case "1.0":
                gui.addChatMessage("Das war effektiv.");
                break;
            case "2.0", "4.0":
                gui.addChatMessage("Das war sehr effektiv");
                break;
        }
    }
}
