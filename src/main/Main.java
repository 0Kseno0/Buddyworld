package main;
import java.sql.SQLException;

public class Main {

    private static KampfDurchfuehrung kampfDurchfuehrung = new KampfDurchfuehrung();

    public static void main(String[] args) throws SQLException, InterruptedException {

        kampfDurchfuehrung.start();
    }
}