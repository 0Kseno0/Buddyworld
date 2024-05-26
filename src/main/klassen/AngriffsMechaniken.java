package main.klassen;

import java.util.Random;

public class AngriffsMechaniken {

    public void warum(Buddy b1, Buddy b2, Angriff angriff, Wetter wetter){

        //b1 Angreifer, b2 Verteidiger, angriff Angriff von b1

        Random random = new Random();
        double wahrscheinlichkeit = 0;

        switch(angriff.getId()){
            case 2:
                b1.incrementCritStage();
                break;
            case 3:
                angriff.randomAnzahl();
                break;
            case 4:
                angriff.randomAnzahl();
                break;
            case 7:
                wahrscheinlichkeit = random.nextDouble(100);
                if(wahrscheinlichkeit < 10){
                    b2.getStatusEffekt().setEffekt(1);
                }
                break;
            case 8:
                wahrscheinlichkeit = random.nextDouble(100);
                if(wahrscheinlichkeit < 10){
                    b2.getStatusEffekt().setEffekt(2);
                }
                break;
            case 9:
                wahrscheinlichkeit = random.nextDouble(100);
                if(wahrscheinlichkeit < 10){
                    b2.getStatusEffekt().setEffekt(3);
                }
                break;
            case 13:
                if(b1.isCharging()){
                    b1.incrementCritStage();
                }
                b1.setCharging(!b1.isCharging());
                break;
            case 14:
                b1.incrementStat(2,2);
        }
    }

    public void warum2(Buddy b1, Buddy b2, Angriff angriff, Wetter wetter){
        switch(angriff.getId()){
            case 2:
                b1.decrementCritStage();
                break;
            case 13:
                if(!b1.isCharging()){
                    b1.decrementCritStage();
                }
        }
    }
}
