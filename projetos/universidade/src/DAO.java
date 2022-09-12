import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.User;

public class DAO {
    public Connection connect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres";
        return DriverManager.getConnection(url);
    }

    public void insert(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeQuery("INSERT INTO users (name, age) VALUES ('moura', 24)");
    }

    public ArrayList<User> select(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from users");
        
        ArrayList<User> users = new ArrayList<>();
        
        while (rs.next()) {
            User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            users.add(user);
        }
        return users;
    }
}
