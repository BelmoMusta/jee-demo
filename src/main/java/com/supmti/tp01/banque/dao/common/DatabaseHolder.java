package com.supmti.tp01.banque.dao.common;

import org.h2.jdbcx.JdbcConnectionPool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseHolder {

    public static final String CONNECTION_STRING = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    public static final String USER = "sa";
    public static final String PASSWORD = "";
    private DataSource dataSource;

    public DatabaseHolder() {
        try {
            dataSource = JdbcConnectionPool.create(CONNECTION_STRING, USER, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException("Erreur de création du data source", ex);

        }
    }

    private static class ConnectionPoolHolder {
        public static final DatabaseHolder INSTANCE = new DatabaseHolder();
    }

    public static DatabaseHolder getInstance() {
        return ConnectionPoolHolder.INSTANCE;
    }

    public static void main(String[] args) {
        getInstance().getConnection();
    }
}