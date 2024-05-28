package main.klassen;

public class Wetter {

    int id;
    String name;
    int dauer;

    /*
    sun -> feuer +50% wasser -50% | solar beam keinen recharge
    rain -> wasser +50% feuer -50% | thunder und hurricane treffen immer
    sand -> gestein +50% Sp. DEF | Gestein, Boden und Stahl kriegen keinen Wetterschaden (1/16 der MAX HP)
    hail -> Eis kriegt keinen Wetterschaden (1/16 der MAX HP)

    -> alle Wettereffekte halten 5 Runden
     */

    public void setWetter(int id){
        this.id = id;
        setName(id);
        setDauer();
    }
    public void setName(int id) {
        switch (id) {
            case 0 -> setName("normal");
            case 1 -> setName("sun");
            case 2 -> setName("rain");
            case 3 -> setName("sand");
            case 4 -> setName("hail");
        }
    }

    public void setId(String name){
        switch(name){
            case "normal" -> setId(0);
            case "sun" -> setId(1);
            case "rain" -> setId(2);
            case "sand" -> setId(3);
            case "hail" -> setId(4);
        }
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public void setDauer(){
        this.dauer = 5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
