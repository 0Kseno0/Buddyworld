package main.klassen;
import main.SQL;
import java.sql.SQLException;
import java.util.Vector;

public class Buddy {

    SQL sql = new SQL();

    private int lvl;
    private int hp;
    private int id;
    private String name;
    private Angriff[] angriffe = new Angriff[4];
    private Vector<Typ> typ = new Vector<Typ>();
    private double[] stats = new double[7];

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void holeTyp() throws SQLException{

        typ = sql.getTyp(id);
    }

    public Vector<Typ> getTyp() {
        return typ;
    }

    public void setTyp(Vector<Typ> typ) {
        this.typ = typ;
    }

    public void zufaelligeAngriffe() throws SQLException {
        angriffe = sql.getAngriffeAusListe(id);
    }

    public Angriff[] getAngriffe() {
        return angriffe;
    }

    public void setAngriffe(Angriff[] angriffe) {
        this.angriffe = angriffe;
    }

    public void ansichtAngriffe(){
        for(int i = 0; i < 4; i++){

            System.out.println(angriffe[i].getName());
            System.out.println("\tPP: " + angriffe[i].getPp());
            System.out.println("\tPower: " + angriffe[i].getPower());
            System.out.println("\tTyp: " + angriffe[i].getTyp().getName());
            System.out.println("\tAcc: " + angriffe[i].getGenauigkeit() + "%");
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getStats() {
        return stats;
    }

    public void setStats(double[] stats) {
        this.stats = stats;
    }

    public void setStat(int index, double value){
        if(index >= 0 && index < stats.length){
            stats[index] = value;
        }   else {
            System.out.println("Invalider Index");
        }
    }
}
