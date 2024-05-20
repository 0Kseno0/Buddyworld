package main.klassen;
import java.util.Random;

public class Mechaniken {

    public int schadensBerechnung(int lvl, double power, double atk, double def,
                                  int wetterTyp, boolean stab, int aTyp, int dId1, int dId2, boolean burn, int critStage){

        Random random = new Random();
        double randomValue = 0.85 + (1 - 0.85) * random.nextDouble();

        double schaden = (((((( 2 * lvl ) / 5 ) + 2 ) * power * ( atk / def )) / 50 ) + 2 )
                         * getEffektivitaet(aTyp, dId1, dId2) * randomValue;

        double critChance = switch (critStage) {
            case 0 -> 6.25;
            case 1 -> 12.5;
            case 2 -> 50;
            case 3 -> 100;
            default -> 100;
        };

        double critCheck = random.nextInt(101);

        schaden = critChance >= critCheck ? schaden * 1.5 : schaden;

        boolean wetter = istRichtigesWetter(wetterTyp, aTyp);

        schaden = wetter ? schaden * 1.5 : schaden;

        schaden = stab ? schaden * 1.5 : schaden;

        schaden = burn ? schaden * 0.5 : schaden;

        return (int) schaden;
    }


    private static final double[][] effektiv = {
            //       NOR FIG FLY POI GRO ROC BUG GHO STE FIR WAT GRA ELE PSY ICE DRA DAR FAI
            /*NOR*/ {1,  1,  1,  1,  1,  0.5,1,  0,  0.5,1,  1,  1,  1,  1,  1,  1,  1,  1},
            /*FIG*/ {2,  1,  0.5,0.5,1,  2,  0.5,0,  2,  1,  1,  1,  1,  0.5,2,  1,  2,  0.5},
            /*FLY*/ {1,  2,  1,  1,  1,  0.5,2,  1,  0.5,1,  1,  2,  0.5,1,  1,  1,  1,  1},
            /*POI*/ {1,  1,  1,  0.5,0.5,0.5,1,  0.5,0,  1,  1,  2,  1,  1,  1,  1,  1,  2},
            /*GRO*/ {1,  1,  0,  2,  1,  2,  0.5,1,  2,  2,  1,  0.5,2,  1,  1,  1,  1,  1},
            /*ROC*/ {1,  0.5,2,  1,  0.5,1,  2,  1,  0.5,2,  1,  2,  1,  1,  2,  1,  1,  1},
            /*BUG*/ {1,  0.5,0.5,0.5,1,  1,  1,  0.5,0.5,0.5,1,  2,  1,  2,  1,  1,  1,  0.5},
            /*GHO*/ {0,  1,  1,  1,  1,  1,  1,  2,  0.5,1,  1,  1,  1,  2,  1,  1,  0.5,1},
            /*STE*/ {1,  1,  1,  1,  1,  2,  1,  1,  0.5,0.5,0.5,1,  0.5,1,  2,  1,  1,  1},
            /*FIR*/ {1,  1,  1,  1,  1,  0.5,2,  1,  2,  0.5,0.5,2,  1,  1,  2,  0.5,1,  1},
            /*WAT*/ {1,  1,  1,  1,  2,  2,  1,  1,  1,  2,  0.5,0.5,1,  1,  1,  0.5,1,  1},
            /*GRA*/ {1,  1,  0.5,0.5,2,  2,  0.5,1,  1,  0.5,2,  0.5,1,  1,  1,  0.5,1,  1},
            /*ELE*/ {1,  1,  2,  1,  0,  1,  1,  1,  1,  1,  2,  0.5,0.5,1,  1,  0.5,1,  1},
            /*PSY*/ {1,  2,  1,  2,  1,  1,  1,  1,  0.5,1,  1,  1,  1,  0.5,1,  1,  0,  1},
            /*ICE*/ {1,  1,  2,  1,  2,  1,  1,  1,  0.5,0.5,0.5,2,  1,  1,  0.5,2,  1,  1},
            /*DRA*/ {1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  2,  1,  0},
            /*DAR*/ {1,  0.5,1,  1,  1,  1,  1,  2,  1,  1,  1,  1,  1,  2,  1,  1,  0.5,0.5},
            /*FAI*/ {1,  2,  1,  0.5,1,  1,  1,  1,  2,  1,  1,  1,  1,  1,  1,  2,  2,  1},
    };

    public double getEffektivitaet(int aId, int dId1, int dId2){

        int attackId = aId - 1;
        int defenderId1 = dId1 - 1;
        int defenderId2 = dId2 != -1 ? dId2 - 1 : -1;

        double effectiveness1 = effektiv[attackId][defenderId1];
        double effectiveness2 = defenderId2 != -1 ? effektiv[attackId][defenderId2] : 1.0;

        System.out.println();
        System.out.println(effectiveness1 * effectiveness2);
        System.out.println();

        return effectiveness1 * effectiveness2;
    }

    public boolean istRichtigesWetter(int wetterTyp, int aId){

        boolean istRichtig;
        if (wetterTyp == aId) istRichtig = true;
        else istRichtig = false;

        return istRichtig;
    }
}
