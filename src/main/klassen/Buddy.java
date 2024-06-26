package main.klassen;
import main.GUI;
import main.SQL;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;
import java.util.Random;

public class Buddy {

    SQL sql = new SQL();

    private int lvl = 50;
    private int hp;
    private int id;
    private String name;
    private int gewicht;
    private int prio;
    private Angriff[] angriffe = new Angriff[4];
    private Vector<Typ> typ = new Vector<Typ>();
    private int[] statsAenderungen = new int[7];
    private int[] stats = new int[7];
    private double[] baseStats = new double[7];
    private int[] IVs = new int[6];
    private final Nature nature;
    private StatusEffekt statusEffekt;
    private int critStage;
    private boolean isBound;
    private int bindDauer;
    private boolean isFlinched;
    private boolean isVerwirrt;
    private int verwirrtDauer;
    private boolean isSleepy;
    private int sleepDauer;
    private boolean usedHyperbeam;
    private boolean isCursed;
    private boolean hatLightScreen;
    private int lightScreenDuration;
    private boolean hatReflect;
    private int reflectDuration;
    private boolean hatSafeguard;
    private int safeguardDauer;
    private int badlyPoisonedDauer;
    private boolean kannAngreifen;

    enum Nature{
        HARDY(-1, -1),
        LONELY(1, 2),
        BRAVE(1, 5),
        ADAMANT(1, 3),
        NAUGHTY(1, 4),
        BOLD(2, 1),
        DOCILE(-1, -1),
        RELAXED(2, 5),
        IMPISH(2, 3),
        LAX(2, 4),
        TIMID(5, 1),
        HASTY(5, 2),
        SERIOUS(-1, -1),
        JOLLY(5, 3),
        NAIVE(5, 4),
        MODEST(3, 1),
        MILD(3, 2),
        QUIET(3, 5),
        BASHFUL(-1, -1),
        RASH(3, 4),
        CALM(4, 1),
        GENTLE(4, 2),
        SASSY(4, 5),
        CAREFUL(4, 3),
        QUIRKY(-1, -1);

        private final int increasedStat;
        private final int decreasedStat;

        Nature(int increasedStat, int decreasedStat) {
            this.increasedStat = increasedStat;
            this.decreasedStat = decreasedStat;
        }

        public int getIncreasedStat() {
            return increasedStat;
        }

        public int getDecreasedStat() {
            return decreasedStat;
        }
    }

    public Buddy(){
        for(Angriff angriff: angriffe){
            angriff = new Angriff();
        }
        isVerwirrt = false;

        prio = 0;
        Random random = new Random();
        statusEffekt = new StatusEffekt();
        for(int i = 0; i < IVs.length; i++){
            IVs[i] = random.nextInt(32);
        }
        nature = Nature.values()[random.nextInt(Nature.values().length)];
    }

    public int getMaxHp(){
        return hp;
    }

    public void setMaxHp(int hp){
        this.hp = hp;
    }

    public int getHp() {
        return stats[0];
    }

