package main;

import main.klassen.*;

import java.sql.*;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class SQL {

    String url = "jdbc:mysql://127.0.0.1:3306/pokemon";
    String username = "root";
    String password = "meinPasswort";

    public Buddy pokemonWahl() throws SQLException{
        Buddy buddy = new Buddy();

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        Scanner scanner = new Scanner(System.in);

        String auswahl = "";
        HashMap<Integer, String> moeglichePokemon = pokemonMap();
        boolean weiter = true ;

        for(Integer id : moeglichePokemon.keySet()){
            System.out.println(id + " " + moeglichePokemon.get(id));
        }

        System.out.println();

        ResultSet pokemonWahl = null;

        while(weiter){
            System.out.println("Bitte eine ID oder einen Namen angeben.");
            auswahl = scanner.nextLine();

            if(!auswahl.isEmpty()){
                if(istZahl(auswahl) && moeglichePokemon.containsKey(Integer.valueOf(auswahl))){
                    pokemonWahl = statement.executeQuery("select * from pokemon where pok_id='" + Integer.valueOf(auswahl) + "'");
                    weiter = false;
                }   else if(!istZahl(auswahl) && moeglichePokemon.containsValue(auswahl.toLowerCase())){
                    pokemonWahl = statement.executeQuery("select * from pokemon where pok_name='" + auswahl.toLowerCase() + "'");
                    weiter = false;
                }
            }
        }

        assert pokemonWahl != null;

        if(pokemonWahl.next()){
            buddy.setId(pokemonWahl.getInt(1));
            buddy.setName(pokemonWahl.getString(2));
            buddy.setGewicht((pokemonWahl.getInt(4)));
        }

        buddy.setName(buddy.getName().substring(0,1).toUpperCase() + buddy.getName().substring(1));

        pokemonWahl.close();

        ResultSet baseStats = statement.executeQuery("select * from base_stats where pok_id='" + buddy.getId() + "'");

        if(baseStats.next()){
            buddy.setBaseStat(0, baseStats.getDouble(2));
            buddy.setBaseStat(1, baseStats.getDouble(3));
            buddy.setBaseStat(2, baseStats.getDouble(4));
            buddy.setBaseStat(3, baseStats.getDouble(5));
            buddy.setBaseStat(4, baseStats.getDouble(6));
            buddy.setBaseStat(5, baseStats.getDouble(7));
            buddy.setBaseStat(6, 1);
        }

        baseStats.close();
        statement.close();
        connection.close();

        buddy.calculateStats();
        buddy.holeTyp();
        buddy.angriffAuswahl();

        return buddy;
    }

    public HashMap<Integer, String> pokemonMap() throws SQLException{

        HashMap<Integer, String> pokemon = new HashMap<>();

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        ResultSet pokemonWahl = statement.executeQuery("select * from pokemon order by pok_id asc");

        while(pokemonWahl.next()){
            pokemon.put(pokemonWahl.getInt(1), pokemonWahl.getString(2));
        }

        pokemonWahl.close();
        statement.close();
        connection.close();

        return pokemon;

    }

    public Buddy pokemonParameterWahl(int id, int a1, int a2, int a3, int a4) throws SQLException{
        Buddy buddy = new Buddy();

        int[] angriffIds = { a1, a2, a3, a4 };

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        ResultSet pokemonWahl = statement.executeQuery("select * from pokemon where pok_id='" + id + "'");

        if(pokemonWahl.next()){
            buddy.setId(pokemonWahl.getInt(1));
            buddy.setName(pokemonWahl.getString(2));
            buddy.setGewicht((pokemonWahl.getInt(4)));
        }

        buddy.setName(buddy.getName().substring(0,1).toUpperCase() + buddy.getName().substring(1));

        pokemonWahl.close();

        ResultSet baseStats = statement.executeQuery("select * from base_stats where pok_id='" + buddy.getId() + "'");

        if(baseStats.next()){
            buddy.setBaseStat(0, baseStats.getDouble(2));
            buddy.setBaseStat(1, baseStats.getDouble(3));
            buddy.setBaseStat(2, baseStats.getDouble(4));
            buddy.setBaseStat(3, baseStats.getDouble(5));
            buddy.setBaseStat(4, baseStats.getDouble(6));
            buddy.setBaseStat(5, baseStats.getDouble(7));
            buddy.setBaseStat(6, 1);
        }

        connection.close();
        statement.close();
        baseStats.close();

        buddy.calculateStats();
        buddy.holeTyp();
        buddy.angriffParameterWahl(angriffIds);

        return buddy;
    }

    public Buddy pokemonWahlRandom() throws SQLException{
            Buddy buddy = new Buddy();

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet menge = statement.executeQuery("select count(*) from pokemon");

            int anzahl = 0;
            if(menge.next()){
                anzahl = menge.getInt(1);
            }

            int auswahl = (int) (Math.random() * anzahl) + 1;

            menge.close();

            ResultSet pokemonWahl = statement.executeQuery("select * from pokemon where pok_id='" + auswahl + "'");

            if(pokemonWahl.next()){
                buddy.setId(pokemonWahl.getInt(1));
                buddy.setName(pokemonWahl.getString(2));
                buddy.setGewicht((pokemonWahl.getInt(4)));
            }

            buddy.setName(buddy.getName().substring(0,1).toUpperCase() + buddy.getName().substring(1));

            pokemonWahl.close();

            ResultSet baseStats = statement.executeQuery("select * from base_stats where pok_id='" + auswahl + "'");

            if(baseStats.next()){
                buddy.setBaseStat(0, baseStats.getDouble(2));
                buddy.setBaseStat(1, baseStats.getDouble(3));
                buddy.setBaseStat(2, baseStats.getDouble(4));
                buddy.setBaseStat(3, baseStats.getDouble(5));
                buddy.setBaseStat(4, baseStats.getDouble(6));
                buddy.setBaseStat(5, baseStats.getDouble(7));
                buddy.setBaseStat(6, 1);
            }

            baseStats.close();

            statement.close();
            connection.close();

            buddy.calculateStats();
            buddy.holeTyp();
            buddy.zufaelligeAngriffe();

            return buddy;
    }

    public Vector<Typ> getTyp(int id) throws SQLException{

        Vector<Typ> typ = new Vector<Typ>();

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stat = con.createStatement();

        ResultSet typListe = stat.executeQuery("select * from pokemon_types where pok_id='" + id + "'");

        int zaehler = 0;

        //Typimmunitaeten einbauen
        while(typListe.next()){

            typ.add(new Typ());
            typ.elementAt(zaehler).setId(typListe.getInt(2));
            typ.elementAt(zaehler).setName(typ.elementAt(zaehler).typNamen(typ.elementAt(zaehler).getId()));

        //    System.out.println(typ.elementAt(zaehler).getName());
        //    System.out.println(typ.elementAt(zaehler).getId());

            zaehler++;
        }

        con.close();
        stat.close();
        typListe.close();

        return typ;
    }

    public Vector<Integer> angriffsListeId(int id) throws SQLException {

    Connection con = DriverManager.getConnection(url, username, password);
    Statement stat = con.createStatement();

    ResultSet liste = stat.executeQuery("select distinct(move_id) from pokemon_moves where pok_id='" + id + "' order by move_id ASC");

    Vector<Integer> angriffsId = new Vector<Integer>();

    while(liste.next()){

            angriffsId.add(liste.getInt(1));
    }

    con.close();
    stat.close();
    liste.close();

    return angriffsId;
    }

    public Angriff findeAngriffDurchId(int id) throws SQLException{
        Angriff angriff = new Angriff();
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stat = con.createStatement();

        ResultSet ausgewaehlterAngriff = stat.executeQuery("select * from moves where move_id='" + id + "'");

        if(ausgewaehlterAngriff.next()) {
            angriff.setId(ausgewaehlterAngriff.getInt(1));
            angriff.setName(ausgewaehlterAngriff.getString(2));
            angriff.getTyp().setTyp(ausgewaehlterAngriff.getInt(3));
            angriff.setPower(ausgewaehlterAngriff.getInt(4));
            angriff.setPp(ausgewaehlterAngriff.getInt(5));
            angriff.setGenauigkeit(ausgewaehlterAngriff.getInt(6));
            angriff.setKategorie(ausgewaehlterAngriff.getInt(7));
            if(ausgewaehlterAngriff.getInt(7) == 0){
                angriff.setKategorieString("Statusaenderung");
            }   else if(ausgewaehlterAngriff.getInt(7) == 1){
                angriff.setKategorieString("Physisch");
            }   else if(ausgewaehlterAngriff.getInt(7) == 2){
                angriff.setKategorieString("Spezial");
            }
        }

        angriff.setName(angriff.getName().replace("-", " "));

        ausgewaehlterAngriff.close();
        con.close();
        stat.close();

        return angriff;
    }

    public void ansichtAngriffe(int id) throws SQLException {

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stat = con.createStatement();

        ResultSet liste = stat.executeQuery("select distinct(moves.move_id),moves.move_name " +
                "from moves join pokemon_moves ON moves.move_id = pokemon_moves.move_id " +
                "where pokemon_moves.pok_id='" + id + "' " +
                "order by moves.move_id ASC");

        while(liste.next()){
            System.out.println(liste.getInt(1) + " " + liste.getString(2));
        }

        liste.close();
        stat.close();
        con.close();

    }

    public Vector<String> getAngriffsListe(int id) throws SQLException{

        Vector<String> angriffe = new Vector<String>();

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stat = con.createStatement();

        ResultSet liste = stat.executeQuery("select moves.move_name " +
                "from moves join pokemon_moves ON moves.move_id = pokemon_moves.move_id " +
                "where pokemon_moves.pok_id='" + id + "'");

        while(liste.next()){
            angriffe.add(liste.getString(1));
        }

        con.close();
        stat.close();
        liste.close();

        return angriffe;
    }

    public Vector<Angriff> getAngriffeAusListe(int id) throws SQLException{

        Vector<Angriff> angriffe = new Vector<>();
        
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stat = con.createStatement();

        Vector<Integer> liste = angriffsListeId(id);

        for(int i = 0; i < liste.size(); i++){

            ResultSet ausgewaehlterAngriff = stat.executeQuery("select * from moves where move_id='" + liste.elementAt(i) + "'");

            Angriff angriff = new Angriff();

            //Bestimmte Angriffe "ignorieren"
            if(ausgewaehlterAngriff.next()) {
                angriff.setId(ausgewaehlterAngriff.getInt(1));
                angriff.setName(ausgewaehlterAngriff.getString(2));
                angriff.getTyp().setTyp(ausgewaehlterAngriff.getInt(3));
                angriff.setPower(ausgewaehlterAngriff.getInt(4));
                angriff.setPp(ausgewaehlterAngriff.getInt(5));
                angriff.setGenauigkeit(ausgewaehlterAngriff.getInt(6));
                angriff.setKategorie(ausgewaehlterAngriff.getInt(7));
                if(ausgewaehlterAngriff.getInt(7) == 0){
                    angriff.setKategorieString("Statusaenderung");
                }   else if(ausgewaehlterAngriff.getInt(7) == 1){
                    angriff.setKategorieString("Physisch");
                }   else if(ausgewaehlterAngriff.getInt(7) == 2){
                    angriff.setKategorieString("Spezial");
                }
            }

            if(!angriffe.contains(angriff)){
                angriffe.add(angriff);
            }

            ausgewaehlterAngriff.close();

        }

        Random random = new Random();

        Vector<Angriff> ausgewaehlteAngriffe = new Vector<>();

        for(int i = 0; i < 4;){

            int randomZahl = random.nextInt(angriffe.size());

            if(!ausgewaehlteAngriffe.contains(angriffe.elementAt(randomZahl))){
                ausgewaehlteAngriffe.add(angriffe.elementAt(randomZahl));
                i++;
            }
        }


        con.close();
        stat.close();

        return ausgewaehlteAngriffe;
    }

    public Angriff angriffAuswahl(int id, int bId) throws SQLException{

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stat = con.createStatement();

        Angriff angriff = new Angriff();
        Vector<Integer> moeglicheIds = angriffsListeId(bId);

        ResultSet ausgewaehlterAngriff = stat.executeQuery("select * from moves where move_id='" + id + "'");

        if(moeglicheIds.contains(id)){

                //Bestimmte Angriffe "ignorieren"
                if (ausgewaehlterAngriff.next()) {
                    angriff.setId(ausgewaehlterAngriff.getInt(1));
                    angriff.setName(ausgewaehlterAngriff.getString(2));
                    angriff.getTyp().setTyp(ausgewaehlterAngriff.getInt(3));
                    angriff.setPower(ausgewaehlterAngriff.getInt(4));
                    angriff.setPp(ausgewaehlterAngriff.getInt(5));
                    angriff.setGenauigkeit(ausgewaehlterAngriff.getInt(6));
                    angriff.setKategorie(ausgewaehlterAngriff.getInt(7));
                    if (ausgewaehlterAngriff.getInt(7) == 0) {
                        angriff.setKategorieString("Statusaenderung");
                    } else if (ausgewaehlterAngriff.getInt(7) == 1) {
                        angriff.setKategorieString("Physisch");
                    } else if (ausgewaehlterAngriff.getInt(7) == 2) {
                        angriff.setKategorieString("Spezial");
                    }
                }
            }

        ausgewaehlterAngriff.close();
        con.close();
        stat.close();

        return angriff;
    }

    public static boolean istZahl(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(string); //
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
