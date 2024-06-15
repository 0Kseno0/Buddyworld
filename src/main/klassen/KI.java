package main.klassen;

import java.util.Random;

public class KI {

    Mechaniken mech = new Mechaniken();

    public KI(){

    }

    public Angriff angriffAuswahl(Buddy b1, Buddy b2, Angriff[] a, Wetter w){
        //b1 -> KI

        int index = 0;
        Random random = new Random();
        boolean hatWetter = false;
        int wetterId = 0;

        double wahrscheinlichkeit = random.nextDouble(100);

        if(b1.getHp() > (b1.getMaxHp() * 0.80)) {
            if (mech.istTyp(b1.getTyp(), 11) && hatAngriff(a, 240) && w.getId() != 2) {
                hatWetter = true;
                wetterId = 240;
            }   else if(mech.istTyp(b1.getTyp(), 10) && hatAngriff(a, 241) && w.getId() != 1){
                hatWetter = true;
                wetterId = 241;
            }   else if(mech.istTyp(b1.getTyp(), 6) && hatAngriff(a, 201) && w.getId() != 3){
                hatWetter = true;
                wetterId = 201;
            }   else if(mech.istTyp(b1.getTyp(), 15) && hatAngriff(a, 258) && w.getId() !=4){
                hatWetter = true;
                wetterId = 258;
            }
        }

        if(hatWetter){
            if(b2.getHp() < (b2.getMaxHp() * 0.40)){
                return a[staerksterAngriffId(a, b2)];
            }   else{
                return a[angriffId(a, wetterId)];
            }
        }   else if(wahrscheinlichkeit < 75){
            return a[staerksterAngriffId(a, b2)];
        }   else{
            return a[random.nextInt(4)];
        }
    }

    public boolean hatAngriff(Angriff[] angriffe, int id){
        for(Angriff a : angriffe){
            if(a.getId() == id){
                return true;
            }
        }
        return false;
    }

    public int angriffId(Angriff[] angriffe, int id){
        for(int i = 0; i < angriffe.length; i++){
            if(angriffe[i].getId() == id) return i;
        }
        return 0;
    }

    public int staerksterAngriffId(Angriff[] angriffe, Buddy b){
        double effektivitaet = 0;
        int schaden = 0;
        int id = 0, dId1 = 0, dId2 = 0;

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

        for(int i = 0; i < angriffe.length; i++){
            if(mech.getEffektivitaet(angriffe[i].getTyp().getId(), dId1, dId2) > effektivitaet){
                id = i;
                effektivitaet = mech.getEffektivitaet(angriffe[i].getTyp().getId(), dId1, dId2);
                schaden = angriffe[i].getPower();
            }   else if(mech.getEffektivitaet(angriffe[i].getTyp().getId(), dId1, dId2) == effektivitaet){
                if(angriffe[i].getPower() > schaden){
                    id = i;
                    effektivitaet = mech.getEffektivitaet(angriffe[i].getTyp().getId(), dId1, dId2);
                    schaden = angriffe[i].getPower();
                }
            }
        }
        return id;
    }
}
