package main;

import main.klassen.*;

import java.util.Random;
import java.util.Scanner;

public class Kampf {

    Mechaniken mech = new Mechaniken();
    KI ki = new KI();
    AngriffsMechaniken aMech = new AngriffsMechaniken();

//SONIC BOOM, DRAGON RAGE, PSYWAVE, SUPER FANG KEINE SCHADENSRECHNUNG
    /*
        Binding Müll
    if(b2.isBound()){
        if(b2.getBindDauer() == 0) {

            b2.setBindDauer(b2.getBindDauer() - 1);
            b2.setHp(b2.getMaxHp()/8);

        }   else{
            b2.setBound(false);
        }
    }
     */
    public Kampf(){

    }



    public void kampf(Buddy b1, Buddy b2, Wetter w){

        boolean b1Zuerst = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcher Angriff soll benutzt werden: ");

        int eingabe = scanner.nextInt();


        if(b1.getPrio() > b2.getPrio()){
            durchlauf(b1, b2, w, b1.getAngriffe()[eingabe-1]);
        }   else if(b1.getPrio() < b2.getPrio()){
            durchlauf(b2, b1, w, ki.angriffAuswahl(b2, b2.getAngriffe()));
        }   else{

        }

        mech.reflectCounter(b1);
        mech.reflectCounter(b2);

        mech.lightScreenCounter(b1);
        mech.lightScreenCounter(b2);

        mech.statusEffektAktion(b1);
        mech.statusEffektAktion(b2);

        mech.wetterAktion(b1, b2, w);

    }

    public void durchlauf(Buddy b1, Buddy b2, Wetter w, Angriff a){

        Random random = new Random();

        double wahrscheinlichkeit = random.nextDouble(100);

        //b1 Angreifer
        switch (a.getId()) {
            case 1:
                break;
            default:
                if(a.getKategorie() > 0) {
                    if (wahrscheinlichkeit < a.getGenauigkeit()) {
                        if (b1.getStatusEffekt().getId() == 3 && wahrscheinlichkeit < 25) {
                            System.out.println("Paralysiert.");
                        }   else{

                        }
                    }   else{
                        if(a.getId() == 210){

                        }
                    }
                }   else if(a.getKategorie() == 0){

                }   else System.out.println("Invalider Angriff!");
                break;
        }
    }
}
