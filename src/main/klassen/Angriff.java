package main.klassen;

public class Angriff {
//
    public Angriff(){

    }
     private int id;
     private String name;
     private Typ typ;
     private int power;
     private int pp;
     private int genauigkeit;
     // 0 = Statusaenderung, 1 = physisch, 2 = spezial
     private int kategorie = -1;

    public int getKategorie() {
        return kategorie;
    }

    public void setKategorie(int kategorie) {
        this.kategorie = kategorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Typ getTyp() {
        return typ;
    }

    public void setTyp(Typ typ) {
        this.typ = typ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getGenauigkeit() {
        return genauigkeit;
    }

    public void setGenauigkeit(int genauigkeit) {
        this.genauigkeit = genauigkeit;
    }
}
