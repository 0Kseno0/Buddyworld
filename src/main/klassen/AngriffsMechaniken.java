package main.klassen;

import java.util.Random;

public class AngriffsMechaniken {

    Mechaniken mech = new Mechaniken();

    public void warum(Buddy b1, Buddy b2, Angriff angriff, Wetter wetter, int schaden){

        //b1 Angreifer, b2 Verteidiger, angriff Angriff von b1

        double indikator = 0;
        Random random = new Random();
        double wahrscheinlichkeit = random.nextDouble(100);
        boolean istTyp[] = new boolean[19];
        for(int i = 0; i < istTyp.length; i++){
            istTyp[i] = false;
        }

        switch(angriff.getId()){
            case 2, 75, 116, 152, 163, 177:
                b1.incrementCritStage();
                break;
            case 3, 4, 31, 42, 131, 140, 154, 198:
                angriff.randomAnzahl(4,2);
                break;
            case 7, 52, 53, 126, 172:
                if(!b2.getStatusEffekt().hatEffekt() && wahrscheinlichkeit < 10){
                    b2.getStatusEffekt().setEffekt(1);
                }
                break;
            case 8, 58, 181:
                if(!b2.getStatusEffekt().hatEffekt() && wahrscheinlichkeit < 10){
                    b2.getStatusEffekt().setEffekt(2);
                }
                break;
            case 9, 84, 85:
                if(!b2.getStatusEffekt().hatEffekt() && wahrscheinlichkeit < 10){
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
                b1.incrementStat(1,2);
                break;
            case 16:
                if(b2.isBFS()){
                    angriff.setPower(angriff.getPower()*2);
                }
                break;
            case 19:
                b1.setBFS(!b1.isBFS());
                break;
            case 20, 35, 83, 128:
                if(!b2.isBound()){
                    b2.setBindDauer(random.nextInt(2) + 4);
                }
                break;
            case 23, 27, 29, 44, 157:
                if(wahrscheinlichkeit < 30){
                    b2.setFlinched(true);
                }
                break;
            case 24, 155:
                angriff.setAnzahl(2);
                break;
            case 28, 108, 134, 148, 189:
                b2.decrementStat(6,1);
                break;
            case 34, 122:
                if(!b2.getStatusEffekt().hatEffekt() && wahrscheinlichkeit < 30){
                    b2.getStatusEffekt().setEffekt(3);
                }
                break;
            case 36, 66:
                if(!mech.istTyp(b2.getTyp(),8)){
                    b1.setHp(b1.getHp() - (schaden/4));
                }
                break;
            case 37, 80, 200:
                if(!b1.isThrashing()){
                    b1.setThrashingDauer();
                    b1.setThrashing(true);
                }   else{
                    if(b1.getThrashingDauer() > 0){
                        b1.setThrashingDauer(b1.getThrashingDauer() - 1);
                    }
                }
                break;
            case 38:
                if(!mech.istTyp(b2.getTyp(),8)){
                    b1.setHp(b1.getHp() - (schaden/3));
                }
                break;
            case 39, 43:
                b2.decrementStat(2,1);
                break;
            case 40, 124, 188:
                if(!b2.getStatusEffekt().hatEffekt() && wahrscheinlichkeit < 30 && !mech.istTyp(b2.getTyp(),4) || !mech.istTyp(b2.getTyp(), 9)){
                    b2.getStatusEffekt().setEffekt(4);
                }
                break;
            case 41:
                angriff.setAnzahl(2);
                for(int i = 0; i < 2; i++) {
                    if(!b2.getStatusEffekt().hatEffekt() && wahrscheinlichkeit < 20 && !mech.istTyp(b2.getTyp(),4) || !mech.istTyp(b2.getTyp(), 9)){
                        b2.getStatusEffekt().setEffekt(4);
                    }
                    wahrscheinlichkeit = random.nextDouble(100);
                }
                break;
            case 45:
                b2.decrementStat(1,1);
                break;
            case 47, 79, 95, 142, 147:
                if(!b2.getStatusEffekt().hatEffekt()) {
                    b2.getStatusEffekt().setEffekt(6);
                    b2.setSleepDauer();
                }
                break;
            case 48, 109, 186:
                if(!b2.isVerwirrt()) {
                    b2.setVerwirrt(true);
                    b2.setVerwirrtDauer(4,1);
                }
                break;
            case 49:
                if(!mech.istTyp(b2.getTyp(),8)){
                    b2.setHp(b2.getHp()-20);
                }
                break;
            case 51, 94:
                if(wahrscheinlichkeit < 10){
                    b2.decrementStat(4,1);
                }
                break;
            case 57:
                if(b2.isDive()){
                    angriff.setPower(angriff.getPower()*2);
                }
                break;
            case 59:
                if(!b2.getStatusEffekt().hatEffekt() && wahrscheinlichkeit < 10){
                    b2.getStatusEffekt().setEffekt(2);
                }
                if(wetter.getId() == 4){
                    angriff.setGenauigkeit(-1);
                }   else {
                    angriff.setGenauigkeit(70);
                }
                break;
            case 60, 93:
                if(!b2.isVerwirrt() && wahrscheinlichkeit < 10) {
                    b2.setVerwirrt(true);
                    b2.setVerwirrtDauer(4,1);
                }
                break;
            case 61, 132, 145:
                if(wahrscheinlichkeit < 10){
                    b2.decrementStat(5,1);
                }
                break;
            case 62:
                if(wahrscheinlichkeit < 10){
                    b2.decrementStat(1,1);
                }
                break;
            case 63:
                b1.usedHyperbeam(true);
                break;
            case 67:
                if(b2.getGewicht()  < 10){
                    angriff.setPower(20);
                }   else if(b2.getGewicht() < 25){
                    angriff.setPower(40);
                }   else if(b2.getGewicht() < 50){
                    angriff.setPower(60);
                }   else if(b2.getGewicht() < 100){
                    angriff.setPower(80);
                }   else if(b2.getGewicht() < 200){
                    angriff.setPower(100);
                }   else{
                    angriff.setPower(120);
                }
                break;
            case 69:
                angriff.setPower(b2.getLvl());
                break;
            case 71, 72, 141, 202:
                if(b1.getHp() + (schaden/2) < b1.getMaxHp()) {
                    b1.setHp(b1.getHp() + (schaden / 2));
                }   else {
                    b1.setHp(b1.getMaxHp());
                }
                break;
            case 74:
                b1.incrementStat(1,1);
                b1.incrementStat(3,1);
                break;
            case 76:
                if(wetter.getId() == 1){
                    b1.setCharging(!b1.isCharging());
                }
                break;
            case 77, 139:
                if(!b2.getStatusEffekt().hatEffekt() && !mech.istTyp(b2.getTyp(),4) || !mech.istTyp(b2.getTyp(), 9)){
                    b2.getStatusEffekt().setEffekt(4);
                }
                break;
            case 78, 137:
                if(!b2.getStatusEffekt().hatEffekt() && !mech.istTyp(b2.getTyp(), 13)){
                    b2.getStatusEffekt().setEffekt(3);
                }
                break;
            case 81, 178, 184, 196:
                b2.decrementStat(5,2);
                break;
            case 82:
                b2.setHp(b2.getHp() - 40);
                break;
            case 86, 192:
                if(!b2.getStatusEffekt().hatEffekt()){
                    b2.getStatusEffekt().setEffekt(3);
                }
                break;
            case 87:
                if(!b2.getStatusEffekt().hatEffekt() && wahrscheinlichkeit < 30){
                    b2.getStatusEffekt().setEffekt(3);
                }
                if(wetter.getId() == 2){
                    angriff.setGenauigkeit(-1);
                }   else if(wetter.getId() == 1){
                    angriff.setGenauigkeit(50);
                }    else{
                    angriff.setGenauigkeit(70);
                }
                break;
            case 89:
                if(b2.isDig()){
                    angriff.setPower(angriff.getPower()*2);
                }
                break;
            case 91:
                b1.setDig(!b1.isDig());
                break;
            case 92:
                if(!b2.getStatusEffekt().hatEffekt()){
                    b2.getStatusEffekt().setEffekt(5);
                }
                break;
            case 96, 159:
                b1.incrementStat(1,1);
                break;
            case 97:
                b1.incrementStat(5,2);
                break;
            case 98, 183:
                b1.incrementPrio();
                break;
            case 101:
                angriff.setPower(b1.getLvl());
                break;
            case 103:
                b2.decrementStat(2,2);
                break;
            case 105, 135:
                if(b1.getHp() > b1.getMaxHp()/2){
                    b1.setHp(b1.getMaxHp());
                }   else{
                    b1.setHp(b1.getMaxHp()/2);
                }
                break;
            case 106, 110, 111:
                b1.incrementStat(2,1);
                break;
            case 112,151:
                b1.incrementStat(2,2);
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
                if(!b2.getStatusEffekt().hatEffekt() && wahrscheinlichkeit < 40){
                    b2.getStatusEffekt().setEffekt(4);
                }
                break;
            case 125, 158:
                if(wahrscheinlichkeit < 10){
                    b2.setFlinched(true);
                }
                break;
            case 127:
                if(wahrscheinlichkeit < 20){
                    b2.setFlinched(true);
                }
                break;
            case 129, 185:
                angriff.setGenauigkeit(-1);
                break;
            case 130:
                if(!b1.isCharging()){
                    b1.incrementStat(2,1);
                }
                b1.setCharging(!b1.isCharging());
                break;
            case 133:
                b1.incrementStat(4,2);
                break;
            case 138:
                if(b2.getStatusEffekt().getId() == 6){
                    angriff.setPower(100);
                }   else {
                    angriff.setPower(0);
                }
                break;
            case 144:
                b1 = b2;
                break;
            case 146:
                if(!b2.isVerwirrt() && wahrscheinlichkeit < 20) {
                    b2.setVerwirrt(true);
                    b2.setVerwirrtDauer(4,1);
                }
                break;
            case 149:
                double multiplikator = random.nextDouble(1) + 0.5;
                b2.setHp(b2.getHp() - (int)(b2.getLvl()*multiplikator));
                break;
            case 150:
                if(wahrscheinlichkeit < 1){
                    angriff.setPower(100000000);
                    angriff.getTyp().setTyp(10);
                }
                break;
            case 156:
                b1.setHp(b1.getMaxHp());
                b1.setSleepDauer(2);
                b1.getStatusEffekt().setEffekt(6);
                break;
            case 161:
                if(!b2.getStatusEffekt().hatEffekt()) {
                    if (wahrscheinlichkeit < 6.68 && !mech.istTyp(b2.getTyp(), 10)) {
                        b2.getStatusEffekt().setEffekt(1);
                    } else if (wahrscheinlichkeit < 13.34 && !mech.istTyp(b2.getTyp(), 13)) {
                        b2.getStatusEffekt().setEffekt(3);
                    } else if (wahrscheinlichkeit < 20 && !mech.istTyp(b2.getTyp(), 15)) {
                        b2.getStatusEffekt().setEffekt(2);
                    }
                }
                break;
            case 162:
                b2.setHp(b2.getHp()/2);
                break;
            case 173:
                if(b1.getStatusEffekt().getId() == 6){
                    angriff.setPower(50);
                    if(wahrscheinlichkeit < 10){
                        b2.setFlinched(true);
                    }
                }   else{
                    angriff.setPower(0);
                }
                break;
            case 174:
                if(mech.istTyp(b1.getTyp(), 8)){
                    b1.setHp(b1.getHp()/2);
                    b2.setCursed(true);
                }   else{
                    b1.incrementStat(1,1);
                    b1.incrementStat(2,1);
                    b1.decrementStat(5,1);
                }
                break;
            case 175:
                indikator = (48 * b1.getHp()) / b1.getMaxHp();

                if(indikator >= 0 && indikator < 2){
                    angriff.setPower(200);
                }   else if(indikator < 4){
                    angriff.setPower(150);
                }   else if(indikator < 9){
                    angriff.setPower(100);
                }   else if(indikator < 16){
                    angriff.setPower(80);
                }   else if(indikator < 32){
                    angriff.setPower(40);
                }   else{
                    angriff.setPower(20);
                }
                break;
            case 179:
                indikator = b1.getHp() / b1.getMaxHp();

                if(indikator > 0.7){
                    angriff.setPower(20);
                }   else if(indikator > 0.35){
                    angriff.setPower(40);
                }   else if(indikator > 0.2){
                    angriff.setPower(80);
                }   else if(indikator > 0.1){
                    angriff.setPower(150);
                }   else {
                    angriff.setPower(200);
                }
                break;
            case 187:
                b1.setHp(b1.getMaxHp()/2);
                b1.incrementStat(1,6);
                break;
            case 190:
                if(wahrscheinlichkeit < 50){
                    b2.decrementStat(6,1);
                }
                break;

        }
    }

    public void warum2(Buddy b1, Buddy b2, Angriff angriff, Wetter wetter, int schaden){
        switch(angriff.getId()){
            case 2, 75, 152, 163, 177:
                b1.decrementCritStage();
                break;
            case 13:
                if(!b1.isCharging()){
                    b1.decrementCritStage();
                }
                break;
            case 16:
                if(b2.isBFS()){
                    angriff.setPower(angriff.getPower()/2);
                }
                break;
            case 19:
                b1.setBFS(b1.isBFS());
                break;
            case 37, 80, 200:
                if(b1.getThrashingDauer() == 0 && b1.isThrashing()){
                    b1.setThrashing(false);
                    b1.setVerwirrtDauer(4,1);
                    b1.setVerwirrt(true);
                }
                break;
            case 57:
                if(b2.isDive()){
                    angriff.setPower(angriff.getPower()/2);
                }
                break;
            case 89:
                if(b2.isDig()){
                    angriff.setPower(angriff.getPower()/2);
                }
                break;
            case 98, 183:
                b1.decrementPrio();
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
        }
    }
}
