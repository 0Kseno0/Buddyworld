package main.klassen;

public class Typ {

    private int id;
    private String name;
    private int schadensTypId;
    public Typ(){
        id = 0;
        name = "";
        schadensTypId = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTyp(int id) {
        this.id = id;
        name = typNamen(id);

        if(id == 10001){
            schadensTypId = 1;
        }   else if(id == 10002){
            schadensTypId = 2;
        }   else{
            schadensTypId = id;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSchadensTypId() {
        return schadensTypId;
    }

    public void setSchadensTypId(int schadensTypId) {
        this.schadensTypId = schadensTypId;
    }
    
    public String typNamen(int id){
        return switch (id) {
            case 1 -> "normal";
            case 2 -> "fighting";
            case 3 -> "flying";
            case 4 -> "poison";
            case 5 -> "ground";
            case 6 -> "rock";
            case 7 -> "bug";
            case 8 -> "ghost";
            case 9 -> "steel";
            case 10 -> "fire";
            case 11 -> "water";
            case 12 -> "grass";
            case 13 -> "electric";
            case 14 -> "psychic";
            case 15 -> "ice";
            case 16 -> "dragon";
            case 17 -> "dark";
            case 18 -> "fairy";
            case 10001 -> "unknown";
            case 10002 -> "shadow";
            default -> "ging iwie nicht";
        };
    }
}
