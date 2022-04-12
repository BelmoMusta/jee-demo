package com.supmti.tp01.banque.dao.common;

import java.sql.Connection;
import java.sql.Statement;

@SuppressWarnings("all")
public class DataBasePopulator {
    public static void createTables() throws Exception {

        String sql = "CREATE TABLE IF NOT EXISTS  Personne\n" +
                "(\n" +
                "    id            INTEGER PRIMARY KEY,\n" +
                "    nom           VARCHAR(64) ,\n" +
                "    prenom        VARCHAR(64) ,\n" +
                "    dateNaissance VARCHAR(64) ,\n" +
                "); ";
        partieCommuneSQL(sql);


    }

    public static void createTableCompte() throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS  Compte\n" +
                "(\n" +
                "    id            INTEGER PRIMARY KEY,\n" +
                "    depotInitial           DECIMAL (64) ,\n" +
                "    personne_id        INTEGER (64)       ,\n" +
                "    dateNaissance VARCHAR(64)       ,\n" +
                ");";
        partieCommuneSQL(sql);

    }

    public static void partieCommuneSQL(String sql) throws Exception{
        DatabaseHolder instance = DatabaseHolder.getInstance();
        Connection connection = instance.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);

    }
}
