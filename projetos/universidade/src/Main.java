import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        DAO dao = new DAO();
        Connection connection = dao.connect();
        // dao.insert(connection);
        ArrayList<models.User> users = dao.select(connection);

        users.get(0).print();
    }
}
