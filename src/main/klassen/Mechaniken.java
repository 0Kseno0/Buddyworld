package main.klassen;
import java.util.Random;
import java.util.Vector;

public class Mechaniken {

    public Mechaniken() {

    }

    public int schadensBerechnung(Buddy b1, Buddy b2, Angriff angriff, Wetter wetter) {

        Random random = new Random();
        double randomValue = 0.85 + (1 - 0.85) * random.nextDouble();
        int dId1 = 0, dId2 = 0;

        if (b2.getTyp().size() == 1) {
            dId1 = b2.getTyp().elementAt(0).getId();
            dId2 = -1;
        } else if (b2.getTyp().size() == 2) {
            dId1 = b2.getTyp().elementAt(0).getId();
            dId2 = b2.getTyp().elementAt(1).getId();
        } else {
            System.out.println("Irgendwas hat nicht richtig funktioniert.");
            dId1 = -1;
            dId2 = -1;
        }

        int atk = angriff.getKategorie() == 1 ? b1.getStatValue(1) : b1.getStatValue(3);
        int def = angriff.getKategorie() == 1 ? b1.getStatValue(2) : b1.getStatValue(4);

        double schaden = ((((((double) (2 * b1.getLvl()) / 5) + 2) * angriff.getPower() * ((double) atk / def)) / 50) + 2)
                * getEffektivitaet(angriff.getTyp().getId(), dId1, dId2) * randomValue;

        double critChance = switch (b1.getCritStage()) {
            case 0 -> 4.17;
            case 1 -> 12.5;
            case 2 -> 50;
            default -> 100;
        };

        double critCheck = random.nextDouble(100);

        schaden = critChance >= critCheck ? schaden * 1.5 : schaden;

        boolean istWetter = false;

        if (wetter.getId() == 1 && angriff.getTyp().getId() == 10 || wetter.getId() == 2 && angriff.getTyp().getId() == 11) {
            istWetter = true;
        }

        schaden = istWetter ? schaden * 1.5 : schaden;

        boolean schlechtesWetter = false;

        if (wetter.getId() == 2 && angriff.getTyp().getId() == 10 || wetter.getId() == 1 && angriff.getTyp().getId() == 11) {
            schlechtesWetter = true;
        }

        schaden = schlechtesWetter ? schaden * 0.5 : schaden;

        boolean stab = b1.getTyp().contains(angriff.getTyp());

        System.out.println("Stab: " + stab);

        schaden = stab ? schaden * 1.5 : schaden;

        boolean burn = b1.getStatusEffekt().getId() == 1;

        schaden = burn && angriff.getKategorie() == 1 ? schaden * 0.5 : schaden;

        schaden = b2.isHatLightScreen() && angriff.getKategorie() == 2 ? schaden * 0.5 : schaden;

        schaden = b2.isHatReflect() && angriff.getKategorie() == 1 ? schaden * 0.5 : schaden;

        return (int) schaden;
    }


