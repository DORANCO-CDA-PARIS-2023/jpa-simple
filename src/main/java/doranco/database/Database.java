package doranco.database;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database INSTANCE = null;
    private Connection connection;


    private Database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jpa_simple", "root", "root");
    }

    public Connection getConnection() {
        return connection;
    }

    public static Database getINSTANCE() throws SQLException {
        if (INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }
}
