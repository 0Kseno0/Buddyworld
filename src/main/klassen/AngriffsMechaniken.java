package main.klassen;

import main.GUI;

import java.util.Random;

public class AngriffsMechaniken {

    Mechaniken mech = new Mechaniken();

    public void warum(Buddy b1, Buddy b2, Angriff angriff, Wetter wetter, int schaden, GUI gui){

        //b1 Angreifer, b2 Verteidiger, angriff Angriff von b1

        double indikator = 0;
        Random random = new Random();
        double wahrscheinlichkeit = random.nextDouble(100);

        switch(angriff.getId()) {
            case 2, 75, 116, 152, 163, 177, 238, 314, 348:
                b1.incrementCritStage();
                break;
            case 3, 4, 31, 42, 131, 140, 154, 198, 292, 331 , 333, 350:
                angriff.randomAnzahl(4, 2);
                break;
            case 7, 52, 53, 126, 172, 257:
                if (b2.getStatusEffekt().getId() == 0 && wahrscheinlichkeit < 10 && !mech.istTyp(b2.getTyp(), 10)) {
                    b2.getStatusEffekt().setEffekt(1);
                    gui.addChatMessage("\n" + b2.getName() + " wurde verbrannt.");
                }
                break;
            case 8, 58, 181:
                if (b2.getStatusEffekt().getId() == 0 && wahrscheinlichkeit < 10 && !mech.istTyp(b2.getTyp(), 15)) {
                    b2.getStatusEffekt().setEffekt(2);
                    gui.addChatMessage("\n" + b2.getName() + " wurde eingefroren.");
                }
                break;
            case 9, 84, 85:
                if (b2.getStatusEffekt().getId() == 0 && wahrscheinlichkeit < 10 && !mech.istTyp(b2.getTyp(), 13)) {
                    b2.getStatusEffekt().setEffekt(3);
                    gui.addChatMessage("\n" + b2.getName() + " wurde paralysiert.");
                }
                break;
            case 14:
                b1.incrementStat(1, 2, gui);
                break;
            case 20, 35, 83, 128, 250, 328:
                if (!b2.isBound()) {
                    b2.setBindDauer(random.nextInt(2) + 4);
                    b2.setBound(true);
                    gui.addChatMessage("\n" + b2.getName() + " wird in einer Falle festgehalten.");
                }
                break;
            case 23, 27, 29, 44, 157, 302, 310, 239:
                if (wahrscheinlichkeit < 30) {
                    b2.setFlinched(true);
                    gui.addChatMessage("\n" + b2.getName() + " schreckt zurück.");
                }
                break;
            case 24, 155:
                angriff.setAnzahl(2);
                break;
            case 34, 122, 209, 225:
                if (b2.getStatusEffekt().getId() == 0 && wahrscheinlichkeit < 30 && !mech.istTyp(b2.getTyp(), 13)) {
                    b2.getStatusEffekt().setEffekt(3);
                    gui.addChatMessage("\n" + b2.getName() + " wurde paralysiert.");
                }
                break;
            case 38:
                if (!mech.istTyp(b2.getTyp(), 8)) {
                    b1.setHp(b1.getHp() - (schaden / 3));
                }
                if(mech.istTyp(b2.getTyp(), 8)){
                    gui.addChatMessage("\nHat leider keinen Effekt.");
                }
                break;
            case 39, 43:
                b2.decrementStat(2, 1, gui);
                break;
            case 40, 124, 188:
                if (b2.getStatusEffekt().getId() == 0 && wahrscheinlichkeit < 30 && !mech.istTyp(b2.getTyp(), 4) && !mech.istTyp(b2.getTyp(), 9)) {
                    b2.getStatusEffekt().setEffekt(4);
                    gui.addChatMessage("\n" + b2.getName() + " wurde vergiftet.");
                }
                break;
            case 41:
                angriff.setAnzahl(2);
                for (int i = 0; i < 2; i++) {
                    if (b2.getStatusEffekt().getId() == 0 && wahrscheinlichkeit < 20 && !mech.istTyp(b2.getTyp(), 4) && !mech.istTyp(b2.getTyp(), 9)) {
                        b2.getStatusEffekt().setEffekt(4);
                        gui.addChatMessage("\n" + b2.getName() + " wurde vergiftet.");
                    }
                    wahrscheinlichkeit = random.nextDouble(100);
                }
                break;
            case 45:
                b2.decrementStat(1, 1, gui);
                break;
            case 47, 79, 95, 142, 147, 320:
                if (b2.getStatusEffekt().getId() == 0) {
                    b2.getStatusEffekt().setEffekt(6);
                    gui.addChatMessage("\n" + b2.getName() + " ist eingeschlafen.");
                    b2.setSleepDauer();
                }
                break;
            case 48, 109, 186, 223, 298:
                if (!b2.isVerwirrt()) {
                    b2.setVerwirrtDauer(4, 1);
                    gui.addChatMessage("\n" + b2.getName() + " wurde verwirrt.");
                }
                break;
            case 59:
                if (b2.getStatusEffekt().getId() == 0 && wahrscheinlichkeit < 10 && !mech.istTyp(b2.getTyp(), 15)) {
                    b2.getStatusEffekt().setEffekt(2);
                    gui.addChatMessage("\n" + b2.getName() + " wurde eingefroren.");
                }
                if (wetter.getId() == 4) {
                    angriff.setGenauigkeit(-1);
                } else {
                    angriff.setGenauigkeit(70);
                }
                break;
            case 60, 93, 324:
                if (!b2.isVerwirrt() && wahrscheinlichkeit < 10) {
                    b2.setVerwirrtDauer(4, 1);
                    gui.addChatMessage("\n" + b2.getName() + " wurde verwirrt.");
                }
                break;
            case 63:
                b1.usedHyperbeam(true);
                break;
            case 67:
                if (b2.getGewicht() < 10) {
                    angriff.setPower(20);
                } else if (b2.getGewicht() < 25) {
                    angriff.setPower(40);
                } else if (b2.getGewicht() < 50) {
                    angriff.setPower(60);
                } else if (b2.getGewicht() < 100) {
                    angriff.setPower(80);
                } else if (b2.getGewicht() < 200) {
                    angriff.setPower(100);
                } else {
                    angriff.setPower(120);
                }
                break;
            case 69:
                angriff.setPower(b2.getLvl());
                break;
            case 71, 72, 141, 202:
                if (b1.getHp() + (schaden / 2) < b1.getMaxHp()) {
                    b1.setHp(b1.getHp() + (schaden / 2));
                } else {
                    b1.setHp(b1.getMaxHp());
                }
                break;
            case 74:
                b1.incrementStat(1, 1, gui);
                b1.incrementStat(3, 1, gui);
                break;
            case 77, 139:
                if (b2.getStatusEffekt().getId() == 0 && !mech.istTyp(b2.getTyp(), 4) && !mech.istTyp(b2.getTyp(), 9)) {
                    b2.getStatusEffekt().setEffekt(4);
                    gui.addChatMessage("\n" + b2.getName() + " wurde vergiftet.");
                }
                if(mech.istTyp(b2.getTyp(), 4) || mech.istTyp(b2.getTyp(), 9)){
                    gui.addChatMessage("\nHat leider keinen Effekt.");
                }
                break;
            case 78, 137, 86, 192:
                if (b2.getStatusEffekt().getId() == 0 && !mech.istTyp(b2.getTyp(), 13)) {
                    b2.getStatusEffekt().setEffekt(3);
                    gui.addChatMessage("\n" + b2.getName() + " wurde paralysiert.");
                }
                if(mech.istTyp(b2.getTyp(), 13)){
                    gui.addChatMessage("\nHat leider keinen Effekt.");
                }
                break;
            case 81, 178, 184, 196:
                b2.decrementStat(5, 2, gui);
                break;
            case 87:
                if (b2.getStatusEffekt().getId() == 0 && wahrscheinlichkeit < 30 && !mech.istTyp(b2.getTyp(), 13)) {
                    b2.getStatusEffekt().setEffekt(3);
                    gui.addChatMessage("\n" + b2.getName() + " wurde paralysiert.");
                }
                if (wetter.getId() == 2) {
                    angriff.setGenauigkeit(-1);
                } else if (wetter.getId() == 1) {
                    angriff.setGenauigkeit(50);
                } else {
                    angriff.setGenauigkeit(70);
                }
                break;
            case 92:
                if (b2.getStatusEffekt().getId() == 0 && !mech.istTyp(b2.getTyp(), 4) && !mech.istTyp(b2.getTyp(), 9)) {
                    b2.getStatusEffekt().setEffekt(5);
                    gui.addChatMessage("\n" + b2.getName() + " wurde stark vergiftet.");
                }
                if(mech.istTyp(b2.getTyp(), 4) || mech.istTyp(b2.getTyp(), 9)){
                    gui.addChatMessage("\nHat leider keinen Effekt.");
                }
                break;
            case 96, 159, 336:
                b1.incrementStat(1, 1, gui);
                break;
            case 97:
                b1.incrementStat(5, 2, gui);
                break;
            case 101:
                angriff.setPower(b1.getLvl());
                break;
            case 103:
                b2.decrementStat(2, 2, gui);
                break;
            case 105, 135, 208, 303, 355:
                if (b1.getHp() > b1.getMaxHp() / 2) {
                    b1.setHp(b1.getMaxHp());
                } else {
                    b1.setHp(b1.getMaxHp() / 2);
                }
                break;
            case 106, 110, 111:
                b1.incrementStat(2, 1, gui);
                break;
            case 112, 151:
                b1.incrementStat(2, 2, gui);
                break;
            case 113:
                b1.setLightScreen();
                break;
            case 114:
                b1.resetStats();
                break;
            case 115:
                b1.setReflect();
                break;
            case 123:
                if (b2.getStatusEffekt().getId() == 0 && wahrscheinlichkeit < 40) {
                    b2.getStatusEffekt().setEffekt(4);
                    gui.addChatMessage("\n" + b2.getName() + " wurde vergiftet.");
                }
                break;
            case 125, 158, 326:
                if (wahrscheinlichkeit < 10) {
                    b2.setFlinched(true);
                    gui.addChatMessage("\n" + b2.getName() + " schreckt zurück.");
                }
                break;
            case 127:
                if (wahrscheinlichkeit < 20) {
                    b2.setFlinched(true);
                    gui.addChatMessage("\n" + b2.getName() + " schreckt zurück.");
                }
                break;
            case 133:
                b1.incrementStat(4, 2, gui);
                break;
            case 144:
                b1 = b2;
                break;
            case 146, 352:
                if (!b2.isVerwirrt() && wahrscheinlichkeit < 20) {
                    b2.setVerwirrtDauer(4, 1);
                    gui.addChatMessage("\n" + b2.getName() + " wurde verwirrt.");
                }
                break;
            case 150:
                if (wahrscheinlichkeit < 1) {
                    angriff.setPower(100000000);
                    angriff.getTyp().setTyp(10);
                }
                break;
            case 156:
                b1.setHp(b1.getMaxHp());
                b1.setSleepDauer(2);
                b1.getStatusEffekt().setEffekt(6);
                gui.addChatMessage("\n" + b1.getName() + " ist eingeschlafen.");
                break;
            case 161:
                if (b2.getStatusEffekt().getId() == 0) {
                    if (wahrscheinlichkeit < 6.68 && !mech.istTyp(b2.getTyp(), 10)) {
                        b2.getStatusEffekt().setEffekt(1);
                        gui.addChatMessage("\n" + b2.getName() + " wurde verbrannt.");
                    } else if (wahrscheinlichkeit < 13.34 && !mech.istTyp(b2.getTyp(), 13)) {
                        b2.getStatusEffekt().setEffekt(3);
                        gui.addChatMessage("\n" + b2.getName() + " wurde paralysiert.");
                    } else if (wahrscheinlichkeit < 20 && !mech.istTyp(b2.getTyp(), 15)) {
                        b2.getStatusEffekt().setEffekt(2);
                        gui.addChatMessage("\n" + b2.getName() + " wurde eingefroren.");
                    }
                }
                break;
            case 174:
                if (mech.istTyp(b1.getTyp(), 8)) {
                    b1.setHp(b1.getHp() / 2);
                    b2.setCursed(true);
                } else {
                    b1.incrementStat(1, 1, gui);
                    b1.incrementStat(2, 1, gui);
                    b1.decrementStat(5, 1, gui);
                }
                break;
            case 175:
                indikator = (double) (48 * b1.getHp()) / b1.getMaxHp();

                if (indikator >= 0 && indikator < 2) {
                    angriff.setPower(200);
                } else if (indikator < 4) {
                    angriff.setPower(150);
                } else if (indikator < 9) {
                    angriff.setPower(100);
                } else if (indikator < 16) {
                    angriff.setPower(80);
                } else if (indikator < 32) {
                    angriff.setPower(40);
                } else {
                    angriff.setPower(20);
                }
                break;
            case 179:
                indikator = (double) b1.getHp() / b1.getMaxHp();

                if (indikator > 0.7) {
                    angriff.setPower(20);
                } else if (indikator > 0.35) {
                    angriff.setPower(40);
                } else if (indikator > 0.2) {
                    angriff.setPower(80);
                } else if (indikator > 0.1) {
                    angriff.setPower(150);
                } else {
                    angriff.setPower(200);
                }
                break;
            case 187:
                b1.setHp(b1.getMaxHp() / 2);
                b1.incrementStat(1, 6, gui);
                break;
            case 201:
                if(wetter.getId() != 3) {
                    if (mech.istTyp(b1.getTyp(), 6)) {
                        b1.setStatValue(4, (int) (b1.getStatValue(4) * 1.50));
                    }
                    if (mech.istTyp(b2.getTyp(), 6)) {
                        b2.setStatValue(4, (int) (b2.getStatValue(4) * 1.50));
                    }
                }
                wetter.setWetter(3);
                break;
            case 204, 297:
                b2.decrementStat(1, 2, gui);
                break;
            case 207:
                if (!b2.isVerwirrt()) {
                    b2.setVerwirrtDauer(4, 1);
                    gui.addChatMessage("\n" + b2.getName() + " wurde verwirrt.");
                }
                b2.incrementStat(1, 2, gui);
                break;
            case 210:
                angriff.setPower(angriff.getPower() * 2);
                break;
            case 211:
                if (wahrscheinlichkeit < 10) {
                    b1.incrementStat(2, 1, gui);
                }
                break;
            case 215, 312:
                b1.getStatusEffekt().setEffekt(0);
                gui.addChatMessage("\n" + b1.getName() + " wurde von jeglichen Statuseffekten geheilt.");
                break;
            case 217:
                if (wahrscheinlichkeit < 40) {
                    angriff.setPower(40);
                } else if (wahrscheinlichkeit < 70) {
                    angriff.setPower(80);
                } else if (wahrscheinlichkeit < 80) {
                    angriff.setPower(120);
                } else {
                    if (b2.getMaxHp() > b2.getHp() + (b2.getMaxHp() / 4)) {
                        b2.setHp(b2.getHp() + (b2.getMaxHp() / 4));
                    } else {
                        b2.setHp(b2.getMaxHp());
                    }
                }
                break;
            case 219:
                b1.setSafeguard();
                break;
            case 220:
                int split = (b1.getHp() + b2.getHp()) / 2;
                b1.setHp(split);
                b2.setHp(split);
                break;
            case 221:
                if (b2.getStatusEffekt().getId() == 0 && wahrscheinlichkeit < 50 && !mech.istTyp(b2.getTyp(), 10)) {
                    b2.getStatusEffekt().setEffekt(1);
                    gui.addChatMessage("\n" + b2.getName() + " wurde verbrannt.");

                }
                break;
            case 222:
                if (wahrscheinlichkeit < 5) {
                    angriff.setPower(10);
                } else if (wahrscheinlichkeit < 15) {
                    angriff.setPower(30);
                } else if (wahrscheinlichkeit < 35) {
                    angriff.setPower(50);
                } else if (wahrscheinlichkeit < 65) {
                    angriff.setPower(70);
                } else if (wahrscheinlichkeit < 85) {
                    angriff.setPower(90);
                } else if (wahrscheinlichkeit < 95) {
                    angriff.setPower(110);
                } else {
                    angriff.setPower(150);
                }
                break;
            case 229:
                b1.setBound(false);
                b1.setBindDauer(0);
                b1.incrementStat(5, 1, gui);
                break;
            case 230:
                b1.incrementStat(6, 1, gui);
                break;
            case 240:
                wetter.setWetter(2);
                break;
            case 241:
                wetter.setWetter(1);
                break;
            case 244:
                b1.resetStats();
                b1.setStatsAenderungen(b2.getStatsAenderungen());
                b1.statNeuRechnen();
                break;
            case 253:
                if (b1.getStatusEffekt().getId() == 6) {
                    b1.getStatusEffekt().setEffekt(0);
                    gui.addChatMessage("\n" + b1.getName() + " wurde geweckt.");
                }
                if (b2.getStatusEffekt().getId() == 6) {
                    b2.getStatusEffekt().setEffekt(0);
                    gui.addChatMessage("\n" + b2.getName() + " wurde geweckt.");
                }
                break;
            case 258:
                wetter.setWetter(4);
                break;
            case 260:
                if (!b2.isVerwirrt()) {
                    b2.setVerwirrtDauer(4, 1);
                    gui.addChatMessage("\n" + b2.getName() + " wurde verwirrt.");
                }
                b2.incrementStat(3, 1, gui);
                break;
            case 261:
                if (b2.getStatusEffekt().getId() == 0 && !mech.istTyp(b2.getTyp(), 10)) {
                    b2.getStatusEffekt().setEffekt(1);
                    gui.addChatMessage("\n" + b2.getName() + " wurde verbrannt.");
                }
                if(mech.istTyp(b2.getTyp(), 10)){
                    gui.addChatMessage("\nHat leider keinen Effekt.");
                }
                break;
            case 263:
                if (b1.getStatusEffekt().getId() == 1 || b1.getStatusEffekt().getId() == 3 || b1.getStatusEffekt().getId() == 4) {
                    angriff.setPower(angriff.getPower() * 2);
                }
                break;
            case 265:
                if (b2.getStatusEffekt().getId() == 3) {
                    angriff.setPower(angriff.getPower() * 2);
                    b2.getStatusEffekt().setEffekt(0);
                    gui.addChatMessage("\n" + b2.getName() + " ist nicht mehr paralysiert.");
                }
                break;
            case 276, 339:
                b1.incrementStat(1, 1, gui);
                b1.incrementStat(2, 1, gui);
                break;
            case 280:
                if (b2.isHatLightScreen()) {
                    b2.setLightScreenDuration(0);
                    b2.setHatLightScreen(false);
                }
                if (b2.isHatReflect()) {
                    b2.setReflectDuration(0);
                    b2.setHatReflect(false);
                }
                break;
            case 281:
                if (b2.getStatusEffekt().getId() == 0) {
                    b2.setSleepy(true);
                }
                break;
            case 283:
                if (b1.getHp() < b2.getHp()) {
                    b2.setHp(b1.getHp());
                }
                break;
            case 284, 323:
                angriff.setPower(150 * b1.getHp() / b1.getMaxHp());
                break;
            case 287:
                if (b1.getStatusEffekt().getId() == 1 || b1.getStatusEffekt().getId() == 3 || b1.getStatusEffekt().getId() == 4){
                    b1.getStatusEffekt().setEffekt(0);
                    gui.addChatMessage("\n" + b1.getName() + " wurde von seinem Statuseffekt geheilt.");
                }
                break;
            case 294:
                b1.incrementStat(3,3, gui);
                break;
            case 299:
                b1.incrementCritStage();
                if (b2.getStatusEffekt().getId() == 0 && wahrscheinlichkeit < 10 && !mech.istTyp(b2.getTyp(), 10)) {
                    b2.getStatusEffekt().setEffekt(1);
                    gui.addChatMessage("\n" + b2.getName() + " wurde verbrannt.");
                }
                break;
            case 305:
                if (b2.getStatusEffekt().getId() == 0 && wahrscheinlichkeit < 50 && !mech.istTyp(b2.getTyp(), 4) && !mech.istTyp(b2.getTyp(), 9)) {
                    b2.getStatusEffekt().setEffekt(5);
                    gui.addChatMessage("\n" + b2.getName() + " wurde stark vergiftet.");
                }
                break;
            case 313, 319:
                b2.decrementStat(4,2, gui);
                break;
            case 315:
                b1.decrementStat(3,2, gui);
                break;
            case 317, 341:
                b2.decrementStat(5,1, gui);
                break;
            case 321:
                b2.decrementStat(1,1, gui);
                b2.decrementStat(2,1, gui);
                break;
            case 322:
                b1.incrementStat(2,1, gui);
                b1.incrementStat(4,1, gui);
                break;
            case 342:
                b1.incrementCritStage();
                if (b2.getStatusEffekt().getId() == 0 && wahrscheinlichkeit < 50 && !mech.istTyp(b2.getTyp(), 4) && !mech.istTyp(b2.getTyp(), 9)) {
                    b2.getStatusEffekt().setEffekt(5);
                    gui.addChatMessage("\n" + b2.getName() + " wurde stark vergiftet.");
                }
                break;
            case 347:
                b1.incrementStat(3,1, gui);
                b1.incrementStat(4,1, gui);
                break;
            case 349:
                b1.incrementStat(1,1, gui);
                b1.incrementStat(5,1, gui);
                break;
            case 354:
                b1.incrementStat(3,2, gui);
                break;
        }
    }

