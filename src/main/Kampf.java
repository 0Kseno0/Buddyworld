package main;

import main.klassen.*;

import java.util.Random;
import java.util.Scanner;

public class Kampf {

    Mechaniken mech = new Mechaniken();
    AngriffsMechaniken aMech = new AngriffsMechaniken();
    KI ki = new KI();

    //SONIC BOOM, DRAGON RAGE, PSYWAVE, SUPER FANG KEINE SCHADENSRECHNUNG
    public Kampf(){

    }

    public void kampf(Buddy b1, Buddy b2, Wetter w, int schaden){

        boolean b1Zuerst = false;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int eingabe = 0;

        while(eingabe < 1 || eingabe > 4) {
            System.out.println("\nWelcher Angriff soll benutzt werden: ");
            eingabe = scanner.nextInt();
        }

        if(b1.getPrio() > b2.getPrio()){
            b1Zuerst = true;
        }   else{
            if(mech.paraCheck(b1)){
                b1Zuerst = mech.speedCheck(b1, b2, 0.75);
            }   else if(mech.paraCheck(b2)){
                b1Zuerst = !mech.speedCheck(b2, b1, 0.75);
            }   else{
                b1Zuerst = mech.speedCheck(b1, b2, 1);
            }
        }

        mech.schlafenAktion(b1, b2);

        if(b1Zuerst){
            durchlauf(b1, b2, b1.getAngriffe()[eingabe-1], w, schaden);

            if(b2.getHp() > 0) {
                durchlauf(b2, b1, ki.angriffAuswahl(b2, b1, b2.getAngriffe(), w), w, schaden);
            }   else{
                System.out.println("\n" + b2.getName() + " wurde getötet.");
            }
        }   else{
            durchlauf(b2, b1, ki.angriffAuswahl(b2, b1, b2.getAngriffe(), w), w, schaden);
            if(b1.getHp() > 0) {
                durchlauf(b1, b2, b1.getAngriffe()[eingabe-1], w, schaden);
            }   else{
                System.out.println("\n" + b1.getName() + " wurde getötet.");
            }
        }

        mech.bindingCheck(b1, b2);
        mech.sleepyToggle(b1, b2);
        mech.verwirrungCounter(b1, b2);
        mech.reflectCounter(b1, b2);
        mech.lightScreenCounter(b1, b2);
        mech.statusEffektAktion(b1, b2);
        mech.wetterAktion(b1, b2, w);
        b1.setFlinched(false);
        b2.setFlinched(false);
    }

