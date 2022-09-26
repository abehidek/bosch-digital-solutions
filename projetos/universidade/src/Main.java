import java.util.ArrayList;

import dao.AlunoService;
import dao.Database;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Database dao = new Database();
        Connection connection = dao.connect();
        // AlunoService.createAluno(connection);
        ArrayList<models.AlunoModel> alunos = AlunoService.allAlunos(connection);

        alunos.get(0).print();
    }
}
