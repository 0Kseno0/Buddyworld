package main.klassen;
import main.GUI;

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
            dId1 = -1;
            dId2 = -1;
        }

        int atk = angriff.getKategorie() == 1 ? b1.getStatValue(1) : b1.getStatValue(3);
        int def = angriff.getKategorie() == 1 ? b2.getStatValue(2) : b2.getStatValue(4);

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

        boolean stab = istTyp(b1.getTyp(), angriff.getTyp().getId());

        schaden = stab ? schaden * 1.5 : schaden;

        boolean burn = b1.getStatusEffekt().getId() == 1;

        schaden = burn && angriff.getKategorie() == 1 ? schaden * 0.5 : schaden;

        schaden = b2.isHatLightScreen() && angriff.getKategorie() == 2 ? schaden * 0.5 : schaden;

        schaden = b2.isHatReflect() && angriff.getKategorie() == 1 ? schaden * 0.5 : schaden;

        return (int) schaden;
    }

    public int verwirrungsSchaden(Buddy b1, Angriff angriff){


        int atk = angriff.getKategorie() == 1 ? b1.getStatValue(1) : b1.getStatValue(3);
        int def = angriff.getKategorie() == 1 ? b1.getStatValue(2) : b1.getStatValue(4);

        double schaden = ((double) (((2 * b1.getLvl() / 5 + 2) * atk * 40) / def) / 50) + 2;

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

        return effectiveness1 * effectiveness2;
    }

    public boolean istTyp(Vector<Typ> typ, int id) {
        boolean istTyp = false;

        for (int i = typ.size()-1; i >= 0; i--) {
            if (typ.elementAt(i).getId() == id) {
                istTyp = true;
            }
        }

        return istTyp;
    }

    public void statusEffektAktion(Buddy b1, Buddy b2) {

        Random random = new Random();
        double wahrscheinlichkeit = random.nextDouble(100);

        if (b1.getStatusEffekt().getId() == 1 || b1.getStatusEffekt().getId() == 4) {
            if (b1.getHp() > b1.getMaxHp() / 8) {
                b1.setHp(b1.getHp() - b1.getMaxHp() / 8);
            } else {
                b1.setHp(0);
            }
        } else if (b1.getStatusEffekt().getId() == 2) {
            b1.setKannAngreifen(false);

            if (wahrscheinlichkeit < 20) {
                b1.getStatusEffekt().setEffekt(0);
                b1.setKannAngreifen(true);
            }
        } else if (b1.getStatusEffekt().getId() == 5) {
            b1.setBadlyPoisonedDauer(b1.getBadlyPoisonedDauer() + 1);
            if (b1.getHp() > (b1.getMaxHp() * b1.getBadlyPoisonedDauer()) / 16) {
                b1.setHp(b1.getHp() - (b1.getMaxHp() * b1.getBadlyPoisonedDauer()) / 16);
            } else {
                b1.setHp(0);
            }
        }

        if (b2.getStatusEffekt().getId() == 1 || b2.getStatusEffekt().getId() == 4) {
            if (b2.getHp() > b2.getMaxHp() / 8) {
                b2.setHp(b2.getHp() - b2.getMaxHp() / 8);
            } else {
                b2.setHp(0);
            }
        } else if (b2.getStatusEffekt().getId() == 2) {
            b2.setKannAngreifen(false);

            if (wahrscheinlichkeit < 20) {
                b2.getStatusEffekt().setEffekt(0);
                b2.setKannAngreifen(true);
            }
        } else if (b2.getStatusEffekt().getId() == 5) {
            b2.setBadlyPoisonedDauer(b2.getBadlyPoisonedDauer() + 1);
            if (b2.getHp() > (b2.getMaxHp() * b2.getBadlyPoisonedDauer()) / 16) {
                b2.setHp(b2.getHp() - (b2.getMaxHp() * b2.getBadlyPoisonedDauer()) / 16);
            } else {
                b2.setHp(0);
            }
        }

        if(b1.getStatusEffekt().getId() != 5){
            b1.setBadlyPoisonedDauer(0);
        }
        if(b2.getStatusEffekt().getId() != 5){
            b2.setBadlyPoisonedDauer(0);
        }
    }

    public void schlafenAktion(Buddy b1, Buddy b2, GUI gui){
        if (b1.getStatusEffekt().getId() == 6) {
            b1.setKannAngreifen(false);
            b1.setSleepDauer(b1.getSleepDauer() - 1);
            if(b1.getSleepDauer() == 0){
                b1.setKannAngreifen(true);
                b1.getStatusEffekt().setEffekt(0);
                gui.addChatMessage("\n" + b1.getName() + " ist aufgewacht.");
            }
        }

        if (b2.getStatusEffekt().getId() == 6) {
            b2.setKannAngreifen(false);
            b2.setSleepDauer(b2.getSleepDauer() - 1);
            if(b2.getSleepDauer() == 0){
                b2.setKannAngreifen(true);
                b2.getStatusEffekt().setEffekt(0);
                gui.addChatMessage("\n" + b2.getName() + " ist aufgewacht.");
            }
        }
    }

    public void wetterAktion(Buddy b1, Buddy b2, Wetter w, GUI gui) {

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
                            b1.setHp(b1.getHp() - b1.getMaxHp() / 16);
                        } else {
                            b1.setHp(0);
                        }
                        gui.addChatMessage("\n" + b1.getName() + " wurde vom Sandsturm getroffen.");
                    }
                    if(!istTyp(b2.getTyp(), 5) || !istTyp(b2.getTyp(), 6) || !istTyp(b2.getTyp(), 9)){
                        if (b2.getHp() > b2.getMaxHp() / 16) {
                            b2.setHp(b2.getHp() - b2.getMaxHp() / 16);
                        } else {
                            b2.setHp(0);
                        }
                        gui.addChatMessage("\n" + b2.getName() + " wurde vom Sandsturm getroffen.");
                    }
                }
                if (w.getId() == 4) {
                    if(!istTyp(b1.getTyp(), 15)){
                        if (b1.getHp() > b1.getMaxHp() / 16) {
                            b1.setHp(b1.getHp() - b1.getMaxHp() / 16);
                        } else {
                            b1.setHp(0);
                        }
                        gui.addChatMessage("\n" + b1.getName() + " wurde vom Hagel getroffen.");
                    }
                    if(!istTyp(b2.getTyp(), 15)){
                        if (b2.getHp() > b2.getMaxHp() / 16) {
                            b2.setHp(b2.getHp() - b2.getMaxHp() / 16);
                        } else {
                            b2.setHp(0);
                        }
                        gui.addChatMessage("\n" + b2.getName() + " wurde vom Hagel getroffen.");
                    }
                }
            }
        }
    }

    public void verwirrungCounter(Buddy b1, Buddy b2){
        if(b1.isVerwirrt()){
            b1.setVerwirrtDauer(b1.getVerwirrtDauer()-1);
            if(b1.getVerwirrtDauer() == 0){
                b1.setVerwirrt(false);
            }
        }

        if(b2.isVerwirrt()){
            b2.setVerwirrtDauer(b2.getVerwirrtDauer()-1);
            if(b2.getVerwirrtDauer() == 0){
                b2.setVerwirrt(false);
            }
        }
    }

    public void reflectCounter(Buddy b1, Buddy b2){
        if(b1.getReflectDuration() > 0){
            b1.setReflectDuration(b1.getReflectDuration() - 1);
        }
        if(b1.getReflectDuration() == 0){
            b1.setHatReflect(false);
        }
        if(b2.getReflectDuration() > 0){
            b2.setReflectDuration(b2.getReflectDuration() - 1);
        }
        if(b2.getReflectDuration() == 0){
            b2.setHatReflect(false);
        }
    }

    public void lightScreenCounter(Buddy b1, Buddy b2){
        if(b1.getLightScreenDuration() > 0){
            b1.setLightScreenDuration(b1.getLightScreenDuration() - 1);
        }
        if(b1.getLightScreenDuration() == 0){
            b1.setHatLightScreen(false);
        }
        if(b2.getLightScreenDuration() > 0){
            b2.setLightScreenDuration(b2.getLightScreenDuration() - 1);
        }
        if(b2.getLightScreenDuration() == 0){
            b2.setHatLightScreen(false);
        }
    }

    public void sleepyToggle(Buddy b1, Buddy b2, GUI gui){
        if(b1.isSleepy()){
            b1.setSleepy(false);
            b1.getStatusEffekt().setEffekt(6);
            gui.addChatMessage("\n" + b1.getName() + " ist eingeschlafen.");
        }
        if(b2.isSleepy()){
            b2.setSleepy(false);
            b2.getStatusEffekt().setEffekt(6);
            gui.addChatMessage("\n" + b2.getName() + " ist eingeschlafen.");
        }
    }

    public void bindingCheck(Buddy b1, Buddy b2, GUI gui){
        if(b1.isBound()){

            b1.setBindDauer(b1.getBindDauer() - 1);
            b1.setHp(Math.max((b1.getHp() - b1.getMaxHp()/8),0));
            gui.addChatMessage("\n" + b1.getName() + " wurde durch eine Falle verletzt.");

            if(b1.getBindDauer() == 0) {
                b1.setBound(false);
                gui.addChatMessage("\n" + b1.getName() + " konnte sich von der Falle befreien.");
            }
        }
        if(b2.isBound()){

            b2.setBindDauer(b2.getBindDauer() - 1);
            b2.setHp(Math.max((b2.getHp() - b2.getMaxHp()/8),0));
            gui.addChatMessage("\n" + b2.getName() + " wurde durch eine Falle verletzt.");

            if(b2.getBindDauer() == 0) {
                b2.setBound(false);
                gui.addChatMessage("\n" + b2.getName() + " konnte sich von der Falle befreien.");
            }
        }
    }

    public boolean paraCheck(Buddy b){
        if(b.getStatusEffekt().getId() == 3){
            return true;
        }   else{
            return false;
        }
    }

    public boolean speedCheck(Buddy b1, Buddy b2, double multiplikator){
        Random random = new Random();

        if(b1.getStatValue(5) * multiplikator > b2.getStatValue(5)){
            return true;
        }   else if(b1.getStatValue(5) * multiplikator < b2.getStatValue(5)){
            return false;
        }else {

            int auswahl = random.nextInt(2);
            if(auswahl == 0){
                return true;
            }   else{
                return false;
            }
        }
    }

    public void gewinnerCheck(Buddy b1, Buddy b2, GUI gui){
        if(b1.getHp() == 0 && b2.getHp() > 0) gui.addChatMessage("\n" + b2.getName() + " hat gewonnen!");
        else if(b2.getHp() == 0 && b1.getHp() > 0) gui.addChatMessage("\n" + b1.getName() + " hat gewonnen!");
        else gui.addChatMessage("Unentschieden?");
    }
}
