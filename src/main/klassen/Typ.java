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
        switch(id) {
            case 1:
               return "normal";
            case 2:
                return "fighting";
            case 3:
                return "flying";
            case 4:
                return "poison";
            case 5:
                return "ground";
            case 6:
                return "rock";
            case 7:
                return "bug";
            case 8:
                return "ghost";
            case 9:
                return "steel";
            case 10:
                return "fire";
            case 11:
                return "water";
            case 12:
                return "grass";
            case 13:
                return "electric";
            case 14:
                return "psychic";
            case 15:
                return "ice";
            case 16:
                return "dragon";
            case 17:
                return "dark";
            case 18:
                return "fairy";
            case 10001:
                return "unknown";
            case 10002:
                return "shadow";
            default:
                return "ging iwie nicht";
        }
    }
}
