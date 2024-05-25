package main.klassen;

class StatusEffekt {

    private boolean hatEffekt;
    private int id;
    private String name;

    public StatusEffekt(boolean hatEffekt, int id, String name) {
        this.hatEffekt = hatEffekt;
        this.id = id;
        this.name = name;
    }

    public void setEffekt(int id){
        hatEffekt = true;
        setName(id);
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
            case 1 -> setName("burn");
            case 2 -> setName("freeze");
            case 3 -> setName("paralysis");
            case 4 -> setName("poison");
            case 5 -> setName("badly-poisoned");
            case 6 -> setName("sleep");
            case 7 -> setName("sleepy");
            default -> setName("unknown");
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
            case "sleepy" -> setId(7);
            default -> setId(0);
        }
    }
}