    public void durchlauf(Buddy b1, Buddy b2, Angriff a, Wetter w, int s){

        Random random = new Random();
        double wahrscheinlichkeit = random.nextDouble(100);

        if(b1.getStatusEffekt().getId() != 2 && b1.getStatusEffekt().getId() != 6 && !b1.isFlinched()) {
            if(a.getPp() != 0 ) {
                if (b1.isVerwirrt() && wahrscheinlichkeit < 50) {
                    b1.setHp(Math.max(b1.getHp() - mech.verwirrungsSchaden(b1, a), 0));
                    System.out.println("\n" + b1.getName() + " hat sich vor Verwirrung selbst verletzt.");
                } else {

                    if (b1.getStatusEffekt().getId() == 3 && wahrscheinlichkeit < 25) {
                        System.out.println("\n" + b1.getName() + " ist paralysiert.");
                    }   else {
                        //b1 Angreifer
                        switch (a.getId()) {
                            case 12, 32, 90, 329:
                                if (wahrscheinlichkeit < 30) {
                                    b2.setHp(0);
                                }
                                printAngriff(b1, a);
                                break;
                            case 49:
                                b2.setHp(Math.max(b2.getHp() - 20, 0));
                                printAngriff(b1, a);
                                System.out.println("\n" + b1.getName() + " fügt 20 Schaden zu.");
                                break;
                            case 82:
                                b2.setHp(Math.max(b2.getHp() - 40, 0));
                                printAngriff(b1, a);
                                System.out.println("\n" + b1.getName() + " fügt 40 Schaden zu.");
                                break;
                            case 149:
                                double multiplikator = random.nextDouble(1) + 0.5;
                                b2.setHp(Math.max((b2.getHp() - (int) (b2.getLvl() * multiplikator)), 0));
                                printAngriff(b1, a);
                                System.out.println("\n" + b1.getName() + " fügt " + b2.getLvl() * multiplikator + " Schaden zu.");
                                break;
                            case 162:
                                b2.setHp(Math.max((b2.getHp() / 2), 0));
                                printAngriff(b1, a);
                                System.out.println("\n" + b1.getName() + " fügt " + b2.getHp() / 2 + " Schaden zu.");
                                break;
                            case 167:
                                for (int i = 0; i < 3; i++) {
                                    a.setPower((i+1) * 10);
                                    int schaden = mech.schadensBerechnung(b1, b2, a, w);
                                    s = schaden;
                                    b2.setHp(Math.max(b2.getHp() - schaden, 0));
                                    printEffektivitaet(b2, a);
                                    System.out.println("\n" + b1.getName() + " fügt " + schaden + " Schaden zu.");
                                }
                                printAngriff(b1, a);
                                break;
                            default:
                                printAngriff(b1, a);
                                if (a.getKategorie() > 0) {
                                    if ((wahrscheinlichkeit / b1.getStatValue(6)) < a.getGenauigkeit()) {
                                        angriffsAusfuehrung(b1, b2, a, w);
                                    } else {

                                        System.out.println("\n" + b1.getName() + " hat verfehlt.");

                                        //Spezielle Effekte beim Verfehlen von einem Angriff
                                        switch (a.getId()) {
                                            case 26, 136:
                                                if (b1.getHp() > 1) {
                                                    b1.setHp(b1.getHp() / 2);
                                                }
                                                System.out.println("\n" + b1.getName() + " stürzt und verletzt sich dabei.");
                                                break;
                                            case 210:
                                                a.setPower(40);
                                                break;
                                        }
                                    }
                                } else if (a.getKategorie() == 0) {
                                    aMech.warum(b1, b2, a, w, mech.schadensBerechnung(b1, b2, a, w));
                                } else System.out.println("Invalider Angriff!");
                                break;
                        }
                    }
                }
            }   else{
                System.out.println("Angriff kann nicht mehr benutzt werden!");
            }
        }   else{
            System.out.println("\n" + b1.getName() + " ist gerade nicht in der Lage anzugreifen.");
        }
    }

    public void angriffsAusfuehrung(Buddy b1, Buddy b2, Angriff a, Wetter w){
        int schaden = mech.schadensBerechnung(b1, b2, a, w);

        aMech.warum(b1, b2, a, w, schaden);

        b2.setHp(Math.max(b2.getHp() - schaden, 0));

        printEffektivitaet(b2, a);
        System.out.println("\n" + b1.getName() + " fügt " + schaden + " Schaden zu.");

        aMech.warum2(b1, b2, a, w, schaden);

        a.setPp(a.getPp() - 1);
    }

    public void printAngriff(Buddy b,  Angriff a){
        System.out.println("\n" + b.getName() + " setzt " + a.getName() + " ein.");
    }

    public void printEffektivitaet(Buddy b, Angriff a){
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
            System.out.println("\nIrgendwas hat nicht richtig funktioniert.");
            dId1 = -1;
            dId2 = -1;
        }

        double effektiv = mech.getEffektivitaet(a.getTyp().getId(), dId1, dId2);

        switch(String.valueOf(effektiv)){
            case "0":
                System.out.println("\n" + b.getName() + " ist Immun gegen diesen Typ.");
                break;
            case "0.25", "0.5":
                System.out.println("Das war nicht sehr effektiv.");
                break;
            case "1.0":
                System.out.println("Das war effektiv.");
                break;
            case "2.0", "4.0":
                System.out.println("Das war sehr effektiv");
                break;
        }
    }
}