    public void warum2(Buddy b1, Buddy b2, Angriff angriff, Wetter wetter, int schaden, GUI gui){

        double indikator = 0;
        Random random = new Random();
        double wahrscheinlichkeit = random.nextDouble(100);

        switch(angriff.getId()){
            case 2, 75, 152, 163, 177, 238, 299, 314, 342, 348:
                b1.decrementCritStage();
                break;
            case 36, 66:
                if (!mech.istTyp(b2.getTyp(), 8)) {
                    b1.setHp(b1.getHp() - (schaden / 4));
                }
                if(mech.istTyp(b2.getTyp(), 8)){
                    gui.addChatMessage("\nHat leider keinen Effekt.");
                }
                break;
            case 51, 94:
                if (wahrscheinlichkeit < 10) {
                    b2.decrementStat(4, 1, gui);
                }
                break;
            case 61, 132, 145:
                if (wahrscheinlichkeit < 10) {
                    b2.decrementStat(5, 1, gui);
                }
                break;
            case 62:
                if (wahrscheinlichkeit < 10) {
                    b2.decrementStat(1, 1, gui);
                }
                break;
            case 120, 153:
                b1.setHp(0);
                break;
            case 138:
                if(b1.getHp() + (schaden/2) < b1.getMaxHp()){
                    b1.setHp(b1.getHp() + (schaden/2));
                }   else {
                    b1.setHp(b1.getMaxHp());
                }
                break;
            case 156:
            case 231:
                if (wahrscheinlichkeit < 30) {
                    b2.decrementStat(2, 1, gui);
                }
                break;
            case 232:
                if (wahrscheinlichkeit < 10) {
                    b1.incrementStat(1, 1, gui);
                }
                break;
            case 246, 318:
                if (wahrscheinlichkeit < 10) {
                    for (int i = 1; i < 6; i++) {
                        b1.incrementStat(i, 1, gui);
                    }
                }
                break;
            case 247:
                if (wahrscheinlichkeit < 20) {
                    b2.decrementStat(4, 1, gui);
                }
                break;
            case 249, 306:
                if (wahrscheinlichkeit < 50) {
                    b2.decrementStat(2, 1, gui);
                }
                break;
            case 242:
                if (wahrscheinlichkeit < 20) {
                    b2.decrementStat(2, 1, gui);
                }
                break;
            case 263, 265:
                angriff.setPower(70);
                break;
            case 295:
                if(wahrscheinlichkeit < 50){
                    b2.decrementStat(4,1, gui);
                }
                break;
            case 296:
                if(wahrscheinlichkeit < 50){
                    b2.decrementStat(3,1, gui);
                }
                break;
            case 309:
                if(wahrscheinlichkeit < 20){
                    b1.incrementStat(1,1, gui);
                }
                break;
            case 344:
                if (b2.getStatusEffekt().getId() == 0 && wahrscheinlichkeit < 10 && !mech.istTyp(b2.getTyp(), 13)) {
                    b2.getStatusEffekt().setEffekt(3);
                    gui.addChatMessage("\n" + b2.getName() + " wurde paralysiert");
                }
                b1.setHp(b1.getHp() - (schaden / 3));
                break;
        }
    }
}
