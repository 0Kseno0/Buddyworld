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

    public void kampf(Buddy b1, Buddy b2, Wetter w){

        boolean b1Zuerst = false;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcher Angriff soll benutzt werden: ");

        int eingabe = scanner.nextInt();

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

        if(b1Zuerst){
            durchlauf(b1, b2, w, b1.getAngriffe()[eingabe-1]);
            durchlauf(b1, b2, w, ki.angriffAuswahl(b2, b2.getAngriffe()));
        }   else{
            durchlauf(b1, b2, w, ki.angriffAuswahl(b2, b2.getAngriffe()));
            durchlauf(b1, b2, w, b1.getAngriffe()[eingabe-1]);
        }

        mech.bindingCheck(b1, b2);
        mech.sleepyToggle(b1, b2);
        mech.reflectCounter(b1, b2);
        mech.lightScreenCounter(b1, b2);
        mech.statusEffektAktion(b1, b2);
        mech.wetterAktion(b1, b2, w);

    }

    public void durchlauf(Buddy b1, Buddy b2, Wetter w, Angriff a){

        Random random = new Random();

        double wahrscheinlichkeit = random.nextDouble(100);

        //b1 Angreifer
        switch (a.getId()) {
            case 1:
                break;
            case 12, 32, 90, 329:
                if(wahrscheinlichkeit < 30){
                    b2.setHp(0);
                }
                break;
            default:
                if(a.getKategorie() > 0) {
                    if (wahrscheinlichkeit < a.getGenauigkeit()) {
                        if (b1.getStatusEffekt().getId() == 3 && wahrscheinlichkeit < 25) {
                            System.out.println("Paralysiert.");
                        }   else{
                            angriffsAusfuehrung(b1, b2, a, w);
                        }
                    }   else{

                        //Spezielle Effekte beim Verfehlen von einem Angriff
                        switch(a.getId()){
                            case 26, 136:
                                if(b1.getHp() > 1){
                                    b1.setHp(b1.getHp()/2);
                                }
                                break;
                            case  210:
                                a.setPower(40);
                                break;

                        }
                    }
                }   else if(a.getKategorie() == 0){

                }   else System.out.println("Invalider Angriff!");
                break;
        }
    }

    public void angriffsAusfuehrung(Buddy b1, Buddy b2, Angriff a, Wetter w){

        aMech.warum(b1, b2, a, w, mech.schadensBerechnung(b1, b2, a, w));

        if(b2.getHp() - mech.schadensBerechnung(b1, b2, a, w) >= 0){
            b2.setHp(b2.getHp() - mech.schadensBerechnung(b1, b2, a, w));
        }   else{
            b2.setHp(0);
        }

        aMech.warum2(b1, b2, a, w, mech.schadensBerechnung(b1, b2, a, w));
    }
}