    public void setHp(int hp) {
        this.stats[0] = hp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
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

    public void getAngriffsListe() throws SQLException{
        Vector<String> angriffe = sql.getAngriffsListe(id);

        int position = 1;

        for(String angriff : angriffe){
            System.out.println(position++ + " " + angriff);
        }
    }

    public void angriffAuswahl() throws SQLException {

        sql.ansichtAngriffe(id);

        Scanner scanner = new Scanner(System.in);

        Vector<Integer> moeglich = sql.angriffsListeId(id);
        Vector<Integer> schonEingegeben = new Vector<>();
        int eingabe;

        Angriff ausgewaehlteAngriffe[] = new Angriff[4];

        for(Angriff angriff: ausgewaehlteAngriffe){
            angriff = new Angriff();
        }

        for(int i = 0; i < 4;){

            eingabe = scanner.nextInt();

            if(moeglich.contains(eingabe)){

                if(!schonEingegeben.contains(eingabe)){

                    schonEingegeben.add(eingabe);
                    ausgewaehlteAngriffe[i] = sql.angriffAuswahl(eingabe, id);
                    i++;

                }   else{
                    System.out.println("Schon ausgewaehlt!");
                }
            }   else{
                System.out.println("Dieser Buddy kann diesen Angriff nicht lernen!");
            }
        }

        for(Angriff angriff : ausgewaehlteAngriffe){
            angriff.setName(angriff.getName().replace("-", " "));
        }

        setAngriffe(ausgewaehlteAngriffe);

    }

    public void angriffParameterWahl(int[] angriffIds) throws SQLException{
        for(int i = 0; i < 4; i++){
            angriffe[i] = sql.findeAngriffDurchId(angriffIds[i]);
        }
    }

    public void zufaelligeAngriffe() throws SQLException {

        Vector<Angriff> ausgewaehlteAngriffe = sql.getAngriffeAusListe(id);

        for(int i = 0; i < 4; i++){
            angriffe[i] = ausgewaehlteAngriffe.elementAt(i);
            angriffe[i].setName(angriffe[i].getName().replace("-"," "));
        }

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
            System.out.println("\tKategorie: " + angriffe[i].getKategorie());
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

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }

    public void incrementPrio(){
        this.prio++;
    }

    public void decrementPrio(){
        if(this.prio > 0) {
            this.prio--;
        }
    }

    public double[] getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(double[] baseStats) {
        this.baseStats = baseStats;
    }

    public void setBaseStat(int index, double wert){
        if(index >= 0 && index < baseStats.length){
            baseStats[index] = wert;
        }   else {
            System.out.println("Invalider Index");
        }
    }

    public void printBaseStats(){

        System.out.println("HP:      " + (int) baseStats[0]);
        System.out.println("ATK:     " + (int) baseStats[1]);
        System.out.println("DEF:     " + (int) baseStats[2]);
        System.out.println("SP. ATK: " + (int) baseStats[3]);
        System.out.println("SP. DEF: " + (int) baseStats[4]);
        System.out.println("SPEED:   " + (int) baseStats[5]);
        System.out.println("ACC:     " + (int) baseStats[6]);

    }

    public int[] getIVs() {
        return IVs;
    }

    public void setIVs(int[] IVs) {
        this.IVs = IVs;
    }

    public void printIV(){
        for(int i = 0; i < IVs.length; i++){
            System.out.println(IVs[i]);
        }
    }

    public void multiplyStat(int index, int menge){
        stats[index] = stats[index] * menge;
    }

    public void divideStat(int index, int menge){
        stats[index] = stats[index] / menge;
    }

    public int[] getStats() {
        return stats;
    }

    public void setStats(int[] stats) {
        this.stats = stats;
    }

    public void calculateStats(){

        stats[0] = (int) ((((2 * baseStats[0] + IVs[0]) * lvl) / 100) + lvl + 10);
        hp = stats[0];

        for(int i = 1; i < 6; i++){
            if(i == nature.getIncreasedStat()){
                stats[i] = (int) (((((2 * baseStats[i] + IVs[i]) * lvl) / 100) + 5) * 1.1);
            }   else if(i == nature.getDecreasedStat()){
                stats[i] = (int) (((((2 * baseStats[i] + IVs[i]) * lvl) / 100) + 5) * 0.9);
            }   else{
                stats[i] = (int) ((((2 * baseStats[i] + IVs[i]) * lvl) / 100) + 5);
            }
        }

        stats[6] = 1;
    }

    public void statNeuRechnen(){
        hp = stats[0];
        calculateStats();
        stats[0] = hp;

        for(int i = 1; i < 6; i++){
            if(statsAenderungen[i] > 0){
                incrementStatOhneNachricht(i, statsAenderungen[i]);
            }   else if(statsAenderungen[i] < 0){
                decrementStatOhneNachricht(i, statsAenderungen[i]);
            }
        }
    }

    public void incrementCritStage(){
        if(critStage < 3){
            critStage++;
        }
    }

    public void decrementCritStage(){
        if(critStage > 0){
            critStage--;
        }
    }

    public void incrementStat(int index, int menge, GUI gui) {

        String stat = "";
        String staerke = "";

        stat = switch (index) {
            case 1 -> "\nAngriff ";
            case 2 -> "\nVerteidigung ";
            case 3 -> "\nSpezial Angriff ";
            case 4 -> "\nSpezial Verteidigung ";
            case 5 -> "\nGeschwindigkeit ";
            default -> stat;
        };

        staerke = switch (menge) {
            case 1 -> " erhöht.";
            case 2 -> " stark erhöht.";
            case 3 -> " drastisch erhöht.";
            case 12 -> " maxmiert.";
            default -> staerke;
        };

        gui.addChatMessage(stat + "wurde" + staerke);

        if (index < 1 || index > 6) {
            throw new IllegalArgumentException("Index muss zwischen 0 und 7 liegen");
        }

        for(; menge > 0; menge--) {
            if (statsAenderungen[index] < 6) {
                statsAenderungen[index]++;
                stats[index] += (int) (stats[index] * 0.5);
            }
        }
    }

    public void decrementStat(int index, int menge, GUI gui) {

        String stat = "";
        String staerke = "";

        stat = switch (index) {
            case 1 -> "\nAngriff ";
            case 2 -> "\nVerteidigung ";
            case 3 -> "\nSpezial Angriff ";
            case 4 -> "\nSpezial Verteidigung ";
            case 5 -> "\nGeschwindigkeit ";
            default -> stat;
        };

        staerke = switch (menge) {
            case 1 -> " verringert.";
            case 2 -> " stark verringert.";
            default -> staerke;
        };

        gui.addChatMessage(stat + "wurde" + staerke);

        if (index < 1 || index > 6) {
            throw new IllegalArgumentException("Index muss zwischen 0 und 7 sein");
        }

        for(; menge > 0; menge--) {
            if (statsAenderungen[index] > -6) {
                statsAenderungen[index]--;
                stats[index] -= (int) (stats[index] * 0.5);
            }
        }
    }

    public void incrementStatOhneNachricht(int index, int menge) {

        if (index < 1 || index > 6) {
            throw new IllegalArgumentException("Index muss zwischen 0 und 7 liegen");
        }

        for(; menge > 0; menge--) {
            if (statsAenderungen[index] < 6) {
                statsAenderungen[index]++;
                stats[index] += (int) (stats[index] * 0.5);
            }
        }
    }

    public void decrementStatOhneNachricht(int index, int menge) {

        if (index < 1 || index > 6) {
            throw new IllegalArgumentException("Index muss zwischen 0 und 7 sein");
        }

        for(; menge > 0; menge--) {
            if (statsAenderungen[index] > -6) {
                statsAenderungen[index]--;
                stats[index] -= (int) (stats[index] * 0.5);
            }
        }
    }

    public void printStats(){

        System.out.println("HP:      " + stats[0]);
        System.out.println("ATK:     " + stats[1]);
        System.out.println("DEF:     " + stats[2]);
        System.out.println("SP. ATK: " + stats[3]);
        System.out.println("SP. DEF: " + stats[4]);
        System.out.println("SPEED:   " + stats[5]);
        System.out.println("ACC:     " + stats[6]);

    }

    public int getStatAenderung(int index){
        return statsAenderungen[index];
    }

    public int getStatValue(int index){
        return stats[index];
    }

    public void setStatValue(int index, int value){
        stats[index] = value;
    }

    public void printNature(){
        System.out.println(nature.getIncreasedStat());
        System.out.println(nature.getDecreasedStat());
    }

    public Nature getNature() {
        return nature;
    }

    public StatusEffekt getStatusEffekt() {
        return statusEffekt;
    }

    public void setStatusEffekt(StatusEffekt statusEffekt) {
        this.statusEffekt = statusEffekt;
    }

    public int[] getStatsAenderungen() {
        return statsAenderungen;
    }

    public void setStatsAenderungen(int[] statsAenderungen) {
        this.statsAenderungen = statsAenderungen;
    }

    public int getCritStage() {
        return critStage;
    }

    public void setCritStage(int critStage) {
        this.critStage = critStage;
    }

    public int getBindDauer() {
        return bindDauer;
    }

    public void setBindDauer(int bindDauer) {
        this.bindDauer = bindDauer;
    }

    public boolean isBound() {
        return isBound;
    }

    public void setBound(boolean bound) {
        isBound = bound;
    }

    public boolean isFlinched() {
        return isFlinched;
    }

    public void setFlinched(boolean flinched) {
        isFlinched = flinched;
    }

    public boolean isVerwirrt() {
        return isVerwirrt;
    }

    public void setVerwirrt(boolean verwirrt) {
        isVerwirrt = verwirrt;
    }

    public int getVerwirrtDauer() {
        return verwirrtDauer;
    }

    public void setVerwirrtDauer(int range, int start){
        Random random = new Random();
        this.verwirrtDauer = random.nextInt(range) + start;
        this.isVerwirrt = true;
    }

    public void setVerwirrtDauer(int verwirrtDauer) {
        this.verwirrtDauer = verwirrtDauer;
    }

    public int getSleepDauer() {
        return sleepDauer;
    }

    public void setSleepDauer(int sleepDauer) {
        this.sleepDauer = sleepDauer;
    }

    public void setSleepDauer(){
        Random random = new Random();
        this.sleepDauer = random.nextInt(3) + 1;
    }

    public boolean isUsedHyperbeam() {
        return usedHyperbeam;
    }

    public void usedHyperbeam(boolean usedHyperbeam) {
        this.usedHyperbeam = usedHyperbeam;
    }

    public boolean isCursed() {
        return isCursed;
    }

    public void setCursed(boolean cursed) {
        isCursed = cursed;
    }

    public boolean isHatLightScreen() {
        return hatLightScreen;
    }

    public void setHatLightScreen(boolean hatLightScreen) {
        this.hatLightScreen = hatLightScreen;
    }

    public int getLightScreenDuration() {
        return lightScreenDuration;
    }

    public void setLightScreenDuration(int lightScreenDuration) {
        this.lightScreenDuration = lightScreenDuration;
    }

    public void setLightScreen(){
        setHatLightScreen(true);
        setLightScreenDuration(5);
    }

    public boolean isHatReflect() {
        return hatReflect;
    }

    public void setHatReflect(boolean hatReflect) {
        this.hatReflect = hatReflect;
    }

    public int getReflectDuration() {
        return reflectDuration;
    }

    public void setReflectDuration(int reflectDuration) {
        this.reflectDuration = reflectDuration;
    }

    public void setReflect(){
        setHatReflect(true);
        setReflectDuration(5);
    }

    public void resetStats(){
        int tmpHp = getHp();

        calculateStats();

        setHp(tmpHp);

        statsAenderungen = new int[]{0,0,0,0,0,0};
    }

    public boolean isHatSafeguard() {
        return hatSafeguard;
    }

    public void setHatSafeguard(boolean hatSafeguard) {
        this.hatSafeguard = hatSafeguard;
    }

    public int getSafeguardDauer() {
        return safeguardDauer;
    }

    public void setSafeguardDauer(int safeguardDauer) {
        this.safeguardDauer = safeguardDauer;
    }

    public void setSafeguard(){
        setHatSafeguard(true);
        setSafeguardDauer(5);
    }

    public boolean isSleepy() {
        return isSleepy;
    }

    public void setSleepy(boolean sleepy) {
        isSleepy = sleepy;
    }

    public int getBadlyPoisonedDauer() {
        return badlyPoisonedDauer;
    }

    public void setBadlyPoisonedDauer(int badlyPoisonedDauer) {
        this.badlyPoisonedDauer = badlyPoisonedDauer;
    }
}


