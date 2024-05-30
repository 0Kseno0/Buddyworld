package main.klassen;

public class StatusEffekt {

    private boolean hatEffekt;
    private int id;
    private String name;

    public StatusEffekt(boolean hatEffekt, int id, String name) {
        this.hatEffekt = hatEffekt;
        this.id = id;
        this.name = name;
    }

    public StatusEffekt(){
        hatEffekt = false;
        id = 0;
        name = "";
    }

    public void setEffekt(int id){
        if(id == 0){
            this.id = 0;
            hatEffekt = false;
            setName(id);
        }   else {
            this.id = id;
            hatEffekt = true;
            setName(id);
        }
    }

    public boolean hatEffekt() {
        return hatEffekt;
    }

    public void setHatEffekt(boolean hatEffekt) {
        this.hatEffekt = hatEffekt;
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

    public void setName(int id){
        switch(id){
            case 1 -> setName("burned");
            case 2 -> setName("frozen");
            case 3 -> setName("paralyzed");
            case 4 -> setName("poisoned");
            case 5 -> setName("badly poisoned");
            case 6 -> setName("asleep");
            default -> setName("");
        }
    }

    public void setId(String name) {
        switch (name.toLowerCase()) {
            case "burn" -> setId(1);
            case "freeze" -> setId(2);
            case "paralysis" -> setId(3);
            case "poison" -> setId(4);
            case "badly-poisoned" -> setId(5);
            case "sleep" -> setId(6);
            default -> setId(0);
        }
    }
}
