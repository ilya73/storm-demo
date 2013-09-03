package com.shareaholic.storm.demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Database {

    private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);

    private static String getSql(String name) {
        try (InputStream stream = Database.class.getClassLoader().getResourceAsStream(name + ".sql"); Scanner s = new Scanner(stream)) {
            s.useDelimiter("\\A");
            return s.hasNext() ? s.next() : "";
        } catch (IOException e) {
            LOGGER.error("", e);
            throw new RuntimeException(e);
        }
    }

    private MysqlDataSource dataSource;

    public Database() {
        ResourceBundle bundle = ResourceBundle.getBundle("config");
        dataSource = new MysqlDataSource();
        dataSource.setUser(bundle.getString("user"));
        dataSource.setPassword(bundle.getString("password"));
        dataSource.setUrl(bundle.getString("url"));
        try {
            dataSource.getConnection().createStatement().execute(getSql("drop"));
            dataSource.getConnection().createStatement().execute(getSql("startup"));
            dataSource.getConnection().createStatement().execute(getSql("data"));
        } catch (SQLException e) {
            LOGGER.error("", e);
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.error("", e);
            throw new RuntimeException(e);
        }
    }
}