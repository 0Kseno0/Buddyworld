package main;

import main.klassen.*;

import java.awt.color.ICC_ColorSpace;
import java.sql.*;
import java.util.Vector;

public class SQL {

    String url = "jdbc:mysql://127.0.0.1:3306/pokemon";
    String username = "root";
    String password = "meinPasswor";

    public void pokemonWahl(Buddy buddy) throws SQLException{

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
            }

            pokemonWahl.close();

            ResultSet baseStats = statement.executeQuery("select * from base_stats where pok_id='" + auswahl + "'");

            if(baseStats.next()){
                buddy.setStat(0, baseStats.getDouble(2));
                buddy.setStat(1, baseStats.getDouble(3));
                buddy.setStat(2, baseStats.getDouble(4));
                buddy.setStat(3, baseStats.getDouble(5));
                buddy.setStat(4, baseStats.getDouble(6));
                buddy.setStat(5, baseStats.getDouble(7));
                buddy.setStat(6, 1);
            }

            baseStats.close();

            statement.close();
            connection.close();
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
            typ.elementAt(zaehler).setSchadensTypId(typ.elementAt(zaehler).getId());
            typ.elementAt(zaehler).setName(typ.elementAt(zaehler).typNamen(typ.elementAt(zaehler).getId()));

            System.out.println(typ.elementAt(zaehler).getName());
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

    ResultSet liste = stat.executeQuery("select * from pokemon_moves where pok_id='" + id + "'");

    Vector<Integer> angriffsId = new Vector<Integer>();

    while(liste.next()){

        if(!angriffsId.contains(liste.getInt(3))) {

            angriffsId.add(liste.getInt(3));

        }
    }

    con.close();
    stat.close();
    liste.close();

    return angriffsId;
    }

    public Angriff[] getAngriffeAusListe(int id) throws SQLException{

        Angriff[] angriffe = new Angriff[4];

        for(int i = 0; i < 4; i++){

            angriffe[i] = new Angriff();

        }

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stat = con.createStatement();

        Vector<Integer> liste = angriffsListeId(id);

        for(int i = 0; i < 4; i++){

            int zufallsZahl = (int) (Math.random() * liste.size()) + 1;

            Typ typ = new Typ();

            ResultSet ausgewaehlterAngriff = stat.executeQuery("select * from moves where move_id='" + liste.elementAt(zufallsZahl) + "'");

            //Bestimmte Angriffe "ignorieren"
            if(ausgewaehlterAngriff.next()) {
                angriffe[i].setId(ausgewaehlterAngriff.getInt(1));
                angriffe[i].setName(ausgewaehlterAngriff.getString(2));
                typ.setTyp(ausgewaehlterAngriff.getInt(3));
                angriffe[i].setTyp(typ);
                angriffe[i].setPower(ausgewaehlterAngriff.getInt(4));
                angriffe[i].setPp(ausgewaehlterAngriff.getInt(5));
                angriffe[i].setGenauigkeit(ausgewaehlterAngriff.getInt(6));
            }

            System.out.println(angriffe[i].getName());

            ausgewaehlterAngriff.close();

        }

        con.close();
        stat.close();

        return angriffe;
    }

    public Vector<String> angriffsListe(int id) throws SQLException {

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stat = con.createStatement();

        ResultSet liste = stat.executeQuery("select * from pokemon_moves where pok_id='" + id + "'");

        Vector<Integer> angriffsId = angriffsListeId(id);

        Vector<String> angriffe = new Vector<String>();

        for(int i = 0; i < angriffsId.size(); i++){

            ResultSet angriff = stat.executeQuery("select * from moves where move_id='" + angriffsId.elementAt(i) + "'");

            if(angriff.next()) {
                angriffe.add(angriff.getString(2));
            }

            angriff.close();

    //        System.out.println(angriffe.elementAt(i));
        }

        con.close();
        stat.close();
        return angriffe;

    }
}
