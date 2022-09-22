package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.AlunoModel;
import models.ProfissaoModel;

public class Database {
    public Connection connect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres";
        return DriverManager.getConnection(url);
    }
}