    private static final double[][] effektiv = {
            //       NOR FIG FLY POI GRO ROC BUG GHO STE FIR WAT GRA ELE PSY ICE DRA DAR FAI
            /*NOR*/ {1, 1, 1, 1, 1, 0.5, 1, 0, 0.5, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            /*FIG*/ {2, 1, 0.5, 0.5, 1, 2, 0.5, 0, 2, 1, 1, 1, 1, 0.5, 2, 1, 2, 0.5},
            /*FLY*/ {1, 2, 1, 1, 1, 0.5, 2, 1, 0.5, 1, 1, 2, 0.5, 1, 1, 1, 1, 1},
            /*POI*/ {1, 1, 1, 0.5, 0.5, 0.5, 1, 0.5, 0, 1, 1, 2, 1, 1, 1, 1, 1, 2},
            /*GRO*/ {1, 1, 0, 2, 1, 2, 0.5, 1, 2, 2, 1, 0.5, 2, 1, 1, 1, 1, 1},
            /*ROC*/ {1, 0.5, 2, 1, 0.5, 1, 2, 1, 0.5, 2, 1, 2, 1, 1, 2, 1, 1, 1},
            /*BUG*/ {1, 0.5, 0.5, 0.5, 1, 1, 1, 0.5, 0.5, 0.5, 1, 2, 1, 2, 1, 1, 1, 0.5},
            /*GHO*/ {0, 1, 1, 1, 1, 1, 1, 2, 0.5, 1, 1, 1, 1, 2, 1, 1, 0.5, 1},
            /*STE*/ {1, 1, 1, 1, 1, 2, 1, 1, 0.5, 0.5, 0.5, 1, 0.5, 1, 2, 1, 1, 1},
            /*FIR*/ {1, 1, 1, 1, 1, 0.5, 2, 1, 2, 0.5, 0.5, 2, 1, 1, 2, 0.5, 1, 1},
            /*WAT*/ {1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 0.5, 0.5, 1, 1, 1, 0.5, 1, 1},
            /*GRA*/ {1, 1, 0.5, 0.5, 2, 2, 0.5, 1, 1, 0.5, 2, 0.5, 1, 1, 1, 0.5, 1, 1},
            /*ELE*/ {1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 2, 0.5, 0.5, 1, 1, 0.5, 1, 1},
            /*PSY*/ {1, 2, 1, 2, 1, 1, 1, 1, 0.5, 1, 1, 1, 1, 0.5, 1, 1, 0, 1},
            /*ICE*/ {1, 1, 2, 1, 2, 1, 1, 1, 0.5, 0.5, 0.5, 2, 1, 1, 0.5, 2, 1, 1},
            /*DRA*/ {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0},
            /*DAR*/ {1, 0.5, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 0.5, 0.5},
            /*FAI*/ {1, 2, 1, 0.5, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 2, 1},
    };

    public double getEffektivitaet(int aId, int dId1, int dId2) {

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

    public boolean istTyp(Vector<Typ> typ, int id) {
        boolean istTyp = false;

        for (int i = typ.size(); i > 0; i--) {
            if (typ.elementAt(i).getId() == id) {
                istTyp = true;
            }
        }

        return istTyp;
    }

    public void statusEffektAktion(Buddy b) {

        Random random = new Random();
        double wahrscheinlichkeit = random.nextDouble(100);

        if (b.getStatusEffekt().getId() == 1 || b.getStatusEffekt().getId() == 4) {
            if (b.getHp() > b.getMaxHp() / 8) {
                b.setHp(b.getMaxHp() / 8);
            } else {
                b.setHp(0);
            }
        } else if (b.getStatusEffekt().getId() == 2) {
            b.setKannAngreifen(false);

            if (wahrscheinlichkeit < 20) {
                b.getStatusEffekt().setId(0);
                b.setKannAngreifen(true);
            }
        } else if (b.getStatusEffekt().getId() == 5) {
            b.setBadlyPoisonedDauer(b.getBadlyPoisonedDauer() + 1);
            if (b.getHp() > (b.getMaxHp() * b.getBadlyPoisonedDauer()) / 16) {
                b.setHp((b.getMaxHp() * b.getBadlyPoisonedDauer()) / 16);
            } else {
                b.setHp(0);
            }
        } else if (b.getStatusEffekt().getId() == 6) {
            b.setKannAngreifen(false);
            b.setSleepDauer(b.getSleepDauer() - 1);
        }
    }

    public void wetterAktion(Buddy b1, Buddy b2, Wetter w) {

        if (w.getDauer() > 0) {
            w.setDauer(w.getDauer() - 1);

            if (w.getDauer() == 0) {
                if(w.getId() == 3){
                    if (istTyp(b1.getTyp(), 6)) {
                        b1.setStatValue(4, (int) (b1.getStatValue(4) * 0.50));
                    }
                    if (istTyp(b2.getTyp(), 6)) {
                        b2.setStatValue(4, (int) (b2.getStatValue(4) * 0.50));
                    }
                }
                w.setWetter(0);
            } else {
                if (w.getId() == 3) {
                    if(!istTyp(b1.getTyp(), 5) || !istTyp(b1.getTyp(), 6) || !istTyp(b1.getTyp(), 9)){
                        if (b1.getHp() > b1.getMaxHp() / 16) {
                            b1.setHp(b1.getMaxHp() / 16);
                        } else {
                            b1.setHp(0);
                        }
                    }
                    if(!istTyp(b2.getTyp(), 5) || !istTyp(b2.getTyp(), 6) || !istTyp(b2.getTyp(), 9)){
                        if (b2.getHp() > b2.getMaxHp() / 16) {
                            b2.setHp(b2.getMaxHp() / 16);
                        } else {
                            b2.setHp(0);
                        }
                    }
                }
                if (w.getId() == 4) {
                    if(!istTyp(b1.getTyp(), 15)){
                        if (b1.getHp() > b1.getMaxHp() / 16) {
                            b1.setHp(b1.getMaxHp() / 16);
                        } else {
                            b1.setHp(0);
                        }
                    }
                    if(!istTyp(b2.getTyp(), 15)){
                        if (b2.getHp() > b2.getMaxHp() / 16) {
                            b2.setHp(b2.getMaxHp() / 16);
                        } else {
                            b2.setHp(0);
                        }
                    }
                }
            }
        }
    }

    public void reflectCounter(Buddy b){
        if(b.getReflectDuration() > 0){
            b.setReflectDuration(b.getReflectDuration() - 1);
        }
    }

    public void lightScreenCounter(Buddy b){
        if(b.getLightScreenDuration() > 0){
            b.setLightScreenDuration(b.getLightScreenDuration() - 1);
        }
    }
}
