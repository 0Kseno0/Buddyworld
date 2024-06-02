package main.klassen;
import java.util.Random;
import java.util.Vector;

public class Mechaniken {

    public int schadensBerechnung(Buddy b1, Buddy b2, Angriff angriff, Wetter wetter){

        Random random = new Random();
        double randomValue = 0.85 + (1 - 0.85) * random.nextDouble();
        int dId1 = 0, dId2 = 0;

        if(b2.getTyp().size() == 1){
            dId1 = b2.getTyp().elementAt(0).getId();
            dId2 = -1;
        }   else if(b2.getTyp().size() == 2){
            dId1 = b2.getTyp().elementAt(0).getId();
            dId2 = b2.getTyp().elementAt(1).getId();
        }   else{
            System.out.println("Irgendwas hat nicht richtig funktioniert.");
            dId1 = -1;
            dId2 = -1;
        }

        int atk = angriff.getKategorie() == 1 ? b1.getStatValue(1) : b1.getStatValue(3);
        int def = angriff.getKategorie() == 1 ? b1.getStatValue(2) : b1.getStatValue(4);

        double schaden = ((((((double) (2 * b1.getLvl()) / 5 ) + 2 ) * angriff.getPower() * ((double) atk / def )) / 50 ) + 2 )
                         * getEffektivitaet(angriff.getTyp().getId(), dId1, dId2) * randomValue;

        double critChance = switch (b1.getCritStage()) {
            case 0 -> 4.17;
            case 1 -> 12.5;
            case 2 -> 50;
            default -> 100;
        };

        double critCheck = random.nextDouble(100);

        schaden = critChance >= critCheck ? schaden * 1.5 : schaden;

        boolean istWetter = istRichtigesWetter(wetter.getId(), angriff.getTyp().getId());

        schaden = istWetter ? schaden * 1.5 : schaden;

        boolean stab = b1.getTyp().contains(angriff.getTyp());

        System.out.println("Stab: " + stab);

        schaden = stab ? schaden * 1.5 : schaden;

        boolean burn = b1.getStatusEffekt().getId() == 1;

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

        boolean istRichtig = false;

        if(wetterTyp == 1 && aId == 10 || wetterTyp == 2 && aId == 11){
            istRichtig = true;
        }

        return istRichtig;
    }

    public boolean istTyp(Vector<Typ> typ, int id){
        boolean istTyp = false;

        for(int i = typ.size(); i > 0; i--){
            if(typ.elementAt(i).getId() == id){
             istTyp = true;
            }
        }

        return istTyp;
    }
}
