package main;

import main.klassen.*;

public class Kampf {
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

        if(b1.getPrio() > b2.getPrio()){
            durchlauf(b1, b2, w);
        }   else{
            durchlauf(b2, b1, w);
        }

        if(w.getDauer() > 1){
            w.setDauer(w.getDauer()-1);

            if(w.getDauer() == 0){
                w.setId(0);
                w.setName("");
            }
        }

    }

    public void durchlauf(Buddy b1, Buddy b2, Wetter w){

        //b1 erster Angreifer


    }

    public void statusEffektAktion(Buddy b){

        if(b.getStatusEffekt().getId() > 1){
            if(b.getHp() > b.getMaxHp()/8){
                b.setHp(b.getMaxHp()/8);
            }   else{
                b.setHp(0);
            }
        }   else if(b.getStatusEffekt().getId() > 4){

        }
    }
}
